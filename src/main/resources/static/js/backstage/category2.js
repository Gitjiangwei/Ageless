$(function(){

	$.ajax({
		type:"POST",
		url:"/CateOne/getcategory1list",
		data:{name:null},
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
            twoCategory+='<tr> <th>编号</th> <th>分类名</th> <th>操作</th> </tr>';
            data.map(function(item,index){
                oneCategory +='<tr><th>'+item.id+'</th><th>'+item.categoryName+'</th><th><button class=" button del" style="width:65px;height: 28px"  onclick="nav('+item.id+')">删除</button> &nbsp;&nbsp;<button  class=" button aaa" style="width:65px;height: 28px">修改</button><span cid='+item.id+' cparentId='+item.parentId+'></span></th></tr>';
            });
            $("#fen2").html("");
            $("#fen2").html(twoCategory+oneCategory);
        },
    });
}


$('#sousuo').click(function () {
    var id=$("#yifen").val();
    var categoryName=$("#souText").val();
    $.ajax({
        type:"GET",
        url:"/CateTwo/Twolist",
        data:{id:id,categoryName:categoryName},
        dataType:"json",
        success:function(data){
            var oneCategory;
            var twoCategory;
            twoCategory+='<tr> <th>编号</th> <th>分类名</th> <th>操作</th> </tr>';
            data.map(function(item,index){
                oneCategory +='<tr><th>'+item.id+'</th><th>'+item.categoryName+'</th><th><button style="width:65px;height: 28px" class="button del" onclick="nav('+item.id+')">删除</button>&nbsp;&nbsp;  <button style="width:65px;height: 28px" class="button aaa">修改</button><span cid='+item.id+'></span></th></tr>';
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
                   showWebAlert("添加成功！");
                   loadAjax();
                   $("#xianshi").hide();
                   $(".sortcon :first").val("");
                   $(".sortcon :first").siblings().remove();
               }else{
                   showWebAlert("添加失败！")

               }
           },
           error:function () {
               showWebAlert("系统错误");
           }
       });
   }else{
       showWebAlert("请选择一级分类");
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
                        showWebAlert("删除二三级分类成功！");
                    } else if(data=="2"){
                        showWebAlert("删除该分类成功！");
                    }else{
                        showWebAlert("删除失败！");
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
                    showWebAlert("修改成功");
                    loadAjax();
                }else{
                    showWebAlert("修改失败");
                }
            }
        });

    }else{
        showWebAlert("请填写修改内容！");
    }
});