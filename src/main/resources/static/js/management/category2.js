$(function(){

	$.ajax({
		type:"GET",
		url:"/CateOne/Oneadd",
		data:{},
		dataType:"json",
		success:function(data){
			var oneCategory;
			var twoCategory;
            twoCategory +='<option value="0">全部</option>';
            data.map(function(item,index){
                oneCategory +='<option value='+item.id+'>'+item.categoryName+'</option>';
            });
            $("#yifen").html("");
			$("#yifen").html(twoCategory+oneCategory);
		},
	});
    loadAjax();
});

function loadAjax(){
    $.ajax({
        type:"GET",
        url:"/CateTwo/Twolist1",
        data:{},
        dataType:"json",
        success:function(data){
            var oneCategory;
            var twoCategory;
            twoCategory+='<tr> <th>&nbsp;</th> <th>编号</th> <th>分类名</th> <th>操作</th> </tr>';
            data.map(function(item,index){
                oneCategory +='<tr><th>&nbsp;</th><th>'+item.id+'</th><th>'+item.categoryName+'</th><th><button class="del" onclick="nav('+item.id+')">删除</button> <span  class="aaa">修改</span><span cid='+item.id+' cparentId='+item.parentId+'></span></th></tr>';
            });
            $("#fen2").html("");
            $("#fen2").html(twoCategory+oneCategory);
        },
    });
}


$('#sousuo').click(function () {
    alert("bbbbb");
    var id=$("#yifen").val();
    alert(id);
    var categoryName=$("#souText").val();
    alert(categoryName);
    $.ajax({
        type:"GET",
        url:"/CateTwo/Twolist",
        data:{id:id,categoryName:categoryName},
        dataType:"json",
        success:function(data){
            var oneCategory;
            var twoCategory;
            twoCategory+='<tr> <th>&nbsp;</th> <th>编号</th> <th>分类名</th> <th>操作</th> </tr>';
            data.map(function(item,index){
                oneCategory +='<tr><th>&nbsp;</th><th>'+item.id+'</th><th>'+item.categoryName+'</th><th><button class="del" onclick="nav('+item.id+')">删除</button>  <span  class="aaa">修改</span><span cid='+item.id+' cparentId='+item.parentId+'></span></th></tr>';
            });
            $("#fen2").html("");
            $("#fen2").html(twoCategory+oneCategory);
        },
    });
});
$(".save").click(function () {
    var parentId = $("#yifen").val();
    var tempArr = $(".tian");
    var categoryNameList =new Array();
    tempArr.map(function (index,item) {
        tempObj = $(item).val();
        categoryNameList.push(tempObj);
    });
   if(parentId!=null && parentId!=""){
       $.ajax({
           type:"post",
           url:"/CateTwo/Twoinsert",
           data:{categoryNameList:categoryNameList.toString(),parentId:parentId},
           dataType:"json",
           success:function(data){
               if(data.result=="success"){
                   //showWebAlert();
                   alert("添加成功！");
                   loadAjax();
               }else{
                   alert("添加失败！")
                   //showWebAlert("添加失败！");
               }
           },
           error:function () {
               alert("系统错误");
           }
       });
   }else{
       alert("对不起，所选一级分类不能为空");
   }

});
function nav(id) {
    deleteShowAlert('删除提示', '确定要删除吗？', '确定', '取消', id,'删除后该类型下面的信息将全部删除');
}
function result(bz, choose) {
    if(choose) {
            $.ajax({
                type: "GET",
                url: "/CateTwo/Twodelete",
                data: {id: bz},
                dataType: "json",
                success: function (data) {
                    if (data == "1") {
                        alert("删除成功！");
                    } else if(data=="2"){
                        alert("删除成功！但不存在对应的三级标签");
                    }else{
                        alert("删除失败！");
                    }
                    loadAjax();
                }
            });

    }
}



$(document).on("click",".ti",function () {
    var id = $(this).parent().attr("cid");

    var name = $(this).prev().val();

   var parentId = $("#yifen").val();

    if(name !=null && name!=""){
        $.ajax({
            type: "GET",
            url: "/CateTwo/xiugai",
            data: {id: id,categoryName:name,parentId:parentId},
            dataType: "json",
            success: function (data) {
                if(data=="1"){
                    alert("修改成功");
                    loadAjax();
                }else{
                    alert("修改失败");
                }
            }
        });

    }else{
        alert("对不起修改内容为空！");
    }
});