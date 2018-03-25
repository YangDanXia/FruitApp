FUNCTION     - | URL
---------------|-------------------------------
[登录](#1) | http://10.0.2.2:8080/Test/LoginServlet
[注册](#2) | http://10.0.2.2:8080/Test/Register
[商品列表查看](#3) | http://10.0.2.2:8080/Test/GoodsList



<h4 id="1" > 1.登录</h4>

URL       |http://10.0.2.2:8080/Test/LoginServlet
----------|--------------------
请求方式  |POST
返回值格式|JSON

#### 请求参数

参数名      |类型  |必填|默认|说明
------------|------|----|-----|------
key|string|√   |   -  |密钥(haiqian)暂无
userId|string|√   |   -  |用户账号
userPwd|string|√   |  -   |用户密码

#### success：
--- |内容      |说明
--- |----------|--- 
code|200       |
msg |登录成功!！|
data|   - |-

#### failed:
--------------|内容      |说明|
--------------|----------|----|
code          |404       |
msg           |登录失败!！|
data          |          |



<h4 id="2" > 1.注册</h4>

URL       |http://10.0.2.2:8080/Test/Register
----------|--------------------
请求方式  |POST
返回值格式|JSON

#### 请求参数

参数名      |类型  |必填|默认|说明
------------|------|----|-----|------
key|string|√   |   -  |密钥(haiqian)暂无
password|string|√   |     |用户密码|-
rePassword|string|√   |     |再次输入密码|暂无
userName|string|√   |     |姓名|暂无
userPhone|string|√   |     |电话|暂无
userAddress|string|√   |     |地址|暂无


#### success：
--- |内容      |说明
--- |----------|--- 
code|200       |
msg |注册成功!！|
data|    |

#### failed:
--------------|内容      |说明|
--------------|----------|----|
code          |404       |
msg           |注册失败!！|
data          |          |




<h4 id="3" > 1.商品列表查看</h4>

URL       |http://10.0.2.2:8080/Test/GoodsList
----------|--------------------
请求方式  |POST
返回值格式|JSON

#### 请求参数

参数名      |类型  |必填|默认|说明
------------|------|----|-----|------
key|string|√   |   -  |密钥(haiqian)暂无


#### success：
--- |内容      |说明
--- |----------|--- 
code|200       |
msg |查询成功!|
data|goodsId<br>goodsName<br>goodsPicture<br>goodsPrice<br>goodsMsg<br>goodsStock<br>categoryId<br>goodsSpec|

#### failed:
--------------|内容      |说明|
--------------|----------|----|
code          |404       |
msg           |无商品信息!|
data          |-          |



























