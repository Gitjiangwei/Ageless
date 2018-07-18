new Vue({
    el:"#pull-right",
    data:{
        totalMoney:0,
        totalMum:0,
        orderList:[],
        delId:0,
        delRessult:0,
        delFlag: false,
        product:'',
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
                //alert(json);
                _this.orderList=json.data;

            });
        },
        getorder:function (status) {
            //alert(status);
            this.$http.get("/Order/all",{"status":status}).then(function (json) {
                this.orderList=json.data;

            });
        },
        delConfrim: function (item) {
            this.delFlag = true;
            this.product = item;
            this.delId=item.id;

        },
        delProduct: function (item) {
            //alert(item);
            this.delId=item.id;
            //alert(this.delId);
            var _this=this;
            this.$http.get("/Order/delorder",{"delid":_this.delId}).then(function (data) {
                _this.delRessult=data.data;
                //alert(_this.delRessult);
                if(_this.delRessult>0){
                    alert("删除成功！");
                    this.cartView();
                }else{
                    alert("删除失败！");
                }
            },function () {
                alert("删除失败！");
            });

            this.delFlag = false;
        },
        delefhsh:function(){
             alert("此订单还未完成，不能删除！");
        },
        fukuan:function () {
            
        }

    }

})
Vue.filter("money", function (value, type) {
    return "￥" + value + type;
})
Vue.filter('time',
    <!-- value 格式为13位unix时间戳 -->
    <!-- 10位unix时间戳可通过value*1000转换为13位格式 -->
    function(value) {
        var date = new Date(value);
        Y = date.getFullYear(),
            m = date.getMonth() + 1,
            d = date.getDate(),
            H = date.getHours(),
            i = date.getMinutes(),
            s = date.getSeconds();
        if (m < 10) {
            m = '0' + m;
        }
        if (d < 10) {
            d = '0' + d;
        }
        if (H < 10) {
            H = '0' + H;
        }
        if (i < 10) {
            i = '0' + i;
        }
        if (s < 10) {
            s = '0' + s;
        }
        <!-- 获取时间格式 2017-01-03 10:13:48 -->
        var t = Y+'-'+m+'-'+d+' '+H+':'+i+':'+s;
        <!-- 获取时间格式 2017-01-03 -->
        // var t = Y + '-' + m + '-' + d;
        return t;
    });




































