/*
 * Copyright (c) 2001-2007, TIBCO Software Inc.
 * Use, modification, and distribution subject to terms of license.
 */
jsx3.require("jsx3.gui.Form","jsx3.gui.Block","jsx3.util.NumberFormat");jsx3.Class.defineClass("jsx3.gui.TimePicker",jsx3.gui.Block,[jsx3.gui.Form],function(f,m){var
dc=jsx3.gui.Event;var
M=jsx3.gui.Interactive;f.g4=jsx3.resolveURI("jsx:///images/jsxtimepicker/spin_up.gif");f.v_=jsx3.resolveURI("jsx:///images/jsxtimepicker/spin_down.gif");jsx3.html.loadImages(f.g4,f.v_);f.nS=new
jsx3.util.NumberFormat("00");f.VQ=new
jsx3.util.NumberFormat("000");m.jsxshowsecs=0;m.jsxshowmillis=0;m.jsx24hour=null;m.init=function(s,p,l,c){this.jsxsuper(s,p,l,0,c);this.jsxhours=0;this.jsxminutes=0;this.jsxseconds=0;this.jsxmillis=0;};m.getShowSeconds=function(){return this.jsxshowsecs!=null?this.jsxshowsecs:m.jsxshowsecs;};m.getShowMillis=function(){return this.jsxshowmillis!=null?this.jsxshowmillis:m.jsxshowmillis;};m.is24Hour=function(){return this.jsx24hour!=null?this.jsx24hour:this.wj("time.24hour");};m.setFontSize=function(p){this.jsxsuper(p);this.fi();return this;};m.setShowSeconds=function(h){this.jsxshowsecs=jsx3.Boolean.valueOf(h);this.fi();return this;};m.setShowMillis=function(l){this.jsxshowmillis=jsx3.Boolean.valueOf(l);this.fi();return this;};m.set24Hour=function(g){this.jsx24hour=g!=null?jsx3.Boolean.valueOf(g):null;this.fi();return this;};m.getHours=function(){return this.jsxhours||Number(0);};m.setHours=function(r){this.jsxhours=Math.max(0,Math.min(23,r));this.YQ();};m.getMinutes=function(){return this.jsxminutes||Number(0);};m.setMinutes=function(r){this.jsxminutes=Math.max(0,Math.min(59,r));this.YQ();};m.getSeconds=function(){return this.jsxseconds||Number(0);};m.setSeconds=function(n){this.jsxseconds=Math.max(0,Math.min(59,n));this.YQ();};m.getMilliseconds=function(){return this.jsxmillis||Number(0);};m.setMilliseconds=function(i){this.jsxmillis=Math.max(0,Math.min(999,i));this.YQ();};m.getDate=function(h){if(this.jsxhours==null&&this.jsxminutes==null)return null;if(h==null)h=new
Date();h.setHours(this.jsxhours||Number(0));h.setMinutes(this.jsxminutes||Number(0));h.setSeconds(this.jsxseconds||Number(0));h.setMilliseconds(this.jsxmillis||Number(0));return h;};m.setDate=function(a){if(a==null){this.jsxhours=this.jsxminutes=this.jsxseconds=this.jsxmillis=null;}else{this.jsxhours=a.getHours();this.jsxminutes=a.getMinutes();this.jsxseconds=a.getSeconds();this.jsxmillis=a.getMilliseconds();}this.YQ();};m.YQ=function(){var
vb=this.getRendered();if(vb!=null){var
Mb=vb.childNodes[0].childNodes;for(var
Yb=0;Yb<Mb.length;Yb++){var
B=Mb[Yb];if(B.tagName&&B.tagName.toLowerCase()=="input"&&B.getAttribute("jsxfield")){var
zc=f.xx[B.getAttribute("jsxfield")];var
Bb=zc.o1(this);B.value=Bb!=null?zc.QM(this,Bb):"";}}}};m.Vd=function(d,a,n){var
jc=this.vi(true,d);if(a){delete d.width;jc.recalculate(d,a,n);var
Rb=jc.tp(0);var
O=a.childNodes[0];Rb.recalculate({height:jc.Zh()},O,n);var
db=Rb.tp(0);db.recalculate({height:Rb.Zh()},O.childNodes[0],n);var
nb=Rb.tp(1);nb.recalculate({height:Rb.Zh()},O.childNodes[2],n);var
V=2;if(this.jsxshowsecs){V=V+2;var
Dc=Rb.tp(2);Dc.recalculate({height:Rb.Zh()},O.childNodes[V],n);if(this.jsxshowsecs&&this.jsxshowmillis){V=V+2;var
J=Rb.tp(3);J.recalculate({height:Rb.Zh()},O.childNodes[V],n);}}if(!this.is24Hour()){V=V+2;var
qc=Rb.tp(4);qc.recalculate({height:Rb.Zh()},O.childNodes[V],n);}var
P=Rb.tp(5);V++;P.recalculate({height:Rb.Zh()},O.childNodes[V],n);}};m.zj=function(e){if(this.getParent()&&(e==null||isNaN(e.parentwidth)||isNaN(e.parentheight))){e=this.getParent().Ln(this);}else if(e==null)e={};var
P=Math.round((this.getFontSize()||jsx3.gui.Block.DEFAULTFONTSIZE)*3/4);var
ec=P;var
V=P*2;var
Gc=Math.round(P*2.2);var
Dc=P*3;var
Ib=this.getRelativePosition()!=0&&(!this.getRelativePosition()||this.getRelativePosition()==1);var
ub=Ib?null:this.getLeft();var
bb=Ib?null:this.getTop();e.boxtype=Ib?"relativebox":"box";e.tagname="span";if(Ib&&this.getMargin())e.margin=this.getMargin();if(e.left==null&&ub!=null)e.left=ub;if(e.top==null&&bb!=null)e.top=bb;if(e.height==null&&this.getHeight())e.height=this.getHeight();var
Wb;if((Wb=this.getBorder())!=null&&Wb!=""){e.border=Wb;}else e.border="solid 1px #9898a5;solid 1px #d8d8e5;solid 1px #d8d8e5;solid 1px #9898a5";var
Rb;if((Rb=this.getPadding())!=null&&Rb!="")e.padding=Rb;var
Db=new
jsx3.gui.Painted.Box(e);var
Q={};Q.tagname="div";Q.boxtype="inline";Q.height=Db.Zh();var
v=new
jsx3.gui.Painted.Box(Q);Db.Od(v);var
ub=0;Q={tagname:"input[text]",empty:true,boxtype:"box",left:ub,top:0,padding:"1 1 0 0",width:V,height:v.Zh(),border:"solid 0px;solid 0px;solid 0px;solid 0px"};v.Od(new
jsx3.gui.Painted.Box(Q));ub=ub+(V+ec);Q={tagname:"input[text]",empty:true,boxtype:"box",left:ub,top:0,padding:"1 1 0 0",width:V,height:v.Zh(),border:"solid 0px;solid 0px;solid 0px;solid 0px"};v.Od(new
jsx3.gui.Painted.Box(Q));ub=ub+(V+ec);Q={tagname:"input[text]",empty:true,boxtype:"box",left:ub,top:0,padding:"1 1 0 0",width:V,height:v.Zh(),border:"solid 0px;solid 0px;solid 0px;solid 0px"};v.Od(new
jsx3.gui.Painted.Box(Q));if(this.jsxshowsecs)ub=ub+(V+ec);Q={tagname:"input[text]",empty:true,boxtype:"box",left:ub,top:0,padding:"1 1 0 0",width:Dc,height:v.Zh(),border:"solid 0px;solid 0px;solid 0px;solid 0px"};v.Od(new
jsx3.gui.Painted.Box(Q));if(this.jsxshowsecs&&this.jsxshowmillis)ub=ub+(Dc+ec);Q={tagname:"input[text]",empty:true,boxtype:"box",left:ub,top:0,padding:"1 1 0 0",width:Gc,height:v.Zh(),border:"solid 0px;solid 0px;solid 0px;solid 0px"};v.Od(new
jsx3.gui.Painted.Box(Q));if(!this.is24Hour())ub=ub+Gc;Q={tagname:"span",boxtype:"box",left:ub,top:0,padding:"0",width:12,height:v.Zh(),border:"solid 0px;solid 0px;solid 0px;solid 1px #d8d8e5"};v.Od(new
jsx3.gui.Painted.Box(Q));ub=ub+12;v.recalculate({width:ub});Db.recalculate({width:ub+Db.getBorderWidth()});return Db;};m.paint=function(){this.applyDynamicProperties();var
ob=this.getEnabled()==1?this.getBackgroundColor():this.getDisabledBackgroundColor();var
cc=this.getEnabled()==1?this.cn("keydown","VC",2)+this.cn("blur","HX",2)+this.cn("focus","P4",2)+this.cn("mousewheel","wz",2):"";cc=cc+(this.vo()+this.pl());var
lb=this.vi(true);lb.setAttributes('id="'+this.getId()+'" class="jsx30timepicker" '+'label="'+this.getName()+'" '+this.fo()+this.qk(null,0)+this.renderAttributes(null,true));lb.setStyles(this.vl()+this.Af()+this.Dh()+this.ji()+(ob!=null?"background-color:"+ob+";":""));var
hc=Math.round((this.getFontSize()||jsx3.gui.Block.DEFAULTFONTSIZE)*3/4);var
qc=this.Eo()+this.Wm()+this.Ak()+this.xp();var
qb=this.Eo()+this.Wm()+this.Ak()+this.xp()+"text-align:right;width:"+hc+"px;top:0px;height:"+lb.tp(0).tp(0).Zh()+"px;position:absolute;";var
U=this.jsxhours!=null?f.xx["hour"].QM(this,this.jsxhours):"";var
K=this.jsxminutes!=null?f.xx["minute"].QM(this,this.jsxminutes):"";var
Vb=lb.tp(0);Vb.setAttributes(' class="fields"');var
ib="";var
mb=0;var
Sb=Vb.tp(0);Sb.setAttributes(cc+' jsxfield="hour" size="2" maxlength="2" value="'+U+'"');Sb.setStyles(qc);ib=ib+Sb.paint().join("");mb=mb+Sb.Oj();var
_=Vb.tp(1);_.setAttributes(cc+' jsxfield="minute" size="2" maxlength="2" value="'+K+'"');_.setStyles(qc);ib=ib+('<div style="'+qb+"left:"+mb+'px;">'+this.wj("time.sep.hour-min")+"</div>");ib=ib+_.paint().join("");mb=mb+(_.Oj()+hc);if(this.jsxshowsecs){var
fb=this.jsxseconds!=null?f.xx["second"].QM(this,this.jsxseconds):"";var
nc=Vb.tp(2);nc.setAttributes(cc+' jsxfield="second" size="2" maxlength="2" value="'+fb+'"');nc.setStyles(qc);ib=ib+('<div style="'+qb+"left:"+mb+'px;">'+this.wj("time.sep.min-sec")+"</div>");ib=ib+nc.paint().join("");mb=mb+(nc.Oj()+hc);if(this.jsxshowmillis){var
F=this.jsxmillis!=null?f.xx["milli"].QM(this,this.jsxmillis):"";var
Ic=Vb.tp(3);Ic.setAttributes(cc+' jsxfield="milli" size="3" maxlength="3" value="'+F+'"');Ic.setStyles(qc);ib=ib+('<div style="'+qb+"left:"+mb+'px;">'+this.wj("time.sep.sec-milli")+"</div>");ib=ib+Ic.paint().join("");mb=mb+(Ic.Oj()+hc);}}if(!this.is24Hour()){var
jc=this.jsxhours!=null?this.wj("time.ampm")[this.jsxhours<12?0:1]:"";var
nb=Vb.tp(4);nb.setAttributes(cc+' jsxfield="ampm" size="2" maxlength="2" value="'+jc+'"');nb.setStyles(qc);ib=ib+('<div style="'+qb+"position:absolute;left:"+mb+'px;">'+this.wj("time.sep.ampm")+"</div>");ib=ib+nb.paint().join("");}var
bb=Vb.tp(5);var
xb=this.getEnabled()==1?"cursor:pointer;":"";bb.setAttributes(' unselectable="on" class="spinner"');var
R='<img unselectable="on" style="top:0px;left:0px;position:absolute;'+xb+'" width="11" height="8" src="'+f.g4+'"'+this.cn("click","V4",3)+this.cn("mousedown","YP",3)+"/>"+'<img unselectable="on" style="top:8px;left:0px;position:absolute;'+xb+'" width="11" height="8" src="'+f.v_+'"'+this.cn("click","U9",3)+this.cn("mousedown","YP",3)+"/>";return lb.paint().join(Vb.paint().join(ib+bb.paint().join(R)+"&#160;"));};f.xx={hour:{S0:function(e,a){if(isNaN(a))a=e.is24Hour()?-1:0;a++;a=e.is24Hour()?a%24:(a-1)%12+1;return a;},j5:function(j,o){if(isNaN(o))o=j.is24Hour()?24:13;o--;o=j.is24Hour()?jsx3.util.numMod(o,24):jsx3.util.numMod(o-1,12)+1;return o;},QM:function(q,h){if(h==null)return "";return q.is24Hour()?f.nS.format(h):(jsx3.util.numMod(h-1,12)+1).toString();},fH:function(o,j){if(j==null||j===""){o.jsxhours=null;}else if(isNaN(j)){o.jsxhours=0;}else if(o.is24Hour()||j==null){o.jsxhours=Number(j);}else{var
S=o.wj("time.ampm");var
kb=o.vZ("ampm");if(kb!=null&&kb.value!=null&&kb.value.toLowerCase()==S[1].toLowerCase())o.jsxhours=Number(j)+12;else o.jsxhours=Number(j);}},o1:function(s){if(s.is24Hour()||s.jsxhours==null){return s.jsxhours;}else return jsx3.util.numMod(s.jsxhours-1,12)+1;},dw:function(i){return i.vZ("minute");},M0:function(q){return null;},PO:function(n,d,r,e){if(!(r>=48&&r<=57)||e)return true;var
wb=d.value;jsx3.sleep(function(){if(n.getParent()==null)return;var
lb=d.value;if(wb==lb)d.value=lb=String.fromCharCode(r);var
ec=Number(d.value);if(!isNaN(ec)){if(ec>(n.is24Hour()?23:12)){d.value=String.fromCharCode(r);ec=Number(d.value);}if(ec>(n.is24Hour()?2:1))this.dw(n).focus();}},null,this);}},minute:{S0:function(q,l){if(isNaN(l))l=0;l++;return l%60;},j5:function(s,j){if(isNaN(j))j=60;j--;return jsx3.util.numMod(j,60);},QM:function(l,n){if(n==null)return "";return f.nS.format(n);},fH:function(q,l){if(isNaN(l)){q.jsxminutes=0;}else q.jsxminutes=Number(l);},o1:function(j){return j.jsxminutes;},dw:function(o){return o.vZ(o.jsxshowsecs?"second":"ampm");},M0:function(i){return i.vZ("hour");},PO:function(o,c,q,l){if(!(q>=48&&q<=57)||l)return true;var
Rb=c.value;jsx3.sleep(function(){if(o.getParent()==null)return;var
zc=c.value;if(Rb==zc)c.value=zc=String.fromCharCode(q);var
v=Number(c.value);if(!isNaN(v)){if(v>=60){c.value=String.fromCharCode(q);v=Number(c.value);}if(v>=6){var
Zb=this.dw(o);if(Zb)Zb.focus();}}},null,this);}},second:{S0:function(b,d){if(isNaN(d))d=0;d++;return d%60;},j5:function(g,r){if(isNaN(r))r=60;r--;return jsx3.util.numMod(r,60);},QM:function(i,p){if(p==null)return "";return f.nS.format(p);},fH:function(e,a){if(isNaN(a)){e.jsxseconds=0;}else e.jsxseconds=Number(a);},o1:function(c){return c.jsxseconds;},dw:function(h){return h.vZ(h.jsxshowmillis?"milli":"ampm");},M0:function(e){return e.vZ("minute");},PO:function(a,q,l,g){return f.xx["minute"].PO.call(this,a,q,l,g);}},milli:{S0:function(q,h){if(isNaN(h))h=0;h++;return h%1000;},j5:function(q,h){if(isNaN(h))h=1000;h--;return jsx3.util.numMod(h,1000);},QM:function(a,e){if(e==null)return "";return f.VQ.format(e);},fH:function(g,r){if(isNaN(r)){g.jsxmillis=0;}else g.jsxmillis=Number(r);},o1:function(o){return o.jsxmillis;},dw:function(n){return n.vZ("ampm");},M0:function(s){return s.vZ("second");},PO:function(e,k,h,c){if(!(h>=48&&h<=57)||c)return true;var
fb=k.value;jsx3.sleep(function(){if(e.getParent()==null)return;var
qc=k.value;if(fb==qc)k.value=qc=String.fromCharCode(h);var
Lc=Number(k.value);if(!isNaN(Lc))if(qc.length==3){var
Jc=this.dw(e);if(Jc)Jc.focus();}},null,this);}},ampm:{S0:function(r,g){var
qc=r.wj("time.ampm");return g!=null&&g.toLowerCase()==qc[0].toLowerCase()?qc[1]:qc[0];},j5:function(a,s){var
mb=a.wj("time.ampm");return s!=null&&s.toLowerCase()==mb[1].toLowerCase()?mb[0]:mb[1];},QM:function(j,o){return o;},fH:function(g,r){var
A=g.wj("time.ampm");var
gb=Number(g.vZ("hour").value);if(!isNaN(gb))if(r!=null&&r.toLowerCase()==A[1].toLowerCase())g.jsxhours=gb+12;else g.jsxhours=gb;},o1:function(c){return c.wj("time.ampm")[c.jsxhours<12?0:1];},dw:function(s){return null;},M0:function(e){return e.vZ(e.jsxshowsecs?e.jsxshowmillis?"milli":"second":"minute");},PO:function(a,q,l,g){var
zc=String.fromCharCode(l);var
W=a.wj("time.ampm");for(var
t=0;t<W.length;t++)if(zc==W[t].charAt(0).toUpperCase()){q.value=W[t];break;}return true;}}};m.VC=function(a,g){if(a.hasModifier(true)||a.isModifierKey())return;var
rc=g.getAttribute("jsxfield");var
wc=f.xx[rc];var
Ec=a.keyCode();if(Ec>=96&&Ec<=105)Ec=Ec+(48-96);if(Ec==38||Ec==40){var
Xb=Ec==38?"S0":"j5";var
I=wc[Xb](this,g.value);if(this.doEvent("jsxchange",{objEVENT:a,strFIELD:rc})!==false){g.value=wc.QM(this,I);wc.fH(this,I);}}else if(Ec==9||Ec==13){var
cc=a.shiftKey()?wc.M0(this):wc.dw(this);if(cc==null)return;cc.focus();}else if(Ec>=48&&Ec<=57||Ec>=65&&Ec<=90){var
wb=wc.PO(this,g,Ec,a.shiftKey());if(!wb)return;}else if(a.isArrowKey()||a.isFunctionKey()||a.escapeKey()||Ec==8||Ec==46){return;}else{}a.cancelAll();};m.HX=function(s,j){var
Lc=j.getAttribute("jsxfield");var
T=f.xx[Lc];var
gc=T.o1(this);var
pc=jsx3.util.numIsNaN(j.value)?jsx3.util.strEmpty(j.value)?null:j.value:Number(j.value);if(gc!==pc){if(this.doEvent("jsxchange",{objEVENT:s,strFIELD:Lc})!==false){T.fH(this,pc);if(pc!=null)j.value=T.QM(this,T.o1(this));}else j.value=T.QM(this,gc);}else j.value=T.QM(this,gc);var
jb=this;this._jsxs4=window.setTimeout(function(){delete jb._jsxs4;delete jb._jsxwy;},0);};m.P4=function(d,i){if(this._jsxs4){window.clearTimeout(this._jsxs4);delete this._jsxs4;}this._jsxwy=i.getAttribute("jsxfield");};m.wz=function(o,q){var
ec=o.getWheelDelta();if(ec!=0){var
fb=q.getAttribute("jsxfield");var
bb=f.xx[fb];var
Ib=ec>0?"S0":"j5";var
P=bb[Ib](this,q.value);if(this.doEvent("jsxchange",{objEVENT:o,strFIELD:fb})!==false){q.value=bb.QM(this,P);bb.fH(this,P);}o.cancelBubble();}};m.YP=function(j,c){dc.publish(j);j.cancelAll();};m.V4=function(k,b){this.GG(k,b,"S0");};m.U9=function(s,j){this.GG(s,j,"j5");};m.GG=function(h,e,n){if(this.getEnabled()!=1)return;var
yc=this._jsxwy||"hour";var
Ec=this.vZ(yc);var
hc=f.xx[yc];var
Ub=hc[n](this,Ec.value);if(this.doEvent("jsxchange",{objEVENT:h,strFIELD:yc})!==false){Ec.value=hc.QM(this,Ub);hc.fH(this,Ub);if(this._jsxwy==null)Ec.focus();}};m.vZ=function(i){var
nc=this.getRendered();if(nc!=null){var
Gc=nc.childNodes[0].childNodes;for(var
ob=0;ob<Gc.length;ob++){var
vb=Gc[ob];if(vb.getAttribute&&vb.getAttribute("jsxfield")==i)return vb;}}return null;};m.emSetValue=function(r){var
mb=this.emGetSession();var
Sb=null;if(jsx3.util.strEmpty(r)){mb.datetype="int";}else if(!isNaN(r)&&!isNaN(parseInt(r))){Sb=new
Date();Sb.setTime(parseInt(r));mb.datetype="int";}else{Sb=new
Date(r);if(isNaN(Sb)){Sb=null;}else mb.datetype="native";}mb.olddate=Sb;this.setDate(Sb);};m.emGetValue=function(){var
nc=this.emGetSession();var
Eb=this.getDate();var
qb=this.emGetSession().datetype||"";if(Eb==null)return null;switch(qb){case "native":return Eb.toString();default:return Eb.getTime().toString();}};m.emFocus=function(){var
bc=this.getRendered();if(bc)bc.childNodes[0].childNodes[0].focus();};});
