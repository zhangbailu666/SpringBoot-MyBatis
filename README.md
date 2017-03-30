# SpringBoot-MyBatis

**Spring boot + MyBatis 提供 RESTful 风格 SaaS 服务**

**get请求不需要鉴权token，所有的post、put、delete请求均作了接口token鉴权，不过具体的鉴权逻辑没有实现，硬编码 token=123456 为鉴权通过，其余均为非法请求。**

**------ 接口列表 ------**

**一**、类别相关接口

1.1、添加类别接口
```
http + post /category
Request body :
{
    "token": "123456",
    "name": "name",
    "introduction": "introduction",
    "preview": "preview"
}
Response data :
{
  "code": 0,
  "msg": "OK",
  "result": null
}
```
1.2、删除类别接口

```
http + delete /category/{id}
Request body : 
{
    "token":"123456"
}
Response data :
{
  "code": 0,
  "msg": "OK",
  "result": null
}
```
1.3、更新类别接口
```
http + put /category/{id}
Request body : 
{
    "token":"123456",
    "name": "name",
    "introduction": "introduction",
    "preview":"preview"
}
Response data :
{
  "code": 0,
  "msg": "OK",
  "result": null
}
```
1.4、获取类别详情接口
```
http + get /category/{id}
Response data :
{
  "code": 0,
  "msg": "OK",
  "result": {
    "id": "27837bca658b40f990b2e75768357847",
    "createTime": 1490853441000,
    "updateTime": 1490853441000,
    "name": "name",
    "introduction": "introduction1",
    "preview": "preview"
  }
}
```
1.5、分页获取类别列表接口
```
http + get /category?pageno=1&pagesize=10
Response data :
{
  "code": 0,
  "msg": "OK",
  "result": {
    "total": 5,
    "nodes": [
      {
        "id": "27837bca658b40f990b2e75768357847",
        "createTime": 1490853441000,
        "updateTime": 1490853441000,
        "name": "哈哈",
        "introduction": "introduction",
        "preview": "preview"
      },
      {
        "id": "a7878d52932e4028a45205431f6b9032",
        "createTime": 1490854115000,
        "updateTime": 1490854115000,
        "name": "哈哈",
        "introduction": "introduction",
        "preview": "preview"
      }, ......
    ]
  }
}
```

**二**、文章相关接口

2.1、添加文章接口
```
http + post /article
Request body : 
{
    "token": "123456",
    "categoryId": "1838d27816b14735810ed2ee55f30ec2",
    "name": "name",
    "content": "content",
    "preview": "preview"
}
Response data :
{
  "code": 0,
  "msg": "OK",
  "result": null
}
```
2.2、删除文章接口
```
http + delete /article/{id}
Request body : 
{
    "token":"123456"
}
Response data :
{
  "code": 0,
  "msg": "OK",
  "result": null
}
```
2.3、更新文章接口
```
http + put /article/{id}
Request body : 
{
    "token":"123456",
    "categoryId": "categoryId",
    "name": "name",
    "content": "content",
    "preview":"preview"
}
Response data :
{
  "code": 0,
  "msg": "OK",
  "result": null
}
```
2.4、获取文章详情接口
```
http + get /article/{id}
Response data :
{
  "code": 0,
  "msg": "OK",
  "result": {
    "id": "fbe10f1a336d4c5fa3b098694f318086",
    "categoryId": "27837bca658b40f990b2e75768357847",
    "categoryName": "name",
    "name": "name",
    "preview": "preview",
    "content": "content",
    "viewNum": 0
  }
}
```
2.5、分页获取文章列表
```
http + get /article?pageno=1&pagesize=10
Response data :
{
  "code": 0,
  "msg": "OK",
  "result": {
    "total": 3,
    "nodes": [
      {
        "id": "fbe10f1a336d4c5fa3b098694f318086",
        "categoryId": "27837bca658b40f990b2e75768357847",
        "categoryName": "name",
        "name": "name",
        "preview": "preview",
        "content": "content",
        "viewNum": 1
      },
      {
        "id": "d84fb1d691f3496885fb9a21caeed16e",
        "categoryId": "27837bca658b40f990b2e75768357847",
        "categoryName": "name",
        "name": "name",
        "preview": "preview",
        "content": "content",
        "viewNum": 0
      },
      {
        "id": "142fbfeb8763448d99c4b400ca1eea79",
        "categoryId": "27837bca658b40f990b2e75768357847",
        "categoryName": "name",
        "name": "name",
        "preview": "preview",
        "content": "content",
        "viewNum": 0
      }
    ]
  }
}
```
三、爬取其他网站接口
3.1、搜索微信公众号接口
```
http + get /wechat/search/{keywords}
Response data :
{
  "code": 0,
  "msg": "OK",
  "result": [
    {
      "photo": "http://xxxxxx.jpg",
      "describe": "xxxxxx",
      "title": "xxxxxx",
      "account": "xxxxxx"
    },
    {
      "photo": "http://xxxxxx.jpg",
      "describe": "xxxxxx",
      "title": "xxxxxx",
      "account": "xxxxxx"
    }
  ]
}
```
3.2、获取某公众号文章列表接口
```
http + get /wechat/account/{account}/{pageno}
**注意事项：最后的分页(pageno)必须是12的倍数**
Response data :
{
  "code": 0,
  "msg": "OK",
  "result": {
    "total": 3552,
    "articles": [
      {
        "createTime": "2017-02-12",
        "id": "1561973031016",
        "title": "xxxxxx"
      },
      {
        "createTime": "2017-02-11",
        "id": "1557723531913",
        "title": "xxxxxx"
      }, ......
    ]
  }
}
```
3.3、获取文章详细信息接口
```
http + get /wechat/article/{articleId}
Response data :
{
  "code": 0,
  "msg": "OK",
  "result": {
    "createTime": "2016-05-13",
    "nickName": "xxx",
    "author": "xxx",
    "name": "xxx",
    "content": "xxx"
  }
}
```