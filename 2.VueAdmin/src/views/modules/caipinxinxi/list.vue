<template>
	<div class="main-content" :style='{"padding":"0px 30px 30px","fontSize":"14px","color":"#666","background":"none"}'>
		<!-- 列表页 -->
		<template v-if="showFlag">
			<el-form class="center-form-pv" :style='{"padding":"0px 0px 0","margin":"0px","overflow":"hidden","flexWrap":"wrap","background":"none","display":"flex","fontSize":"inherit","justifyContent":"flex-end"}' :inline="true" :model="searchForm">
				<el-row :style='{"padding":"0px","margin":"0 10px 20px","borderRadius":"0 0 8px 8px","textAlign":"right","background":"none","display":"block","width":"auto","fontSize":"inherit","order":"1"}' >
					<div :style='{"margin":"0 10px 0 0","fontSize":"inherit","display":"inline-block"}'>
						<label :style='{"margin":"0 10px 0 0","color":"inherit","display":"inline-block","lineHeight":"40px","fontSize":"inherit","fontWeight":"500","height":"40px"}' class="item-label">菜品名称</label>
						<el-input v-model="searchForm.caipinmingcheng" placeholder="菜品名称" @keydown.enter.native="search()" clearable></el-input>
					</div>
					<div :style='{"margin":"0 10px 0 0","fontSize":"inherit","display":"inline-block"}'>
						<label :style='{"margin":"0 10px 0 0","color":"inherit","display":"inline-block","lineHeight":"40px","fontSize":"inherit","fontWeight":"500","height":"40px"}' class="item-label">菜品口味</label>
						<el-input v-model="searchForm.caipinkouwei" placeholder="菜品口味" @keydown.enter.native="search()" clearable></el-input>
					</div>
					<div :style='{"margin":"0 10px 0 0","fontSize":"inherit","display":"inline-block"}'>
						<label :style='{"margin":"0 10px 0 0","color":"inherit","display":"inline-block","lineHeight":"40px","fontSize":"inherit","fontWeight":"500","height":"40px"}' class="item-label">价格</label>
						<el-input v-model="searchForm.pricestart" placeholder="最小价格" clearable></el-input>
					</div>
					<div :style='{"margin":"0 10px 0 0","fontSize":"inherit","display":"inline-block"}' :label="'至'">
						<el-input v-model="searchForm.priceend" placeholder="最大价格" clearable></el-input>
					</div>
					<el-button class="search" type="success" @click="search()">
						<span class="icon iconfont icon-chakan14" :style='{"margin":"0 2px","fontSize":"inherit","color":"inherit","display":"none","height":"40px"}'></span>
						查找
					</el-button>
				</el-row>

				<el-row class="actions" :style='{"margin":"0px 0 20px","color":"#fff","flexWrap":"wrap","textAlign":"right","flexDirection":"row","display":"flex","width":"auto","fontSize":"inherit","justifyContent":"flex-end","order":"2"}'>
					<el-button class="add" v-if="isAuth('caipinxinxi','新增')" type="success" @click="addOrUpdateHandler()">
						<span class="icon iconfont icon-tianjia17" :style='{"color":"inherit","margin":"0 2px","fontSize":"inherit"}'></span>
						添加
					</el-button>
					<el-button class="del" v-if="isAuth('caipinxinxi','删除')" :disabled="dataListSelections.length?false:true" type="danger" @click="deleteHandler()">
						<span class="icon iconfont icon-shanchu8" :style='{"margin":"0 2px","fontSize":"inherit","color":"inherit","height":"40px"}'></span>
						删除
					</el-button>



					<el-button class="btn18" v-if="isAuth('caipinxinxi','菜品分类统计')" type="success" @click="chartDialog1()">
						<span class="icon iconfont icon-a-fenxiang2" :style='{"color":"inherit","margin":"0 2px","fontSize":"inherit"}'></span>
						菜品分类统计
					</el-button>
					<el-button class="btn18" v-if="isAuth('caipinxinxi','菜品库存统计')" type="success" @click="chartDialog2()">
						<span class="icon iconfont icon-a-fenxiang2" :style='{"color":"inherit","margin":"0 2px","fontSize":"inherit"}'></span>
						菜品库存统计
					</el-button>
				</el-row>
			</el-form>
			<div :style='{"border":"0px solid #eee","width":"100%","padding":"0","margin":"0px 0 0","borderRadius":"20px","background":"rgba(255,255,255,1)"}'>
				<el-table class="tables"
					:stripe='false'
					:style='{"padding":"0","borderColor":"#edf7ff","color":"inherit","borderRadius":"20px","borderWidth":"0px 0px 0 0px","background":"none","width":"100%","fontSize":"inherit","borderStyle":"solid"}' 
					:border='true'
					v-if="isAuth('caipinxinxi','查看')"
					:data="dataList"
					v-loading="dataListLoading"
				@selection-change="selectionChangeHandler">
					<el-table-column :resizable='true' type="selection" align="center" width="50"></el-table-column>
					<el-table-column :resizable='true' :sortable='true' label="序号" type="index" width="50" />
					<el-table-column :resizable='true' :sortable='true'  
						prop="caipinmingcheng"
						label="菜品名称">
						<template slot-scope="scope">
							{{scope.row.caipinmingcheng}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="caipinfenlei"
						label="菜品分类">
						<template slot-scope="scope">
							{{scope.row.caipinfenlei}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true' prop="caipintupian" width="200" label="菜品图片">
						<template slot-scope="scope">
							<div v-if="scope.row.caipintupian">
								<img v-if="scope.row.caipintupian.substring(0,4)=='http'" :src="scope.row.caipintupian.split(',')[0]" width="100" height="100" style="object-fit: cover" @click="imgPreView(scope.row.caipintupian.split(',')[0])">
								<img v-else :src="$base.url+scope.row.caipintupian.split(',')[0]" width="100" height="100" style="object-fit: cover" @click="imgPreView($base.url+scope.row.caipintupian.split(',')[0])">
							</div>
							<div v-else>无图片</div>
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="caipinkouwei"
						label="菜品口味">
						<template slot-scope="scope">
							{{scope.row.caipinkouwei}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="caipintese"
						label="菜品特色">
						<template slot-scope="scope">
							{{scope.row.caipintese}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="yuangonggonghao"
						label="员工工号">
						<template slot-scope="scope">
							{{scope.row.yuangonggonghao}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="lianxifangshi"
						label="联系方式">
						<template slot-scope="scope">
							{{scope.row.lianxifangshi}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="discussnum"
						label="评论数">
						<template slot-scope="scope">
							{{scope.row.discussnum}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="price"
						label="价格">
						<template slot-scope="scope">
							{{scope.row.price}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="storeupnum"
						label="收藏数">
						<template slot-scope="scope">
							{{scope.row.storeupnum}}
						</template>
					</el-table-column>
					<el-table-column width="300" label="操作">
						<template slot-scope="scope">
							<el-button class="view" v-if=" isAuth('caipinxinxi','查看')" type="success" @click="addOrUpdateHandler(scope.row.id,'info')">
								<span class="icon iconfont icon-chakan2" :style='{"margin":"0 2px","fontSize":"inherit","color":"inherit","display":"none","height":"40px"}'></span>
								查看
							</el-button>
							<el-button class="edit" v-if=" isAuth('caipinxinxi','修改') " type="success" @click="addOrUpdateHandler(scope.row.id)">
								<span class="icon iconfont icon-xiugai10" :style='{"margin":"0 2px","fontSize":"inherit","color":"inherit","display":"none","height":"40px"}'></span>
								修改
							</el-button>

							<el-button class="btn8" v-if="isAuth('caipinxinxi','私聊')" type="success" @click="chatClick(scope.row)">
								<span class="icon iconfont icon-geren7" :style='{"margin":"0 2px","fontSize":"inherit","color":"inherit","display":"none","height":"40px"}'></span>
								私聊
							</el-button>
							<el-button class="view" v-if="isAuth('caipinxinxi','查看评论')" type="success" @click="disscussListHandler(scope.row.id)">
								<span class="icon iconfont icon-chakan2" :style='{"margin":"0 2px","fontSize":"inherit","color":"inherit","display":"none","height":"40px"}'></span>
								查看评论
							</el-button>



							<el-button class="del" v-if="isAuth('caipinxinxi','删除') " type="primary" @click="deleteHandler(scope.row.id )">
								<span class="icon iconfont icon-guanbi1" :style='{"margin":"0 2px","fontSize":"inherit","color":"inherit","display":"none","height":"40px"}'></span>
								删除
							</el-button>
						</template>
					</el-table-column>
				</el-table>
			</div>
			<el-pagination
				@size-change="sizeChangeHandle"
				@current-change="currentChangeHandle"
				:current-page="pageIndex"
				background
				:page-sizes="[10, 50, 100, 200]"
				:page-size="pageSize"
				:layout="layouts.join()"
				:total="totalPage"
				prev-text="上一页 "
				next-text="下一页 "
				:hide-on-single-page="false"
				:style='{"padding":"0","margin":"20px 0 0","whiteSpace":"nowrap","color":"inherit","textAlign":"left","width":"100%","fontSize":"inherit","fontWeight":"500"}'
			></el-pagination>
		</template>
		
		<!-- 添加/修改页面  将父组件的search方法传递给子组件-->
		<add-or-update v-if="addOrUpdateFlag" :parent="this" ref="addOrUpdate"></add-or-update>




		<el-dialog
		  :visible.sync="chartVisiable1"
		  width="800">
			<div id="caipinfenleiChart1" style="width:100%;height:600px;"></div>
		  <span slot="footer" class="dialog-footer">
			<el-button @click="chartDialog1">返回</el-button>
		  </span>
		</el-dialog>
		<el-dialog
		  :visible.sync="chartVisiable2"
		  width="800">
			<div id="alllimittimesChart2" style="width:100%;height:600px;"></div>
		  <span slot="footer" class="dialog-footer">
			<el-button @click="chartDialog2">返回</el-button>
		  </span>
		</el-dialog>

		<el-dialog :visible.sync="chatVisible" @close="clearChat" :title="nowname" :append-to-body="true">
			<div class="chat-content" id="chat-content">
				<div v-bind:key="item.id" v-for="item in chatList">
					<div v-if="item.uid==myid" class="right-content">
						<el-alert v-if="item.format==1" class="text-content" :title="item.content" :closable="false"
							type="warning"></el-alert>
						<el-image v-else fit="cover" :src="item.content?$base.url + item.content:''"
							style="width: 100px;height: 100px;"
							:preview-src-list="[item.content?$base.url + item.content:'']"></el-image>
						<img :src="avatar?$base.url + avatar:require('@/assets/img/avator.png')" alt=""
							style="width: 30px;border-radius: 50%;height: 30px;margin: 0 0 0 10px;" />
					</div>
					<div v-else class="left-content">
						<img :src="nowfpic?$base.url + nowfpic:require('@/assets/img/avator.png')" alt=""
							style="width: 30px;border-radius: 50%;height: 30px;margin: 0 10px 0 0;" />
						<el-alert v-if="item.format==1" class="text-content" :title="item.content" :closable="false"
							type="success"></el-alert>
						<el-image v-else fit="cover" :src="item.content?$base.url + item.content:''"
							style="width: 100px;height: 100px;"
							:preview-src-list="[item.content?$base.url + item.content:'']"></el-image>
					</div>
					<div class="clear-float"></div>
				</div>
			</div>
			<div slot="footer" class="dialog-footer">
				<el-input @keydown.enter.native="addChat" v-model="chatForm.content" placeholder="请输入内容"
					style="width: calc(100% - 180px);float: left;">
				</el-input>
				<el-button :disabled="chatForm.content?false:true" type="primary" @click="addChat">发送</el-button>
				<el-upload style="display: inline-block;margin: 0 0 0 6px;" class="upload-demo" :action="uploadUrl"
					:on-success="uploadSuccess" :show-file-list="false">
					<el-button type="success">上传图片</el-button>
				</el-upload>
			</div>
		</el-dialog>
		<el-dialog title="预览图" :visible.sync="previewVisible" width="50%">
			<img :src="previewImg" alt="" style="width: 100%;">
		</el-dialog>
	</div>
</template>

<script>
import * as echarts from 'echarts'
import chinaJson from "@/components/echarts/china.json";
import axios from 'axios'
import AddOrUpdate from "./add-or-update";
	export default {
		data() {
			return {
				searchForm: {
					key: ""
				},
				form:{},
				dataList: [],
				pageIndex: 1,
				pageSize: 10,
				totalPage: 0,
				dataListLoading: false,
				dataListSelections: [],
				showFlag: true,
				chartVisiable1: false,
				chartVisiable2: false,
				addOrUpdateFlag:false,
				layouts: ["prev","pager","next","jumper"],
				chatVisible: false,
				nowfid: 0,
				nowfpic: '',
				nowname: '',
				chatList: [],
				chatForm: {
					content: ''
				},
				chatTimer: null,
				uploadUrl: this.$base.url + 'file/upload',
				previewImg: '',
				previewVisible: false,
			};
		},
		created() {
			this.init();
			this.getDataList();
			this.contentStyleChange()
		},
		mounted() {
		},
		filters: {
			htmlfilter: function (val) {
				return val.replace(/<[^>]*>/g).replace(/undefined/g,'');
			}
		},
		computed: {
			tablename(){
				return this.$storage.get('sessionTable')
			},
			avatar() {
				return this.$storage.get('headportrait') ? this.$storage.get('headportrait') : ''
			},
			myid() {
				return this.$storage.get('userid') ? this.$storage.get('userid') : ''
			},
		},
		components: {
			AddOrUpdate,
		},
		methods: {
			imgPreView(url){
				this.previewImg = url
				this.previewVisible = true
			},
			chatClick(row) {
				if(row.id == this.myid){
					this.$message.error('不能给自己发消息！')
					return false
				}
				this.nowfid = row.id
				if(row.touxiang){
					this.nowfpic = row.touxiang.split(',')[0]
				}else if(row.headportrait){
					this.nowfpic = row.headportrait.split(',')[0]
				}
				this.getChatList()
				this.chatVisible = true
			},
			getChatList() {
				this.$http.get('chatmessage/mlist', {
					params: {
						page: 1,
						limit: 1000,
						uid: this.myid,
						fid: this.nowfid
					}
				}).then(res => {
					if (res.data && res.data.code == 0) {
						this.chatList = res.data.data.list
						let div = document.getElementsByClassName('chat-content')[0]
						setTimeout(() => {
							if (div)
								div.scrollTop = div.scrollHeight
						}, 0)
						this.chatTimer = setTimeout(() => {
							this.getChatList()
						}, 5000)
					}
				})
			},
			clearChat() {
				clearTimeout(this.chatTimer)
				this.chatList = []
				this.getRecordList()
			},
			uploadSuccess(res) {
				if (res.code == 0) {
					clearTimeout(this.chatTimer)
					this.$http.get('friend/page', {
						params: {
							uid: this.myid,
							fid: this.nowfid,
						}
					}).then(obj => {
						if (obj.data && obj.data.code == 0) {
							if (!obj.data.data.list.length) {
								this.$http.post('friend/add', {
									uid: this.myid,
									fid: this.nowfid,
									name: this.nowname,
									picture: this.nowfpic,
									type: 2,
									tablename: 'yisheng',
								}).then(res => {
									this.$http.post('friend/add', {
										uid: this.nowfid,
										fid: this.myid,
										type: 2,
										tablename: this.$storage.get('sessionTable'),
										name: this.$storage.get('adminName'),
										picture: this.avatar,
									}).then(res1 => {
			
									})
								})
							}
							this.$http.post('chatmessage/add', {
								uid: this.myid,
								fid: this.nowfid,
								content: 'upload/' + res.file,
								format: 2
							}).then(res2 => {
								this.chatForm = {
									content: ''
								}
								this.getChatList()
							})
						}
					})
				}
			},
			addChat() {
				clearTimeout(this.chatTimer)
				this.$http.get('friend/page', {
					params: {
						uid: this.myid,
						fid: this.nowfid,
					}
				}).then(obj => {
					if (obj.data && obj.data.code == 0) {
						if (!obj.data.data.list.length) {
							this.$http.post('friend/add', {
								uid: this.myid,
								fid: this.nowfid,
								name: this.nowname,
								picture: this.nowfpic,
								type: 2,
								tablename: 'yisheng',
							}).then(res => {
								this.$http.post('friend/add', {
									uid: this.nowfid,
									fid: this.myid,
									type: 2,
									tablename: this.$storage.get('sessionTable'),
									name: this.$storage.get('adminName'),
									picture: this.avatar,
								}).then(res1 => {
			
								})
							})
						}
						this.$http.post('chatmessage/add', {
							uid: this.myid,
							fid: this.nowfid,
							content: this.chatForm.content,
							format: 1
						}).then(res2 => {
							this.chatForm = {
								content: ''
							}
							this.getChatList()
						})
					}
				})
			},
			contentStyleChange() {
				this.contentPageStyleChange()
			},
			// 分页
			contentPageStyleChange(){
				let arr = []

				// if(this.contents.pageTotal) arr.push('total')
				// if(this.contents.pageSizes) arr.push('sizes')
				// if(this.contents.pagePrevNext){
				//   arr.push('prev')
				//   if(this.contents.pagePager) arr.push('pager')
				//   arr.push('next')
				// }
				// if(this.contents.pageJumper) arr.push('jumper')
				// this.layouts = arr.join()
				// this.contents.pageEachNum = 10
			},


//统计接口
    chartDialog1() {
      this.chartVisiable1 = !this.chartVisiable1;
      this.$nextTick(()=>{
        var caipinfenleiChart1 = echarts.init(document.getElementById("caipinfenleiChart1"),'dark-fresh-cut');
        this.$http({
            url: "caipinxinxi/group/caipinfenlei",
            method: "get",
        }).then(({ data }) => {
            if (data && data.code === 0) {
                let res = data.data;
                let xAxis = [];
                let yAxis = [];
                let pArray = []
                for(let i=0;i<res.length;i++){
                    xAxis.push(res[i].caipinfenlei);
                    yAxis.push(parseFloat((res[i].total)));
                    pArray.push({
                        value: parseFloat((res[i].total)),
                        name: res[i].caipinfenlei
                    })
                }
                var option = {};
                option = {
                        title: {
                            text: '菜品分类统计',
                            left: 'center'
                        },
                        legend: {
                          orient: 'vertical',
                          left: 'left'
                        },
                        tooltip: {
                          trigger: 'item',
                          formatter: '{b} : {c} ({d}%)'
                        },
                        series: [
                            {
                                type: 'pie',
                                radius: '55%',
                                center: ['50%', '60%'],
                                data: pArray,
                                emphasis: {
                                    itemStyle: {
                                        shadowBlur: 10,
                                        shadowOffsetX: 0,
                                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                                    }
                                }
                            }
                        ]
                };
                // 使用刚指定的配置项和数据显示图表。
                caipinfenleiChart1.setOption(option);
                  //根据窗口的大小变动图表
                window.onresize = function() {
                    caipinfenleiChart1.resize();
                };
            }
        });
      })
    },

//统计接口
    chartDialog2() {
      this.chartVisiable2 = !this.chartVisiable2;
      this.$nextTick(()=>{
        // caipinmingcheng caipinmingcheng
        //  alllimittimes

        var alllimittimesChart2 = echarts.init(document.getElementById("alllimittimesChart2"),'dark-fresh-cut');
        this.$http({
            url: `caipinxinxi/value/caipinmingcheng/alllimittimes`,
            method: "get",
        }).then(({ data }) => {
            if (data && data.code === 0) {
                let res = data.data;
                let xAxis = [];
                let yAxis = [];
                let pArray = []
                for(let i=0;i<res.length;i++){
                    xAxis.push(res[i].caipinmingcheng);
                    yAxis.push(parseFloat((res[i].total)));
                    pArray.push({
                        value: parseFloat((res[i].total)),
                        name: res[i].caipinmingcheng
                    })
                }
                var option = {};
                option = {
                    title: {
                        text: '菜品库存统计',
                        left: 'center'
                    },
                    tooltip: {
                      trigger: 'item',
                      formatter: '{b} : {c}'
                    },
                    xAxis: {
                        type: 'category',
                        data: xAxis,
                        axisLabel : {
                            rotate:40
                        }
                    },
                    yAxis: {
                        type: 'value'
                    },
                    series: [{
                        data: yAxis,
                        type: 'bar'
                    }]
                };
                // 使用刚指定的配置项和数据显示图表。
                alllimittimesChart2.setOption(option);
                  //根据窗口的大小变动图表
                window.onresize = function() {
                    alllimittimesChart2.resize();
                };
            }
        });
      })
    },



    init () {
    },
    search() {
      this.pageIndex = 1;
      this.getDataList();
    },

    // 获取数据列表
    getDataList() {
      this.dataListLoading = true;
      let params = {
        page: this.pageIndex,
        limit: this.pageSize,
        sort: 'id',
        order: 'desc',
      }
           if(this.searchForm.caipinmingcheng!='' && this.searchForm.caipinmingcheng!=undefined){
            params['caipinmingcheng'] = '%' + this.searchForm.caipinmingcheng + '%'
          }
           if(this.searchForm.caipinkouwei!='' && this.searchForm.caipinkouwei!=undefined){
            params['caipinkouwei'] = '%' + this.searchForm.caipinkouwei + '%'
          }
           if(this.searchForm.pricestart!='' && this.searchForm.pricestart!=undefined ){
            params['pricestart'] = this.searchForm.pricestart
          }
          if(this.searchForm.priceend!='' && this.searchForm.priceend!=undefined){
            params['priceend'] = this.searchForm.priceend
          }
			let user = JSON.parse(this.$storage.getObj('userForm'))
			console.log(user)
			this.$http({
				url: "caipinxinxi/page",
				method: "get",
				params: params
			}).then(({ data }) => {
				if (data && data.code === 0) {
					this.dataList = data.data.list;
					this.totalPage = data.data.total;
				} else {
					this.dataList = [];
					this.totalPage = 0;
				}
				this.dataListLoading = false;
			});
    },
    // 每页数
    sizeChangeHandle(val) {
      this.pageSize = val;
      this.pageIndex = 1;
      this.getDataList();
    },
    // 当前页
    currentChangeHandle(val) {
      this.pageIndex = val;
      this.getDataList();
    },
    // 多选
    selectionChangeHandler(val) {
      this.dataListSelections = val;
    },
    // 添加/修改
    addOrUpdateHandler(id,type) {
      this.showFlag = false;
      this.addOrUpdateFlag = true;
      this.crossAddOrUpdateFlag = false;
      if(type!='info'){
        type = 'else';
      }
      this.$nextTick(() => {
        this.$refs.addOrUpdate.init(id,type);
      });
    },
    // 查看评论
    disscussListHandler(id,type) {
	this.$router.push({path:'/discusscaipinxinxi',query:{refid:id}});
    },
    // 下载
    download(file){
      let arr = file.replace(new RegExp('upload/', "g"), "")
      axios.get(this.$base.url + 'file/download?fileName=' + arr, {
      	headers: {
      		token: this.$storage.get('Token')
      	},
      	responseType: "blob"
      }).then(({
      	data
      }) => {
      	const binaryData = [];
      	binaryData.push(data);
      	const objectUrl = window.URL.createObjectURL(new Blob(binaryData, {
      		type: 'application/pdf;chartset=UTF-8'
      	}))
      	const a = document.createElement('a')
      	a.href = objectUrl
      	a.download = arr
      	// a.click()
      	// 下面这个写法兼容火狐
      	a.dispatchEvent(new MouseEvent('click', {
      		bubbles: true,
      		cancelable: true,
      		view: window
      	}))
      	window.URL.revokeObjectURL(data)
      },err=>{
		  axios.get((location.href.split(this.$base.name).length>1 ? location.href.split(this.$base.name)[0] :'') + this.$base.name + '/file/download?fileName=' + arr, {
		  	headers: {
		  		token: this.$storage.get('Token')
		  	},
		  	responseType: "blob"
		  }).then(({
		  	data
		  }) => {
		  	const binaryData = [];
		  	binaryData.push(data);
		  	const objectUrl = window.URL.createObjectURL(new Blob(binaryData, {
		  		type: 'application/pdf;chartset=UTF-8'
		  	}))
		  	const a = document.createElement('a')
		  	a.href = objectUrl
		  	a.download = arr
		  	// a.click()
		  	// 下面这个写法兼容火狐
		  	a.dispatchEvent(new MouseEvent('click', {
		  		bubbles: true,
		  		cancelable: true,
		  		view: window
		  	}))
		  	window.URL.revokeObjectURL(data)
		  })
	  })
    },
	// 预览
	preClick(file){
		if(!file){
			return false
		}
		window.open((location.href.split(this.$base.name).length>1 ? location.href.split(this.$base.name)[0] + this.$base.name + '/' + file :this.$base.url + file))
	},
	caipinxinxistatusChange(e,row){
		if(row.status==0){
			row.passwordwrongnum = 0
		}
		this.$http({
			url:'caipinxinxi/update',
			method:'post',
			data:row
		}).then(res=>{
			if(row.status==1){
				this.$message.error('该用户已锁定')
			}else{
				this.$message.success('该用户已解除锁定')
			}
		})
	},
    // 删除
    async deleteHandler(id ) {
		var ids = id? [Number(id)]: this.dataListSelections.map(item => {
			return Number(item.id);
		});
		await this.$confirm(`确定进行[${id ? "删除" : "批量删除"}]操作?`, "提示", {
			confirmButtonText: "确定",
			cancelButtonText: "取消",
			type: "warning"
		}).then(async () => {
			await this.$http({
				url: "caipinxinxi/delete",
				method: "post",
				data: ids
			}).then(async ({ data }) => {
				if (data && data.code === 0) {
					for(let x in ids){
						await this.$http.get('storeup/list',{params: {
							page: 1,
							limit: 100,
							refid: ids[x],
							tablename: 'caipinxinxi'
						}}).then(async obj=>{
							if(obj.data&&obj.data.code==0){
								if(obj.data.data.list.length){
									let arr = []
									for(let i in obj.data.data.list){
										arr.push(obj.data.data.list[i].id)
									}
									await this.$http.post('storeup/delete',arr).then(()=>{})
								}
							}
						})
					}
					this.$message({
						message: "操作成功",
						type: "success",
						duration: 1500,
						onClose: () => {
							this.search();
						}
					});
            
				} else {
					this.$message.error(data.msg);
				}
			});
		});
    },


  }

};
</script>
<style lang="scss" scoped>
	
	.center-form-pv {
	  .el-date-editor.el-input {
	    width: auto;
	  }
	}
	
	.el-input {
	  width: auto;
	}
	
	// form
	.center-form-pv .el-input ::v-deep .el-input__inner {
				border: 1px solid #d8d8d8;
				border-radius: 30px;
				padding: 0 12px;
				color: inherit;
				background: #fff;
				width: 170px;
				font-size: inherit;
				height: 38px;
			}
	
	.center-form-pv .el-select ::v-deep .el-input__inner {
				border: 1px solid #d8d8d8;
				border-radius: 30px;
				padding: 0 10px;
				color: inherit;
				background: #fff;
				width: 170px;
				font-size: inherit;
				height: 38px;
			}
	
	.center-form-pv .el-date-editor ::v-deep .el-input__inner {
				border: 1px solid #d8d8d8;
				border-radius: 30px;
				padding: 0 10px 0 30px;
				color: inherit;
				background: #fff;
				width: 170px;
				font-size: inherit;
				height: 38px;
			}
	
	.center-form-pv .search {
				border: 0;
				cursor: pointer;
				border-radius: 30px;
				padding: 0 20px;
				outline: none;
				color: #fff;
				background: #ffc054;
				width: auto;
				font-size: inherit;
				transition: all 0.3s;
				height: 38px;
			}
	
	.center-form-pv .search:hover {
				transform: scale(0.9);
				opacity: 1;
			}
	
	.center-form-pv .actions .add {
				border: 0px solid rgba(126, 96, 16, .2);
				cursor: pointer;
				border-radius: 30px;
				padding: 0 16px 0 10px;
				margin: 4px 4px 5px 0;
				outline: none;
				color: inherit;
				background: #ffce6b;
				width: auto;
				font-size: inherit;
				height: 32px;
			}
	
	.center-form-pv .actions .add:hover {
				transform: scale(0.9);
				opacity: 1;
			}
	
	.center-form-pv .actions .del {
				border: 0px solid rgba(126, 96, 16, .2);
				cursor: pointer;
				border-radius: 30px;
				padding: 0 16px 0 10px;
				margin: 4px 4px 5px;
				outline: none;
				color: inherit;
				background: #ff6b6b;
				width: auto;
				font-size: inherit;
				height: 32px;
			}
	
	.center-form-pv .actions .del:hover {
				transform: scale(0.9);
				opacity: 1;
			}
	
	.center-form-pv .actions .statis {
				border: 0px solid rgba(126, 96, 16, .2);
				cursor: pointer;
				border-radius: 30px;
				padding: 0 16px 0 10px;
				margin: 4px 4px 5px;
				outline: none;
				color: inherit;
				background: #9c6bff;
				width: auto;
				font-size: inherit;
				height: 32px;
			}
	
	.center-form-pv .actions .statis:hover {
				transform: scale(0.9);
				opacity: 1;
			}
	
	.center-form-pv .actions .btn18 {
				border: 0px solid rgba(126, 96, 16, .2);
				cursor: pointer;
				border-radius: 30px;
				padding: 0 16px 0 10px;
				margin: 4px 4px 5px;
				outline: none;
				color: #333;
				background: #fff;
				width: auto;
				font-size: inherit;
				height: 32px;
			}
	
	.center-form-pv .actions .btn18:hover {
				transform: scale(0.9);
				opacity: 1;
			}
	
	// table
	.el-table ::v-deep .el-table__header-wrapper thead {
				color: inherit;
				background: #fff;
				width: 100%;
			}
	
	.el-table ::v-deep .el-table__header-wrapper thead tr {
				background: none;
			}
	
	.el-table ::v-deep .el-table__header-wrapper thead tr th {
				padding: 12px 0;
				background: none;
				border-color: #f0f1f5;
				border-width: 0 0px 2px 0;
				border-style: solid;
				text-align: left;
			}

	.el-table ::v-deep .el-table__header-wrapper thead tr th .cell {
				padding: 0 10px;
				word-wrap: normal;
				word-break: break-all;
				white-space: normal;
				font-weight: 600;
				display: inline-block;
				vertical-align: middle;
				width: 100%;
				line-height: 24px;
				position: relative;
				text-overflow: ellipsis;
			}

	
	.el-table ::v-deep .el-table__body-wrapper tbody {
				padding: 0;
				width: 100%;
			}

	.el-table ::v-deep .el-table__body-wrapper tbody tr {
				background: none;
			}
	
	.el-table ::v-deep .el-table__body-wrapper tbody tr td {
				padding: 2px 0;
				color: inherit;
				background: #f9f9f9;
				font-size: inherit;
				border-color: #f0f1f5;
				border-width: 0 0px 2px 0px;
				border-style: solid;
				text-align: left;
			}
	
		
	.el-table ::v-deep .el-table__body-wrapper tbody tr:hover td {
				padding: 2px 0;
				color: #000;
				background: #f9f9f9;
				border-color: #f0f1f5;
				border-width: 0 0px 2px 0px;
				border-style: solid;
				text-align: left;
			}
	
	.el-table ::v-deep .el-table__body-wrapper tbody tr td {
				padding: 2px 0;
				color: inherit;
				background: #f9f9f9;
				font-size: inherit;
				border-color: #f0f1f5;
				border-width: 0 0px 2px 0px;
				border-style: solid;
				text-align: left;
			}

	.el-table ::v-deep .el-table__body-wrapper tbody tr td .cell {
				padding: 0 10px;
				overflow: hidden;
				color: inherit;
				word-break: break-all;
				white-space: normal;
				line-height: 24px;
				text-overflow: ellipsis;
			}
	
	.el-table ::v-deep .el-table__body-wrapper tbody tr td .view {
				border: 0px solid rgba(126, 96, 16, .2);
				cursor: pointer;
				border-radius: 0px;
				padding: 0 12px 0 6px;
				margin: 0 10px 5px 0;
				outline: none;
				color: #ffc054;
				background: none;
				width: auto;
				font-size: 14px;
				height: 32px;
			}
	
	.el-table ::v-deep .el-table__body-wrapper tbody tr td .view:hover {
				transform: scale(1.3);
				opacity: 0.8;
			}
	
	.el-table ::v-deep .el-table__body-wrapper tbody tr td .add {
			}
	
	.el-table ::v-deep .el-table__body-wrapper tbody tr td .add:hover {
			}
	
	.el-table ::v-deep .el-table__body-wrapper tbody tr td .edit {
				border: 0px solid #36ab80;
				cursor: pointer;
				border-radius: 0px;
				padding: 0 12px 0 6px;
				margin: 0 10px 5px 0;
				outline: none;
				color: #4bd054;
				background: none;
				width: auto;
				font-size: 14px;
				height: 32px;
			}
	
	.el-table ::v-deep .el-table__body-wrapper tbody tr td .edit:hover {
				transform: scale(1.3);
				opacity: 0.8;
			}
	
	.el-table ::v-deep .el-table__body-wrapper tbody tr td .del {
				border: 0px solid #ab3636;
				cursor: pointer;
				border-radius: 0px;
				padding: 0 12px 0 6px;
				margin: 0 10px 5px 0;
				outline: none;
				color: #5606f1;
				background: none;
				width: auto;
				font-size: 14px;
				height: 32px;
			}
	
	.el-table ::v-deep .el-table__body-wrapper tbody tr td .del:hover {
				transform: scale(1.3);
				opacity: 0.8;
			}
	
	.el-table ::v-deep .el-table__body-wrapper tbody tr td .btn8 {
				border: 0px solid #3696ab;
				cursor: pointer;
				border-radius: 0px;
				padding: 0 12px 0 6px;
				margin: 0 10px 5px 0;
				outline: none;
				color: #333;
				background: none;
				width: auto;
				font-size: 14px;
				height: 32px;
			}
	
	.el-table ::v-deep .el-table__body-wrapper tbody tr td .btn8:hover {
				transform: scale(1.3);
				opacity: 0.8;
			}
	
	// pagination
	.main-content .el-pagination ::v-deep .el-pagination__total {
				margin: 0 10px 0 0;
				color: inherit;
				font-weight: 400;
				display: inline-block;
				vertical-align: top;
				font-size: inherit;
				line-height: 28px;
				height: 28px;
			}
	
	.main-content .el-pagination ::v-deep .btn-prev {
				border: none;
				border-radius: 20px;
				padding: 0 5px;
				margin: 0 5px;
				color: inherit;
				background: #fff;
				display: inline-block;
				vertical-align: top;
				font-size: inherit;
				line-height: 24px;
				min-width: 35px;
				height: 24px;
			}
	
	.main-content .el-pagination ::v-deep .btn-next {
				border: none;
				border-radius: 20px;
				padding: 0 5px;
				margin: 0 5px;
				color: inherit;
				background: #fff;
				display: inline-block;
				vertical-align: top;
				font-size: inherit;
				line-height: 24px;
				min-width: 35px;
				height: 24px;
			}
	
	.main-content .el-pagination ::v-deep .btn-prev:disabled {
				border: none;
				cursor: not-allowed;
				border-radius: 20px;
				padding: 0 5px;
				margin: 0 5px;
				color: #999;
				background: #fff;
				display: inline-block;
				vertical-align: top;
				font-size: inherit;
				line-height: 24px;
				height: 24px;
			}
	
	.main-content .el-pagination ::v-deep .btn-next:disabled {
				border: none;
				cursor: not-allowed;
				border-radius: 20px;
				padding: 0 5px;
				margin: 0 5px;
				color: #999;
				background: #fff;
				display: inline-block;
				vertical-align: top;
				font-size: inherit;
				line-height: 24px;
				height: 24px;
			}

	.main-content .el-pagination ::v-deep .el-pager {
				padding: 0;
				margin: 0;
				display: inline-block;
				vertical-align: top;
				font-size: inherit;
			}

	.main-content .el-pagination ::v-deep .el-pager .number {
				cursor: pointer;
				border-radius: 20px;
				padding: 0 4px;
				margin: 0 5px;
				color: inherit;
				background: #fff;
				display: inline-block;
				vertical-align: top;
				font-size: inherit;
				line-height: 24px;
				text-align: center;
				height: 24px;
			}
	
	.main-content .el-pagination ::v-deep .el-pager .number:hover {
				cursor: pointer;
				padding: 0 4px;
				margin: 0 5px;
				color: #fff;
				background: #ffc054;
				display: inline-block;
				vertical-align: top;
				font-size: inherit;
				line-height: 24px;
				text-align: center;
				height: 24px;
			}
	
	.main-content .el-pagination ::v-deep .el-pager .number.active {
				cursor: default;
				border-radius: 20px;
				padding: 0 4px;
				margin: 0 5px;
				color: #fff;
				background: #ffc054;
				display: inline-block;
				vertical-align: top;
				font-size: inherit;
				line-height: 24px;
				text-align: center;
				height: 24px;
			}
	
	.main-content .el-pagination ::v-deep .el-pagination__sizes {
				color: inherit;
				display: inline-block;
				vertical-align: top;
				font-size: inherit;
				line-height: 28px;
				height: 28px;
			}
	
	.main-content .el-pagination ::v-deep .el-pagination__sizes .el-input {
				margin: 0 5px;
				color: inherit;
				width: 100px;
				font-size: inherit;
				position: relative;
			}
	
	.main-content .el-pagination ::v-deep .el-pagination__sizes .el-input .el-input__inner {
				border: 0px solid #ddd;
				cursor: pointer;
				padding: 0 25px 0 8px;
				color: inherit;
				display: inline-block;
				font-size: inherit;
				line-height: 28px;
				border-radius: 3px;
				outline: 0;
				background: none;
				width: 100%;
				text-align: center;
				height: 28px;
			}
	
	.main-content .el-pagination ::v-deep .el-pagination__sizes .el-input span.el-input__suffix {
				top: 0;
				position: absolute;
				right: 0;
				height: 100%;
			}
	
	.main-content .el-pagination ::v-deep .el-pagination__sizes .el-input .el-input__suffix .el-select__caret {
				cursor: pointer;
				color: #C0C4CC;
				width: 25px;
				font-size: 14px;
				line-height: 28px;
				text-align: center;
			}
	
	.main-content .el-pagination ::v-deep .el-pagination__jump {
				margin: 0 0 0 24px;
				color: inherit;
				display: inline-block;
				vertical-align: top;
				font-size: inherit;
				line-height: 28px;
				height: 28px;
			}
	
	.main-content .el-pagination ::v-deep .el-pagination__jump .el-input {
				border-radius: 3px;
				padding: 0 2px;
				margin: 0 2px;
				color: inherit;
				display: inline-block;
				width: 50px;
				font-size: inherit;
				line-height: 18px;
				position: relative;
				text-align: center;
				height: 28px;
			}
	
	.main-content .el-pagination ::v-deep .el-pagination__jump .el-input .el-input__inner {
				border: 1px solid #eee;
				cursor: pointer;
				padding: 0 0px;
				color: inherit;
				display: inline-block;
				font-size: inherit;
				line-height: 24px;
				border-radius: 20px;
				outline: 0;
				background: #fff;
				width: auto;
				text-align: center;
				height: 24px;
			}
	
	// list one
	.one .list1-view {
				border: 0px solid rgba(126, 96, 16, .2);
				cursor: pointer;
				border-radius: 0px;
				padding: 0 6px 0 4px;
				margin: 0px 5px 5px 0;
				outline: none;
				color: #ffc144;
				background: none;
				width: auto;
				font-size: inherit;
				height: 32px;
			}
	
	.one .list1-view:hover {
				transform: scale(1.3);
				opacity: 0.8;
			}
	
	.one .list1-edit {
				border: 0px solid rgba(254, 148, 34, .2);
				cursor: pointer;
				border-radius: 0px;
				padding: 0 6px 0 4px;
				margin: 0px 5px 5px 0;
				outline: none;
				color: #50d159;
				background: none;
				width: auto;
				font-size: inherit;
				height: 32px;
			}
	
	.one .list1-edit:hover {
				transform: scale(1.3);
				opacity: 0.8;
			}
	
	.one .list1-del {
				border: 0px solid rgba(180, 52, 31, .2);
				cursor: pointer;
				border-radius: 0px;
				padding: 0 6px 0 4px;
				margin: 0px 5px 5px 0;
				outline: none;
				color: #7c3ef3;
				background: none;
				width: auto;
				font-size: inherit;
				height: 32px;
			}
	
	.one .list1-del:hover {
				transform: scale(1.3);
				opacity: 0.8;
			}
	
	.one .list1-btn8 {
				border: 0px solid rgba(31, 160, 180, .2);
				cursor: pointer;
				border-radius: 0px;
				padding: 0 6px 0 4px;
				margin: 0px 5px 5px 0;
				outline: none;
				color: #333;
				background: none;
				width: auto;
				font-size: inherit;
				height: 32px;
			}
	
	.one .list1-btn8:hover {
				transform: scale(1.3);
				opacity: 0.8;
			}
	
	.main-content .el-table .el-switch {
				display: inline-flex;
				vertical-align: middle;
				line-height: 30px;
				position: relative;
				align-items: center;
				height: 30px;
			}
	.main-content .el-table .el-switch ::v-deep .el-switch__label--left {
				cursor: pointer;
				margin: 0 10px 0 0;
				color: #333;
				font-weight: 500;
				display: inline-block;
				vertical-align: middle;
				font-size: 16px;
				transition: .2s;
				height: 30px;
			}
	.main-content .el-table .el-switch ::v-deep .el-switch__label--right {
				cursor: pointer;
				margin: 0 0 0 10px;
				color: #333;
				font-weight: 500;
				display: inline-block;
				vertical-align: middle;
				font-size: 16px;
				transition: .2s;
				height: 30px;
			}
	.main-content .el-table .el-switch ::v-deep .el-switch__core {
				border: 1px solid #8a8a8a;
				cursor: pointer;
				border-radius: 15px;
				margin: 0;
				outline: 0;
				background: #8a8a8a;
				display: inline-block;
				width: 40px;
				box-sizing: border-box;
				transition: border-color .3s,background-color .3s;
				height: 20px;
			}
	.main-content .el-table .el-switch ::v-deep .el-switch__core::after {
				border-radius: 100%;
				top: 1px;
				left: 1px;
				background: #FFF;
				width: 16px;
				position: absolute;
				transition: all .3s;
				height: 16px;
			}
	.main-content .el-table .el-switch.is-checked ::v-deep .el-switch__core::after {
				margin: 0 0 0 -17px;
				left: 100%;
			}
	
	.main-content .el-table .el-rate ::v-deep .el-rate__item {
				cursor: pointer;
				display: inline-block;
				vertical-align: middle;
				font-size: 0;
				position: relative;
			}
	.main-content .el-table .el-rate ::v-deep .el-rate__item .el-rate__icon {
				margin: 0 3px;
				color: #666;
				display: inline-block;
				font-size: 18px;
				position: relative;
				transition: .3s;
			}

	.section-content {
		cursor: pointer;
		padding: 20px;
		box-shadow: 0px 4px 10px 0px rgba(0, 0, 0, 0.3);
		margin: 0 0 20px;
		color: #333;
		background: #fff;
		display: flex;
		width: 100%;
		border-color: #efefef;
		border-width: 0;
		align-items: center;
		border-style: solid;
		position: relative;
	}
	
	.section-content:hover {
		color: #fff;
		background: #DF847F10;
	}
	.chat-content {
		padding-bottom: 20px;
		width: 100%;
		margin-bottom: 10px;
		max-height: 300px;
		height: 300px;
		overflow-y: scroll;
		border: 1px solid #eeeeee;
		background: #fff;
	
		.left-content {
			float: left;
			margin-bottom: 10px;
			padding: 10px;
			max-width: 80%;
			display: flex;
			align-items: center;
		}
	
		.right-content {
			float: right;
			margin-bottom: 10px;
			padding: 10px;
			max-width: 80%;
			display: flex;
			align-items: center;
		}
	}
	
	.clear-float {
		clear: both;
	}
	.noList {
		color: #9e9e9e;
		width: 100%;
		text-align: center;
		padding: 60px 0;
	}
</style>
