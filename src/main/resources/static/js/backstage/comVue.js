new Vue({
    el:".container",
    data:{

            orderList: []

    },
    filters:{
        /*  formatMoney: function (value) {
              return "￥" + value.toFixed(2)//前端不建议数据格式转换，会丢失精度
          }*/
    },
    mounted:function () {
        this.$nextTick(function () {
            this.cartView();
        })

    },
    methods:{
        cartView:function () {
            var _this=this;

            this.$http.get("/comment/selPro").then(function (json) {
                _this.orderList=json.data;

            });
        },
        soso:function () {
            var _thiss=this;
            var one=$("#one").val();
            var two=$("#two").val();
            var three=$("#three").val();
            var proName=$("#proName").val();
            this.$http.get("/comment/selPro",{CatrOne:one,CatrTwo:two,CatrThree:three,proName:proName},{emulateJSON:false}).then(function (json) {
                _thiss.orderList = json.data;
            });
        },
        pages:function (pageNo) {
            var _pages=this;
            var one=$("#one").val();
            var two=$("#two").val();
            var three=$("#three").val();
            var proName=$("#proName").val();
            this.$http.get("/comment/selPro",{pageNo:pageNo,CatrOne:one,CatrTwo:two,CatrThree:three,proName:proName},{emulateJSON:false}).then(function (json) {
                _pages.orderList = json.data;
            });
        }


    }

})
