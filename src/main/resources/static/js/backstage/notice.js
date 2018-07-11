//窗体加载事件
$(function () {

    select(null,0);
    xiaLa();

})
function select(title,typeId) {
   $.ajax({
       type:"GET",
       url:"/er/select",
       data:{title:title,typeId:typeId},
       dataType:"json",
       success:function (data) {
           $("#shabiwuleilei").remove();
           $("#tbo").html("");
        for(var i=0;i<data.length;i++){

            $("#tbo").append(" <tr> <td>"+data[i].id+" </td> <td>"+data[i].typeName+"</td> <td>"+data[i].title+"</td> <td>"+
            "<a href='javascript:;' id='edit'val="+data[i].id+" class='button edi'>编辑</a>"+
                "<a href='javascript:;' id='open' val="+data[i].id+" class='button'>详情</a>"+
                "<a href='javascript:;' id='del"+data[i].id+"' val="+data[i].id+" class='button del'>删除</a> </td> </tr>");

        }

       }
   })
}

//搜索点击事件
function sousuo() {

    var ss=$(".textStyle").val();

    var oo=$(".selectStyle").val();

    select(ss,oo);
}

//下拉列表查
function xiaLa() {
    $.ajax({
        type:"GET",
        url:"/er/xiaLa",
        dataType:"json",
        success:function (data) {

            $(".selt").html("");
            $(".selt").append("<option value='0'>全部</option>");
            for (var i=0;i<data.length;i++){
                $(".selt").append("<option value="+data[i].nId+">"+data[i].typeName+"</option>");
            }
        }
    });
}
//删除点击事件
$(document).on("click",".del",function () {

    var id=$(this).attr("val");
    var sss="del";
    deleteShowAlert('删除提示', '确定要删除吗？', '确定', '取消', id,sss);


})



//修改点击事件
$(document).on("click","#ed",function () {
    var id=$("#mm").val();

    var a=$("#userNames").val();

    var b=$("#select").val();
    if(b == '' || b == null){
        alert("请选择新闻类型");
        return false;
    }

    var c=$("#url").val();

    var d=$("#nei").val();

    xiuGai(id,a,b,c,d);

})


//修改法
function xiuGai(id,title,typeId,link,announcementContent) {
    $.ajax({
        type:"GET",
        url:"/er/update",
        data:{id:id,title:title,typeId:typeId,link:link,announcementContent:announcementContent},
        dataType:"json",
        success:function (data) {
           alert("更新成功");
            select(null,0);
            closeMask("stuInfo2");
        }
    });
}



function result(bz, choose,choo) {
        if(choose) {
            $.ajax({
                type:"GET",
                url:"/er/delet",
                data:{id:bz},
                dataType:"json",
                success:function (data) {
                    $("#del"+bz).parent().parent().remove();
                    showWebAlert('删除成功！');
                }
            });

        }

   /* if(choo=="update"){
        if(choose) {
            closeMask('all');
            closeMask('stuInfo2');
            closeMask('prop');
            showWebAlert('更新成功！');
        }else{
            closeMask('all');
            closeMask('prop');
            closeMask("stuInfo2");
        }
    }*/
}

//删除方法
/*function delet(id) {
    $.ajax({
        type:"GET",
        url:"/er/delet",
        data:{id:id},
        dataType:"json",
        success:function (data) {
            alert("删除成功");
        }
    });
}*/
//ID查询点击事件
$(document).on("click","#open",function () {

    var id=$(this).attr("val");
    selectId(id);
})

//详情ID查询方法
function selectId(id) {
    $.ajax({
        type:"GET",
        url:"/er/selectId",
        data:{id:id},
        dataType:"json",
        success:function (data) {
            $("#pp").html("");
            $(".pfooter").html("");
            $("#pp").append("<dl>\n" +
                "\t\t\t\t\t\t<dt><span>标题</span></dt>\n" +
                "\t\t\t\t\t\t<dd>\n" +
                "\t\t\t\t\t\t\t<div class=\"fbox\">\n" +
                ""+data.title+"" +
                "\t\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t</dd>\n" +
                "\t\t\t\t\t</dl>\n" +
                "\t\t\t\t\t<dl>\n" +
                "\t\t\t\t\t\t<dt><span>类型</span></dt>\n" +
                "\t\t\t\t\t\t<dd>\n" +
                "\t\t\t\t\t\t\t<div class=\"fbox\">\n" +
                ""+data.typeId+"" +
                "\t\t\t\t\t\t\t</div>\n" +
                "\n" +
                "\t\t\t\t\t\t</dd>\n" +
                "\t\t\t\t\t</dl>\n" +
                "\t\t\t\t\t<dl>\n" +
                "\t\t\t\t\t\t<dt><span>网址</span></dt>\n" +
                "\t\t\t\t\t\t<dd>\n" +
                "\t\t\t\t\t\t\t<div class=\"fbox\">\t\n" +
                ""+data.link+"" +
                "\t\t\t\t\t\t\t</div>\n" +
                "\n" +
                "\t\t\t\t\t\t</dd>\n" +
                "\t\t\t\t\t</dl>\n" +
                "\t\t\t\t\t<dl>\n" +
                "\t\t\t\t\t\t<dt><span>内容</span></dt>\n" +
                "\t\t\t\t\t\t<dd>\n" +
                "\t\t\t\t\t\t\t<div class=\"fbox\">\n" +
                "\t\t\t\t\t\t\t\t<p style=\"text-indent: 2em\">\n" +
                ""+data.announcementContent+"" +
                "\t\t\t\t\t\t\t\t</p>\n" +
                "\t\t\t\t\t\t\t</div>\t\t\t\t\t\t\n" +
                "\t\t\t\t\t\t</dd>\n" +
                "\t\t\t\t\t</dl>\n" +
                "\t\t\t\t\t<dl>\n" +
                "\t\t\t\t\t\t<dt><span>发布日期</span></dt>\n" +
                "\t\t\t\t\t\t<dd>\n" +
                "\t\t\t\t\t\t\t<div class=\"fbox\">\t\n" +
                ""+data.announcementTime+"" +
                "\t\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t</dd>\n" +
                "\t\t\t\t\t</dl>");
        }
    });
}

//编辑点击事件

$(document).on("click","#edit",function () {
    var id=$(this).attr("val");
    selectIdd(id);
})

//编辑ID查询方法
function selectIdd(id) {
    $.ajax({
        type:"GET",
        url:"/er/selectId",
        data:{id:id},
        dataType:"json",
        success:function (data) {
        $("#userNames").val("");
        $("#userNames").val(data.title);
        $("#url").val("");
        $("#url").val(data.link);
        $("#nei").val("");
        $("#mm").val("");
        $("#mm").val(data.id);
        $("#nei").val(data.announcementContent);
        }
});
};

