/*
 * Copyright (c) 2001-2007, TIBCO Software Inc.
 * Use, modification, and distribution subject to terms of license.
 */
jsx3.require("jsx3.gui.Form","jsx3.gui.Block");jsx3.Class.defineClass("jsx3.gui.TextBox",jsx3.gui.Block,[jsx3.gui.Form],function(d,m){var
gb=jsx3.gui.Event;var
F=jsx3.gui.Interactive;d.TYPETEXT=0;d.TYPETEXTAREA=1;d.TYPEPASSWORD=2;d.WRAPYES=1;d.WRAPNO=0;d.OVERFLOWNORMAL="";d.OVERFLOWAUTO="auto";d.OVERFLOWSCROLL="scroll";jsx3.gui.TextBox.DEFAULTBACKGROUNDCOLOR="#ffffff";d.VALIDATIONNONE="none";d.VALIDATIONSSN="ssn";d.VALIDATIONPHONE="phone";d.VALIDATIONEMAIL="email";d.VALIDATIONNUMBER="number";d.VALIDATIONLETTER="letter";d.VALIDATIONUSZIP="uszip";d.DEFAULTCLASSNAME="jsx30textbox";d.rB={};d.rB["none"]=/[\s\S]*/;d.rB["ssn"]=/^\d{3}-\d{2}-\d{4}$/;d.rB["phone"]=/^[0-9\-\(\) ]+$/;d.rB["email"]=/([a-zA-Z0-9_~\-\.]+)@([a-zA-Z0-9]+)\.[a-zA-Z0-9]{2,}/;d.rB["number"]=/^\d+$/;d.rB["letter"]=/^[a-zA-Z ,-\.]+$/;d.rB["uszip"]=/^\d{5}(-\d{4})?$/;m.init=function(h,q,l,f,c,g,k){this.jsxsuper(h,q,l,f,c);if(g!=null){this.setDefaultValue(g);this.setValue(g);}if(k!=null)this.setType(k);};m.ri=function(q,o){if(q.enterKey()&&this.getEvent("jsxexecute")){this.doEvent("jsxexecute",{objEVENT:q});}else this.doEvent("jsxkeypress",{objEVENT:q});};m.zd=function(i,c){var
jc=this.doEvent("jsxchange",{objEVENT:i,strPREVIOUS:this.jsxvalue,strVALUE:c.value});if(jc===false){c.value=this.jsxvalue;}else this.jsxvalue=c.value;};m.Bi=function(s,j){this.doEvent("jsxkeyup",{objEVENT:s});if(this.getType()==1){var
Wb=this.getMaxLength();if(Wb>0){var
vc=j.value;if(vc&&vc.length>Wb)j.value=vc.substring(0,Wb);}}if(this.hasEvent("jsxincchange")){var
xb=j.value;if(this._jsxYq!=xb){var
Db=this.doEvent("jsxincchange",{objEVENT:s,strPREVIOUS:this._jsxYq,strVALUE:xb});if(Db===false){j.value=this._jsxYq!=null?this._jsxYq:"";}else this._jsxYq=xb;}}};m.getMaxLength=function(){return this.jsxmaxlength!=null?this.jsxmaxlength:null;};m.setMaxLength=function(p){this.jsxmaxlength=p;return this;};m.setOverflow=function(g){this.jsxoverflow=g;return this;};m.getType=function(){return this.jsxtype==null?0:this.jsxtype;};m.setType=function(b){this.jsxtype=b;this.fi();return this;};m.getValue=function(){var
db=this.getRendered();if(db!=null){return db.value;}else return this.jsxvalue!=null?this.jsxvalue:this.getDefaultValue();};m.bV=function(){var
Hb=null;var
tc=this.getRendered();if(tc!=null)Hb=tc.value;if(Hb==null)Hb=this.jsxvalue!=null?this.jsxvalue:this.getDefaultValue();Hb=Hb.toString().replace(/&/g,"&amp;").replace(/</g,"&lt;").replace(/>/g,"&gt;");return Hb;};m.im=function(){return this.getText()?this.getText():"";};m.getDefaultValue=function(){return this.im();};m.setValue=function(g){this.jsxvalue=g;this._jsxYq=g;var
lb=this.getRendered();if(lb!=null)lb.value=g!=null?g:"";return this;};m.setDefaultValue=function(c){this.setText(c);return this;};m.getWrap=function(){return this.jsxwrap==null?1:this.jsxwrap;};m.setWrap=function(p){this.jsxwrap=p;return this;};m.Vd=function(j,g,h){this.Qh(j,g,h,3);};m.zj=function(s){if(this.getParent()&&(s==null||isNaN(s.parentwidth)||isNaN(s.parentheight))){s=this.getParent().Ln(this);}else if(s==null)s={};this.applyDynamicProperties();var
L=this.getRelativePosition()!=0;var
I,wb,U,Rb,fc;var
A=!L&&!jsx3.util.strEmpty(this.getTop())?this.getTop():0;var
Nc=!L&&!jsx3.util.strEmpty(this.getLeft())?this.getLeft():0;if(s.left==null)s.left=Nc;if(s.top==null)s.top=A;if(s.width==null)s.width=(Rb=this.getWidth())!=null?Rb:100;if(s.height==null)s.height=(fc=this.getHeight())!=null?fc:18;var
cb=this.getType();if(cb==0){s.tagname="input[text]";s.empty=true;}else if(cb==2){s.tagname="input[password]";s.empty=true;}else s.tagname="textarea";if(s.boxtype==null)s.boxtype=L?"inline":"box";s.padding=(I=this.getPadding())!=null&&I!=""?I:"2 0 0 2";if(s.tagname!="textarea")s.margin=L&&(wb=this.getMargin())!=null&&wb!=""?wb:null;s.border=(U=this.getBorder())!=null&&U!=""?U:"solid 1px #a6a6af;solid 1px #e6e6e6;solid 1px #e6e6e6;solid 1px #a6a6af";var
ab=new
jsx3.gui.Painted.Box(s);return ab;};m.paint=function(){this.applyDynamicProperties();var
ab=this.getId();var
db=this.getType();var
yc={};if(this.hasEvent("jsxexecute")||this.hasEvent("jsxkeypress"))yc["keypress"]=true;if(this.hasEvent("jsxkeydown"))yc["keydown"]=true;if(this.hasEvent("jsxkeyup")||this.hasEvent("jsxincchange")||this.getType()==1&&this.getMaxLength()>0){yc["keyup"]=true;this._jsxYq=this.getValue();}if(this.hasEvent("jsxblur"))yc["blur"]=true;if(this.hasEvent("jsxfocus"))yc["focus"]=true;if(this.hasEvent("jsxdblclick"))yc["dblclick"]=true;if(this.hasEvent("jsxclick"))yc["click"]=true;if(this.hasEvent("jsxmousedown"))yc["mousedown"]=true;if(this.hasEvent("jsxmousewheel"))yc["mousewheel"]=true;yc["change"]=true;var
L=this.qk(yc,0);var
dc=this.renderAttributes(null,true);var
sc=this.vi(true);if(db==0||db==2){sc.setAttributes(this.k3()+' id="'+ab+'"'+this.so()+this.pl()+this.Rw()+this.vo()+this.fo()+L+' value="'+this.getValue().toString().replace(/\"/g,"&quot;")+'" class="'+this.Wg()+'" '+dc);sc.setStyles(this.Ak()+this.xp()+this.Wm()+this.Af()+this.Dh()+this.vl()+this.Dg()+this.mg()+this.Eo()+this.Ho()+this.ji());var
kc="";}else{sc.setAttributes(' id="'+ab+'"'+this.so()+this.pl()+this.vo()+this.fo()+L+' class="'+this.Wg()+'" '+this.renderAttributes()+this.bC());sc.setStyles(this.Ak()+this.xp()+this.Wm()+this.Af()+this.Dh()+this.vl()+this.Oo()+this.Dg()+this.mg()+this.Eo()+this.Ho()+this.ji());var
kc=this.bV();}return sc.paint().join(kc);};m.Oo=function(){return "overflow:"+(this.getOverflow()?this.getOverflow():"")+";";};m.bC=function(){return ' wrap="'+(this.getWrap()==1?"virtual":"off")+'"';};m.Dg=function(){var
bc=this.getEnabled()!=0?this.getBackgroundColor()||d.DEFAULTBACKGROUNDCOLOR:this.getDisabledBackgroundColor()||jsx3.gui.Form.DEFAULTDISABLEDBACKGROUNDCOLOR;return "background-color:"+bc+";";};m.k3=function(){return ' type="'+(this.getType()==0?"text":"password")+'"';};m.Rw=function(a){return this.getMaxLength()!=null?' MAXLENGTH="'+parseInt(this.getMaxLength())+'" ':"";};m.Wg=function(){var
qc=this.getClassName();return d.DEFAULTCLASSNAME+(qc?" "+qc:"");};m.getValidationType=function(){return jsx3.util.strEmpty(this.jsxvalidationtype)?"none":this.jsxvalidationtype;};m.setValidationType=function(o){this.jsxvalidationtype=o;return this;};m.getValidationExpression=function(){return jsx3.util.strEmpty(this.jsxvalidationexpression)?null:this.jsxvalidationexpression;};m.setValidationExpression=function(g){this.jsxvalidationexpression=g;return this;};m.doValidate=function(){this.setValidationState(1);var
Xb=this.getValue();var
Bc=null;if(Xb==null||jsx3.util.strTrim(Xb)==""){if(this.getRequired()==1)this.setValidationState(0);}else if(typeof Xb=="string"){var
ec=this.getValidationExpression();if(ec==null){Bc=d.rB[this.getValidationType()];}else Bc=new
RegExp(ec);this.setValidationState(Xb.search(Bc)==0?1:0);}return this.getValidationState();};m.beep=function(){jsx3.gui.po(this.getRendered(),{backgroundColor:"#FFFF66"});};d.getVersion=function(){return "3.0.00";};m.emInit=function(s){this.jsxsupermix(s);var
ob="jsxkeydown";if(!this.hasEvent(ob))this.setEvent("1;",ob);this.subscribe(ob,this,"Ss");};m.emUpdateDisplay=function(q,i){if(this.getType()==1){var
v=this.getWidth(),Jb=this.getHeight();var
ub=this.emGetSession();ub.width=v;ub.height=Jb;var
Fc=isNaN(v)?q.W:Math.min(parseInt(v),q.W);var
Rb=isNaN(Jb)?q.H:Math.min(parseInt(Jb),i.H-q.T);this.setDimensions(q.L,q.T,Fc,Rb,true);}else this.jsxsupermix(q,i);};m.emGetValue=function(){var
Bc=this.emGetSession().value;var
L=this.getValue();return Bc===null&&L===""?Bc:L;};m.Ss=function(p){var
pc=p.context.objEVENT;var
cb=false;if(!pc.hasModifier(true)){var
sb=pc.keyCode();var
yb=false;if(this.getType()==1){cb=!pc.shiftKey()&&sb==13;yb=pc.isArrowKey();}else yb=sb==37||sb==39;if(!cb&&yb){var
ac=this.getRendered(pc);var
cc=jsx3.html.getSelection(ac);var
J=ac.value;var
Ub=sb==37||sb==38;cb=Ub&&(cc.getStartIndex()>0||cc.getEndIndex()>0)||!Ub&&(cc.getStartIndex()<J.length||cc.getEndIndex()<J.length);}}if(cb)pc.cancelBubble();};});jsx3.TextBox=jsx3.gui.TextBox;
