var path = $("#path").val();


$("#categoryLevel1").change(function(){

    var categoryLevel1 = $("#categoryLevel1").val();

    if(categoryLevel1 != '' && categoryLevel1 != null){



        $.ajax({
            type:"GET",//请求类型
            url:"/CateTwo/Twolist",//请求的url
            data:{id:categoryLevel1},//请求参数
            dataType:"json",//ajax接口（请求url）返回的数据类型
            success:function(data){//data：返回数据（json对象）

                $("#categoryLevel2").html("");
                var options = "<option value=\"\">--请选择--</option>";
                for(var i = 0; i < data.length; i++){



                    options += "<option value=\""+data[i].id+"\">"+data[i].categoryName+"</option>";
                }
                $("#categoryLevel2").html(options);
            },
            error:function(data){//当访问时候，404，500 等非200的错误状态码
                alert("加载二级分类失败！");
            }
        });
    }else{
        $("#categoryLevel2").html("");
        var options = "<option value=\"\">--请选择--</option>";
        $("#categoryLevel2").html(options);
    }
    $("#categoryLevel3").html("");
    var options = "<option value=\"\">--请选择--</option>";
    $("#categoryLevel3").html(options);
});

$("#categoryLevel2").change(function(){
    var categoryLevel2 = $("#categoryLevel2").val();
    if(categoryLevel2 != '' && categoryLevel2 != null){
        $.ajax({
            type:"GET",//请求类型
            url:"/CateThree/Threelist",//请求的url
            data:{id:categoryLevel2},//请求参数
            dataType:"json",//ajax接口（请求url）返回的数据类型
            success:function(data){//data：返回数据（json对象）
                $("#categoryLevel3").html("");
                var options = "<option value=\"\">--请选择--</option>";
                for(var i = 0; i < data.length; i++){
                    //alert(data[i].id);
                    //alert(data[i].categoryName);
                    options += "<option value=\""+data[i].id+"\">"+data[i].categoryName+"</option>";
                }
                $("#categoryLevel3").html(options);
            },
            error:function(data){//当访问时候，404，500 等非200的错误状态码
                alert("加载三级分类失败！");
            }
        });
    }else{
        $("#categoryLevel3").html("");
        var options = "<option value=\"\">--请选择--</option>";
        $("#categoryLevel3").html(options);
    }
});

function  nav(num) {
    deleteShowAlert('删除提示', '确定要删除吗？', '确定', '取消', num,'点确定后将删除属性及其对应的属性选项');
}
function result(bz, choose) {

    var falg=false;
    if(choose) {
        $.ajax({
            type: "GET",
            url: "/sort/del",
            data: {id: bz},
            dataType: "json",
            success: function (data) {
                if (data ==true||data==success) {
                    showWebAlert("删除成功！");

                     falg=true;
                } else if(data==false){
                    showWebAlert("删除失败！请刷新页面");
                } else{
                    showWebAlert("服务器异常！");
                }
              if(falg){
                    window.location.href="/sort/sortcon";
                }

            }
        });
    }

}

$("#tijiao").click(
    function () {

    var sx=$(".shuxing");
    var sort =new Array();
        sx.map(function (index,item) {
            tempObj = $(item).val();
            alert(index);
            sort.push(tempObj);

        }

        );
        alert(sort);
      var con=$(".ss");
      var sortcon=new Array();
       con.map(function (index,item) {
             sortObj=$(item).val();
             sortcon.push(sortObj);
       });
       alert(sortcon);
});