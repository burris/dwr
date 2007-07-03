/*
 * Copyright (c) 2001-2007, TIBCO Software Inc.
 * Use, modification, and distribution subject to terms of license.
 */
jsx3.require("jsx3.xml.Cacheable","jsx3.gui.Form","jsx3.gui.Heavyweight","jsx3.gui.Block","jsx3.util.MessageFormat");jsx3.Class.defineClass("jsx3.gui.Select",jsx3.gui.Block,[jsx3.gui.Form,jsx3.xml.Cacheable,jsx3.xml.CDF],function(i,q){var
ac=jsx3.util.Logger.getLogger(i.jsxclass.getName());var
nb=jsx3.gui.Event;i.DEFAULTBACKGROUNDCOLOR="#ffffff";i.DEFAULTTEXT="- Select -";i.DEFAULTXSLURL=jsx3.resolveURI("jsx:///xsl/jsxselect.xsl");i.SELECTXSLURL=i.DEFAULTXSLURL;i.SELECTXSLID="JSX_SELECT_XSL";i.COMBOXSLURL=i.DEFAULTXSLURL;i.COMBOXSLID="JSX_COMBO_XSL";i.ARROWICON=jsx3.resolveURI("jsx:///images/select/arrow.gif");i.OVERIMAGE=jsx3.resolveURI("jsx:///images/select/selectover.gif");i.SELECTEDIMAGE=jsx3.resolveURI("jsx:///images/select/selected.gif");jsx3.html.loadImages(i.ARROWICON,i.OVERIMAGE,i.SELECTEDIMAGE);i.NODATAMESSAGE="<div tabIndex='0' class='jsx30select_option' onmousedown='var e = jsx3.gui.Event.wrap(event); jsx3.gui.Event.publish(e); e.cancelBubble();'>- data unavailable -</div>";i.NOMATCHMESSAGE="<div tabIndex='0' class='jsx30select_option' onmousedown='var e = jsx3.gui.Event.wrap(event); jsx3.gui.Event.publish(e); e.cancelBubble();'>- no match found -</div>";i.H2=new
jsx3.util.MessageFormat('<div tabIndex="0" class="jsx30select_option jsx30select_none" onmousedown="var e=jsx3.gui.Event.wrap(event); jsx3.gui.Event.publish(e); e.cancelBubble();"><span style="left:0px;">{0}</span></div>');i.TYPESELECT=0;i.TYPECOMBO=1;i.TYPEAHEADDELAY=250;i.lN=null;i.uW=null;i.rv="jsx30curvisibleoptions";i.DEFAULTCLASSNAME="jsx30select_select";q.init=function(j,o,r,h,e,p){this.jsxsuper(j,o,r,h,e);if(p!=null)this.jsxvalue=p;};q.getXSL=function(){return this.Mn(i.DEFAULTXSLURL);};q.doValidate=function(){var
Q=jsx3.gui.Form;var
ic=this.getRequired()==0;if(!ic){var
Ic=this.getValue();if(this.getType()==0){ic=this.getRecordNode(Ic)!=null;}else ic=Ic!=null&&Ic.length>0;}this.setValidationState(ic?1:0);return this.getValidationState();};q.Dg=function(){var
uc=this.getEnabled()!=0?this.getBackgroundColor()||i.DEFAULTBACKGROUNDCOLOR:this.getDisabledBackgroundColor()||jsx3.gui.Form.DEFAULTDISABLEDBACKGROUNDCOLOR;return "background-color:"+uc+";";};q.getType=function(){return this.jsxtype==null?0:this.jsxtype;};q.setType=function(c){this.jsxtype=c;return this;};q.getDefaultText=function(){return this.jsxdefaulttext!=null&&this.jsxdefaulttext!=null?this.jsxdefaulttext:this.wj("jsx3.gui.Select.defaultText");};q.setDefaultText=function(l){this.jsxdefaulttext=l;return this;};q.yx=function(e,h){if(this.Rn(e,h))return;var
dc=e.srcElement();var
Zb=dc.getAttribute("jsxtype");var
ib=e.hasModifier();if((e.spaceKey()||e.enterKey())&&dc.getAttribute("jsxid")!=null){this.JB(e,dc.getAttribute("jsxid"));this.hide(true);}else if(Zb=="Display"||Zb=="Text"||Zb=="Select"){if(e.downArrow()&&!ib){this.Kp();}else return;}else if(e.leftArrow()||e.escapeKey()){this.hide(true);}else if(e.downArrow()){if(ib)return;if(dc==dc.parentNode.lastChild){i.doFocus(dc.parentNode.firstChild.nextSibling);}else i.doFocus(dc.nextSibling);}else if(e.upArrow()){if(ib)return;if(dc==dc.parentNode.firstChild.nextSibling){i.doFocus(dc.parentNode.lastChild);}else i.doFocus(dc.previousSibling);}else if(e.tabKey()){if(e.hasModifier(true))return;this.JB(e,dc.getAttribute("jsxid"));jsx3.html[e.shiftKey()?"focusPrevious":"focusNext"](this.getRendered(e),e);this.hide(false);return;}else return;e.cancelAll();};q.sL=function(h,e){if(this.Rn(h,e))return;var
I=h.hasModifier();if(!I&&(h.downArrow()||h.enterKey())){var
fb=jsx3.gui.Heavyweight.GO(i.rv);if(!h.enterKey()&&fb!=null&&fb.getRendered(h).childNodes[0].getAttribute("jsxselid")==this.getId()){i.doFocus(fb.getRendered(h).childNodes[0].childNodes[1]);}else{var
cb=h.enterKey()?"":this.getText();this.Kp(cb);}h.cancelAll();}else if(!I&&h.tabKey()){var
fb=jsx3.gui.Heavyweight.GO(i.rv);if(fb!=null&&fb.getRendered(h).childNodes[0].getAttribute("jsxselid")==this.getId()){var
ab=fb.getRendered(h).childNodes[0].childNodes[1];if(ab){var
N=ab.getAttribute("jsxid");if(N!=null)this.JB(h,N);}this.hide(true);h.cancelAll();}}else if(h.tabKey()&&h.shiftKey()&&!h.hasModifier(true)){jsx3.html.focusPrevious(this.getRendered(h),h);}else if(!I&&(h.rightArrow()||h.leftArrow())){var
xb=h.leftArrow();var
cc=this.EH();var
zb=cc.value;var
Zb=jsx3.html.getSelection(cc);if(xb&&(Zb.getStartIndex()>0||Zb.getEndIndex()>0)||!xb&&(Zb.getStartIndex()<zb.length||Zb.getEndIndex()<zb.length))h.cancelBubble();}else{var
eb=this.EH();var
B=eb.value;jsx3.sleep(function(){if(this.getParent()==null)return;var
sc=eb.value;if(B!=sc){this.jsxvalue=sc;if(i.uW)window.clearTimeout(i.uW);var
Ic=this;i.uW=window.setTimeout(function(){if(Ic.getParent()==null)return;i.uW=null;Ic.Kp(sc);},i.TYPEAHEADDELAY);}},null,this);}};q.CQ=function(j,c){this.yx(j,c);};q.EH=function(a){a=this.getRendered(a);return a?this.getType()==1?a.childNodes[0].childNodes[0].childNodes[0]:a.childNodes[0].childNodes[0]:null;};q.show=function(){var
ab=this.getRendered();if(ab)this.Kp();};q.fM=function(o,m){var
Nb=o.srcElement();while(Nb!=null&&(!Nb.getAttribute||Nb.getAttribute("jsxid")==null)){Nb=Nb.parentNode;if(Nb==m)Nb=null;}if(Nb!=null)this.JB(o,Nb.getAttribute("jsxid"));this.hide(true);};i.doFocus=function(h){var
fc=h.getAttribute("jsxid");if(fc!=null){h.focus();h.style.backgroundImage="url("+i.OVERIMAGE+")";}};i.doBlur=function(h){h.style.backgroundImage="url("+jsx3.gui.Block.SPACE+")";};q.yX=function(s,d){var
Mc=d.value;var
nc=this.getXML().selectSingleNode('//record[@jsxtext="'+Mc.replace(/\"/g,"&quot")+'" or (not(@jsxtext) and @jsxid="'+Mc.replace(/\"/g,"&quot")+'")]');if(nc!=null){this.JB(s,nc.getAttribute("jsxid"));}else this.jsxvalue=Mc;};q.hide=function(n){if(i.lN==this){var
pc=jsx3.gui.Heavyweight.GO(i.rv);if(pc)pc.destroy();if(n)try{this.focus();}catch(Kc){}nb.unsubscribeLoseFocus(this);i.lN=null;}if(i.uW){i.uW=null;window.clearTimeout(i.uW);}};i.hideOptions=function(){if(i.lN!=null)i.lN.hide();};q.Kp=function(l){if(this._jsxopening)return;var
dc=this.getRendered();if(dc!=null){var
Lc=this.getType();var
Mb=dc.ownerDocument;if(i.lN!=null)i.lN.hide(false);i.lN=this;var
X=this.getAbsolutePosition(Mb.getElementsByTagName("body")[0]);var
Gc=X.W;var
W=this.getType()==1;var
y={};y.jsxtabindex=this.getIndex()?this.getIndex():0;y.jsxselectedimage=i.SELECTEDIMAGE;y.jsxtransparentimage=jsx3.gui.Block.SPACE;y.jsxdragtype="JSX_GENERIC";y.jsxid=this.getId();y.jsxselectedid=this.getValue()==null?"null":this.getValue();y.jsxpath=jsx3.getEnv("jsxabspath");y.jsxpathapps=jsx3.getEnv("jsxhomepath");y.jsxpathprefix=this.getUriResolver().getUriPrefix();if(W){y.jsxsortpath="jsxtext";y.jsx_type="combo";}if(l!=null)y.jsxtext=l;var
ub=this.getXSLParams();for(var Nb in ub)y[Nb]=ub[Nb];var
x=this.doTransform(y);if(!jsx3.xml.Template.supports(1))x=jsx3.html.removeOutputEscapingSpan(x);x=this.yp(x);if(!x.match(/\<div/i))x=i.H2.format(this.wj("jsx3.gui.Select."+(Lc==0?"dataUnavailable":"noMatch")));var
Jc='<div style="height:1px;width:'+(Gc-4)+"px;position:relative;left:0px;top:0px;"+'padding:0px;margin:0px 0px -1px 0px;overflow:hidden;">&#160;</div>';var
bb='<div jsxselid="'+this.getId()+'"'+this.cn("keydown","CQ")+this.cn("click","fM")+this.cn("mousedown","UD")+' jsxtype="Options" class="jsx30select_optionlist" style="'+this.Dg()+"min-width:"+(Gc-4)+"px;"+this.Ak()+this.xp()+this.Wm()+this.Ho()+'">'+Jc+x+"</div>";var
jc=new
jsx3.gui.Heavyweight(i.rv,this);jc.setHTML(bb);jc.addXRule(dc,"W","W",-2);jc.addXRule(dc,"E","E",-6);jc.addYRule(dc,"S","N",0);jc.addYRule(dc,"N","S",0);jc.show();if(Lc==0||l==null){this._jsxopening=true;jsx3.sleep(function(){if(this.getParent()==null)return;delete this._jsxopening;try{i.doFocus(jc.getRendered(dc).childNodes[0].childNodes[1]);}catch(Kc){ac.info("Error focusing first object: "+jsx3.NativeError.wrap(Kc));}},null,this);}else this.EH().focus();nb.subscribeLoseFocus(this,dc,"LR");}};q.LR=function(h){var
Ob=h.event.srcElement();if(!this.containsHtmlElement(Ob))this.hide(false);};q.Vd=function(l,e,f){var
ob=this.vi(true,l);if(e){var
K=ob.recalculate(l,e,f);if(!K.w&&!K.h)return;var
w=ob.tp(0);w.recalculate({parentwidth:ob.Si(),parentheight:ob.Zh()},e?e.childNodes[0]:null,f);var
kb=w.tp(0);if(this.getType()!=0){var
cc=kb.tp(0);cc.recalculate({parentwidth:w.Si()-1,parentheight:w.Zh()},e?jsx3.html.selectSingleElm(e,0,0,0):null,f);}else kb.recalculate({parentwidth:w.Si(),parentheight:w.Zh()},e?e.childNodes[0].childNodes[0]:null,f);}};q.zj=function(c){if(this.getParent()&&(c==null||isNaN(c.parentwidth)||isNaN(c.parentheight))){c=this.getParent().Ln(this);}else if(c==null)c={};var
Bb=this.getRelativePosition()!=0&&(!this.getRelativePosition()||this.getRelativePosition()==1);var
x,fc,t,w,Lc;c.tagname="span";c.border=(x=this.getBorder())!=null&&x!=""?x:"solid 1px #a6a6af;solid 1px #e6e6e6;solid 1px #e6e6e6;solid 1px #a6a6af";c.margin=Bb&&(fc=this.getMargin())!=null&&fc!=""?fc:null;if(c.boxtype==null)c.boxtype=Bb?"relativebox":"box";if(c.left==null)c.left=!Bb&&!jsx3.util.strEmpty(this.getLeft())?this.getLeft():0;if(c.top==null)c.top=!Bb&&!jsx3.util.strEmpty(this.getTop())?this.getTop():0;if(c.width==null)c.width=(w=this.getWidth())!=null?w:100;if(c.height==null)c.height=(Lc=this.getHeight())!=null?Lc:18;c.padding="0 0 0 0";var
uc=new
jsx3.gui.Painted.Box(c);var
Cb={};Cb.tagname="div";Cb.boxtype="relativebox";if((t=this.getPadding())!=null&&t!=""){Cb.padding=t;}else Cb.padding="0 19 0 0";Cb.parentwidth=uc.Si();Cb.parentheight=uc.Zh();Cb.left=0;Cb.top=0;Cb.width="100%";Cb.height="100%";var
Fc=new
jsx3.gui.Painted.Box(Cb);uc.Od(Fc);if(this.getType()==0){Cb={};Cb.tagname="div";Cb.boxtype="relativebox";Cb.padding="2 0 0 3";Cb.parentwidth=Fc.Si();Cb.parentheight=Fc.Zh();Cb.width="100%";Cb.height="100%";var
ub=new
jsx3.gui.Painted.Box(Cb);Fc.Od(ub);}else{Cb={};Cb.tagname="div";Cb.boxtype="inline";var
ub=new
jsx3.gui.Painted.Box(Cb);Fc.Od(ub);Cb={};Cb.tagname="input[text]";Cb.boxtype="relativebox";Cb.parentwidth=Fc.Si()-1;Cb.parentheight=Fc.Zh();Cb.width="100%";Cb.height="100%";Cb.padding="0 0 0 4";Cb.empty=true;Cb.border="solid 0px;solid 1px #c8c8d5;solid 0px;solid 0px";var
D=new
jsx3.gui.Painted.Box(Cb);ub.Od(D);}return uc;};q.paint=function(){this.applyDynamicProperties();var
Eb=this.getId();var
yc=this.getEnabled()==1;var
H={};if(yc){H["mousedown"]=true;if(this.hasEvent("jsxkeyup"))H["keyup"]=true;if(this.getType()==1){H["keydown"]="sL";H["focus"]=true;}else H["keydown"]="yx";}var
Dc=this.qk(H,0);var
Cc=this.renderAttributes(null,true);var
tb=this.vi(true);tb.setAttributes(' id="'+Eb+'"'+this.so()+' class="'+this.Wg()+'" jsxtype="Select" '+Cc+Dc+this.vo());tb.setStyles(this.Eo()+this.Dg()+"background-image:url("+i.ARROWICON+");background-repeat:no-repeat;background-position:right 0px;"+this.vl()+this.Af()+this.Dh()+this.ji());var
u=tb.tp(0);u.setAttributes(' class="jsx30select_display" jsxtype="Display" '+this.fo());u.setStyles("");if(this.getType()==0){var
vb=u.tp(0);vb.setAttributes(' jsxtype="Text" class="jsx30select_text" unselectable="on" ');vb.setStyles(this.Ak()+this.xp()+this.Wm()+this.Eo()+this.Ho());var
qc=tb.paint().join(u.paint().join(vb.paint().join(this.im())));}else{var
vb=u.tp(0);vb.setAttributes('class="jsx30combo"');var
Vb=vb.tp(0);Vb.setAttributes(this.vo()+this.paintMaxLength()+this.pl()+' class="jsx30combo_text" value="'+this.im().replace(/\"/g,"&quot")+'" jsxtype="Text" '+this.cn("blur","yX",3));Vb.setStyles(this.Ak()+this.xp()+this.Wm()+this.Eo()+this.Ho()+this.Dg());var
qc=tb.paint().join(u.paint().join(vb.paint().join(Vb.paint().join(""))));}return qc;};q.Sf=function(j,c){if(!j.leftButton())return;if(j.srcElement().tagName.toLowerCase()!="input")this.Kp();};q.Uo=function(j,c){this.EH(c).focus();};q.UD=function(l,a){l.cancelBubble();};q.setText=function(n){this.t2(n);return this;};q.t2=function(b){var
ec;if(ec=this.EH())ec[this.getType()==1?"value":"innerHTML"]=b;};q.focus=function(){var
Ob=this.getType()==1?this.EH():this.getRendered();if(Ob)Ob.focus();return Ob;};q.setValue=function(l){this.JB(this.isOldEventProtocol(),l);return this;};q.JB=function(k,o){if(o!=this.getValue()){var
Xb=true;if(k instanceof nb)Xb=this.doEvent("jsxbeforeselect",{objEVENT:k,strRECORDID:o});if(Xb===false)return;this.jsxvalue=o;this.redrawRecord(o,2);if(k)this.doEvent("jsxselect",{objEVENT:k instanceof nb?k:null,strRECORDID:o});}};q.getValue=function(){return this.jsxvalue;};q.getText=function(){var
U=this.getRecordNode(this.getValue());if(U!=null){var
zc=U.getAttribute("jsxtext");return zc!=null?zc:U.getAttribute("jsxid");}else return this.getType()==1||this.getValue()!=null?this.getValue():this.getDefaultText();};q.redrawRecord=function(m,e){if(this.getValue()==m){var
z=this.getRecordNode(m);if(z!=null){var
cc=z.getAttribute("jsxtext");this.t2(cc!=null?cc:z.getAttribute("jsxid"));}else this.t2(this.getType()==0?this.getDefaultText():m!=null?m:"");}return this;};q.onDestroy=function(r){this.jsxsuper(r);this.onDestroyCached(r);};i.getVersion=function(){return "3.0.00";};q.containsHtmlElement=function(l){var
bb=jsx3.gui.Heavyweight.GO(i.rv);return this.jsxsuper(l)||bb!=null&&bb.containsHtmlElement(l);};q.getMaxLength=function(){return this.jsxmaxlength!=null?this.jsxmaxlength:null;};q.setMaxLength=function(p){p=parseInt(p);this.jsxmaxlength=p>0?p:null;return this;};q.paintMaxLength=function(o){return this.getMaxLength()!=null?' maxlength="'+this.getMaxLength()+'" ':"";};q.Wg=function(){var
Mb=this.getClassName();return i.DEFAULTCLASSNAME+(Mb?" "+Mb:"");};q.emInit=function(a){this.jsxsupermix(a);this.subscribe("jsxselect",this,"H7");};q.emCollapseEdit=function(b){this.hide(false);};q.H7=function(k){this.commitEditMask(k.context.objEVENT,true);};});jsx3.Select=jsx3.gui.Select;
