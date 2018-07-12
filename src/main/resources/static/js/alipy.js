$(function () {
   $(document).on('click','#zh',function () {

       var vNow = new Date();
       var sNow = "";
       sNow += String(vNow.getFullYear());
       sNow += String(vNow.getMonth() + 1);
       sNow += String(vNow.getDate());
       sNow += String(vNow.getHours());
       sNow += String(vNow.getMinutes());
       sNow += String(vNow.getSeconds());
       sNow += String(vNow.getMilliseconds());
       var WIDsubject=$("#WIDsubject").val();
       var WIDtotal_amount=$("#WIDtotal_amount").html();
       $.ajax({
           type:"POST",
           url:"/alipay/pagepay",
           data:{"WIDout_trade_no":sNow,"WIDtotal_amount":WIDtotal_amount,"WIDsubject":WIDsubject},
           dataType:"text",
           success:function (data) {
               $("#bdo").html(data);
           },error:function () {

               alert("通讯失败")
           }
        });
   });
});