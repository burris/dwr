/*
 * Copyright (c) 2001-2007, TIBCO Software Inc.
 * Use, modification, and distribution subject to terms of license.
 */
jsx3.require("jsx3.gui.Form","jsx3.gui.Heavyweight","jsx3.gui.Block","jsx3.util.DateFormat");jsx3.Class.defineClass("jsx3.gui.DatePicker",jsx3.gui.Block,[jsx3.gui.Form],function(f,g){var
x=jsx3.gui.Event;var
Dc=jsx3.gui.Interactive;var
v=jsx3.util.DateFormat;f.DEFAULT_FORMAT="M/d/yyyy";f.DEFAULT_WEEK_START=0;f.h0=jsx3.resolveURI("jsx:///images/jsxdatepicker/next.gif");f.cI=jsx3.resolveURI("jsx:///images/jsxdatepicker/previous.gif");f.w2=jsx3.resolveURI("jsx:///images/jsxdatepicker/open.gif");jsx3.html.loadImages(f.h0,f.cI,f.w2);g.jsxformat=null;g.jsxfirstweekday=null;g._jsxmD=null;g._jsxV2=null;g._jsxkr=false;g._jsxVM=null;g.init=function(c,s,o,q,e){this.jsxsuper(c,s,o,q,e);this.jsxyear=1970;this.jsxmonth=0;this.jsxdate=1;};g.focusCalendar=function(){this.DH();};g.DA=function(){var
Bc=this.LM(true);this.EE();Bc.show();var
cc=this.doEvent("jsxshow");if(cc&&typeof cc=="object"&&typeof cc.objDATE!="undefined"){var
Nc=cc.objDATE;this._jsxmD=Nc.getFullYear();this._jsxV2=Nc.getMonth();this.EE();}var
tb=Bc.getRendered();tb.childNodes[0].focus();this._jsxkr=true;x.subscribeLoseFocus(this,tb,"h7");};g.h7=function(a,k){var
Ub=this.LM();if(Ub!=null){Ub.destroy();this.doEvent("jsxhide");x.unsubscribeLoseFocus(this);}this._jsxkr=false;if(k){var
xb=this.aQ();if(xb)xb.focus();}};g.getFormat=function(){return this.jsxformat!=null?this.jsxformat:0;};g.setFormat=function(s){this.jsxformat=s;delete this._jsxVM;};g.Xz=function(){if(this._jsxVM==null||!this._jsxVM.getLocale().equals(this.Ni()))try{var
Lb=this.getFormat();if(typeof Lb=="number")this._jsxVM=v.getDateInstance(Lb,this.Ni());else this._jsxVM=new
v(Lb,this.Ni());}catch(Kc){jsx3.util.Logger.getLogger("jsx3.gui").warn(jsx3._msg("gui.dp.fmt",this.getFormat(),this),jsx3.NativeError.wrap(Kc));this._jsxVM=v.getDateInstance(null,this.Ni());}return this._jsxVM;};g.getFirstDayOfWeek=function(){return this.jsxfirstweekday!=null?this.jsxfirstweekday:this.wj("date.firstWeekDay");};g.setFirstDayOfWeek=function(e){if(e>=0&&e<=6){this.jsxfirstweekday=e;}else throw new
jsx3.IllegalArgumentException("jsxfirstweekday",e);};g.getDate=function(){if(this.jsxyear!=null)return new
Date(this.jsxyear,this.jsxmonth,this.jsxdate);else return null;};g.aS=function(){var
gc=this.getDate();if(gc!=null){return this.Xz().format(gc);}else{var
X=this.getFormat();if(typeof X=="number")return v.getDateInstance(X,this.Ni());else return this.getFormat();}};g.getValue=function(){var
_b=this.aQ();return _b!=null?_b.value:null;};g.setDate=function(s){if(s!=null){this.jsxyear=s.getFullYear();this.jsxmonth=s.getMonth();this.jsxdate=s.getDate();}else this.jsxyear=this.jsxmonth=this.jsxdate=null;var
zb=this.aQ();if(zb!=null)zb.value=this.aS();};g.QG=function(k){var
O=new
Date(this._jsxmD+k,this._jsxV2,1);this._jsxmD=O.getFullYear();this._jsxV2=O.getMonth();this.EE();this.v1(true,k>0);};g._K=function(r){var
tc=new
Date(this._jsxmD,this._jsxV2+r,1);this._jsxmD=tc.getFullYear();this._jsxV2=tc.getMonth();this.EE();this.v1(false,r>0);};g.v1=function(a,d){var
bc=this.LM();if(bc!=null){var
vc=bc.getRendered();if(vc!=null){var
gb=jsx3.html.getElementById(vc,this.getId()+"_"+(d?"u":"d")+(a?"y":"m"),true);gb.focus();}}};g.a7=function(h,e){var
mc=e.id.substring(e.id.lastIndexOf("_")+1).split("-");var
Mc=this.getDate();var
Mb=new
Date(mc[0],mc[1],mc[2]);if(Mc==null||Mb.getTime()!=Mc.getTime())if(this.doEvent("jsxchange",{objEVENT:h,oldDATE:Mc,newDATE:Mb})!==false){this.setDate(Mb);this.EE();var
Sb=this.aQ();Sb.value=this.aS();}this.h7(null,true);};g.EE=function(){var
A=this.LM();if(A!=null)A.setHTML(this.PU(this._jsxmD,this._jsxV2),true);};g.DH=function(n,r){if(this._jsxkr)return;if(this.getEnabled()!=1)return;var
Cb=this.getDate();if(this.jsxyear!=null){this._jsxmD=this.jsxyear;this._jsxV2=this.jsxmonth;}else{Cb=new
Date();this._jsxmD=Cb.getFullYear();this._jsxV2=Cb.getMonth();}this.DA();};g.zd=function(c,j){if(j.value==""){this.setDate(null);}else{var
U=j.value;var
Zb=this.doEvent("jsxinput",{objEVENT:c,strINPUT:U});var
Q=null,Ob=true;if(Zb&&typeof Zb=="object"){if(typeof Zb.objDATE!="undefined"){Q=Zb.objDATE;Ob=false;}else if(typeof Zb.strINPUT!="undefined")U=Zb.strINPUT;}else if(Zb===false)return;if(Ob)try{Q=this.Xz().parse(U);}catch(Kc){j.value=this.aS();return;}if(this.doEvent("jsxchange",{objEVENT:c,oldDATE:this.getDate(),newDATE:Q})!==false)this.setDate(Q);}};g.ti=function(a,l){var
yc=a.getWheelDelta();if(yc!=0){var
W=this.getDate(),lb=null;if(W!=null){lb=new
Date(W.getFullYear(),W.getMonth(),W.getDate()+(yc>0?1:-1));}else{W=new
Date();lb=new
Date(W.getFullYear(),W.getMonth(),W.getDate());}if(this.doEvent("jsxchange",{objEVENT:a,oldDATE:W,newDATE:lb})!==false)this.setDate(lb);}};g.ZY=function(h,e){if(h.rightButton()){this.h7();this.jsxsupermix(h,e);}};g.Rn=function(a,l){if(!a.hasModifier()&&(a.downArrow()||a.upArrow()||a.enterKey())){this.DH(a,l);a.cancelAll();}};g.Jr=function(m,s){if(m.enterKey()||m.spaceKey())this.DH(m,s);};g._A=function(c,j){var
Tb=c.getType()=="keypress";if(!Tb&&c.escapeKey()){this.h7(null,true);}else if(!Tb&&c.enterKey()){var
S=c.srcElement();x.dispatchMouseEvent(S,"click");}else if(c.tabKey())if(c.srcElement()==j){if(c.shiftKey()){c.cancelAll();this.h7(null,true);}}else if(c.srcElement().getAttribute("tabreturn")){c.cancelAll();this.v1(true,false);}};g.focus=function(){var
y=this.aQ();if(y)y.focus();};g.aQ=function(l){if(l==null)l=this.getRendered();if(l)return l.childNodes[0].childNodes[0];};g.repaint=function(){delete this._jsxVM;return this.jsxsuper();};g.Vd=function(k,h,p){var
Nb=this.vi(true,k);if(h){var
Eb=Nb.recalculate(k,h,p);if(!Eb.w&&!Eb.h)return;var
Sb=Nb.tp(0);Sb.recalculate({width:Nb.Si(),height:Nb.Zh()},h?h.childNodes[0]:null,p);var
P=Sb.tp(0);P.recalculate({width:Sb.Si()-16,height:Sb.Zh()},h?this.aQ(h):null,p);var
ob=Sb.tp(1);ob.recalculate({left:Sb.Si()-16},h?h.childNodes[0].childNodes[1]:null,p);}};g.zj=function(l){if(this.getParent()&&(l==null||isNaN(l.parentwidth)||isNaN(l.parentheight))){l=this.getParent().Ln(this);}else if(l==null)l={};var
H=this.getRelativePosition()!=0&&(!this.getRelativePosition()||this.getRelativePosition()==1);var
_=H?null:this.getLeft();var
w=H?null:this.getTop();var
lc,oc,ec,S,U;l.boxtype=H?"relativebox":"box";l.tagname="span";if(H&&(ec=this.getMargin())!=null&&ec!="")l.margin=ec;if(l.left==null&&_!=null)l.left=_;if(l.top==null&&w!=null)l.top=w;if(l.width==null)l.width=(S=this.getWidth())!=null&&S!=""?S:100;if(l.height==null)l.height=(U=this.getHeight())!=null&&U!=""?U:18;var
qb=new
jsx3.gui.Painted.Box(l);var
A={};A.tagname="div";A.boxtype="inline";A.width=qb.Si();A.height=qb.Zh();if((lc=this.getPadding())!=null&&lc!="")A.padding=lc;if((oc=this.getBorder())!=null&&oc!="")A.border=oc;var
X=new
jsx3.gui.Painted.Box(A);qb.Od(X);A={};A.tagname="input[text]";A.empty=true;A.boxtype="box";A.left=0;A.top=0;A.width=X.Si()-16;A.height=X.Zh();A.padding="0 0 0 2";A.border="1px pseudo";var
nb=new
jsx3.gui.Painted.Box(A);X.Od(nb);A={};A.tagname="span";A.boxtype="box";A.left=X.Si()-16;A.top=0;A.width=13;A.height=18;A.padding="1 1 1 1";var
hb=new
jsx3.gui.Painted.Box(A);X.Od(hb);return qb;};g.paint=function(){this.applyDynamicProperties();var
Hb="jsx3.GO('"+this.getId()+"')";var
Bc=this.getEnabled()==1?this.getBackgroundColor():this.getDisabledBackgroundColor();var
Jb={};Jb["change"]=true;Jb["mousewheel"]=true;Jb["keydown"]="Rn";var
Z=this.qk(Jb,2);var
Mc=this.renderAttributes(null,true);var
rb=this.vi(true);rb.setAttributes('id="'+this.getId()+'" class="jsx30datepicker" '+'label="'+this.getName()+'" '+Mc);rb.setStyles(this.vl()+this.Af()+this.Dh()+this.ji());var
Gc=rb.tp(0);var
pc=Gc.tp(0);pc.setAttributes(' type="text" value="'+this.aS()+'" '+this.vo()+this.fo()+this.pl()+Z);pc.setStyles(this.Ak()+this.Eo()+this.Wm()+this.Ho()+this.xp()+(Bc!=null?"background-color:"+Bc+";":"")+(this.getBackground()!=null?this.getBackground()+";":""));var
y=Gc.tp(1);y.setAttributes(' class="open" '+this.cn("click","DH",2)+this.cn("keydown","Jr",2)+this.vo());y.setStyles("background-image:url("+f.w2+");");return rb.paint().join(Gc.paint().join(pc.paint().join("")+y.paint().join("&#160;")+"&#160;"));};g.PU=function(h,m){var
F=this.getId();var
xc="jsx3.GO('"+F+"')";var
Zb="QG";var
Hc="_K";var
Gc=this.vo();return '<span class="jsx3_dp_cal"'+Gc+' style="z-index:5000;position:absolute;left:0px;top:0px;"'+this.cn("keydown","_A")+this.cn("keypress","_A")+">"+'<table cellspacing="0" class="jsx3_dp_cal">'+'<tr class="year">'+'<td class="prev"'+Gc+' id="'+F+'_dy" onclick="'+xc+"."+Zb+'(-1);"><img src="'+f.cI+'"/></td>'+'<td class="title">'+h+"</td>"+'<td class="next"'+Gc+' id="'+F+'_uy" onclick="'+xc+"."+Zb+'(1);"><img src="'+f.h0+'"/></td>'+"</tr>"+'<tr class="month">'+'<td class="prev"'+Gc+' id="'+F+'_dm" onclick="'+xc+"."+Hc+'(-1);"><img src="'+f.cI+'"/></td>'+'<td class="title">'+this.d2(m)+"</td>"+'<td class="next"'+Gc+' id="'+F+'_um" onclick="'+xc+"."+Hc+'(1);"><img src="'+f.h0+'"/></td>'+"</tr>"+'<tr class="days"><td class="cal" colspan="3">'+this.NH(h,m)+"</td></tr></table>"+"</span>";};f.w3=function(m){var
Jc=m.getMonth();return f.AI[Jc]||((new
Date(m.getYear(),Jc,29)).getMonth()==Jc?29:28);};f.AI=[31,null,31,30,31,30,31,31,30,31,30,31];g.NH=function(l,c){var
Qb=this.getServer();var
Mc=new
Date(l,c,1);var
Lc=this.getFirstDayOfWeek();var
Tb=Mc.getDay();var
W=f.w3(Mc);var
uc=this.getId();var
cb="jsx3.GO('"+uc+"')";var
zb=[];zb.push('<table cellspacing="0" class="jsx3_dp_month">');zb.push("<tr>");for(var
Y=Lc;Y<Lc+7;Y++)zb.push("<th>"+this.Py(Y%7,Qb)+"</th>");zb.push("</tr>");var
_b=new
Date(l,c,1-(Tb-Lc+7)%7);var
z=_b.getDate();var
Eb=new
Date(l,c+1,1);var
Ub=Eb.getDate();var
Jb=new
Date();var
w=this.vo();var
S=this.cn("click","a7");var
Y=0;while(Y<=W){zb.push("<tr>");for(var
ac=0;ac<7;ac++){var
Cb=l;var
nc=c;var
wc=null;var
Ec=null;var
Fc="over";if(Y==0)if((ac+Lc)%7==Tb){Y=1;}else{Cb=_b.getFullYear();nc=_b.getMonth();Ec="prev";wc=z;z++;}if(Y>0)if(Y<=W){Ec="normal";wc=Y;Y++;}else{Cb=Eb.getFullYear();nc=Eb.getMonth();Ec="next";wc=Ub;Ub++;}var
Ob=ac==6&&Y>W;if(this.jsxyear==Cb&&this.jsxmonth==nc&&this.jsxdate==wc)Ec="selected";var
Nc=wc==Jb.getDate()&&nc==Jb.getMonth()&&Cb==Jb.getFullYear();if(Nc){Ec=Ec+" today";Fc=Fc+" today";}zb.push('<td id="'+uc+"_"+Cb+"-"+nc+"-"+wc+'"'+(Ob?' tabreturn="true"':"")+w+' class="'+Ec+"\" onmouseover=\"this.className='"+Fc+"'\" onmouseout=\"this.className='"+Ec+"'\""+S+">"+wc+"</td>");}zb.push("</tr>");}zb.push("</table>");return zb.join("");};g.Py=function(e,n){if(n==null)n=this.getServer();return this.wj("date.day.narrow")[e%7];};g.d2=function(j,q){if(q==null)q=this.getServer();return this.wj("date.month")[j%12];};g.LM=function(m){var
jb="jsxDatePicker"+this.getId();var
qc=jsx3.gui.Heavyweight.GO(jb);if(m){if(qc!=null)qc.destroy();var
X=this.aQ();qc=new
jsx3.gui.Heavyweight(jb,this);qc.addXRule(X,"E","W",0);qc.addXRule(X,"W","E",0);qc.addYRule(X,"N","N",0);qc.addYRule(X,"S","S",0);}return qc;};g.doValidate=function(){var
Bc=this.getDate()!=null||this.getRequired()==0?1:0;this.setValidationState(Bc);return Bc;};g.containsHtmlElement=function(h){var
Z=this.LM();return this.jsxsuper(h)||Z!=null&&Z.containsHtmlElement(h);};g.emSetValue=function(l){var
cc=this.emGetSession();var
Rb=null;if(jsx3.util.strEmpty(l==null)){cc.datetype="int";}else if(!isNaN(l)&&!isNaN(parseInt(l))){Rb=new
Date();Rb.setTime(parseInt(l));cc.datetype="int";}else{var
Hc=this.Xz();try{Rb=Hc.parse(l);cc.datetype="format";}catch(Kc){Rb=new
Date(l);if(isNaN(Rb)){Rb=null;}else cc.datetype="native";}}this.setDate(Rb);};g.emGetValue=function(){var
C=this.getDate();if(C==null)return null;var
wb=this.emGetSession().datetype||"";switch(wb){case "format":return this.Xz().format(C);case "native":return C.toString();default:return C.getTime().toString();}};g.emCollapseEdit=function(k){this.h7(k,false);};});jsx3.DatePicker=jsx3.gui.DatePicker;
