
//窗体加载事件
$(function () {
    xiaLa();
    $(document).on("click","#save",function(){

     
        insert();

    });
})

// 下拉列表查
function xiaLa() {
    $.ajax({
        type:"GET",
        url:"/er/xiaLa",
        dataType:"json",
        success:function (data) {
            $(".selt").html("");
            $(".selt").append("<option value='0'>全部</option>");
            for (var i=0;i<data.length;i++){
                $("#xiaLa").append("<option value="+data[i].nId+">"+data[i].typeName+"</option>");
            }
        }
    });
}


//新增方法
function insert() {
    var form =$("#insert").serialize();
    $.ajax({
        type:"GET",
        url:"/er/insert",
        data:form,
        dataType:"JSON",
        success:function (data) {

            alert('保存成功！');
            window.location.href="/backstage/noticeAll.html"
        }
    });
}
