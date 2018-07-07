$(function(){
    nav();
    mav();
});
function nav(){
    $.ajax({
        type:"GET",
        url:"/CateThree/Threelist",
        data:{"id":null,"name":null},
        dataType:"JSON",
        success:function(data) {
            var three ;
            var threeCategory;

            three +='<tr><th>&nbsp;</th> <th>编号</th> <th>分类名</th><th>操作</th></tr>'
            data.map(function(item,index){
                threeCategory +='<tr><th>&nbsp;</th><th>'+item.id+'</th><th>'+item.categoryName+'</th>'
                    +'<th><button class="del" onclick="nav2('+item.id+')">删除</button> <span  class="aaa">修改</span><span cid='+item.id+'></span></th></tr>';
            });
            $("#there").html("");
            $("#there").html(three+threeCategory);
        }
    });
}
function mav() {
    $.ajax({
        type:"POST",
        url:"/CateOne/getcategory1list",
        data:{name:null},
        dataType:"JSON",
        success:function(data) {
            var three ;
            var threeCategory;
            three +='<option value="0">全部</option>'
            data.map(function(item,index){
                threeCategory +='<option value='+item.id+'>'+item.categoryName+'</option>'
            });
            $("#onecate").html("");
            $("#onecate").html(three+threeCategory);
        }
    });
}
$("#onecate").click(function(){
    var id=$("#onecate").val();
    $.ajax({
        type:"GET",
        url:"/CateTwo/Twolist",
        data:{"id":id},
        dataType:"JSON",
        success:function(data){
            var threeCategory;
            data.map(function(item,index){
                threeCategory +='<option value='+item.id+'>'+item.categoryName+'</option>'
            });
            $("#twocate").html("");
            $("#twocate").html(threeCategory);
        }
    });
});
$("#sousuo").click(function(){
    var id=$("#twocate").val();
    var name=$("#nama").val();
    $.ajax({
        type:"GET",
        url:"/CateThree/Threelist",
        data:{"id":id,"name":name},
        dataType:"JSON",
        success:function(data){
            var three ;
            var threeCategory;

            three +='<tr><th>&nbsp;</th> <th>编号</th> <th>分类名</th><th>操作</th></tr>'
            data.map(function(item,index){
                threeCategory +='<tr><th>&nbsp;</th><th>'+item.id+'</th><th>'+item.categoryName+'</th>'
                    +'<th><button class="del" onclick="nav2('+item.id+')" >删除</button> <span  class="aaa">修改</span><span cid='+item.id+'></span></th></tr>';
            });
            $("#there").html("");
            $("#there").html(three+threeCategory);
        }
    });
});
$(document).on("click",".ti",function(){
    var name = $(this).prev().val();
    var id = $(this).parent().attr("cid");
   $.ajax({
        type:"GET",
        url:"/CateThree/Threeupdate",
        data:{"id":id,"name":name},
        dataType:"JSON",
        success:function(data) {
            if(data=="1"){
                showWebAlert("修改成功");
                nav();
            }else{
                showWebAlert("修改失败");
            }
        },error:function(){
           showWebAlert("系统错误");
       }
    });
});
function nav2(id) {
    deleteShowAlert('删除提示', '确定要删除吗？', '确定', '取消', id,'删除后该类型下面的信息将全部删除');
}
function result(bz, choose) {
    if(choose) {
        $.ajax({
            type: "GET",
            url: "/CateThree/Threedelete",
            data: {"id": bz},
            dataType: "JSON",
            success: function (data) {
                if (data == "1") {
                    showWebAlert("删除成功");
                    nav();
                } else {
                    showWebAlert("删除失败");
                }
            }, error: function () {
                showWebAlert("系统错误");
            }
        });
    }
}
$("#insertThree").click(function(){
    var id=$("#twocate").val();
    var name=$(".threetext");
    var names=new Array();
    var tempObj;
    name.map(function(index,item){
        tempObj=$(item).val();
        names.push(tempObj);
    });
   if(id!=null && id!=""){
       $.ajax({
           type:"GET",
           url:"/CateThree/Threeinsert",
           data:{"id":id,names:names.toString()},
           dataType:"JSON",
           success:function(data) {
               if(data.result=="success"){
                   showWebAlert("添加成功");
                   nav();
                   $("#xianshi").hide();
                   $(".sortcon :first").val("");
                   $(".sortcon :first").siblings().remove();
               }else{
                   showWebAlert("添加失败");
               }
           },error:function(){
               showWebAlert("系统错误");
           }
       });
   }else{
       showWebAlert("请选择二级分类");
   }

});


