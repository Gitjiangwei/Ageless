$(function () {
    $.ajax({
        type:'post',
        url:'/showAdd',
        dataType:'json',
        success:function (data) {
            var context="";
            $.each(data,function (e,i) {
                if(i.state==1){
                    context+="<div class=\"radio-line radio-box active\">\n" +
                        "\t\t\t\t\t\t\t<label class=\"radio-label ep\" title=\""+i.province+i.city+i.area+i.street+i.details+i.consignee+i.tel+"\">\n" +
                        "\t\t\t\t\t\t\t\t<input name=\"addr\" checked=\"\" value=\"0\" autocomplete=\"off\" type=\"radio\"><i class=\"iconfont icon-radio\"></i>\n" +
                        "\t\t\t\t\t\t\t\t"+i.province+" "+i.city+" "+i.area+" "+i.street+"\n" +
                        "\t\t\t\t\t\t\t\t"+i.details+"\n" +
                        "\t\t\t\t\t\t\t\t（"+i.consignee+" 收） 1"+i.tel+"\n" +
                        "\t\t\t\t\t\t\t</label>\n" +
                        "\t\t\t\t\t\t\t<a href=\"javascript:;\" class=\"default\">默认地址</a>\n" +
                        "\t\t\t\t\t\t\t<a href=\"udai_address_edit.html?id="+i.id+"\" class=\"edit\">修改</a>\n" +
                        "\t\t\t\t\t\t</div>";
                }else if(i.state==0){
                    context+="<div class=\"radio-line radio-box\">\n" +
                        "\t\t\t\t\t\t\t<label class=\"radio-label ep\" title=\""+i.province+i.city+i.area+i.street+i.details+i.consignee+i.tel+"\">\n" +
                        "\t\t\t\t\t\t\t\t<input name=\"addr\" value=\"1\" autocomplete=\"off\" type=\"radio\"><i class=\"iconfont icon-radio\"></i>\n" +
                        "\t\t\t\t\t\t\t\t"+i.province+" "+i.city+" "+i.area+" "+i.street+"\n" +
                        "\t\t\t\t\t\t\t\t"+i.details+"\n" +
                        "\t\t\t\t\t\t\t\t（"+i.consignee+" 收） 1"+i.tel+"\n" +
                        "\t\t\t\t\t\t\t</label>\n" +
                        "\t\t\t\t\t\t\t<a onclick=\"cc("+i.id+','+i.nameId+")\" class=\"default\">设为默认地址</a>\n" +
                        "\t\t\t\t\t\t\t<a href=\"udai_address_edit.html?id="+i.id+"\" class=\"edit\">修改</a>\n" +
                        "\t\t\t\t\t\t</div>";
                }

            })
            $(".addr-radio").html(context);
        }
    })



})

new Vue({
    el:"#xunhuan",
    data:{
        totalMoney:0,
        shopList:[],
    },
    filters:{
    },
    mounted:function () {
        this.$nextTick(function () {
            this.cartView();
        })
    },
    methods:{
        cartView:function () {
            this.shopList=[]
            var _this=this;
            this.$http.get("/shop/getTotalMoney").then(function (json) {
                _this.totalMoney=json.data;
                alert(_this.totalMoney);
               /* _this.productList=json.data;
                for (var i =0;i<json.data.length;i++){
                    _this.picPathList=json.data[i].picPath;
                    /!* alert(json.data[i].picPath);*!/
                }*/
            });
            this.$http.get("/shop/getList").then(function (json) {
                _this.shopList=json.data;

                /*for (var int i;i<json.data.length;i++){

                }*/
                /*alert(json.data.length);*/
            });
        },
    }
})



Vue.filter("money",function (value,type) {
return "￥"+value.toFixed(2)+type;
})





