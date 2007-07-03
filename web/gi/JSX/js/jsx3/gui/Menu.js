/*
 * Copyright (c) 2001-2007, TIBCO Software Inc.
 * Use, modification, and distribution subject to terms of license.
 */
jsx3.require("jsx3.xml.Cacheable","jsx3.gui.Form","jsx3.gui.Heavyweight","jsx3.gui.Block","jsx3.gui.ToolbarButton","jsx3.util.MessageFormat");jsx3.Class.defineClass("jsx3.gui.Menu",jsx3.gui.Block,[jsx3.xml.Cacheable,jsx3.xml.CDF,jsx3.gui.Form],function(e,i){var
uc=jsx3.gui.Event;var
R=jsx3.gui.Interactive;e.DEFAULTBACKGROUND="background-image:url("+jsx3.resolveURI("jsx:///images/menu/bg.gif")+");background-repeat:repeat-y;";e.DEFAULTBACKGROUNDCOLOR="#ffffff";e.DEFAULTXSLURL=jsx3.resolveURI("jsx:///xsl/jsxmenu.xsl");e.DEFAULTXSLCACHEID="JSX_MENU_XSL";e.DEFAULTCONTEXTLEFTOFFSET=10;e.NODATAMESSAGE="<div tabIndex ='0' class='jsx30menu_0_itemlist' onmousedown='var e = jsx3.gui.Event.wrap(event); jsx3.gui.Event.publish(e); e.cancelBubble(); e.cancelReturn();'>- no data -</div>";e.iR=new
jsx3.util.MessageFormat('<div tabIndex="0" class="{0}" onmousedown="var e = jsx3.gui.Event.wrap(event); jsx3.gui.Event.publish(e); e.cancelBubble(); e.cancelReturn();">{1}</div>');e.FS=0;e.OS=1;e.J2=12;e.lv=jsx3.resolveURI("jsx:///images/menu/submenuarrow.gif");e.Eq=jsx3.resolveURI("jsx:///images/menu/selectover.gif");e.Dx=jsx3.resolveURI("jsx:///images/menu/selected.gif");e.Ir=jsx3.resolveURI("jsx:///images/menu/down_menu.gif");e.Mr=jsx3.resolveURI("jsx:///images/menu/off_menu.gif");e.n0=jsx3.resolveURI("jsx:///images/menu/on_menu.gif");e.eT=jsx3.resolveURI("jsx:///images/menu/over_menu.gif");e.R9=jsx3.resolveURI("jsx:///images/menu/scroll_up.gif");e.gI=jsx3.resolveURI("jsx:///images/menu/scroll_down.gif");e.y4=jsx3.resolveURI("jsx:///images/tbb/down.gif");e.QH=jsx3.resolveURI("jsx:///images/tbb/on.gif");e.zE="#9B9BB7";jsx3.html.loadImages("jsx:///images/menu/bg.gif",e.Ir,e.Mr,e.n0,e.eT,e.Dx,e.Eq,e.lv,e.y4,e.QH,e.R9,e.gI);e.Iu=null;e.uz=[];e.Mz=null;e.tD=null;e.cs=null;e.qZ=250;e.GM=150;e.i8="jsx30curvisiblemenu_";e.TS=1000;e.c3=75;e.iU=12;e.EG=16;i.init=function(l,g){this.jsxsuper(l);if(g!=null)this.setText(g);};i.getImage=function(){return this.jsximage!=null&&jsx3.util.strTrim(this.jsximage)!=""?this.jsximage:null;};i.setImage=function(c){this.jsximage=c;return this;};i.getXSL=function(){return this.Mn(e.DEFAULTXSLURL);};i.disableItem=function(h){return this.enableItem(h,false);};i.enableItem=function(d,c){delete this._jsxIH;if(c||c==null)this.deleteRecordProperty(d,"jsxdisabled",false);else this.insertRecordProperty(d,"jsxdisabled","1",false);return this;};i.isItemEnabled=function(g){var
E=this.getRecordNode(g);return E!=null&&E.getAttribute("jsxdisabled")!="1";};i.selectItem=function(l,s){delete this._jsxIH;if(s||s==null){var
oc=this.getRecordNode(l);if(oc!=null){var
bb=oc.getAttribute("jsxgroupname");if(bb)for(var
xc=this.getXML().selectNodeIterator("//record[@jsxgroupname='"+bb+"']");xc.hasNext();){var
tb=xc.next();if(tb.getAttribute("jsxid")!=l)tb.removeAttribute("jsxselected");}}this.insertRecordProperty(l,"jsxselected",1,false);}else this.deleteRecordProperty(l,"jsxselected",false);return this;};i.deselectItem=function(b){return this.selectItem(b,false);};i.isItemSelected=function(k){var
D=this.getRecordNode(k);return D!=null&&D.getAttribute("jsxselected")=="1";};i.doFocus=function(p,b,n){if(b.getAttribute("jsxtype")!="Disabled"){var
pc=b.getAttribute("jsxid");var
Xb=this.es(pc);if(!Xb)this.uM(n);b.style.backgroundImage="url("+e.Eq+")";if(!Xb)b.focus();}};i.uM=function(g,k){if(e.uz.length>g&&(e.mN==null||e.mN>g)){if(e.cs)window.clearTimeout(e.cs);this.AC(g,null);e.mN=g;var
cc=this;e.cs=window.setTimeout(function(){if(cc.getParent()==null)return;e.cs=null;e.mN=null;cc.Ps(g+1,true);},k?0:e.GM);}};i.doBlur=function(l,a){if(l!=null&&l.isFakeOut(a))return;if(a.getAttribute("jsxtype")!="Disabled"&&!this.es(a.getAttribute("jsxid")))a.style.backgroundImage="url("+jsx3.gui.Block.SPACE+")";};i.es=function(o){if(this._jsxP5)return jsx3.util.arrIndexOf(this._jsxP5,o)>=0;return false;};i.AC=function(j,n){if(j<1)return;if(this._jsxP5==null)this._jsxP5=[];if(n==null){var
Z=this._jsxP5[j-1];this._jsxP5.splice(j-1,this._jsxP5.length);if(Z){var
Fb=e.uz[j-1];if(Fb!=null){var
Fc=Fb.getRendered().childNodes[0].childNodes[0].childNodes;for(var
fc=0;fc<Fc.length;fc++)if(Fc[fc].getAttribute("jsxid")==Z)this.doBlur(null,Fc[fc]);}}}else this._jsxP5.splice(j-1,this._jsxP5.length,n);};i.Rn=function(c,j){if(this.jsxsupermix(c,j))return;if(c.downArrow()&&!c.hasModifier()){this.showMenu(c,j,1);c.cancelAll();}};i.ri=function(f){if(f.spaceKey()||f.enterKey())f.cancelAll();};i.Sf=function(h,s){if(!h.leftButton())return;this.FZ(h,s);s.childNodes[2].style.backgroundImage="url("+e.Ir+")";if(this.getState()==e.OS){if(!this._jsxX2)this.Ps();}else this.showMenu(h,s,1);};i.Wh=function(k,b){if(k.isFakeOver(b))return;if(e.tD){window.clearTimeout(e.tD);e.tD=null;}this.I1(k,b);if(this.getState()==e.FS)b.childNodes[2].style.backgroundImage="url("+e.eT+")";if(e.Iu!=null&&this!=e.Iu&&e.Iu.getParent()==this.getParent()||jsx3.EventHelp.FLAG==1&&this.getCanDrop()==1)this.showMenu(k,b,1);};i.gn=function(n,h){if(n.isFakeOut(h))return;if(e.tD){window.clearTimeout(e.tD);e.tD=null;}if(this.getState()==e.FS||h!=this._jsxB_[0]){this.r6(n,h);h.childNodes[2].style.backgroundImage="url("+e.Mr+")";}};i.CQ=function(p,b){if(p.hasModifier())return;var
Cc=Number(b.getAttribute("intINDEX"));var
Jc=p.srcElement();var
_=Jc.getAttribute("jsxtype");if((p.spaceKey()||p.enterKey())&&_!="Disabled"&&typeof _!="undefined"){this.Jz(p,Jc.getAttribute("jsxid"));this.Ps();}else if(p.rightArrow()&&_=="Book"){this.showMenu(p,Jc,Cc+1,Jc.getAttribute("jsxid"));}else if(p.leftArrow()){this.Ps(Cc);}else if(p.escapeKey()){this.Ps();}else if(p.downArrow()){var
Ac=Jc;do
if(Ac==Ac.parentNode.lastChild){Ac=Ac.parentNode.firstChild;}else Ac=Ac.nextSibling;while(Ac.getAttribute("jsxdiv")!=null&&Ac!=Jc);Ac.focus();}else if(p.upArrow()){var
Ac=Jc;do
if(Ac==Ac.parentNode.firstChild){Ac=Ac.parentNode.lastChild;}else Ac=Ac.previousSibling;while(Ac.getAttribute("jsxdiv")!=null&&Ac!=Jc);Ac.focus();}else return;p.cancelAll();};i.UD=function(o,q){if(!o.leftButton()){o.cancelBubble();return;}var
w=Number(q.getAttribute("intINDEX"));var
Eb=o.srcElement();var
tb=Eb.getAttribute("jsxtype")=="Book"?Eb:Eb.parentNode;if(tb.getAttribute("jsxtype")=="Book")this.showMenu(o,tb,w+1,tb.getAttribute("jsxid"));o.cancelBubble();};i.xM=function(p,b){if(!p.leftButton())p.cancelBubble();};i.o7=function(b,k){if(e.tD){window.clearTimeout(e.tD);e.tD=null;}var
Cc=null;var
w=b.srcElement();while(w!=null&&w.getAttribute("jsxtype")==null){w=w.parentNode;if(w==k||w==k.ownerDocument)w=null;}if(w!=null&&w.getAttribute("jsxtype")=="Book"){Cc=w.getAttribute("jsxid");if(!this.es(Cc)){var
cb=k;while(cb!=null&&cb.getAttribute("intINDEX")==null)cb=cb.parentNode;var
ab=cb!=null?Number(cb.getAttribute("intINDEX")):null;if(ab!=null){var
Ab=this;b.bg();e.tD=window.setTimeout(function(){if(Ab.getParent()==null)return;e.tD=null;Ab.showMenu(b,w,ab+1,Cc);},e.qZ);}}}else{var
cb=k;while(cb!=null&&cb.getAttribute("intINDEX")==null)cb=cb.parentNode;var
gc=cb!=null?Number(cb.getAttribute("intINDEX")):null;if(gc>0)this.uM(gc);}if(Cc==null)if((w=b.srcElement()).jsxid||(w=b.srcElement().parentNode).jsxid)Cc=w.getAttribute("jsxid");if(Cc!=null)this.rG(b,Cc,w.getAttribute("jsxtype")=="Book");};i.rG=function(k,o,r){if(this.getEvent("jsxspy")){var
X=k.clientX()+jsx3.EventHelp.DEFAULTSPYLEFTOFFSET;var
eb=k.clientY()+jsx3.EventHelp.DEFAULTSPYTOPOFFSET;k.bg();var
P=this;e.ET=window.setTimeout(function(){if(P.getParent()==null)return;e.ET=null;var
nb=P.doEvent("jsxspy",{objEVENT:k,strRECORDID:o});if(nb){jsx3.gui.Interactive.hideSpy();P.showSpy(nb,X,eb);}},r?e.TS:jsx3.EventHelp.TS);}};e.F2=function(){if(e.ET){window.clearTimeout(e.ET);e.ET=null;}jsx3.gui.Interactive.hideSpy();};i.uC=function(n,r){if(e.tD){window.clearTimeout(e.tD);e.tD=null;}e.F2();};i.fM=function(o,q){if(!o.leftButton()){o.cancelBubble();return;}var
cb=o.srcElement();while(cb!=null&&!cb.getAttribute("jsxid")){cb=cb.parentNode;if(cb==q||cb==q.ownerDocument)cb=null;}if(cb!=null){var
ec=cb.getAttribute("jsxtype");if(ec!="Book"&&ec!="Disabled"){this.Jz(o,cb.getAttribute("jsxid"));this.Ps();}}};e.SM=function(m){for(var
mb=e.uz.length-1;mb>=m-1;mb--)e.uz[mb].destroy();e.uz.splice(m-1,e.uz.length);};i.Ps=function(f,l){if(f==null)f=1;if(this==e.Iu){if(e.cs)window.clearTimeout(e.cs);e.F2();this.AC(f-1,null);e.SM(f);if(f==1){this.dz(e.FS);this.doEvent("jsxhide");e.Iu=null;e.I7=false;uc.unsubscribe("mousedown",e.RT);}if(!l)try{if(this._jsxB_[f-1])this._jsxB_[f-1].focus();else if(f==1)this.focus();}catch(Kc){}this._jsxB_.splice(f-1,this._jsxB_.length);}};e.RT=function(d){if(e.Iu!=null)e.Iu.Ps();};i.showContextMenu=function(m,p,b,c){e.I7=true;this._jsxx8=p;this._jsxtU=b;this.showMenu(m,null,1,null,c);};i.getContextParent=function(){return this._jsxx8;};i.getContextRecordId=function(){return this._jsxtU;};i.showMenu=function(a,o,k,q,j){var
ac=this.doEvent("jsxmenu",{objEVENT:a,objANCHOR:o,intINDEX:k,strPARENTID:q});if(ac===false)return;if(o==null&&q!=null)o=this.getRendered(a);if(k==1){this._jsxX2=true;if(e.Iu!=null&&e.Iu!=this)e.Iu.Ps(1,true);e.Iu=this;}a.bg();jsx3.sleep(function(){this.ur(a,o,k,q,j);},"Menu.showTopMenu",this,true);if(this._jsxB_==null)this._jsxB_=[];};i.ur=function(s,g,j,r,a){this._jsxB_[j-1]=g;this.AC(j,r);var
Db=e.i8+j;var
D=this.gV(false,r,j);var
Y="jsx30menu_"+jsx3.html.getMode()+"_itemlist";var
Vb='<span intINDEX="'+j+'"'+this.cn("mouseover","o7")+this.cn("mouseout","uC")+this.cn("keydown","CQ")+this.cn("click","fM")+this.cn("mousedown","UD")+this.cn("mouseup","xM")+' class="'+Y+'" style="'+this.Dg()+this.mg()+'">'+'<span class="jsx30menu_scrollpane" style="top:0px;">'+D+"</span></span>";var
vc=e.uz[j-1];if(vc)vc.destroy();var
kb=e.uz[j-1]=new
jsx3.gui.Heavyweight(Db,this);kb.setHTML(Vb);kb.setOverflow(2);var
ob=this.getHeight();var
_b=this.getWidth();if(ob)kb.setHeight(ob);if(_b)kb.setWidth(_b);if(g&&r!=null){kb.addXRule(g,"E","W",-4);kb.addXRule(g,"W","E",8,true);kb.addYRule(g,"N","N",0);kb.addRule(null,"N",0,"Y");}else if(g){kb.addXRule(g,"W","W",0);kb.addRule(null,"W",0,"X");kb.addYRule(g,"S","N",0);kb.addYRule(g,"N","S",0,true);}else{kb.addXRule(a?a.L:s,null,"W",e.DEFAULTCONTEXTLEFTOFFSET);kb.addXRule(a?a.L:s,null,"E",-e.DEFAULTCONTEXTLEFTOFFSET,true);kb.addYRule(a?a.T:s,null,"N",e.J2);kb.addRule(null,"N",0,"Y");}if(j==1&&!e.I7)this.dz(e.OS,g);kb.setContentNodePath("0/0");kb.show();var
lb=kb.getRendered(g);var
mc=lb.childNodes[0];var
yc=mc.childNodes[0];var
I=yc.childNodes[0];var
v=yc.offsetWidth;var
Bc=yc.offsetHeight;var
K=new
jsx3.gui.Painted.Box({width:v,height:Bc,border:"1px solid black"});K.calculate();lb.style.width=v+"px";mc.style.width=2+K.Oj()+"px";if(mc.style.height=="")mc.style.height=2+K.Ae()+"px";this.X8(lb);I.focus();if(j==1){uc.subscribe("mousedown",e.RT);jsx3.sleep(function(){this._jsxX2=false;},null,this);}};i.X8=function(g){var
bc=g.childNodes[0].childNodes[0];var
wb=g.childNodes[1];var
Db=g.childNodes[2];var
ec=bc.offsetWidth,xb=parseInt(g.style.height);var
Ic=new
jsx3.gui.Painted.Box({width:ec,height:e.EG,border:"1px solid black;0px;0px;0px"});Ic.calculate();var
db=1+Ic.Ae();var
zc=e.EG-Ic.Ae();if(bc.offsetHeight>xb){if(!wb){jsx3.html.insertAdjacentHTML(g,"beforeEnd",'<span class="jsx30menu_scroll" style="top:'+zc+"px;left:1px;border-width:0px 0px 1px 0px;"+"width:"+ec+"px;height:"+db+"px;background-image:url("+e.R9+');"'+this.cn("mouseover","TD")+this.cn("mouseout","tO")+">&#160;</span>");wb=g.childNodes[1];}if(!Db){jsx3.html.insertAdjacentHTML(g,"beforeEnd",'<span class="jsx30menu_scroll" style="top:'+(xb-(1-zc)-db)+"px;left:1px;width:"+ec+"px;height:"+db+"px;background-image:url("+e.gI+');border-width:1px 0px 0px 0px;"'+this.cn("mouseover","a0")+this.cn("mouseout","tO")+">&#160;</span>");Db=g.childNodes[2];}this.jL(g);}else{if(wb)bc.removeChild(wb);if(Db)bc.removeChild(Db);}};i.jL=function(p){var
y=p.childNodes[0].childNodes[0];var
Sb=p.childNodes[1];var
Nc=p.childNodes[2];var
A=p.offsetHeight,Nb=y.offsetHeight,Ub=parseInt(y.style.top);Sb.style.visibility=Ub>=0?"hidden":"visible";Nc.style.visibility=A>=Nb+Ub?"hidden":"visible";};i.TD=function(c,j){this.r7(c,j,true);};i.a0=function(c,j){this.r7(c,j,false);};i.tO=function(j,c){window.clearInterval(this._jsxZO);};i.r7=function(n,h,p){var
x=this;this._jsxZO=window.setInterval(function(){x.z6(h.parentNode,p);},e.c3);this.uM(parseInt(h.parentNode.childNodes[0].getAttribute("intINDEX")),true);x.z6(h.parentNode,p);};i.z6=function(r,o){var
cb=r.childNodes[0].childNodes[0];var
Ac=r.offsetHeight,db=cb.offsetHeight,Cb=parseInt(cb.style.top);var
Nb=Math.min(0,Math.max(Cb+(o?1:-1)*e.iU,Ac-db));cb.style.top=Nb+"px";this.jL(r);};i.repaint=function(){this.Ps();this.clearCachedContent();return this.jsxsuper();};i.gV=function(r,o,m){if(r)this.clearCachedContent();if(this._jsxIH==null||o!=null){var
hb={};hb.jsxtabindex=this.getIndex()?this.getIndex():0;hb.jsxselectedimage=e.Dx;hb.jsxtransparentimage=jsx3.gui.Block.SPACE;hb.jsxdragtype="JSX_GENERIC";hb.jsxid=this.getId();hb.jsxsubmenuimage=e.lv;hb.jsxmode=jsx3.html.getMode();hb.jsxpath=jsx3.getEnv("jsxabspath");hb.jsxpathapps=jsx3.getEnv("jsxhomepath");hb.jsxpathprefix=this.getUriResolver().getUriPrefix();hb.jsxkeycodes=this.YZ(o);if(o!=null)hb.jsxrootid=o;if(m!=null)hb.jsxindex=m;var
jc=this.getXSLParams();for(var tc in jc)hb[tc]=jc[tc];var
xc=this.doTransform(hb);if(!jsx3.xml.Template.supports(1))xc=jsx3.html.removeOutputEscapingSpan(xc);xc=this.yp(xc);if(jsx3.util.strTrim(xc)==""){var
D="jsx30menu_"+jsx3.html.getMode()+"_itemlist";xc=e.iR.format(D,this.wj("jsx3.gui.Menu.noData"));}if(o==null){this._jsxIH=xc;}else return xc;}return this._jsxIH;};i.YZ=function(o){if(this._jsxVZ==null)return "";var
hb=[];for(var U in this._jsxVZ)hb[hb.length]=U+":"+this._jsxVZ[U].getFormatted();hb[hb.length]="";return hb.join("|");};i.clearCachedContent=function(){delete this._jsxIH;};i.getState=function(){return this._jsxBB!=null?this._jsxBB:e.FS;};i.dz=function(g,o){if(o==null)o=this.getRendered(o);if(o!=null)if(g==e.OS){if(e.Mz==this)return this;if(e.Mz!=null)e.Mz.dz(e.FS);o.style.backgroundImage="url("+e.QH+")";o.childNodes[3].style.backgroundColor=e.zE;o.childNodes[2].style.backgroundImage="url("+e.n0+")";e.Mz=this;}else{o.style.backgroundImage="";o.childNodes[3].style.backgroundColor="";o.childNodes[2].style.backgroundImage="url("+e.Mr+")";if(e.Mz==this)e.Mz=null;}this._jsxBB=g;return this;};i.Jv=function(){if(this._jsxVZ!=null)for(var Y in this._jsxVZ)this._jsxVZ[Y].destroy();this._jsxVZ={};var
Ob=this.getId();var
rb=this.getXML();if(rb!=null)for(var
db=rb.selectNodeIterator("//record[@jsxkeycode]");db.hasNext();){var
rc=db.next();var
Sb=rc.getAttribute("jsxkeycode").toLowerCase();var
xc=rc.getAttribute("jsxid");var
_=jsx3.makeCallback(function(f,p){this.Nw(p[0],f);},this,xc);this._jsxVZ[xc]=this.doKeyBinding(_,Sb);}};i.Nw=function(f,a){var
tb=this.getRecordNode(a);if(tb==null)return;var
fb=tb.getParent();var
N=fb!=null&&fb.getNodeName()=="record"?fb.getAttribute("jsxid"):null;var
ub=this.doEvent("jsxmenu",{objEVENT:f,objANCHOR:null,intINDEX:null,strPARENTID:N});if(ub===false)return;if(this.isItemEnabled(a))this.Jz(f,a);};e.Tk={};e.Tk["keypress"]=true;e.Tk["keydown"]=true;e.Tk["mousedown"]=true;e.Tk["mouseout"]=true;e.Tk["mouseover"]=true;e.Tk["blur"]="gn";e.Tk["focus"]="Wh";i.Vd=function(l,a,f){this.Qh(l,a,f,3);};i.zj=function(){this.applyDynamicProperties();var
jb=this.getRelativePosition()!=0;var
Hb={};Hb.height=22;if(jb){var
N=this.getMargin();Hb.margin=N!=null&&N!=""?N:"1 4 1 0";Hb.tagname="span";Hb.boxtype="relativebox";}else{var
Eb=this.getLeft();var
pc=this.getTop();Hb.left=Eb!=null&&Eb!=""?Eb:0;Hb.top=pc!=null&&pc!=""?pc:0;Hb.tagname="div";Hb.boxtype="box";}if(this.getDivider()==1){Hb.padding="0 0 0 4";Hb.border="0px;0px;0px;solid 1px "+e.zE;}var
dc=new
jsx3.gui.Painted.Box(Hb);Hb={};Hb.width=this.getImage()!=null&&this.getImage()!=""?22:3;Hb.height=22;Hb.tagname="span";Hb.boxtype="relativebox";var
gc=new
jsx3.gui.Painted.Box(Hb);dc.Od(gc);Hb={};if(jsx3.util.strEmpty(this.getText())){Hb.width=1;}else Hb.padding="5 4 5 0";Hb.height=22;Hb.tagname="span";Hb.boxtype="relativebox";var
Gb=new
jsx3.gui.Painted.Box(Hb);dc.Od(Gb);Hb={};Hb.width=11;Hb.height=22;Hb.tagname="span";Hb.boxtype="relativebox";var
Jc=new
jsx3.gui.Painted.Box(Hb);dc.Od(Jc);Hb={};Hb.width=1;Hb.height=22;Hb.tagname="span";Hb.boxtype="relativebox";var
Gc=new
jsx3.gui.Painted.Box(Hb);dc.Od(Gc);return dc;};i.paint=function(){this.applyDynamicProperties();this.Jv();var
Nb=this;var
hc=this.getState()==e.OS?"background-image:url("+e.QH+");":"";var
Mb=this.Af();var
B=this.Dh();var
Wb=null,ec=null,sb=null;if(this.getEnabled()==1){Wb=this.qk(e.Tk,0);sb="";}else{Wb="";sb=jsx3.html.getCSSOpacity(0.4);}if(this.getImage()!=null)ec=this.getUriResolver().resolveURI(this.getImage());var
Ic=this.renderAttributes(null,true);var
yc=this.vi(true);yc.setAttributes("id='"+this.getId()+"' "+"label='"+this.getName()+"' "+this.vo()+this.fo()+Wb+" class='jsx30toolbarbutton'"+Ic);yc.setStyles(this.Nh()+hc+Mb+B+sb+this.vl()+this.ji());var
x=yc.tp(0);x.setStyles("overflow:hidden;"+(ec!=null?"background-image:url("+ec+");":""));x.setAttributes("class='jsx30toolbarbutton_img' unselectable='on'");var
G=yc.tp(1);G.setAttributes("class='jsx30toolbarbutton_lbl' unselectable='on'");var
_=this.getText();if(_!=null&&_!=""){G.setStyles(this.Eo()+this.Ak()+this.xp()+this.Wm());}else{_="&#160;";G.setStyles("overflow:hidden;");}var
_b=yc.tp(2);_b.setStyles("background-image:url("+(this.getState()==e.OS?e.n0:e.Mr)+");");_b.setAttributes("class='jsx30toolbarbutton_mnu'");var
vb=yc.tp(3);vb.setStyles("overflow:hidden;"+(this.getState()==e.OS?"background-color:"+e.zE+";":""));vb.setAttributes("class='jsx30toolbarbutton_cap'");return yc.paint().join(x.paint().join("&#160;")+G.paint().join(_)+_b.paint().join("&#160;")+vb.paint().join("&#160;"));};i.Dg=function(){return "background-color:"+(this.getBackgroundColor()?this.getBackgroundColor():e.DEFAULTBACKGROUNDCOLOR)+";";};i.mg=function(){return this.getBackground()?this.getBackground()+";":e.DEFAULTBACKGROUND;};i.Nh=function(){return this.getEnabled()==1?"cursor:pointer;":"cursor:default;";};i.executeRecord=function(m){this.Jz(this.isOldEventProtocol(),m);return this;};i.Jz=function(b,k){var
Sb=null;if((Sb=this.getRecordNode(k))!=null){this._jsxvalue=k;var
nb=Sb.getAttribute("jsxexecute");var
nc=true;var
tc={strRECORDID:k,objRECORD:Sb};if(b instanceof jsx3.gui.Event)tc.objEVENT=b;nc=jsx3.util.strEmpty(nb)?true:this.eval(nb,tc);if(nc!==false&&b)this.doEvent("jsxexecute",tc);}};i.redrawRecord=function(){delete this._jsxIH;if(this==e.Iu)this.Ps();return this;};i.getValue=function(){return this._jsxvalue;};i.doValidate=function(){return this.setValidationState(1).getValidationState();};i.beep=function(){var
Yb=this.getRendered();jsx3.gui.po(Yb.childNodes[2],{backgroundImage:"url("+e.Ir+")"});jsx3.gui.po(Yb,{backgroundImage:"url("+e.y4+")"});jsx3.gui.po(Yb.childNodes[3],{backgroundColor:"#808080"});return this;};i.onDestroy=function(q){this.jsxsuper(q);this.onDestroyCached(q);};e.getVersion=function(){return "3.0.00";};i.emGetType=function(){return jsx3.gui.Matrix.EditMask.FORMAT;};i.emInit=function(k){this.jsxsupermix(k);this.subscribe("jsxexecute",this,"CN");};i.emSetValue=function(l){};i.emGetValue=function(){return null;};i.emBeginEdit=function(r,f,h,n,p,q,d){var
A=d.childNodes[0].childNodes[0];if(A){this.jsxsupermix(r,f,h,n,p,q,d);A.focus();}else return false;};i.emPaintTemplate=function(){this.setEnabled(0);var
hc=this.paint();this.setEnabled(1);var
tb=this.paint();return this.To(tb,hc);};i.CN=function(j){var
Jc=this.emGetSession();if(Jc){Jc.td.focus();this.Ps(1,true);}};i.containsHtmlElement=function(b){var
Y=this.jsxsuper(b);if(!Y&&this==e.Iu)for(var
vc=0;vc<e.uz.length&&!Y;vc++)Y=e.uz[vc].containsHtmlElement(b);return Y;};i.getDivider=function(){return this.jsxdivider!=null?this.jsxdivider:0;};i.setDivider=function(k,d){this.jsxdivider=k;if(d)this.recalcBox(["border","padding"]);else this.fi();return this;};i.emCollapseEdit=function(q){this.Ps(1,true);};});jsx3.gui.Menu.prototype.FZ=jsx3.gui.ToolbarButton.prototype.Sf;jsx3.gui.Menu.prototype.I1=jsx3.gui.ToolbarButton.prototype.Wh;jsx3.gui.Menu.prototype.r6=jsx3.gui.ToolbarButton.prototype.gn;jsx3.Menu=jsx3.gui.Menu;
