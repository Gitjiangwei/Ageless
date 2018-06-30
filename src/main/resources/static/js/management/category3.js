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
                    +'<th><button class="del" value='+item.id+'>删除</button> <span  class="aaa">修改</span><span  style="display:none;"><input type="text" class="textStyle" style="width:60px;" id="threename"><a  id="threetijiao">提交</ a></span></th></tr>';
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
                    +'<th><button class="del" value='+item.id+' >删除</button> <span  class="aaa">修改</span><span  style="display:none;"><input type="text" class="textStyle" style="width:60px;" id="threename"><a id="threetijiao">提交</ a></span></th></tr>';
            });
            $("#there").html("");
            $("#there").html(three+threeCategory);
        }
    });
});
$("#there").on("click","#threetijiao",	function(){
    var name=$("#threename").val();
    var id=$(".del").val();
   $.ajax({
        type:"GET",
        url:"/CateThree/Threeupdate",
        data:{"id":id,"name":name},
        dataType:"JSON",
        success:function(data) {
            if(data=="1"){
                alert("修改成功");
                nav();
            }
        },error:function(){
           alert("失败");
       }
    });
});
$("#there").on("click",".del",	function(){
    var id=$(this).val();
    alert(id);
    $.ajax({
        type:"GET",
        url:"/CateThree/Threedelete",
        data:{"id":id},
        dataType:"JSON",
        success:function(data) {
            if(data=="1"){
                alert("删除成功");
                nav();
            }
        },error:function(){
            alert("失败");
        }
    });
});
$("#insertThree").click(function(){
    var id=$("#twocate").val();
    var name=$(".threetext");
    var names=new Array();
    var tempObj;
    name.map(function(index,item){
        tempObj=$(item).val();
        names.push(tempObj);
    });
    alert(names.toString());
   if(id!=null && id!=""){
       $.ajax({
           type:"GET",
           url:"/CateThree/Threeinsert",
           data:{"id":id,names:names.toString()},
           dataType:"JSON",
           success:function(data) {
               if(data.result=="success"){
                   alert("添加成功");
                   nav();
               }
           },error:function(){
               alert("失败");
           }
       });
   }else{
       alert("请选择二级分类");
   }

});


