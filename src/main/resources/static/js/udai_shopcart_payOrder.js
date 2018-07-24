$(function () {
    $(document).on("click","#zh",function () {
        /* var orderamounts=$(".orderamounts").text();*/
        var prices=$(".prices").text();
        var skuids=$(".skuids").text();
        var productIds=$(".productIds").text();

        $.ajax({
            type:"POST",
            url:"/Order/addOrder",
            data: {order_price:prices ,productid: productIds},
            dataType:"json",
            success:function(data){
                if(data>0){
                    $.ajax({
                        type:"POST",
                        url:"/Order/addOrderdet",
                        data: {skuId: skuids },
                        dataType:"json",
                        success:function(data){
                            if(data>0){
                                alert("添加成功!");
                                window.location.href="/Order/show";
                            }
                        },error:function(data){
                            alert("添加失败！");
                        }
                    });
                }
            },error:function(data){
                alert("添加失败！");
            }
        });


    })
});
