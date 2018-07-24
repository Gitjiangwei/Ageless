$(function () {
    //nav();//类型查询
    f();//id查询
    index(1);//类型
});
//类型查询
function nav(){
    var typeId=$("#xid").val();
    $.ajax({
        type:"GET",
        url:"/er/select.html",
        data:{typeId:typeId},
        dataType:"json",
        success:function(data){
            $("#linfo").html("");
            for (var i=0;i<data.length;i++){

                $("#linfo").append("<a href='javascript:;' class='ep active woqu' vid="+data[i].id+"  >【"+data[i].typeName+"】 "+data[i].title+"</a>");

            }

        },error:function(){
            alert("失败5");
        }
    });
}



/*//id点击查
$(document).on("click",".woqu",function (){
 var lll=$(this).attr("vid");
 alert(lll);
    $.ajax({
        type:"post",
        url:"/er/idcha.html",
        data:{id:lll},
        dataType:"json",
        success:function(data){
            $("#idcha").html("");
            alert(data);
            var date = new Date(data.announcementTime);
            var month = date.getMonth()+1;
            var year =date.getFullYear();
            var day = date.getDate();
            var hours  = date.getHours();
            var minutes  = date.getMinutes() ;
            var seconds = date.getSeconds();
            alert(year+"年"+month+"月"+day+"日"+hours+"时"+minutes+"分"+seconds+"秒");
            $("#idcha").append("<div class=\"head-div clearfix posr\"><div class=\"title\">"+'【' + data.typeName + '】' + data.title + "</div><div class=\"time pull-right\">发布时间："+year+"年"+month+"月"+day+"日"+hours+"时"+minutes+"分"+seconds+"秒"+"</div></div><div class=\"html-code\"><p style=\"text-indent: 2em\">" + data.announcementContent  + "</p></div>");
        },error:function(){
            alert("查看失败");
        }
    })
});*/
//窗体id查
function f() {
    var yid=$("#yid").val();

    $.ajax({
        type:"post",
        url:"/er/idcha.html",
        data:{id:yid},
        dataType:"json",
        success:function(data){
            $("#idcha").html("");
            alert(yid);
            alert("asda");
            var date = new Date(data.announcementTime);
            var month = date.getMonth()+1;
            var year =date.getFullYear();
            var day = date.getDate();
            var hours  = date.getHours();
            var minutes  = date.getMinutes() ;
            var seconds = date.getSeconds();
            $("#idcha").append("<div class=\"head-div clearfix posr\"><div class=\"title\">"+'【' + data.typeName + '】' + data.title + "</div><div class=\"time pull-right\">发布时间："+year+"年"+month+"月"+day+"日"+hours+"时"+minutes+"分"+seconds+"秒"+"</div></div><div class=\"html-code\"><p style=\"text-indent: 2em\">" + data.announcementContent  + "</p></div>");
            },error:function(){
            alert("查看失败");
        }
    })
}
//窗体类型
function index(a) {
    var typeId=$("#xid").val();
    $.ajax({
        type:"post",
        url:"/er/probyxiao.html",
        data:{pageindex:a,typeId:typeId},
        dataType:"html",
        success:function (data){
            $(".mvs").empty();
            $(".mvs").append(data);
            $("#xid").val(data.typeId);
        },error:function(){

        }
    })
}


