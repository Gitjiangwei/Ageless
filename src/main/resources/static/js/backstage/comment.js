function First() {
    $.ajax({
        type: "post",
        url: "/CateOne/getcategory1list",
        data: {name: null},
        dataType: "JSON",
        success: function (data) {
            $("#one").html("");
            $("#one").append("<option value='0'>--请选择--</option>");
            for (var i = 0; i < data.length; i++) {
                $("#one").append("<option value='" + data[i].id + "'>" + data[i].categoryName + "</option>")
            }
        },
        error: function (data) {
            alert("一级分类加载失败");
        }
    })
}
function getCategoryListTwo(id){

   if(id!=0) {
       $.ajax({
           type: "post",
           url: "/CateTwo/Twolist",
           data: {id: id},
           dataType: "json",
           success: function (data) {
               $("#two").html("");
               $("#two").append("<option value='0'>--请选择--</option>");
               for (var i = 0; i < data.length; i++) {
                   $("#two").append("<option value='" + data[i].id + "'>" + data[i].categoryName + "</option>")
               }
           },
           error: function (data) {
               alert("二级分类加载失败");
           }
       });
   }else{
       $("#two").html("");
       $("#three").html("");
   }

}
function getCategoryListThree(id){

    if(id!=0) {
        $.ajax({
            type: "post",
            url: "/CateThree/Threelist",
            data: {id: id},
            dataType: "json",
            success: function (data) {
                $("#three").html("");
                $("#three").append("<option value='0'>--请选择--</option>");
                for (var i = 0; i < data.length; i++) {
                    $("#three").append("<option value='" + data[i].id + "'>" + data[i].categoryName + "</option>")
                }
            },
            error: function (data) {
                alert("三级分类加载失败");
            }
        });
    }else{
        $("#three").html("");
    }
}
$(document).ready(function () {
    First();

    $("#one").change(function(){
        var one = $("#one").val();
        if(one != '' && one != null){
            getCategoryListTwo(one);
        }else{
            getCategoryListTwo(null);

        }
        $("#Two").html("<option value='0'>--请选择--</option>");
    });

    $("#two").change(function(){
        var queryCategoryLevel2 = $("#two").val();
        if(queryCategoryLevel2 != '' && queryCategoryLevel2 != null){
            getCategoryListThree(queryCategoryLevel2);
        }else{
            getCategoryListTwo(null);
        }
    });
});