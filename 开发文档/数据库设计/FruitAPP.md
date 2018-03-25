# 水果平台数据库设计

 * [用户信息表](#1) 
 * [商品信息表](#2) 
 * [订单信息表](#3) 
 * [订单商品表](#4) 
 * [收藏](#5) 
 * [商品类别表](#6) 


<h1 id="1">用户信息表user</h1>

|字段名称      |说明       |键别|是否空|数据类型|长度|备注|
--------------|------------|---|------|--------|---|---
|userId       |用户编号    |PK |NO	 |int     |16 ||
|userPwd      |用户密码    | - |NO    |varchar |16 ||
|userName     |用户名      | - |NO    |varchar |64 ||
|userPhone    |手机号      | - |NO    |varchar |32||
|userAddress  |收货地址    | - |NO    |varchar |128||
|userIntegration|用户积分  |-  |NO    |int     |16 |    |
|gmt_create   |创建时间    |-  |NO    |data_time|  ||
|gmt_modified |修改时间    |-  |NO    |data_time|   ||


<h1 id="2">商品信息表goods</h1>

|字段名称	  |说明 	  |键别	|是否空  |数据类型|长度|备注|
|-------------|---------|-----|-------|-------|----|------
|goodsId	  |商品编号  |PK	|NO	    |int	|16  |      |
|goodsName	  |商品名	|-	|NO		|varchar|32  |      |
|goodsPicture |商品照片	|-   |NO	    |varchar|128 |      |
|goodsPrice	  |商品价格  |-   |NO		|int    |16  |      |
|goodsMsg	  |商品信息	|-   |NO	    |varchar|128 |      |
|goodsStock	  |商品库存	|-   |NO   	|int    |16  |      | 
|categoryId   |商品类别  |-   |NO	    |int    |16  |      |
|goodsSpec	  |商品规格	|-   |NO	    |varchar|64  |      |
|gmt_create	  |创建时间	|-   |NO    	|data_time|  |      |
|gmt_modified |修改时间	|-   |NO     |data_time|  |      |



<h1 id="3">订单信息表order</h1>

|字段名称	  |说明 	  |键别	|是否空  |数据类型|长度|备注|
|--------------|---------|-----|-------|-------|----|------
|orderId	  |订单编号  |PK	|NO	    |int	  |16  |      |
|userId	      |用户编号	|-	|NO		|int      |16  |      |
|orderTime    |下单时间	|-   |NO	    |data_time|128 |      |
|orderState	  |订单状态  |-   |NO		|bit      |1   | 1已完成<br> 0未完成|
|totalPrice	  |订单总价	|-   |NO	    |int      |16  |      |
|comment	  |用户评价	|-   |NO   	|text|    |    | 
|sendTime     |派送时间  |-   |NO	    |data_time|64  |      |
|gmt_create	  |创建时间	| -  |NO    	|data_time|    |      |
|gmt_modified |修改时间	|-   |NO     |data_time|    |      |


<h1 id="4">订单商品信息表order_goods</h1>

|字段名称	  |说明 	  |键别	|是否空  |数据类型|长度|备注|
|-------------|---------|-----|-------|-------|----|------
|orderId	  |订单编号  |PK	|NO	    |int	|16  |      |
|goodsId	  |商品编号  |PK	|NO	    |int	|16  |      |
|goodsName	  |商品名	|-	|NO		|varchar|32  |      |
|goodsMsg	  |商品信息	|-   |NO	    |varchar|128  |     |
|goodsPrice	  |商品价格  |-   |NO		|int|32  |    |
|goodsCount  |购买数量  |-   |NO	    |smallInt|64  |      |
|gmt_create	  |创建时间	|-   |NO    	|data_time|  |      |
|gmt_modified |修改时间	|-   |NO     |data_time|  |      |



<h1 id="5">收藏collection</h1>

|字段名称	  |说明 	  |键别	|是否空  |数据类型|长度|备注|
|-------------|---------|-----|-------|-------|----|------
|userId	  |用户编号  |PK	|NO	    |int	|16  |      |
|goodsId	  |商品编号  |PK	|NO	    |int	|16  |      |
|gmt_create	  |创建时间	|-   |NO    	|data_time|  |      |
|gmt_modified |修改时间	|-   |NO     |data_time|  |      |




<h1 id="6">商品类别category</h1>

|字段名称	  |说明 	    |键别   	|是否空  |数据类型  |长度|备注|
|-------------|----------|--------|-------|---------|----|------
|categoryId	  |类别编号  |PK 	 |NO	    |int	|16  |      |
|categoryNama |类型名    |-     	|NO	        |varchar	|16  |      |
|gmt_create	  |创建时间	 |-       |NO    	|data_time|  |      |
|gmt_modified |修改时间	 |-       |NO        |data_time|  |      |

