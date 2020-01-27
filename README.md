​						基于id自增的短网址生成工具

------------

该工具支持将长链接装换成短链接，同时开放接口支持直接返回js配合前端代码直接将HTML中需要转换的长链转换成短链。

如：

- 美好的生活记录：https://surl.zhqy.xyz/6666
- GeekTom‘s Blog：https://surl.zhqy.xyz/8888

### 技术栈

SpringBoot + Maven + Mybatis

### 目录结构

├── java
│   └── com
│       └── geektomya
│           └── surl
│               ├── common
│               │   ├── message
│               │   ├── response
│               │   └── util
│               ├── controller
│               ├── dao
│               ├── exception
│               ├── model
│               │   └── vo
│               └── service
└── resources
    ├── mybatis
    │   └── mapper
    └── static

短链返回的域名前缀等信息存于message中

### 运行项目

1. 新建数据库surl，然后运行数据库脚本（项目根目录/doc/surl.sql）
2. 修改resources目录下的application.yml文件中的数据库信息
3. 修改短链的前缀为你自己的域名（message目录中的Message类）

启动项目后就可以通过相应的接口进行链接的转换，支持自动转化以及自定义短链。

### 调用服务

可以直接在前端中通过引入js，代码如下

```js
<script src="https://surl.zhqy.xyz/url/js" charset="utf-8"></script>
```

然后在相应的如要转换为短链的a标签中，设置为 `id=“url”`

最后调用 `<script>setUrl();</script>`即可在打开页面的时候前端中的长链接转换为相应的短链接。

