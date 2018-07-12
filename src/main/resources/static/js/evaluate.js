
//点击事件
$(document).on("click","#tiJiao",function () {

    add();
})

//新增方法
function add() {
    var size = $(".uploader__files").find('li').length;

    var formData = new FormData();
    for (var i=0;i<size;i++){
       switch (i) {
           case 0:
            var shopImg1 = $(".file1")[0].files[0];
            formData.append("shopImg1",shopImg1);
            break;
           case 1:
               var shopImg1 = $(".file1")[0].files[0];
               formData.append("shopImg1",shopImg1);
               var shopImg2 = $(".file2")[0].files[0];
               formData.append("shopImg2",shopImg2);
               break;
           case 2:
               var shopImg1 = $(".file1")[0].files[0];
               formData.append("shopImg1",shopImg1);
               var shopImg2 = $(".file2")[0].files[0];
               formData.append("shopImg2",shopImg2);
               var shopImg3 = $(".file3")[0].files[0];
               formData.append("shopImg3",shopImg3);
               break;
           case 3:
               var shopImg1 = $(".file1")[0].files[0];
               formData.append("shopImg1",shopImg1);
               var shopImg2 = $(".file2")[0].files[0];
               formData.append("shopImg2",shopImg2);
               var shopImg3 = $(".file3")[0].files[0];
               formData.append("shopImg3",shopImg3);
               var shopImg4 = $(".file4")[0].files[0];
               formData.append("shopImg4",shopImg4);
               break;
           case 4:
               var shopImg1 = $(".file1")[0].files[0];
               formData.append("shopImg1",shopImg1);
               var shopImg2 = $(".file2")[0].files[0];
               formData.append("shopImg2",shopImg2);
               var shopImg3 = $(".file3")[0].files[0];
               formData.append("shopImg3",shopImg3);
               var shopImg4 = $(".file4")[0].files[0];
               formData.append("shopImg4",shopImg4);
               var shopImg5 = $(".file5")[0].files[0];
               formData.append("shopImg5",shopImg5);
               break;
        }

    }

    var dengJi = $("input[name=dengJi]").val();
    var pingjia=$(".pingjia").val();
    formData.append("dengJi",dengJi);
    formData.append("pingjia",pingjia);


    $.ajax({

        type: "post",
        url: "/haha/insert",
        data:formData ,
        dataType: "json",
        contentType:false,
        processData:false,
        cache:false,
        success: function (data) {
            alert("新增成功");
        }


    });
}