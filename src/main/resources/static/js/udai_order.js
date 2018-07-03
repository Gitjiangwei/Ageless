new Vue({
    el:"#pull-right",
    data:{
        totalMoney:0,
        totalMum:0,
        orderList:[],
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

            this.$http.get("/Order/all").then(function (json) {
                alert(json);
                _this.orderList=json.data;

            });
        },

    }

})
Vue.filter("money", function (value, type) {
    return "￥" + value.toFixed(2) + type;
})




































