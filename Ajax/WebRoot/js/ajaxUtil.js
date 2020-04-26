function myAjax(method,url,data,deal200,deal404,deal500,async){
			
			
			var ajax=getAjax();
			
			
			
			//覆写onredaystatement函数
			ajax.onreadystatechange=function(){
				//判断ajax状态码
				if(ajax.readyState==4)
				{
					//判断响应状态码
					if(ajax.status==200){
						if(deal200){
							deal200(ajax);
						}
						
					}else if(ajax.status==404){
						if(deal404){
							deal404();
						}
						
					}else if(ajax.status==500){
						if(deal500){
							deal500();
						}
						
					}
					
				
				}
			}
			//发送请求
			if(method=="get"){
				ajax.open("get", url+(data==null?"":"?"+data),async);
				ajax.send(null);
			}else if(method=="post"){
				ajax.open("post", url,async);
				ajax.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
				ajax.send(data);
			}
			
			
		}
		
		
		myAjax("get","ajax",null,function(a){},async);
		
		/* ---------------------------------------------------------------------- */
		function getAjax(){
			//创建ajax引擎对象
			var ajax;
			if(window.XMLHttpRequest){//基本上的新版本浏览器都支持这个
				ajax=new XMLHttpRequest();
			}else if(window.activeXObject){//早期版本浏览器
				ajax=new activeXObject("Msxml2.XMLHTTP");
			}
			return ajax;
		}
		function deal200(a){
		//获取响应内容
						var result=a.responseText;
						//alert(ajax.readyState);
						//获取元素对象
						var showdiv=document.querySelector("#showdiv");
		
						showdiv.innerHTML=result;
		
		}