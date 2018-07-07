$(function () {
    $("#backs").click(function () {
        location.href="/backstage/back_table.html";
    });
    $.ajax({
        url:"/backstage/gerenInfo",
        type:"get",
        data:"text",
        dataType:"json",
        success:function (data) {
            for (var i=0;i<data.length;i++) {
                $("#memberName").text("会员名："+data[i].membership);
                if(data[i].sex==1){
                    $("#sex").text("性别：男");
                }else if(data[i].sex==2){
                    $("#sex").text("性别：女");
                }else{
                    $("#sex").text("性别：保密");
                }
                if(data[i].mailbox!=null){
                    $("#emailNum").text("注册邮箱："+data[i].mailbox);
                }else{
                    $("#emailNum").text("注册邮箱：暂未绑定");
                }
                if(data[i].phone!=null){
                    $("#phoneNum").text("注册手机："+data[i].phone);
                }else{
                    $("#phoneNum").text("注册手机：暂未绑定");
                }

                $("#dateTime").text("创建日期："+getMyDate(data[i].regtime));
                if(data[i].dongjie==1){
                    $("#dong").text("是否冻结：未冻结");
                }else {
                    $("#dong").text("是否冻结：已冻结");
                }

            }
        },
        error:function (data) {
            alert("请求服务器失败");
        }
    });
});

/**
 * 时间日期转换
 * @param str
 * @returns {string}
 */
function getMyDate(str){
    var oDate = new Date(str),
        oYear = oDate.getFullYear(),
        oMonth = oDate.getMonth()+1,
        oDay = oDate.getDate(),
        oHour = oDate.getHours(),
        oMin = oDate.getMinutes(),
        oSen = oDate.getSeconds(),
        oTime = oYear +'-'+ getzf(oMonth) +'-'+ getzf(oDay) +' '+ getzf(oHour) +':'+ getzf(oMin) +':'+getzf(oSen);//最后拼接时间
    return oTime;
};
//补0操作
function getzf(num){
    if(parseInt(num) < 10){
        num = '0'+num;
    }
    return num;
}