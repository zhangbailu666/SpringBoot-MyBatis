//package com.qbian.common.plugin;
//
//import com.qbian.common.dto.Page;
//import com.qbian.common.exception.ServiceException;
//
//import org.apache.ibatis.executor.parameter.ParameterHandler;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.Properties;
//
//import org.apache.ibatis.executor.statement.StatementHandler;
//import org.apache.ibatis.mapping.BoundSql;
//import org.apache.ibatis.mapping.MappedStatement;
//import org.apache.ibatis.plugin.Interceptor;
//import org.apache.ibatis.plugin.Intercepts;
//import org.apache.ibatis.plugin.Invocation;
//import org.apache.ibatis.plugin.Plugin;
//import org.apache.ibatis.plugin.Signature;
//import org.apache.ibatis.reflection.MetaObject;
//import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
//import org.apache.ibatis.reflection.factory.ObjectFactory;
//import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;
//import org.apache.ibatis.reflection.wrapper.ObjectWrapperFactory;
//import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
//import org.apache.ibatis.session.Configuration;
//import org.springframework.stereotype.Component;
//
///**
// * Created by Qbian on 2017/3/27.
// */
//@Intercepts({
//        @Signature(method = "prepare", type = StatementHandler.class, args = { Connection.class})
//})
//public class PagePlugin implements Interceptor {
//
//    // 默认数据库方言：mysql
//    private static String DEFAULT_DIALECT = "mysql";
//
//    // 需要拦截的方法后缀
//    private static String DEFAULT_PAGESQLID_SUFFIX = "WithPage";
//
//    private static final ObjectFactory DEFAULT_OBJECT_FACTORY = new DefaultObjectFactory();
//
//    private static final ObjectWrapperFactory DEFAULT_OBJECT_WRAPPER_FACTORY = new DefaultObjectWrapperFactory();
//
//    /**
//     * 拦截后要执行的方法
//     * @param invocation
//     * @return
//     * @throws Throwable
//     */
//    @Override
//    public Object intercept(Invocation invocation) throws Throwable {
//        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
//
//        // 通过MetaObject包装一个对象后可以获取或设置该对象的原本不可访问的属性
//        MetaObject metaStatementHandler = MetaObject.forObject(statementHandler,
//                DEFAULT_OBJECT_FACTORY, DEFAULT_OBJECT_WRAPPER_FACTORY, null);
//
//        // 分离代理对象链(由于目标类可能被多个拦截器拦截，从而形成多次代理，通过下面的两次循环
//        // 可以分离出最原始的的目标类)
//        while (metaStatementHandler.hasGetter("h")){
//            Object object = metaStatementHandler.getValue("h");
//            metaStatementHandler = MetaObject.forObject(object, DEFAULT_OBJECT_FACTORY,
//                    DEFAULT_OBJECT_WRAPPER_FACTORY, null);
//        }
//
//        // 分离最后一个代理对象的目标类
//        while (metaStatementHandler.hasGetter("target")) {
//            Object object = metaStatementHandler.getValue("target");
//            metaStatementHandler = MetaObject.forObject(object, DEFAULT_OBJECT_FACTORY,
//                    DEFAULT_OBJECT_WRAPPER_FACTORY, null);
//        }
//
//        Configuration configuration = (Configuration) metaStatementHandler.getValue("delegate.configuration");
//        String dialect = null;
//        String pageSqlIdSuffix = null;
//        // 没有配置文件
//        if(null == configuration.getVariables()) {
//            dialect = DEFAULT_DIALECT;
//            pageSqlIdSuffix = DEFAULT_PAGESQLID_SUFFIX;
//        } else {
//            dialect = configuration.getVariables().getProperty("dialect");
//            // 配置文件中没有指定分页数据库类型
//            if(null == dialect || "".equals(dialect)) {
//                dialect = DEFAULT_DIALECT;
//            }
//            pageSqlIdSuffix = configuration.getVariables().getProperty("pageSqlId");
//            // 配置 文件中没有指定分页方法的后缀名
//            if(null == pageSqlIdSuffix || "".equals(pageSqlIdSuffix)) {
//                pageSqlIdSuffix = DEFAULT_PAGESQLID_SUFFIX;
//            }
//        }
//        MappedStatement mappedStatement = (MappedStatement) metaStatementHandler.getValue("delegate.mappedStatement");
//        // 只重写需要分页的sql语句，通过MappedStatement的id匹配，默认重写以WithPage结尾的
//        // MappedStatement的sql
//        if(mappedStatement.getId().endsWith(pageSqlIdSuffix)) {
//            BoundSql boundSql = (BoundSql) metaStatementHandler.getValue("delegate.boundSql");
//            Object parameterObject = boundSql.getParameterObject();
//            if(parameterObject == null) {
//                throw  new NullPointerException("parameterObject is null!");
//            } else {
//                Page page = (Page) parameterObject;
//                String sql = boundSql.getSql();
//                // 重写sql
//                String pageSql = buildPageSql(sql, page, dialect);
//                metaStatementHandler.setValue("delegate.boundSql.sql", pageSql);
//
//                Connection connection = (Connection) invocation.getArgs()[0];
//                // 重设分页参数里的总页数等
//                setPageParameter(sql, connection, mappedStatement, boundSql, page);
//            }
//        }
//        // 将执行权交给下一个拦截器
//        return invocation.proceed();
//    }
//
//    /**
//     * 拦截器对应的封装原始对象的方法
//     * @param target
//     * @return
//     */
//    @Override
//    public Object plugin(Object target) {
//        return Plugin.wrap(target, this);
//    }
//
//    @Override
//    public void setProperties(Properties properties) {
//
//    }
//
//    private String buildPageSql(String sql, Page page, String dialect) {
//        if(page != null) {
//            StringBuilder pageSql = new StringBuilder();
//            if("mysql".equals(dialect)) {
//                pageSql = buildPageSqlForMysql(sql, page);
//                sql = pageSql.toString();
//            } else if("oracle".equals(dialect)) {
//                pageSql = buildPageSqlForOracle(sql, page);
//                sql = pageSql.toString();
//            }
//        }
//        return sql;
//    }
//
//    private StringBuilder buildPageSqlForMysql(String sql, Page page) {
//        StringBuilder pageSql = new StringBuilder(100);
//        pageSql.append(sql);
//        pageSql.append(" limit " + ((page.getPageNo() - 1) * page.getPageSize()) + "," + page.getPageSize());
//
//        return pageSql;
//    }
//
//    private StringBuilder buildPageSqlForOracle(String sql, Page page) {
//        StringBuilder pageSql = new StringBuilder(100);
//        int beginrow = page.getPageNo() -1;
//        int endrow = page.getPageNo() - 1 + page.getPageSize();
//
//        pageSql.append("select * from ( select temp.*, rownum row_id from ( ");
//        pageSql.append(sql);
//        pageSql.append(" ) temp where rownum <= ").append(String.valueOf(endrow));
//        pageSql.append(") where row_id > ").append(String.valueOf(beginrow));
//
//        return pageSql;
//    }
//
//    private void setPageParameter(String sql, Connection connection, MappedStatement mappedStatement,
//                                  BoundSql boundSql, Page page) {
//        // 记录总记录数
//        String countSql = "select count(0) from (" + sql + ") as total";
//        PreparedStatement countStmt = null;
//        ResultSet rs = null;
//        try {
//            countStmt = connection.prepareStatement(countSql);
//            BoundSql countBS = new BoundSql(mappedStatement.getConfiguration(), countSql,
//                    boundSql.getParameterMappings(), boundSql.getParameterObject());
//            setParameters(countStmt, mappedStatement, countBS, boundSql.getParameterObject());
//            rs = countStmt.executeQuery();
//            int totalCount = 0;
//            if(rs.next()) {
//                totalCount = rs.getInt(1);
//            }
//            page.setTotal(totalCount);
//        } catch (SQLException e) {
//            throw new ServiceException();
//        } finally {
//            try {
//                rs.close();
//                countStmt.close();
//            } catch (SQLException e) {
//                throw new ServiceException();
//            }
//        }
//
//    }
//
//    /**
//     * 对SQL参数(?)设值
//     *
//     * @param ps
//     * @param mappedStatement
//     * @param boundSql
//     * @param parameterObject
//     * @throws SQLException
//     */
//    private void setParameters(PreparedStatement ps, MappedStatement mappedStatement, BoundSql boundSql,
//                               Object parameterObject) throws SQLException
//    {
//        ParameterHandler parameterHandler = new DefaultParameterHandler(mappedStatement, parameterObject, boundSql);
//        parameterHandler.setParameters(ps);
//    }
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//}
