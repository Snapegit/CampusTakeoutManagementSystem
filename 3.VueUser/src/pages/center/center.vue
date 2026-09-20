<template>
<div class="center-preview" :style='{"padding":"0 20px 20px","margin":"0 auto","borderColor":"#d3d3d3","flexWrap":"wrap","background":"#fff","borderWidth":"0 0px","display":"flex","width":"1200px","position":"relative","borderStyle":"solid","justifyContent":"space-between"}'>
	<div class="title" :style='{"padding":"0","margin":"20px auto 0","borderColor":"#ffc652","color":"#222","textAlign":"center","background":"none","borderWidth":"0px 0 0 ","width":"100%","fontSize":"24px","borderStyle":"solid","fontWeight":"500","height":"60px"}'>{{ title }}</div>
	
	<div class="info" :style='{"padding":"80px 0 40px 240px","boxShadow":"0 0px 0px rgba(0, 0, 0, 0.3)","margin":"0 auto","borderColor":"#ddd","alignItems":"center","display":"flex","minHeight":"250px","borderRadius":"0px","flexWrap":"wrap","background":"#fff","borderWidth":"1px","width":"100%","position":"relative","borderStyle":"solid","height":"auto","order":"1"}'>
		<div :style='{"padding":" 0 0 0 34px","borderColor":"#eee","margin":"0 20px 0 0","color":"#fff","textAlign":"left","letterSpacing":"0px","top":"0","borderRadius":"0px","left":"0","borderWidth":"0px","background":"#eb6100","width":"100%","lineHeight":"44px","fontSize":"16px","position":"absolute","borderStyle":"solid","fontWeight":"500","height":"auto"}'>个人信息</div>
		<div :style='{"padding":"20px 0","borderColor":"#f8524630","top":"46px","left":"20px","borderWidth":"0px","width":"140px","fontSize":0,"position":"absolute","borderStyle":"solid","height":"auto"}' v-if="userTableName=='yonghu'">
			<el-image :style='{"padding":"4px","margin":"0 auto","borderColor":"#eee","objectFit":"cover","borderRadius":"0","borderWidth":"1px","display":"block","width":"180px","borderStyle":"solid","height":"180px"}' :src="sessionForm.touxiang?baseUrl + sessionForm.touxiang:require('@/assets/avator.png')" fit="cover"></el-image>
		</div>
		<div :style='{"padding":"20px 0","borderColor":"#f8524630","top":"46px","left":"20px","borderWidth":"0px","width":"140px","fontSize":0,"position":"absolute","borderStyle":"solid","height":"auto"}' v-if="userTableName=='yuangong'">
			<el-image :style='{"padding":"4px","margin":"0 auto","borderColor":"#eee","objectFit":"cover","borderRadius":"0","borderWidth":"1px","display":"block","width":"180px","borderStyle":"solid","height":"180px"}' :src="sessionForm.touxiang?baseUrl + sessionForm.touxiang:require('@/assets/avator.png')" fit="cover"></el-image>
		</div>
		<div :style='{"padding":"0 20px","borderColor":"#f9eacc","margin":"0 2% 10px 0","borderWidth":"0px","background":"none","display":"flex","width":"48%","lineHeight":"40px","borderStyle":"solid","height":"auto"}' v-if="userTableName=='yonghu'">
			<span class="icon iconfont icon-shouye-zhihui" :style='{"padding":"0 5px","fontSize":"14px","color":"#333","display":"none"}'></span>
			<div :style='{"margin":"0 10px 0 0","fontSize":"14px","color":"#333","display":"inline-block"}'>用户名</div>
			<div :style='{"color":"#999","textAlign":"left","fontSize":"14px"}'>{{sessionForm.yonghuming}}</div>
		</div>
		<div :style='{"padding":"0 20px","borderColor":"#f9eacc","margin":"0 2% 10px 0","borderWidth":"0px","background":"none","display":"flex","width":"48%","lineHeight":"40px","borderStyle":"solid","height":"auto"}' v-if="userTableName=='yonghu'">
			<span class="icon iconfont icon-shouye-zhihui" :style='{"padding":"0 5px","fontSize":"14px","color":"#333","display":"none"}'></span>
			<div :style='{"color":"#333","margin":"0 10px 0 0","fontSize":"14px"}'>姓名</div>
			<div :style='{"color":"#999","textAlign":"left","fontSize":"14px"}'>{{sessionForm.xingming}}</div>
		</div>
		<div :style='{"padding":"0 20px","borderColor":"#f9eacc","margin":"0 2% 10px 0","borderWidth":"0px","background":"none","display":"flex","width":"48%","lineHeight":"40px","borderStyle":"solid","height":"auto"}' v-if="userTableName=='yonghu'">
			<span class="icon iconfont icon-shouye-zhihui" :style='{"padding":"0 5px","fontSize":"14px","color":"#333","display":"none"}'></span>
			<div :style='{"color":"#333","margin":"0 10px 0 0","fontSize":"14px"}'>性别</div>
			<div :style='{"color":"#999","textAlign":"left","fontSize":"14px"}'>{{sessionForm.xingbie}}</div>
		</div>
		<div :style='{"padding":"0 20px","borderColor":"#f9eacc","margin":"0 2% 10px 0","borderWidth":"0px","background":"none","display":"flex","width":"48%","lineHeight":"40px","borderStyle":"solid","height":"auto"}' v-if="userTableName=='yonghu'">
			<span class="icon iconfont icon-shouye-zhihui" :style='{"padding":"0 5px","fontSize":"14px","color":"#333","display":"none"}'></span>
			<div :style='{"color":"#333","margin":"0 10px 0 0","fontSize":"14px"}'>手机</div>
			<div :style='{"color":"#999","textAlign":"left","fontSize":"14px"}'>{{sessionForm.shouji}}</div>
		</div>
		<div :style='{"padding":"0 20px","borderColor":"#f9eacc","margin":"0 2% 10px 0","borderWidth":"0px","background":"none","display":"flex","width":"48%","lineHeight":"40px","borderStyle":"solid","height":"auto"}' v-if="userTableName=='yonghu'">
			<span class="icon iconfont icon-shouye-zhihui" :style='{"padding":"0 5px","fontSize":"14px","color":"#333","display":"none"}'></span>
			<div :style='{"color":"#333","margin":"0 10px 0 0","fontSize":"14px"}'>余额</div>
			<div :style='{"color":"#999","textAlign":"left","fontSize":"14px"}'>{{sessionForm.money}}</div>
		</div>
		<div :style='{"padding":"0 20px","borderColor":"#f9eacc","margin":"0 2% 10px 0","borderWidth":"0px","background":"none","display":"flex","width":"48%","lineHeight":"40px","borderStyle":"solid","height":"auto"}' v-if="userTableName=='yuangong'">
			<span class="icon iconfont icon-shouye-zhihui" :style='{"padding":"0 5px","fontSize":"14px","color":"#333","display":"none"}'></span>
			<div :style='{"margin":"0 10px 0 0","fontSize":"14px","color":"#333","display":"inline-block"}'>员工工号</div>
			<div :style='{"color":"#999","textAlign":"left","fontSize":"14px"}'>{{sessionForm.yuangonggonghao}}</div>
		</div>
		<div :style='{"padding":"0 20px","borderColor":"#f9eacc","margin":"0 2% 10px 0","borderWidth":"0px","background":"none","display":"flex","width":"48%","lineHeight":"40px","borderStyle":"solid","height":"auto"}' v-if="userTableName=='yuangong'">
			<span class="icon iconfont icon-shouye-zhihui" :style='{"padding":"0 5px","fontSize":"14px","color":"#333","display":"none"}'></span>
			<div :style='{"color":"#333","margin":"0 10px 0 0","fontSize":"14px"}'>性别</div>
			<div :style='{"color":"#999","textAlign":"left","fontSize":"14px"}'>{{sessionForm.xingbie}}</div>
		</div>
		<div :style='{"padding":"0 20px","borderColor":"#f9eacc","margin":"0 2% 10px 0","borderWidth":"0px","background":"none","display":"flex","width":"48%","lineHeight":"40px","borderStyle":"solid","height":"auto"}' v-if="userTableName=='yuangong'">
			<span class="icon iconfont icon-shouye-zhihui" :style='{"padding":"0 5px","fontSize":"14px","color":"#333","display":"none"}'></span>
			<div :style='{"color":"#333","margin":"0 10px 0 0","fontSize":"14px"}'>姓名</div>
			<div :style='{"color":"#999","textAlign":"left","fontSize":"14px"}'>{{sessionForm.xingming}}</div>
		</div>
		<div :style='{"padding":"0 20px","borderColor":"#f9eacc","margin":"0 2% 10px 0","borderWidth":"0px","background":"none","display":"flex","width":"48%","lineHeight":"40px","borderStyle":"solid","height":"auto"}' v-if="userTableName=='yuangong'">
			<span class="icon iconfont icon-shouye-zhihui" :style='{"padding":"0 5px","fontSize":"14px","color":"#333","display":"none"}'></span>
			<div :style='{"color":"#333","margin":"0 10px 0 0","fontSize":"14px"}'>职务</div>
			<div :style='{"color":"#999","textAlign":"left","fontSize":"14px"}'>{{sessionForm.zhiwu}}</div>
		</div>
		<div :style='{"padding":"0 20px","borderColor":"#f9eacc","margin":"0 2% 10px 0","borderWidth":"0px","background":"none","display":"flex","width":"48%","lineHeight":"40px","borderStyle":"solid","height":"auto"}' v-if="userTableName=='yuangong'">
			<span class="icon iconfont icon-shouye-zhihui" :style='{"padding":"0 5px","fontSize":"14px","color":"#333","display":"none"}'></span>
			<div :style='{"color":"#333","margin":"0 10px 0 0","fontSize":"14px"}'>联系方式</div>
			<div :style='{"color":"#999","textAlign":"left","fontSize":"14px"}'>{{sessionForm.lianxifangshi}}</div>
		</div>
		<div :style='{"padding":"0 20px","borderColor":"#f9eacc","margin":"0 2% 10px 0","borderWidth":"0px","background":"none","display":"flex","width":"48%","lineHeight":"40px","borderStyle":"solid","height":"auto"}' v-if="userTableName=='yuangong'">
			<span class="icon iconfont icon-shouye-zhihui" :style='{"padding":"0 5px","fontSize":"14px","color":"#333","display":"none"}'></span>
			<div :style='{"color":"#333","margin":"0 10px 0 0","fontSize":"14px"}'>身份证号</div>
			<div :style='{"color":"#999","textAlign":"left","fontSize":"14px"}'>{{sessionForm.shenfenzhenghao}}</div>
		</div>
		
	</div>
	
    <el-tabs tab-position="left" :style='{"width":"100%","margin":"20px 0 0","flexWrap":"wrap","background":"#fff","display":"flex","order":"1"}' @tab-click="handleClick">
      <el-tab-pane label="个人中心">
        <el-form class="center-preview-pv" ref="sessionForm" :model="sessionForm" :rules="rules" label-width="110px">
          <el-form-item :style='{"width":"auto","padding":"0px","margin":"0 0 40px","background":"#fff","display":"inline-block"}' v-if="userTableName=='yonghu'" label="用户名" prop="yonghuming">
            <el-input v-model="sessionForm.yonghuming" placeholder="用户名" readonly></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"auto","padding":"0px","margin":"0 0 40px","background":"#fff","display":"inline-block"}' v-if="userTableName=='yonghu'" label="姓名" prop="xingming">
            <el-input v-model="sessionForm.xingming" placeholder="姓名" ></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"auto","padding":"0px","margin":"0 0 40px","background":"#fff","display":"inline-block"}' v-if="userTableName=='yonghu'" label="性别" prop="xingbie">
            <el-select v-model="sessionForm.xingbie" placeholder="请选择性别" >
              <el-option v-for="(item, index) in dynamicProp.xingbie" :key="index" :label="item" :value="item"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item :style='{"width":"auto","padding":"0px","margin":"0 0 40px","background":"#fff","display":"inline-block"}' v-if="userTableName=='yonghu'" label="头像" prop="touxiang">
			<file-upload
			tip="点击上传头像"
			action="file/upload"
			:limit="1"
			:multiple="true"
			:fileUrls="sessionForm.touxiang?sessionForm.touxiang:''"
			@change="yonghutouxiangHandleAvatarSuccess"
			></file-upload>
          </el-form-item>
          <el-form-item :style='{"width":"auto","padding":"0px","margin":"0 0 40px","background":"#fff","display":"inline-block"}' v-if="userTableName=='yonghu'" label="手机" prop="shouji">
            <el-input v-model="sessionForm.shouji" placeholder="手机" ></el-input>
          </el-form-item>
          <el-form-item class="balance" :style='{"width":"auto","padding":"0px","margin":"0 0 40px","background":"#fff","display":"inline-block"}' v-if="userTableName=='yonghu'" label="余额">
            <div :style='{"flexWrap":"wrap","display":"flex"}'>
				<el-input v-model="sessionForm.money" placeholder="余额" readonly></el-input>
				<div @click="dialogFormVisibleMoney = true" :style='{"cursor":"pointer","padding":"0 15px","margin":"2px 20px 0 10px","borderColor":"#f9eacc","color":"#fff","display":"inline-block","borderRadius":"0px","background":"#b4a078","borderWidth":"0px","width":"auto","lineHeight":"36px","fontSize":"14px","borderStyle":"solid","height":"36px"}'>点我充值</div>
			</div>
		  </el-form-item>
          <el-form-item :style='{"width":"auto","padding":"0px","margin":"0 0 40px","background":"#fff","display":"inline-block"}' v-if="userTableName=='yuangong'" label="员工工号" prop="yuangonggonghao">
            <el-input v-model="sessionForm.yuangonggonghao" placeholder="员工工号" readonly></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"auto","padding":"0px","margin":"0 0 40px","background":"#fff","display":"inline-block"}' v-if="userTableName=='yuangong'" label="头像" prop="touxiang">
			<file-upload
			tip="点击上传头像"
			action="file/upload"
			:limit="1"
			:multiple="true"
			:fileUrls="sessionForm.touxiang?sessionForm.touxiang:''"
			@change="yuangongtouxiangHandleAvatarSuccess"
			></file-upload>
          </el-form-item>
          <el-form-item :style='{"width":"auto","padding":"0px","margin":"0 0 40px","background":"#fff","display":"inline-block"}' v-if="userTableName=='yuangong'" label="性别" prop="xingbie">
            <el-select v-model="sessionForm.xingbie" placeholder="请选择性别" >
              <el-option v-for="(item, index) in dynamicProp.xingbie" :key="index" :label="item" :value="item"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item :style='{"width":"auto","padding":"0px","margin":"0 0 40px","background":"#fff","display":"inline-block"}' v-if="userTableName=='yuangong'" label="姓名" prop="xingming">
            <el-input v-model="sessionForm.xingming" placeholder="姓名" ></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"auto","padding":"0px","margin":"0 0 40px","background":"#fff","display":"inline-block"}' v-if="userTableName=='yuangong'" label="职务" prop="zhiwu">
            <el-input v-model="sessionForm.zhiwu" placeholder="职务" ></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"auto","padding":"0px","margin":"0 0 40px","background":"#fff","display":"inline-block"}' v-if="userTableName=='yuangong'" label="联系方式" prop="lianxifangshi">
            <el-input v-model="sessionForm.lianxifangshi" placeholder="联系方式" ></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"auto","padding":"0px","margin":"0 0 40px","background":"#fff","display":"inline-block"}' v-if="userTableName=='yuangong'" label="身份证号" prop="shenfenzhenghao">
            <el-input v-model="sessionForm.shenfenzhenghao" placeholder="身份证号" ></el-input>
          </el-form-item>
          <el-form-item class="balance" :style='{"width":"auto","padding":"0px","margin":"0 0 40px","background":"#fff","display":"inline-block"}' v-if="userTableName=='yuangong'" label="余额">
            <div :style='{"flexWrap":"wrap","display":"flex"}'>
				<el-input v-model="sessionForm.money" placeholder="余额" readonly></el-input>
				<div @click="dialogFormVisibleMoney = true" :style='{"cursor":"pointer","padding":"0 15px","margin":"2px 20px 0 10px","borderColor":"#f9eacc","color":"#fff","display":"inline-block","borderRadius":"0px","background":"#b4a078","borderWidth":"0px","width":"auto","lineHeight":"36px","fontSize":"14px","borderStyle":"solid","height":"36px"}'>点我充值</div>
			</div>
		  </el-form-item>
          <el-form-item :style='{"padding":"0","margin":"0"}'>
            <el-button :style='{"border":"0px solid #eccc19","cursor":"pointer","padding":"0","margin":"0 20px 0 0","color":"#fff","borderRadius":"0px","background":"#b4a078","width":"150px","lineHeight":"40px","fontSize":"16px","height":"40px"}' type="primary" @click="onSubmit('sessionForm')">更新信息</el-button>
            <el-button :style='{"border":"0px solid #ddd","cursor":"pointer","padding":"0","margin":"0","color":"#fff","borderRadius":"0px","background":"#999","width":"150px","lineHeight":"40px","fontSize":"14px","height":"40px"}' type="danger" @click="logout">退出登录</el-button>
          </el-form-item>
        </el-form>
      </el-tab-pane>
	  <el-tab-pane label="修改密码">
		<el-form class="center-preview-pv" ref="passwordForm" :model="passwordForm" :rules="passwordRules" label-width="110px">
			<el-form-item :style='{"width":"auto","padding":"0px","margin":"0 0 40px","background":"#fff","display":"inline-block"}' label="原密码" prop="password">
			  <el-input type="password" v-model="passwordForm.password" placeholder="原密码"></el-input>
			</el-form-item>
			<el-form-item :style='{"width":"auto","padding":"0px","margin":"0 0 40px","background":"#fff","display":"inline-block"}' label="新密码" prop="newpassword">
			  <el-input type="password" v-model="passwordForm.newpassword" placeholder="新密码"></el-input>
			</el-form-item>
			<el-form-item :style='{"width":"auto","padding":"0px","margin":"0 0 40px","background":"#fff","display":"inline-block"}' label="确认密码" prop="repassword">
			  <el-input type="password" v-model="passwordForm.repassword" placeholder="确认密码"></el-input>
			</el-form-item>
			<el-form-item :style='{"padding":"0","margin":"0"}'>
			  <el-button :style='{"border":"0px solid #eccc19","cursor":"pointer","padding":"0","margin":"0 20px 0 0","color":"#fff","borderRadius":"0px","background":"#b4a078","width":"150px","lineHeight":"40px","fontSize":"16px","height":"40px"}' type="primary" @click="updatePassword">修改密码</el-button>
			</el-form-item>
		</el-form>
	  </el-tab-pane>
	  <el-tab-pane label="聊天记录" style="width: 100%;" v-if="changeHasChat()">
	  	<div class="z-box" :style='{"width":"70%","padding":"20px","margin":"0 auto"}'>
	  		<div class="section-content" v-for="item in recordList" :key="item.id" @click="chatClick(item)">
	  			<img :src="item.picture?baseUrl + item.picture:require('@/assets/avator.png')" style="width: 60px;border-radius: 50%;"
	  				alt="">
	  			<div style="margin: 0 0 0 10px;display: flex;flex-direction: column;align-items: flex-start;">
	  				<div :style='{"fontSize":"14px","color":"#000","flex":"1","fontWeight":"bold"}'
	  					class="item-style">{{item.name}}</div>
	  				<div :style='{"color":"#666","flex":"1","fontSize":"14px","lineHeight":"1.5","display":"flex","alignItems":"center"}'
	  					class="item-style">
	  					<div v-if="item.notreadnum" style="padding: 0 5px;height: 16px;border-radius: 50%;text-align: center;line-height: 16px;font-size: 12px;background: #f00;color:#fff;width: auto;margin: 0 2px 0 0">{{item.notreadnum}}</div>
	  					{{item.content.split('/').length>1&&item.content.split('/')[0]=='upload'?'[图片]':item.content}}
	  				</div>
	  			</div>
	  		</div>
			<div class="noList" v-if="!recordList.length">
				暂无聊天记录
			</div>
	  	</div>
	  	
	  </el-tab-pane>
		<el-tab-pane v-for="(item,index) in menuList" :key="index" v-if="hasBack(item.menu)" :label="item.child[0].menu" :name="item.child[0].tableName"></el-tab-pane>
      <el-tab-pane label="我的订单"></el-tab-pane>
      <el-tab-pane label="我的地址" name="MyAddress">
        <router-view></router-view>
      </el-tab-pane>
      <el-tab-pane label="我的收藏"></el-tab-pane>
    </el-tabs>

	<el-dialog title="用户充值" :visible.sync="dialogFormVisibleMoney" width="726px" center>
	  <el-form :model="chongzhiForm">
		<el-form-item label="充值金额" label-width="120px">
		  <el-input type="number" v-model="chongzhiForm.money" autocomplete="off" placeholder="充值金额"></el-input>
		</el-form-item>
		<el-form-item label-width="120px">
		  <el-radio-group v-model="chongzhiForm.radio">
			<el-radio style="margin-bottom: 30px" label="微信支付">
			  <el-image
				style="width: 60px; height: 60px;vertical-align: middle;"
				:src="require('@/assets/weixin.png')"
				fit="fill"></el-image>
				<span style="display: inline-block;margin-left: 10px">微信支付</span>
			</el-radio>
			<el-radio label="支付宝支付">
			  <el-image
				style="width: 60px; height: 60px;vertical-align: middle;"
				:src="require('@/assets/zhifubao.png')"
				fit="fill"></el-image>
				<span style="display: inline-block;margin-left: 10px">支付宝支付</span>
			</el-radio>
			<el-radio label="中国建设银行支付">
			  <el-image
				style="width: 120px; height: 60px;vertical-align: middle;"
				:src="require('@/assets/jianshe.png')"
				fit="fill"></el-image>
			</el-radio>
			<el-radio label="中国农业银行支付">
			  <el-image
				style="width: 126px; height: 60px;vertical-align: middle;"
				:src="require('@/assets/nongye.png')"
				fit="fill"></el-image>
			</el-radio>
			<el-radio label="中国银行支付">
			  <el-image
				style="width: 140px; height: 60px;vertical-align: middle;"
				:src="require('@/assets/zhongguo.png')"
				fit="fill"></el-image>
			</el-radio>
			<el-radio label="交通银行支付">
			  <el-image
				style="width: 120px; height: 60px;vertical-align: middle;"
				:src="require('@/assets/jiaotong.png')"
				fit="fill"></el-image>
			</el-radio>
		  </el-radio-group>
		</el-form-item>
	  </el-form>
	  <div slot="footer" class="dialog-footer">
		<el-button @click="dialogFormVisibleMoney = false">取 消</el-button>
		<el-button type="primary" @click="chongzhi">确认充值</el-button>
	  </div>
	</el-dialog>
	<el-dialog :visible.sync="chatVisible" @close="clearChat" :title="nowname">
		<div class="chat-content" id="chat-content">
			<div v-bind:key="item.id" v-for="item in chatList">
				<div v-if="item.uid==sessionForm.id" class="right-content">
					<el-alert v-if="item.format==1" class="text-content" :title="item.content" :closable="false"
						type="warning"></el-alert>
					<el-image v-else fit="cover" :src="item.content?baseUrl + item.content:''" style="width: 100px;height: 100px;" :preview-src-list="[item.content?baseUrl + item.content:'']"></el-image>
					<img :src="mypic?baseUrl + mypic:require('@/assets/avator.png')" alt="" style="width: 30px;border-radius: 50%;height: 30px;margin: 0 0 0 10px;" />
				</div>
				<div v-else class="left-content">
					<img :src="nowfpic?baseUrl + nowfpic:require('@/assets/avator.png')" alt="" style="width: 30px;border-radius: 50%;height: 30px;margin: 0 10px 0 0;" />
					<el-alert v-if="item.format==1" class="text-content" :title="item.content" :closable="false"
						type="success"></el-alert>
					<el-image v-else fit="cover" :src="item.content?baseUrl + item.content:''" style="width: 100px;height: 100px;" :preview-src-list="[item.content?baseUrl + item.content:'']"></el-image>
				</div>
				<div class="clear-float"></div>
			</div>
		</div>
		<div slot="footer" class="dialog-footer">
			<el-input @keydown.enter.native="addChat" v-model="chatForm.content" placeholder="请输入内容" style="width: calc(100% - 180px);float: left;">
			</el-input>
			<el-button :disabled="chatForm.content?false:true" type="primary" @click="addChat">发送</el-button>
			<el-upload style="display: inline-block;margin: 0 0 0 6px;" class="upload-demo" :action="uploadUrl" :on-success="uploadSuccess"
			    :show-file-list="false">
			    <el-button type="success">上传图片</el-button>
			</el-upload>
		</div>
	</el-dialog>
