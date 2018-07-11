$(document).ready(function () {
    var proId=$("#proId").val();

    pij(null,proId,null);

    commCoun(proId);

    $(".pinj").click(function () {
        var pinj=$(this).val();
        pij(null,proId,pinj);
    });

    $(document).on("click",".xqs",function () {
        var proId=$(this).attr("xq");
        xq(proId);
    });

    $(document).on("click",".page",function () {
        var page=$(this).attr("pages");
        var pj=$(".radioStyle").val();
        pij(page,proId,pj);
    })

});

function result(cid,choose) {
    if(choose==true){
        $.ajax({
            type:"GET",
            url:"/comment/dele",
            data:{cid:cid},
            dataType:"JSON",
            success:function (data) {
                if(data>0){
                    $("#del"+cid).parent().parent().remove();
                    showWebAlert("删除成功");
                    var proId=$("#proId").val();+

                    commCoun(proId);
                }
            }
        })
    }
}

function commCoun(proId) {
    $.ajax({
        type:"GET",
        url:"/comment/count",
        data:{proId:proId},
        dataType:"JSON",
        success:function (data) {
            var count=0;
            for (var i=0;i<data.length;i++){
                $(".pin"+i+"").text(data[i])
                count+=data[i];
            }
            var num=parseInt(data[1]);
            $(".pin4").text("好评率："+(num/count)*100+"%");
        }
    });
}

function pij(page,proId,pinj) {
    $.ajax({
        type:"GET",
        url:"/comment/proCom",
        data:{proId:proId,pinj:pinj,pageNo:page},
        dataType:"JSON",
        beforeSend:function(XMLResquest){
            $("tbody").html("<tr>" +
                "<td colspan=\"4\">" +
                "<img src='/images/backstage/loading.gif' />" +
                "</td>" +
                "</tr>");
        },
        success:function (data) {
            $("tbody").html("");
            for(var i=0;i<data.list.length;i++){
                $("tbody").append("<tr id='c"+data.list[i].pingId+"'>\n" +
                    "<td style=\"width: 50px;\">\n" +
                    ""+(i+1)+"</td>\n" +
                    "<td style=\"width: 150px;\">"+data.list[i].name+"</td>\n" +
                    "<td class=\"commen\">"+data.list[i].file+"\n" +
                    "</td>\n" +
                    "\t\t\t\t\t\t\t<td style=\"width: 150px;\">\n" +
                    "\t\t\t\t\t\t\t\t<a href=\"javascript:;\" id=\"open\" bh="+i+" xq="+data.list[i].pingId+" class=\"button xqs\">详情</a>\n" +
                    "\t\t\t\t\t\t\t\t<a href=\"javascript:;\" id='del"+data.list[i].pingId+"' bh="+i+" xq="+data.list[i].pingId+" class=\"button del\">删除</a>\n" +
                    "\t\t\t\t\t\t    </td>\n" +
                    "\t\t\t\t\t\t</tr>")
            }

            $(".page_fen").html("");
            if(data.pageNum!=1) {
                $(".page_fen").append("<li><a href=\"javascript:;\" class='page' pages=1 >首页</a></li>\n");
            }
            for (var i=1;i<=data.lastPage;i++) {
                    if (i == data.pageNum) {
                        $(".page_fen").append("<li><a href=\"javascript:;\" class='page' pages=" + i + " style='color: #4c0d0f;font-weight: bold'>" + i + "</a></li>\n");
                    } else {
                        $(".page_fen").append("<li><a href=\"javascript:;\" class='page' pages=" + i + ">" + i + "</a></li>\n");
                    }
            }
            if(data.pageNum!=data.lastPage) {
                $(".page_fen").append("<li><a href=\"javascript:;\" class='page' pages="+data.lastPage+" >末页</a></li>\n");
            }
        }
    })
}

function xq(proId) {
    $.ajax({
        type:"GET",
        url:"/comment/selectById",
        data:{cid:proId},
        dataType:"JSON",
        success:function (data) {
               $("#fbox1").text(data[0].name);
               $("#fbox2").text(data[0].file);
               $("#fbox3").html("<img src="+data[0].photo1+" width=\"100px;\" alt=\"\">\n" +
                   "<img src="+data[0].photo2+" width=\"100px;\" alt=\"\">\n" +
                   "<img src="+data[0].photo3+" width=\"100px;\" alt=\"\">\n" +
                   "<img src="+data[0].photo4+" width=\"100px;\" alt=\"\">\n" +
                   "<img src="+data[0].photo5+" width=\"100px;\" alt=\"\">\n" +
                   "\t");
               $("#fbox4").text(data[0].createTime);
        }
    })
}