




//闭包写法
(function($){
	  //级联机构列表
 $.fn.myremoteselect= function(opts){
		 var setting =$.extend ({
			  id:"#_select",
			  chlid:"#_select1",
			  chlid2:"#_select2",
	          type:"1",
	          chltype:"2",
	          chltype2:"3",
            _url:"",
            _value:"0",
            _defaultvalue1:"",
            _defaultvalue2:"",
            _defaultvalue3:"",
            _isUpdate:false
         },opts||{});
		 if(setting._defaultvalue1!=""){
			 setting._isUpdate=true;
		 }
    	if(setting._isUpdate){
    		  initSecletUpdate(setting);
    	}else initSeclet(setting,false);
	  $(setting.id).change(function (){
			initSeclet(setting,true,$(setting.id));
			if($(setting.id).val()=="0"){
				$(setting.chlid).html("");
			}
			$(setting.chlid2).html("");
	  });
	  if(setting.chlid!=null){
		 $(setting.chlid).change(function (){
			$(setting.chlid2).html("");
			initSeclet(setting,false,$(setting.chlid),true);
			if($(setting.chlid).val()=="0"){
				$(setting.chlid2).html("");
			}
		  });	
	  }
	  function initSeclet(object,isChild,event,isChild2){
		var url;
		if(isChild){
    	   url= object._url+"?id="+event.val()+"&typeId="+object.chltype;
    	   }else if(isChild2){
    	    url=object._url+"?id="+event.val()+"&typeId="+object.chltype2; 
    	  }else{
    	    url=object._url+"?id="+object._value+"&typeId="+object.type; 
    	  }
    	   var _data =  remoteAjaxSelect(url);
    	    if(isChild){
    	    	  displaySelect(_data,object.chlid,object._defaultvalue2);
    		}else if(isChild2){
    			  displaySelect(_data,object.chlid2,object._defaultvalue3);
    		}else{
    			  displaySelect(_data,object.id,object._defaultvalue1);
    		}	
	   }
	  function initSecletUpdate(object){
			 var url2= object._url+"?id="+object._defaultvalue1+"&typeId="+object.chltype;
			 var url3 =  url=object._url+"?id="+object._defaultvalue2+"&typeId="+object.chltype2;
			 var url1 =url=object._url+"?id="+object._value+"&typeId="+object.type; 
			 var data1 = remoteAjaxSelect(url1);
			 var data2 = remoteAjaxSelect(url2);
			 var data3 = remoteAjaxSelect(url3);
			 displaySelect(data1,object.id,object._defaultvalue1);
			 displaySelect(data2,object.chlid,object._defaultvalue2);
			 displaySelect(data3,object.chlid2,object._defaultvalue3);
	  }
	  function displaySelect(data ,objid,defaultvalue){
			var str;
			if(data!=null && data.length != 0){
	    	    	str= "<option value ='0'>----请选择----</option>";
	    	      for(var i = 0;i < data.length; i++ ){ 
	    	    	 if(data[i].id==defaultvalue){
	    	    		   str+="<option value =' " + data[i].id + " '  selected='selected'> "+ data[i].name +"</option>"; 
	    	    	 }else{
	    	    		   str+="<option value =' " + data[i].id + " '> "+data[i].name +"</option>";    
	    	    	 }
	    	       } 
	    	      $(objid).html(str);
	    	 	}  
	  }
        function remoteAjaxSelect(url){
        	  var _data;
        	  $.ajax({
        			cache: false,
        			async: false,
        			url : url,
        			dataType : "JSON",
        			success : function(data) {
        				  _data=data;
        			}
        		 });
        	 return _data;
        }
};
	  //统一处理ajax的返回结果
	  $.ajaxCheck = function(data) {
			if(data.result) return true;
			else {
				  $.messager.alert("提示信息",data.msg);
				return false;
			}
		}
	  //表格排序
	  $.fn.mysorttable = function(opts) {
			var _isSort = false;
			var sortEle = $(this).find("tbody");
			var _that = this;
			var setting = $.extend({
				begin:"beginOrder",
				save:"saveOrder"
			},opts||{});
			sortEle.sortable({
				axis:"y",
				helper:function(e,ele) {
					//原始元素的td对象
					var _original = ele.children();
					var _helper = ele.clone();
					_helper.children().each(function(index){
						$(this).width(_original.eq(index).width());
					});
					_helper.css("background","#aaf");
					return _helper;
				},
				update:function(e,ui) {
					setOrders();
				}
			});
			
			sortEle.sortable("disable");
			
			$("#"+setting.begin).click(beginOrders);
			
			$("#"+setting.save).click(saveOrders);
			
			function beginOrders() {
				if(!_isSort) {
					$(_that).find("thead tr").append("<td>序号</td>");
					setOrders();
					$(_that).find("tfoot tr").append("<td>拖动排序</td>");
					sortEle.sortable("enable");
					_isSort = true;
				} else {
					  $.messager.alert('提示','已经处于排序状态');
				}
			}
			
			function saveOrders() {
				if(_isSort) {
					var idArg = sortEle.sortable("serialize",{key:"ids"});
					$.post("updateSort?"+idArg,function(data){
						if($.ajaxCheck(data)) {
							$(_that).find("tr").each(function(){
								$(this).children().last().remove();
							});
							sortEle.sortable("disable");
							_isSort = false;
						}
					});
				} else {
					  $.messager.alert('提示','还不是排序状态');
				}
			}
			
			function setOrders() {
				$(_that).find("tbody tr").each(function(index){
					if(_isSort) {
						$(this).find("td:last").html((index+1));
					} else
						$(this).append("<td>"+(index+1)+"</td>");
				});
			}
			return sortEle;
		}
	  //侧边栏的JavaScript动态效果
	$.fn.myaccordion = function(opts){
		  //定义配置的class和节点名称
		  var settings = $.extend ({
			  selectedClz: "navSelected",
			  titleTagName:"h3"
		  },opts||{});
		  var titleNode =  $(this).find("ul>"+settings.titleTagName);
		  var selectedNode = $(this).find("ul."+settings.selectedClz+">"+settings.titleTagName);
		  titleNode.css("cursor","pointer");
		  titleNode.nextAll().css("display","none");
		  selectedNode.nextAll().css("display","block");
		  //点击收回展开
		  titleNode.click(function(){
				var checked = $(this).parent("ul").hasClass(settings.selectedClz);
				if(checked){
					  $(this).parent().removeClass(settings.selectedClz);
					  $(this).nextAll().slideUp();
				}else{
					  $(this).parent().addClass(settings.selectedClz);
					  $(this).nextAll().slideDown();
				}
		  });
	};
	//列表鼠标悬停变色
	$.fn.trColorChange = function(opts){
		  var settings = $.extend ({
				overClz:"trMouseover",
				evenClz:"trEvenColor"
		  },opts||{});
		  $(this).find("tbody tr:even").addClass(settings.evenClz);
		  $(this).find("tbody tr").on("mouseenter mouseleave",function(){
			$(this).toggleClass(settings.overClz);	
		  });
	};
	//操作的提示
	$.fn.confirmOperator = function (opts){
		  var settings = $.extend ({
				msg:"该操作不可逆，确定进行该操作吗？",
			    eventName:"click"
		  },opts||{});
		  $(this).on(settings.eventName,function(){
			var uri = $(this).attr("href");
			console.info(uri);
			event.preventDefault();
			$.messager.confirm('操作确认！', settings.msg, function(r){
					if (r){
						window.location.href=uri;
					}
				});
		 });
	};
	//ztree 插件异步加载
	$.fn.mytree = function(opts) {
			var setting = $.extend({
				data:{
					simpleData:{
						enable: true,
						idKey: "id",
						pIdKey: "pid",
						rootPId: -1
					}
				},
				view: {
					dblClickExpand: false,
					selectedMulti: false
				},
				async: {
					enable: true,
					url: opts?(opts.url||"treeAll"):"treeAll"
					
				},
				mine: {
					listChild:1,
					srcElement:"#cc",
					src:"orgs/",
				},
				callback:{
					onAsyncSuccess:function(){
						  if(opts!=null){
							if(opts.mine.expandAll)t.expandAll(true);
						  }  
					}
				}
			},opts||{});
			var _mine = setting.mine;
			var t = $.fn.zTree.init($(this), setting);
			t.getCheckParentNodes = getCheckParentNodes;
			t.getCheckChildNodes = getCheckChildNodes;
			if(_mine.listChild) {
				t.setting.callback.onClick = listChild;
			}
			
			function listChild(event,treeId,treeNode) {
				  if(opts!=null){
						if(opts.mine.src)$(_mine.srcElement).attr("src",opts.mine.src+treeNode.id);
					 }  else{
						   $(_mine.srcElement).attr("src","channels/"+treeNode.id);   
					 }
			}
			
			function getCheckParentNodes(treeNode,checked) {
				var ps = new Array();
				var pn;
				while((pn=treeNode.getParentNode())) {
					if(pn.checked==checked) ps.push(pn);
					treeNode = pn;
				}
				return ps;
			}
			//第三个参数存储所有子节点
			function getCheckChildNodes(treeNode,checked,cs) {
				var ccs;
				if((ccs=treeNode.children)) {
					for(var i=0;i<ccs.length;i++) {
						var c = ccs[i];
						if(c.checked==checked) {
							cs.push(c);
						}
						getCheckChildNodes(c,checked,cs);
					}
				}
			}
			return t;
		}
	//远程非级联下来列表
$.fn.initselect= function(opts){
		 var setting =$.extend ({
			  id:"#_select",
			  _url:"",
			  _tyep:"1001",
			  _defaultvalue:''
        },opts||{});
		 var url1 = setting._url+'/'+setting._tyep;
		 var str= "<option value =''>--请选择--</option>";
	$.ajax({  
	         url:url1 ,  
	         type: 'GET',  
	         async: false,  
	         cache: false,  
	         dataType: "json",
	         success: function (data) {  
    	      for(var i = 0;i < data.length; i++ ){ 
    	    	 if(data[i].value==$.trim(setting._defaultvalue)){
    	    		   str+="<option value =' " + data[i].value + " '  selected='selected'> "+ data[i].name +"</option>"; 
    	    	 }else{
    	    		   str+="<option value =' " + data[i].value + " '> "+data[i].name +"</option>";    
    	    	 }
    	       } 
    	      $(setting.id).html(str);
	         }
		  });    
}
})(jQuery)
