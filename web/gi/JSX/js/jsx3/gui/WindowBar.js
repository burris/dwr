/*
 * Copyright (c) 2001-2007, TIBCO Software Inc.
 * Use, modification, and distribution subject to terms of license.
 */
jsx3.require("jsx3.gui.Block");jsx3.Class.defineClass("jsx3.gui.WindowBar",jsx3.gui.Block,null,function(a,f){var
u=jsx3.gui.Block;a.DEFAULTHEIGHT=26;a.DEFAULTBACKGROUND=jsx3.html.getCSSFade(false);a.DEFAULTBG="#c8c8d5";a.DEFAULTBGCAPTION="#aaaacb";a.DEFAULTBORDER="solid 1px #e8e8f5;solid 0px;solid 1px #a8a8b5;solid 0px;";a.DEFAULTBORDERCAPTION="solid 1px #9898a5";a.DEFAULTFONTWEIGHT="bold";a.DEFAULTFONTSIZE=11;a.TYPECAPTION=0;a.TYPETOOL=1;a.TYPEMENU=2;a.TYPETASK=3;f.init=function(m,r){this.jsxsuper(m);this.setRelativePosition(1);if(r!=null)this.setType(r);};f.getMaskProperties=function(){return this.getRelativePosition()==0?u.MASK_MOVE_ONLY:u.MASK_NO_EDIT;};f.getType=function(){return this.jsxbartype==null?0:this.jsxbartype;};f.setType=function(j){this.jsxbartype=j;return this;};f.setText=function(g,d){this.jsxsuper(g,d);if(d)if(this.getType()==0){var
Pb=this.getParent();if(Pb instanceof jsx3.gui.Dialog&&Pb.getRendered()!=null)Pb.Ce();}return this;};f.doBeginMove=function(e,h){if(jsx3.html.getJSXParent(e.srcElement())==this)this.getParent().doBeginMove(e,h);};a.Tk={};a.Tk["mousedown"]="doBeginMove";f.Vd=function(n,k,d){this.Qh(n,k,d,2);};f.zj=function(q){this.applyDynamicProperties();if(this.getParent()&&(q==null||!isNaN(q.parentwidth)&&!isNaN(q.parentheight))){q=this.getParent().Ln(this);}else if(q==null)q={};var
J=this.getBorder();var
Ab=this.getRelativePosition()!==0;if(q.left==null&&!Ab&&!jsx3.util.strEmpty(this.getLeft()))q.left=this.getLeft();if(q.top==null&&!Ab&&!jsx3.util.strEmpty(this.getTop()))q.top=this.getTop();if(q.width==null)q.width="100%";if(q.height==null)q.height=a.DEFAULTHEIGHT;q.boxtype=Ab?"inline":"box";q.tagname="div";q.padding="0 0 0 4";q.border=J!=null?J:this.getType()==0?a.DEFAULTBORDERCAPTION:a.DEFAULTBORDER;var
Eb=new
jsx3.gui.Painted.Box(q);if(this.getType()==0){var
X={};X.left=6;X.top=6;X.tagname="span";X.boxtype="box";var
Gc=new
jsx3.gui.Painted.Box(X);Eb.Od(Gc);}return Eb;};f.paint=function(){this.applyDynamicProperties();var
B=this.vi(true);var
mc=null,jc=null,R=null;if(this.getType()==0){var
K=B.tp(0);K.setAttributes('class="jsx30windowbar_lbl"');K.setStyles(this.Eo()+this.Wm()+this.Ak()+this.xp());R=K.paint().join(this.im());mc="cursor:move;";jc=this.qk(a.Tk,0);}else{mc="cursor:default;";jc="";R="";}var
x=this.renderAttributes(null,true);B.setAttributes('id="'+this.getId()+'"'+this.so()+this.fo()+this.vo()+jc+' class="jsx30windowbar"'+x);B.setStyles(mc+this.Ho()+this.Dg()+this.vl()+this.mg()+this.ji());return B.paint().join(R+this.paintChildren());};f.vo=function(){return this.jsxsuper(this.getIndex()||Number(0));};f.Dg=function(){var
Nc=this.getBackgroundColor();return Nc==null||Nc!=""?"background-color:"+(Nc?Nc:this.getType()==0?a.DEFAULTBGCAPTION:a.DEFAULTBG)+";":"";};f.mg=function(){if(this.getType()==2)return "";var
Xb=this.getBackground();return Xb==null?a.DEFAULTBACKGROUND:Xb;};f.getHeight=function(){var
S=this.jsxsuper();if(S==null||isNaN(S))S=a.DEFAULTHEIGHT;return S;};f.Wm=function(){return this.getFontWeight()?"font-weight:"+this.getFontWeight()+";":"font-weight:"+"bold"+";";};f.xp=function(){return "font-size:"+(this.getFontSize()?this.getFontSize():a.DEFAULTFONTSIZE)+"px;";};f.Ho=function(){return "text-align:"+(this.getTextAlign()?this.getTextAlign():this.getType()==0?"right":"left")+";";};f.im=function(){return this.getText()?this.getText():"";};f.beep=function(){jsx3.gui.po(this.getRendered(),{filter:"none",backgroundColor:"#FFFFFF",backgroundImage:""});};a.getVersion=function(){return "2.4.00";};});jsx3.WindowBar=jsx3.gui.WindowBar;
