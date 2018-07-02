$(function () {
    nav();
});
//查询所有
function nav(){
    $.ajax({
        type:"GET",
        url:"/er/select.html",
        dataType:"json",
        success:function(data){
             $("#info").html("");
            for (var i=0;i<data.length;i++){

                $("#info").append("<a class='swiper-slide ep' style='height: 24px' href='/er/getTest.html?xid="+data[i].typeId+"&yid="+data[i].id+"'>【"+data[i].typeName+"】"+data[i].title+"</a><br>");

            }
                },error:function(){
            alert("11");
        }
    });
}


//id点击查
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
});



