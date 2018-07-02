$(function () {

alert("xhaungti");


ss(1);





})

function ss(PageIndex) {
    $.ajax({
        type: 'POST',
        url: '/shangpin',
        data: {PageIndex: PageIndex},
        success: function (data) {
            $("#xuan").empty();
            $("#xuan").append(data);
        }, error: function () {
            alert("no");
        }
    })

}




function lll(jiage) {
    var zhi=$("#login_phone").val();

alert(jiage);



$.ajax({
    type:'get',
    url:'/gai',
    data:{ji:jiage},
    dataType:"JSON",
    success:function (data) {
        alert("兑换成功");
        window.location.href="/shangpin";

    },error:function () {
        alert("兑换失败");
    }
})
}


