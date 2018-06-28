$(function () {

    cha(0 ,null);
});


function cha(id ,name){
    $.ajax({
        url: "/sku/cha",
        type: "get",
        data:{id:id,nam:name},
        dataType: "json",
        async: true,
        success: function(data) {
            $("#tbod").html("");
            var s="";
            for (var p=0;p<data.length ;p++) {
               s+= "<tr><td>"+(p+1)+"</td><td>"+data[p].propertyName+"</td><td>";
                for(var i=0;i<data[p].list.length;i++){
                    s+=data[p].list[i].optionName;
                    if(i !=data[p].list.length-1){
                      s+=  "、";
                    }
                }
            s+="</td><td>"+data[p].categoryName+"</td>"
            s+="<td id='del"+data[p].id+"'><span onclick=update1("+data[p].id+");>删除</span></td></tr>";
        }
            $("#tbod").html(s);
          /*  $('#tableData tbody').replaceWith(tbody);*/
            showPage(1, 10, 46);
        },
        error: function() {
            alert("出现异常！");
        }
    });
}
$("#sousou").click(function () {
    var sid=$("#sid").val();
    var sname=$("#sname").val();
    cha(sid ,sname);
});
function update1(id) {
    alert("asdasda");
    deleteShowAlert('删除提示', '确定要删除吗？', '确定', '取消', id);

};
function result(bz, choose) {
    if(choose) {
    $.ajax({
        url: "/sku/shan",
        type: "get",
        data:{id:bz},
        dataType: "json",
        async: true,
        success: function(data) {
            if(data !=0){
                showWebAlert("删除成功！");
                $("#del"+bz+"").parent().remove();
            }else{
                showWebAlert("删除失败！");
            }
        },
        error: function() {
            alert("删除失败！");
        }
    });
    }
};