$(function () {
    alert("lll");

    $("#jifen").click(function () {
        var zhi=$("#login_phone").val();
        alert(zhi);
        alert("jifen");
       window.location.href="/chafen?hhhh="+zhi;
   /*     window.location.href="/chafen";*/
    })

})