</div>
</template>

<script>
  import config from '@/config/config'
  import menu from '@/config/menu'
  import Vue from 'vue'
  export default {
    //数据集合
    data() {
      return {
        title: '个人中心',
        baseUrl: config.baseUrl,
        sessionForm: {},
		passwordForm: {},
		passwordRules: {
			password: [
				{
					required: true,
					message: "密码不能为空",
					trigger: "blur"
				}
			],
			newpassword: [
				{
					required: true,
					message: "新密码不能为空",
					trigger: "blur"
				}
			],
			repassword: [
				{
					required: true,
					message: "确认密码不能为空",
					trigger: "blur"
				}
			]
		},
        rules: {},
        chongzhiForm: {
          money: '',
          radio: ''
        },
		menuList: [],
        disabled: false,
        dialogFormVisibleMoney: false,
        uploadUrl: config.baseUrl + 'file/upload',
        imageUrl: '',
        headers: {Token: localStorage.getItem('frontToken')},
        userTableName: localStorage.getItem('UserTableName'),
        dynamicProp: {},
		recordList: [],
		chatVisible: false,
		nowfid: 0,
		nowfpic:'',
		nowname: '',
		mypic: localStorage.getItem('frontHeadportrait'),
		chatList: [],
		chatForm: {
			content: ''
		},
		chatTimer: null,
		hasChatList: [
			'yonghu',
			'yuangong',
			'caipinxinxi',
		],
      }
    },
    created() {
		let menus = menu.list()
		for(let x in menus){
			if(menus[x].tableName == this.userTableName){
				this.menuList = menus[x].backMenu
			}
		}
		if ('yonghu' == this.userTableName) {
			this.$set(this.sessionForm, 'yonghuming', null);
		}
		if ('yonghu' == this.userTableName) {
			this.$set(this.sessionForm, 'mima', null);
		}
		if ('yonghu' == this.userTableName) {
			this.$set(this.sessionForm, 'xingming', null);
		}
		if ('yonghu' == this.userTableName) {
			this.$set(this.sessionForm, 'xingbie', null);
		}
		if ('yonghu' == this.userTableName) {
			this.$set(this.sessionForm, 'touxiang', null);
		}
		if ('yonghu' == this.userTableName) {
			this.$set(this.sessionForm, 'shouji', null);
		}
		if ('yonghu' == this.userTableName) {
			this.$set(this.sessionForm, 'money', null);
		}
		if ('yuangong' == this.userTableName) {
			this.$set(this.sessionForm, 'yuangonggonghao', null);
		}
		if ('yuangong' == this.userTableName) {
			this.$set(this.sessionForm, 'mima', null);
		}
		if ('yuangong' == this.userTableName) {
			this.$set(this.sessionForm, 'touxiang', null);
		}
		if ('yuangong' == this.userTableName) {
			this.$set(this.sessionForm, 'xingbie', null);
		}
		if ('yuangong' == this.userTableName) {
			this.$set(this.sessionForm, 'xingming', null);
		}
		if ('yuangong' == this.userTableName) {
			this.$set(this.sessionForm, 'zhiwu', null);
		}
		if ('yuangong' == this.userTableName) {
			this.$set(this.sessionForm, 'lianxifangshi', null);
		}
		if ('yuangong' == this.userTableName) {
			this.$set(this.sessionForm, 'shenfenzhenghao', null);
		}
		if ('yuangong' == this.userTableName) {
			this.$set(this.sessionForm, 'userid', null);
		}
		if ('yuangong' == this.userTableName) {
			this.$set(this.sessionForm, 'money', null);
		}

		if ('yonghu' == this.userTableName&&this.rules['yonghuming']){
			this.rules['yonghuming'].push({ required: true, message: '请输入用户名', trigger: 'blur' })
		}else if('yonghu' == this.userTableName&&!this.rules['yonghuming']) {
			this.$set(this.rules, 'yonghuming', [{ required: true, message: '请输入用户名', trigger: 'blur' }]);
		}
		if ('yonghu' == this.userTableName&&this.rules['mima']){
			this.rules['mima'].push({ required: true, message: '请输入密码', trigger: 'blur' })
		}else if('yonghu' == this.userTableName&&!this.rules['mima']) {
			this.$set(this.rules, 'mima', [{ required: true, message: '请输入密码', trigger: 'blur' }]);
		}
		if ('yonghu' == this.userTableName&&this.rules['xingming']){
			this.rules['xingming'].push({ required: true, message: '请输入姓名', trigger: 'blur' })
		}else if('yonghu' == this.userTableName&&!this.rules['xingming']) {
			this.$set(this.rules, 'xingming', [{ required: true, message: '请输入姓名', trigger: 'blur' }]);
		}
		if ('yonghu' == this.userTableName) {
			this.$set(this.rules, 'shouji', [{ required: false, validator: this.$validate.isMobile, trigger: 'blur' }]);
		}
		if ('yonghu' == this.userTableName) {
			this.$set(this.rules, 'money', [{ required: false, validator: this.$validate.isNumber, trigger: 'blur' }]);
		}
		if ('yuangong' == this.userTableName&&this.rules['yuangonggonghao']){
			this.rules['yuangonggonghao'].push({ required: true, message: '请输入员工工号', trigger: 'blur' })
		}else if('yuangong' == this.userTableName&&!this.rules['yuangonggonghao']) {
			this.$set(this.rules, 'yuangonggonghao', [{ required: true, message: '请输入员工工号', trigger: 'blur' }]);
		}
		if ('yuangong' == this.userTableName&&this.rules['mima']){
			this.rules['mima'].push({ required: true, message: '请输入密码', trigger: 'blur' })
		}else if('yuangong' == this.userTableName&&!this.rules['mima']) {
			this.$set(this.rules, 'mima', [{ required: true, message: '请输入密码', trigger: 'blur' }]);
		}
		if ('yuangong' == this.userTableName&&this.rules['xingming']){
			this.rules['xingming'].push({ required: true, message: '请输入姓名', trigger: 'blur' })
		}else if('yuangong' == this.userTableName&&!this.rules['xingming']) {
			this.$set(this.rules, 'xingming', [{ required: true, message: '请输入姓名', trigger: 'blur' }]);
		}
		if ('yuangong' == this.userTableName) {
			this.$set(this.rules, 'lianxifangshi', [{ required: false, validator: this.$validate.isMobile, trigger: 'blur' }]);
		}
		if ('yuangong' == this.userTableName) {
			this.$set(this.rules, 'shenfenzhenghao', [{ required: false, validator: this.$validate.isIdCard, trigger: 'blur' }]);
		}
		if ('yuangong' == this.userTableName) {
			this.$set(this.rules, 'money', [{ required: false, validator: this.$validate.isNumber, trigger: 'blur' }]);
		}

      this.init();
      this.sessionForm = JSON.parse(localStorage.getItem('sessionForm'))
    },
    //方法集合
    methods: {
      init() {
        if ('yonghu' == this.userTableName) {
          this.dynamicProp.xingbie = '男,女'.split(',');
        }
        if ('yuangong' == this.userTableName) {
          this.dynamicProp.xingbie = '男,女'.split(',');
        }
      },
	  setSession(){
		  localStorage.setItem('sessionForm',JSON.stringify(this.sessionForm))
	  },
      onSubmit(formName) {
		if(`yonghu` == this.userTableName && this.sessionForm.touxiang!=null){
			this.sessionForm.touxiang = this.sessionForm.touxiang.replace(new RegExp(this.$config.baseUrl,"g"),"");
		}
		if(`yuangong` == this.userTableName && this.sessionForm.touxiang!=null){
			this.sessionForm.touxiang = this.sessionForm.touxiang.replace(new RegExp(this.$config.baseUrl,"g"),"");
		}
        this.$refs[formName].validate((valid) => {
			if (valid) {
				this.$http.post(this.userTableName + '/update', this.sessionForm).then(res => {
					if (res.data.code == 0) {
						this.setSession()
						this.$message({
							message: '更新成功',
							type: 'success',
							duration: 1500
						});
					}
				});
			} else {
				return false;
			}
        });
      },
      yonghutouxiangHandleAvatarSuccess(fileUrls) {
        this.sessionForm.touxiang = fileUrls;
      },
      yuangongtouxiangHandleAvatarSuccess(fileUrls) {
        this.sessionForm.touxiang = fileUrls;
      },
      chongzhi() {
        if (this.chongzhiForm.money == '') {
          this.$message({
            message: '请输入充值金额',
            type: 'error',
            duration: 1500
          });
          return;
        }
        if (this.chongzhiForm.money <= 0) {
          this.$message({
            message: '请输入正确的充值金额',
            type: 'error',
            duration: 1500
          });
          return;
        }
        if (this.chongzhiForm.radio == '') {
          this.$message({
            message: '请选择充值方式',
            type: 'error',
            duration: 1500
          });
          return;
        }
		if(!this.sessionForm.money) {
			this.sessionForm.money = parseFloat(this.chongzhiForm.money)
		}else{
			this.sessionForm.money = parseFloat(this.sessionForm.money) + parseFloat(this.chongzhiForm.money);
		}
        
        this.$http.post(this.userTableName + '/update', this.sessionForm).then(res => {
          if (res.data.code == 0) {
			  this.setSession()
            this.$message({
              message: '充值成功',
              type: 'success',
              duration: 1500,
              onClose: () => {
                this.dialogFormVisibleMoney = false;
              }
            });
          }
        });
      },
      handleClick(tab, event) {
        switch(event.target.outerText) {
          case '个人中心':
            tab.$router.push('/index/center');
            break;
          case '修改密码':
            this.passwordForm = {
				password: '',
				newpassword: '',
				repassword: '',
			}
			this.$forceUpdate()
            break;
		  case '聊天记录':
			this.getRecordList()
			break;
          case '我的订单':
            tab.$router.push('/index/shop-order/order');
            break;
          case '我的地址':
            tab.$router.push('/index/shop-address/list');
            break;
          case '我的收藏':
            localStorage.setItem('storeupType', 1);
            tab.$router.push('/index/storeup');
            break;
		  default:
		  	tab.$router.push(`/index/${tab.name}?centerType=1`);
        }

        this.title = event.target.outerText;
      },
		changeHasChat(){
			let table = localStorage.getItem('frontSessionTable')
			console.log(table)
			for(let x in this.hasChatList){
				if(this.hasChatList[x]==table){
					return true
				}
			}
			return false
		},
		getRecordList() {
			this.$http.get('friend/page2', {
				params: {
					uid: localStorage.getItem('frontUserid'),
					type: 2
				}
			}).then(res => {
				if (res.data && res.data.code == 0) {
					this.recordList = res.data.data.list
				}
			})
		},
		chatClick(row) {
			this.nowfid = row.fid
			this.nowfpic = row.picture
			this.nowname = row.name
			this.getChatList()
			this.chatVisible = true
		},
		getChatList() {
			this.$http.get('chatmessage/mlist', {
				params: {
					page: 1,
					limit: 1000,
					uid: localStorage.getItem('frontUserid'),
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
		clearChat(){
			clearTimeout(this.chatTimer)
			this.chatList = []
			this.getRecordList()
		},
		uploadSuccess(res) {
			if (res.code == 0) {
				clearTimeout(this.chatTimer)
				this.$http.post('chatmessage/add', {
					uid: localStorage.getItem('frontUserid'),
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
		},
		addChat() {
			clearTimeout(this.chatTimer)
			this.$http.post('chatmessage/add', {
				uid: localStorage.getItem('frontUserid'),
				fid: this.nowfid,
				content: this.chatForm.content,
				format: 1
			}).then(res2 => {
				this.chatForm = {
					content: ''
				}
				this.getChatList()
			})
		},
	  async updatePassword(){
			this.$refs["passwordForm"].validate(async valid => {
				if (valid) {
					var password = "";
					if (this.sessionForm.mima) {
						password = this.sessionForm.mima;
					} else if (this.sessionForm.password) {
						password = this.sessionForm.password;
					}
					var nowpassword = ''
					await this.$http.get('encrypt/md5?text=' + this.passwordForm.password,).then(res=>{
						if(res.data&&res.data.code==0){
							nowpassword = res.data.data
						}
					})
					if(nowpassword!=password){
						this.$message.error("原密码错误");
						return;
					}
					if (this.passwordForm.newpassword != this.passwordForm.repassword) {
						this.$message.error("两次密码输入不一致");
						return;
					}
					if (this.passwordForm.newpassword == this.passwordForm.password) {
						this.$message.error("新密码与原密码相同！");
						return;
					}
					if (this.userTableName == 'yonghu') {
					}
					this.sessionForm.password = this.passwordForm.newpassword;
					this.sessionForm.mima = this.passwordForm.newpassword;
					this.$http.post(`${this.userTableName}/update`,this.sessionForm).then(({data})=>{
						if (data && data.code === 0) {
							this.$message({
								message: "修改密码成功,下次登录系统生效",
								type: "success",
								duration: 1500,
								onClose: () => {
								}
							});
							this.setSession()
						} else {
							this.$message.error(data.msg);
						}
					});
				}
			})
	  },
      logout() {
        localStorage.clear();
        Vue.http.headers.common['Token'] = "";
        this.$router.push('/index/home');
        this.activeIndex = '0'
        localStorage.setItem('keyPath', this.activeIndex)
        this.$forceUpdate()
        this.$message({
            message: '登出成功',
            type: 'success',
            duration: 1500,
        });
      },
	  hasBack(name){
		  switch(name){
			case '订单管理':
				return false
				break;
			case '我的收藏管理':
				return false
				break;
			default:
				return true
		  }
	  }
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
  .center-preview {
  
    .el-tabs {
      & ::v-deep .el-tabs__header {
		.el-tabs__nav{
			overflow: auto;
		}
		::-webkit-scrollbar {
		  -webkit-appearance: none;
		  width: 6px;
		  height: 6px;
		}
		::-webkit-scrollbar-track {
		  background: rgba(0, 0, 0, 0.1);
		  border-radius: 0;
		}
		::-webkit-scrollbar-thumb {
		  cursor: pointer;
		  border-radius: 5px;
		  background: rgba(0, 0, 0, 0.15);
		  transition: color 0.2s ease;
		}
		::-webkit-scrollbar-thumb:hover {
		  background: rgba(0, 0, 0, 0.3);
		}
        .el-tabs__nav-wrap {
          margin: 0;
  
          &::after {
            content: none;
          }
        }
  
        .el-tabs__active-bar {
          display: none !important;
        }
      }
  
      .center-preview-pv {
        .el-date-editor.el-input {
          width: auto;
        }
  
        .balance {
          .el-input {
            width: auto;
          }
        }
      }
    }
  }
  
  .center-preview .el-tabs ::v-deep .el-tabs__header {
	padding: 0px;
	margin: 10px 0 0 40px;
	display: flex;
	border-color: #f8524630;
	float: right;
	flex-wrap: wrap;
	background: none;
	width: 200px;
	border-width: 0px;
	position: relative;
	border-style: solid;
	text-align: center;
	height: auto;
	order: 2;
  }
  
  .center-preview .el-tabs ::v-deep .el-tabs__header .el-tabs__item {
  	padding: 0 10px;
  	color: #666;
  	font-weight: 500;
  	font-size: 14px;
  	border-color: #eee;
  	line-height: 50px;
  	transition: 0ms;
  	background: #fff;
  	width: 200px;
  	border-width: 0 0 1px;
  	border-style: solid;
  	text-align: center;
  	height: auto;
  }
  
  .center-preview .el-tabs ::v-deep .el-tabs__header .el-tabs__item:hover {
  	padding: 0 10px;
  	color: #fff;
  	background: #b4a078;
  	font-weight: 600;
  	font-size: 14px;
  	line-height: auto;
  	text-align: center;
  	height: auto;
  }
  
  .center-preview .el-tabs ::v-deep .el-tabs__header .el-tabs__item.is-active {
  	padding: 0 10px;
  	color: #fff;
  	background: #b4a078;
  	font-weight: 600;
  	width: 100%;
  	font-size: 14px;
  	line-height: 50px;
  	text-align: center;
  	height: auto;
  }
  
  .center-preview .el-tabs ::v-deep .el-tabs__content {
  	padding: 30px 20px 40px;
  	margin: 10px 0 0;
  	background: #fff;
  	flex: 1;
  	width: calc(100% - 220px);
  	border-color: #eee;
  	border-width: 1px;
  	float: left;
  	border-style: solid;
  }
  .center-preview .el-tabs ::v-deep .el-tabs__content .el-tab-pane {
  	width: 100%;
  }
  
  .center-preview-pv .el-form-item ::v-deep .el-form-item__label {
  	padding: 0 10px 0 0;
  	color: #666;
  	font-weight: 500;
  	width: 110px;
  	font-size: 14px;
  	line-height: 40px;
  	text-align: right;
  }
  
  .center-preview-pv .el-form-item .el-form-item__content {
    margin-left: 110px;
  }
  
  .center-preview-pv .el-input ::v-deep .el-input__inner {
  	border-radius: 0px;
  	padding: 0 12px;
  	box-shadow: 0 0 0px rgba(64, 158, 255, .5);
  	outline: none;
  	color: #666;
  	width: auto;
  	font-size: 14px;
  	border-color: #eee;
  	border-width: 1px;
  	border-style: solid;
  	min-width: 150px;
  	height: 40px;
  }
  
  .center-preview-pv .el-select ::v-deep .el-input__inner {
  	border-radius: 0px;
  	padding: 0 12px;
  	box-shadow: 0 0 0px rgba(64, 158, 255, .5);
  	outline: none;
  	color: #666;
  	width: auto;
  	font-size: 14px;
  	border-color: #eee;
  	border-width: 1px;
  	border-style: solid;
  	min-width: 150px;
  	height: 40px;
  }
  
  .center-preview-pv .el-date-editor ::v-deep .el-input__inner {
  	border-radius: 0px;
  	padding: 0 10px 0 30px;
  	box-shadow: 0 0 0px rgba(64, 158, 255, .5);
  	outline: none;
  	color: #666;
  	width: 200px;
  	font-size: 14px;
  	border-color: #eee;
  	border-width: 1px;
  	border-style: solid;
  	height: 40px;
  }
  
  .center-preview-pv ::v-deep .avatar-uploader-icon {
  	cursor: pointer;
  	border-radius: 2px;
  	color: #999;
  	width: 130px;
  	font-size: 24px;
  	border-color: #eee;
  	border-width: 1px;
  	line-height: 50px;
  	border-style: solid;
  	text-align: center;
  	height: 50px;
  }
  
  .center-preview-pv .el-form-item.balance ::v-deep .el-input__inner {
  	border-radius: 0px;
  	padding: 0 12px;
  	color: #666;
  	display: inline-block;
  	width: 200px;
  	font-size: 14px;
  	border-color: #eee;
  	border-width: 1px;
  	border-style: solid;
  	height: 36px;
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
