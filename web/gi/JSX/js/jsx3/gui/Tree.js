/*
 * Copyright (c) 2001-2007, TIBCO Software Inc.
 * Use, modification, and distribution subject to terms of license.
 */
jsx3.require("jsx3.xml.Cacheable","jsx3.gui.Form","jsx3.gui.Block");jsx3.Class.defineClass("jsx3.gui.Tree",jsx3.gui.Block,[jsx3.gui.Form,jsx3.xml.Cacheable,jsx3.xml.CDF],function(h,d){var
Ob=jsx3.gui.Event;var
Ib=jsx3.gui.Interactive;h.DEFAULTXSLID="JSX_TREE_XSL";h.DEFAULTXSLURL=jsx3.resolveURI("jsx:///xsl/jsxtree.xsl");h.ICONMINUS="jsx:///images/tree/minus.gif";h.ICONPLUS="jsx:///images/tree/plus.gif";h.ICON="jsx:///images/tree/file.gif";h.SELECTEDIMAGE=jsx3.resolveURI("jsx:///images/tree/select.gif");h.INSERT_BEFORE_IMG=jsx3.resolveURI("jsx:///images/matrix/insert_before.gif");h.APPEND_IMG=jsx3.resolveURI("jsx:///images/matrix/append.gif");h.ONDROPBGIMAGE="url("+jsx3.resolveURI("jsx:///images/tree/over.gif")+")";jsx3.html.loadImages(h.ICONMINUS,h.ICONPLUS,h.ICON,h.SELECTEDIMAGE,"jsx:///images/tree/over.gif",h.INSERT_BEFORE_IMG,h.APPEND_IMG);h.BORDERCOLOR="#8CAEDF";h.DEFAULTBACKGROUNDCOLOR="#ffffff";h.DEFAULTNODATAMSG="&#160;";h.x1=null;h.q8=500;h.x7=null;h.oz=250;h.CU=null;h.MULTI=1;h.SINGLE=0;d.init=function(m,i){this.jsxsuper(m);if(i!=null)this.insertRecordProperty(i,"jsxselected","1",false);};d.onAfterAttach=function(){if(this.jsxvalue!=null&&this.jsxvalue!=""&&this.jsxvalue!="null")this.setValue(this.jsxvalue);this.jsxsuper();};d.getXSL=function(){return this.Mn(h.DEFAULTXSLURL);};d.doValidate=function(){var
ac=this.H5();var
N=ac.length>0||this.getRequired()==0;this.setValidationState(N?1:0);return this.getValidationState();};d.Dg=function(){return "background-color:"+(this.getBackgroundColor()?this.getBackgroundColor():h.DEFAULTBACKGROUNDCOLOR)+";";};d.setValue=function(n,j){var
ib=this.getValue();var
wc=this.getMultiSelect()==1;var
lc=false;lc=this.isOldEventProtocol();if(n instanceof Array){if(!wc)throw new
jsx3.IllegalArgumentException("strRecordId",n);}else if(wc)n=[n];if(wc){this.x6();for(var
eb=0;eb<n.length;eb++){var
lb=n[eb];if(lb!=null&&!this.Ih(lb))continue;this.NE(lb);}if(j&&n.length>0)this.revealRecord(n[0]);if(lc)this.doEvent("jsxselect",{strRECORDID:n[0],strRECORDIDS:n});}else{if(n!=null&&!this.Ih(n))return this;this.x6();if(n!=null){this.NE(n);if(j)this.revealRecord(n);}if(lc)this.doEvent("jsxselect",{strRECORDID:n,strRECORDIDS:[n]});}if(lc)this.doEvent("jsxchange",{objEVENT:null,preVALUE:ib});return this;};d.aG=function(j,p,k,n,s){var
cc=this.getValue();var
zc=this.getMultiSelect()==1;if(zc&&k){if(p!=null&&!this.Ih(p))return;var
z=false;if(this.Dq(p)){if(n)this.PF(p);}else{this.NE(p);z=true;}if(z&&!s)this.doEvent("jsxselect",{objEVENT:j,strRECORDID:p,strRECORDIDS:[p]});}else{var
jc=this.getValue()==p;if(!n&&jc&&!k)return;this.x6();if(p!=null&&!this.Ih(p))p=null;if(p!=null)if(jc)this.PF(p);else this.NE(p);if(!s){var
pb=jc?null:p;var
X=jc?[]:[pb];this.doEvent("jsxselect",{objEVENT:j,strRECORDID:pb,strRECORDIDS:X});}}if(!s)this.doEvent("jsxchange",{objEVENT:j,preVALUE:cc});};d.Pv=function(m){var
mc=typeof m=="string"?this.fz(m):m;if(mc!=null&&mc.getAttribute){m=mc.getAttribute("jsxid");if(m)try{mc.childNodes[0].childNodes[2].focus();this.PV(mc.getAttribute("jsxid"));}catch(Kc){}}else this.PV(null);};d.PV=function(e){if(e!=null){if(this._jsxf3==null)if(this.getMultiSelect()==1)Ob.subscribeLoseFocus(this,this.getRendered(),"VW");this._jsxf3=e;}else{if(this._jsxf3!=null)Ob.unsubscribeLoseFocus(this);this._jsxf3=null;}};d.VW=function(i){Ob.unsubscribeLoseFocus(this);this._jsxf3=null;};d.o2=function(n){var
eb=this.fz(n);if(eb!=null){var
gb=jsx3.html.selectSingleElm(eb,0,2);gb.style.backgroundImage="url("+h.SELECTEDIMAGE+")";gb.style.borderRight="solid 1px "+h.BORDERCOLOR;}};d.J0=function(c){var
ub=this.fz(c);if(ub!=null){var
Sb=jsx3.html.selectSingleElm(ub,0,2);Sb.style.backgroundImage="";Sb.style.borderRight="";}};d.x6=function(){for(var
Gc=this.Wx();Gc.hasNext();){var
H=Gc.next();H.removeAttribute("jsxselected");this.J0(H.getAttribute("jsxid"));}};d.PF=function(p){this.deleteRecordProperty(p,"jsxselected",false);this.J0(p);};d.NE=function(e){this.insertRecordProperty(e,"jsxselected","1",false);this.o2(e);};d.Wx=function(){return this.getXML().selectNodeIterator("//record[@jsxselected='1']");};d.H5=function(){var
tc=this.Wx();var
Kc=[];while(tc.hasNext()){var
gc=tc.next();Kc[Kc.length]=gc.getAttribute("jsxid");}return Kc;};d.revealRecord=function(i,j){var
Rb=this.getRecordNode(i);var
H=Rb?Rb.getParent():null;while(H!=null){this.toggleItem(H.getAttribute("jsxid"),true);H=H.getParent();}var
v=this.fz(i);if(v){var
zc=j?j.getRendered(v):this.getRendered(v);if(zc)jsx3.html.scrollIntoView(v,zc,0,10);}};d.getValue=function(){return this.getMultiSelect()==0?this.H5()[0]:this.H5();};d.getKeyListener=function(){return this.jsxkeylistener==null?1:this.jsxkeylistener;};d.setKeyListener=function(s){this.jsxkeylistener=s;return this;};d.getText=function(){var
X=this.Wx().next();return X!=null?X.getAttribute("jsxtext"):null;};d.getMultiSelect=function(){return this.jsxmultiselect==null?0:this.jsxmultiselect;};d.setMultiSelect=function(r){this.jsxmultiselect=r;return this;};d.redrawRecord=function(p,i){var
U=this.fz(p);if(i==0){if(U)if(U.parentNode.childNodes.length>1){U.parentNode.removeChild(U);}else{var
lc=U.parentNode.parentNode;var
z=lc.getAttribute("jsxid");jsx3.html.setOuterHTML(lc,this.doTransform(z));}return this;}if(U==null){var
Sb=this.getRecordNode(p);if(Sb!=null)if(this.getParent()!=null){Sb=Sb.getParent();var
z=Sb.getAttribute("jsxid");var
lc=this.fz(z);if(lc!=null)jsx3.html.setOuterHTML(lc,this.doTransform(z));}}else jsx3.html.setOuterHTML(U,this.doTransform(p));return this;};d.getRoot=function(){return this.jsxuseroot!=null?this.jsxuseroot:1;};d.setRoot=function(g){this.jsxuseroot=g;return this;};d.getIcon=function(){return this.jsxicon!=null?this.jsxicon:h.ICON;};d.setIcon=function(p){this.jsxicon=p;return this;};d.getIconMinus=function(){return this.jsxiconminus!=null?this.jsxiconminus:h.ICONMINUS;};d.setIconMinus=function(f){this.jsxiconminus=f;return this;};d.getIconPlus=function(){return this.jsxiconplus!=null?this.jsxiconplus:h.ICONPLUS;};d.setIconPlus=function(o){this.jsxiconplus=o;return this;};d.fz=function(f){var
qc=this.getDocument();return qc!=null?qc.getElementById(this.getId()+"_"+f):null;};d.Uo=function(n,r){if(r!=n.srcElement())return;var
N=this.H5()[0];if(N){this.Pv(N);}else{var
kb=this.getRendered(r).childNodes[0];if(kb!=null)this.Pv(kb);}};d.Th=function(f,g){if(!f.leftButton())return;g=f.srcElement();var
eb=this.getRendered(g);while(jsx3.util.strEmpty(g.getAttribute("jsxtype"))&&g!=eb)g=g.parentNode;if(g.getAttribute("jsxtype")!=null){if(g.getAttribute("jsxtype")=="plusminus"){this.A4(f,g.parentNode.parentNode.getAttribute("jsxid"));}else if(g.getAttribute("jsxtype")=="text"||g.getAttribute("jsxtype")=="icon"){var
oc=g.parentNode.parentNode.getAttribute("jsxid");var
Kc=this.yI();this.Pv(g.parentNode.parentNode);if(!g.parentNode)g=this.fz(oc).childNodes[0].childNodes[2];if(this.Ih(oc))if(f.shiftKey()&&this.getMultiSelect()==1){if(Kc){this.revealRecord(Kc);this.zW(f,Kc,oc);}else this.aG(f,oc,false,true);}else{var
Gb=jsx3.gui.isMouseEventModKey(f);if(Gb||!this.Dq(oc))this.aG(f,oc,Gb,Gb);}}else this.Pv(this.H5()[0]);}else this.Pv(this.H5()[0]);};d.yI=function(){if(this._jsxf3!=null)return this._jsxf3;var
sc=this.H5();if(sc.length==1)return sc[0];return null;};d.zW=function(r,j,o){var
Nb=this.getValue();var
ec=false;var
Bb=!jsx3.gui.isMouseEventModKey(r)||!this.Dq(o);var
tc=[j];var
V=j;while((V=this.cB(V))!=null){tc.push(V);if(V==o){ec=true;break;}}if(!ec){tc=[j];V=j;while((V=this.YA(V))!=null){tc.push(V);if(V==o){ec=true;break;}}if(!ec)return;}var
cb=[];for(var
pb=0;pb<tc.length;pb++){var
vc=this.Dq(tc[pb]);if(!vc)cb.push(tc[pb]);}if(!jsx3.gui.isMouseEventModKey(r))this.x6();for(var
pb=0;pb<tc.length;pb++){var
nb=tc[pb];var
vc=this.Dq(nb);if(Bb||vc)this.aG(null,nb,true,!Bb&&vc,true);}if(Bb)this.doEvent("jsxselect",{objEVENT:r,strRECORDID:cb[0],strRECORDIDS:cb});this.doEvent("jsxchange",{objEVENT:r,preVALUE:Nb});};d.Ih=function(o){var
mb=o instanceof jsx3.xml.Entity?o:this.getRecord(o);return mb!=null&&mb.jsxunselectable!="1";};d.Dq=function(j){return this.getRecordNode(j).getAttribute("jsxselected")=="1";};h.getDragIcon=function(g,s,n,o){return "<div id='JSX' class='jsx30tree_dragicon' style='"+jsx3.html.getCSSOpacity(0.75)+"'>"+jsx3.html.getOuterHTML(g.parentNode.childNodes[1])+jsx3.html.getOuterHTML(g)+"</div>";};d.toggleItem=function(p,q,c){var
Mc=this.getRecordNode(p);var
Ub=this.fz(p);if(Ub!=null)this.B9(Mc,Ub,q,c);return this;};d.A4=function(b,e,i,l){var
H=this.getRecordNode(e);var
Bb=this.fz(e);if(Bb!=null){var
Nb=null;if(H.getAttribute("jsxlazy")=="1"&&H.getAttribute("jsxopen")!="1"&&(i==null||i===true)){jsx3.html.updateCSSOpacity(Bb.childNodes[0].childNodes[0],0.5);jsx3.sleep(function(){if(this.getParent()==null)return;var
Rb=this.doEvent("jsxdata",{objXML:this.getXML(),objNODE:H});if(Rb&&typeof Rb=="object"){if(Rb.bCLEAR)H.removeAttribute("jsxlazy");if(Rb.arrNODES!=null){H.removeChildren();for(var
O=0;O<Rb.arrNODES.length;O++)H.appendChild(Rb.arrNODES[O]);}}else H.removeAttribute("jsxlazy");this.redrawRecord(e,2);if(l!=null)l();},null,this);H.setAttribute("jsxopen","1");Nb=true;}else Nb=this.B9(H,Bb,i,false);this.doEvent("jsxtoggle",{objEVENT:b,strRECORDID:e,objRECORD:H,bOPEN:Nb});}};d.B9=function(s,c,q,r){var
nb=s.getAttribute("jsxopen")=="1";if(q==null)q=!nb;if(nb==q)return q;if(q){c.childNodes[0].childNodes[0].src=this.getUriResolver().resolveURI(this.getIconMinus());c.childNodes[1].style.display="block";s.setAttribute("jsxopen","1");}else{c.childNodes[0].childNodes[0].src=this.getUriResolver().resolveURI(this.getIconPlus());c.childNodes[1].style.display="none";s.removeAttribute("jsxopen");}if(r)c.childNodes[0].childNodes[0].setAttribute("jsxtype","plusminus");return q;};d.Sf=function(q,o){if(this.getCanDrag()==1&&!q.rightButton()){var
F=q.srcElement();if(F==null)return;var
O=false;if(jsx3.util.strEmpty(F.getAttribute("jsxtype")))F=F.parentNode;if(F.getAttribute("jsxtype")=="icon"){O=true;F=F.parentNode.childNodes[2];}if(F.getAttribute("jsxtype")=="text"){if(!this.Ih(F.getAttribute("JSXDragId")))return;var
V=this;q.bg();h.CU=window.setTimeout(function(){h.CU=null;Ob.unsubscribe("mouseup",V,"cw");if(V.getParent()!=null){V.Th(q,o);V.doDrag(q,F,h.getDragIcon,{strDRAGIDS:V.H5()});}},h.oz);Ob.subscribe("mouseup",this,"cw");if(O){Ob.publish(q);q.cancelAll();}}}};d.cw=function(p){Ob.unsubscribe("mouseup",this,"cw");if(h.CU)window.clearTimeout(h.CU);};d.ZY=function(b,k){var
Bc=b.srcElement();if(Bc==null)return;var
kc=Bc.getAttribute("jsxtype");if(jsx3.util.strEmpty(kc))Bc=Bc.parentNode;kc=Bc.getAttribute("jsxtype");if(this.getCanDrop()==1&&jsx3.EventHelp.isDragging()){var
Z=this.yS(b);var
sc=Z.getAttribute("dropverb")=="insertbefore";var
cb=Z.getAttribute("rowcontext");if(cb!=null){var
vc=jsx3.EventHelp.JSXID;var
lb=jsx3.EventHelp.getDragId();var
x=jsx3.EventHelp.getDragIds();var
Sb=jsx3.EventHelp.DRAGTYPE;var
Cc=jsx3.gui.isMouseEventModKey(b);if(vc==null)return;var
Ub=vc.doEvent("jsxadopt",{objEVENT:b,strRECORDID:lb,strRECORDIDS:x,objTARGET:this,bCONTROL:Cc});var
D={objEVENT:b,strRECORDID:cb,objSOURCE:vc,strDRAGID:lb,strDRAGIDS:x,strDRAGTYPE:Sb,bINSERTBEFORE:sc,bALLOWADOPT:Ub!==false};var
cc=this.doEvent(Cc?"jsxctrldrop":"jsxdrop",D);if(Ub!=false&&cc!==false&&vc.instanceOf(jsx3.xml.CDF)){for(var
v=0;v<x.length;v++)if(sc)this.adoptRecordBefore(vc,x[v],cb);else this.adoptRecord(vc,x[v],cb);this.revealRecord(x[0]);}}}else if((kc=="text"||kc=="icon")&&b.rightButton()&&this.getMenu()){var
cb=Bc.parentNode.parentNode.getAttribute("jsxid");var
kb=this.getServer().getJSX(this.getMenu());if(kb!=null&&this.Ih(cb)){var
tb=this.doEvent("jsxmenu",{objEVENT:b,objMENU:kb,strRECORDID:cb});if(tb!==false){if(tb instanceof Object&&tb.objMENU instanceof jsx3.gui.Menu)kb=tb.objMENU;var
N=b.shiftKey()||jsx3.gui.isMouseEventModKey(b);if(this.Dq(cb))this.Pv(cb);else this.aG(b,cb,N,N);kb.showContextMenu(b,this,cb);}}}this.f8(b);};d.Wh=function(j,s){var
M=j.toElement();if(M==null)return;var
jc=M.getAttribute("jsxtype");if(jc=="text"&&this.hasEvent("jsxspy")){var
wc=M;while(wc.getAttribute("jsxid")==null&&wc!=s)wc=wc.parentNode;if(wc==s)return;var
_=wc.getAttribute("jsxid");this.applySpyStyle(M);var
mb=j.clientX()+jsx3.EventHelp.DEFAULTSPYLEFTOFFSET;var
wb=j.clientY()+jsx3.EventHelp.DEFAULTSPYTOPOFFSET;j.bg();var
sb=this;if(h.x7)window.clearTimeout(h.x7);h.x7=window.setTimeout(function(){h.x7=null;if(sb.getParent()!=null)sb.sM(j,mb,wb,_,M,wc);},jsx3.EventHelp.SPYDELAY);}};d._ebMouseMove=function(l,m){if(jsx3.EventHelp.isDragging()&&this.getCanDrop()==1){var
Jb=l.srcElement();if(Jb==null)return;var
lc=Jb.getAttribute("jsxtype");var
oc=Jb;while(oc.getAttribute("jsxid")==null&&oc!=m)oc=oc.parentNode;if(oc==m)return;var
y=oc.getAttribute("jsxid");if(lc=="plusminus"){var
lb=this.getRecordNode(y).getAttribute("jsxopen")=="1";if(!lb&&!h.x1){var
xb=this;l.bg();h.x1=window.setTimeout(function(){delete h.x1;if(xb.getParent()!=null)xb.A4(l,y);},h.q8);}}else if(lc=="text"){var
Hc=jsx3.EventHelp.getDragSource();var
hc=jsx3.EventHelp.getDragType();var
Kb=this.doEvent("jsxbeforedrop",{objEVENT:l,strRECORDID:y,objSOURCE:Hc,strDRAGID:jsx3.EventHelp.getDragId(),strDRAGIDS:jsx3.EventHelp.getDragIds(),strDRAGTYPE:hc,objGUI:oc});if(Kb===false)return;var
J=this.getAbsolutePosition(m,oc);var
E=this.getAbsolutePosition(m,oc.childNodes[0]);var
T=this.yS(m);var
F=T.style;var
vb=J.L;if(E.H/3>l.getOffsetY()){var
zb=this.getAbsolutePosition(m,m);F.top=E.T-4+"px";F.width=Math.max(0,zb.W-vb-8)+"px";F.height="7px";F.backgroundImage="url("+h.INSERT_BEFORE_IMG+")";T.setAttribute("dropverb","insertbefore");}else{vb=vb+26;F.width="12px";F.height="12px";F.top=E.T-10+E.H+"px";F.backgroundImage="url("+h.APPEND_IMG+")";T.setAttribute("dropverb","append");}F.left=vb+"px";T.setAttribute("rowcontext",y);F.display="block";}}};d.yS=function(r){return this.getRendered(r).lastChild;};d.f8=function(o){var
Nb=this.yS(o);Nb.style.display="none";Nb.removeAttribute("dropverb");Nb.removeAttribute("rowcontext");};d.sM=function(k,e,a,c,r,b){this.removeSpyStyle(r);var
y=this.doEvent("jsxspy",{objEVENT:k,strRECORDID:c});if(y){jsx3.gui.Interactive.hideSpy();this.showSpy(y,e,a);}};d.gn=function(m,q){var
pc=m.isFakeOut(q);var
nc=m.fromElement();if(nc==null)return;var
C=nc.getAttribute("jsxtype");if(!pc&&jsx3.EventHelp.isDragging()&&this.getCanDrop()==1){this.f8(m);window.clearTimeout(h.x1);var
gb=jsx3.EventHelp.JSXID;var
dc=jsx3.EventHelp.DRAGTYPE;var
V=nc.parentNode.parentNode.getAttribute("jsxid");var
hb=nc.parentNode.parentNode;var
K=this.doEvent("jsxcanceldrop",{objEVENT:m,strRECORDID:V,objSOURCE:gb,strDRAGID:jsx3.EventHelp.getDragId(),strDRAGIDS:jsx3.EventHelp.getDragIds(),strDRAGTYPE:dc,objGUI:hb});}else if(C=="text"&&this.hasEvent("jsxspy")){var
Xb=m.toElement();if(!Xb||Xb.id!="_jsxspy"){jsx3.sleep(jsx3.gui.Interactive.hideSpy);this.removeSpyStyle(nc);if(h.x7)window.clearTimeout(h.x7);}}};d.Rn=function(l,b){if(this.jsxsupermix(l,b))return;var
sb=l.keyCode();var
Bb=this.getXML();var
vb=l.srcElement().parentNode.parentNode;if(vb!=null&&vb.getAttribute("jsxid")!=null){var
Bc=vb.getAttribute("jsxid");if(sb>=37&&sb<=40){var
Ac=this.getRecordNode(Bc);var
V=Ac.getAttribute("jsxlazy")=="1";if(V||Ac.selectSingleNode("record")!=null){var
A=true;var
Rb=Ac.getAttribute("jsxopen")=="1";}else var
A=false;if(sb==37){if(A&&Rb){this.A4(l,Bc,false);}else this.OT(Ac);}else if(sb==38){this.OT(Ac);}else if(sb==39){if(V&&!Rb){var
ob=this;this.A4(l,Bc,true,function(){ob.Pv(Bc);});}else if(A&&!Rb){this.A4(l,Bc,true);}else this.xR(Ac);}else if(sb==40)this.xR(Ac);l.cancelAll();}else if(sb==9){if(l.shiftKey()){jsx3.html.focusPrevious(this.getRendered(b),l);}else jsx3.html.focusNext(this.getRendered(b),l);}else if(l.spaceKey()||l.enterKey()){var
ub=this.Dq(Bc);if(ub&&l.enterKey()){this.uK(l);}else this.aG(l,Bc,jsx3.gui.isMouseEventModKey(l)||l.shiftKey(),true);l.cancelAll();}}};d.OT=function(a){var
cc=this.YA(a.getAttribute("jsxid"));if(cc!=null)this.Pv(cc);};d.xR=function(f){var
v=this.cB(f.getAttribute("jsxid"));if(v!=null)this.Pv(v);};d.YA=function(f){var
Y=this.fz(f);if(Y!=null){var
Fc=Y.previousSibling;if(Fc!=null){while(Fc.childNodes[1].style.display=="block"){var
V=Fc.childNodes[1].lastChild;if(V==null)break;Fc=V;}return Fc.getAttribute("jsxid");}else return Y.parentNode.parentNode.getAttribute("jsxid");}return null;};d.cB=function(r){var
jc=this.fz(r);if(jc!=null){if(jc.childNodes[1].style.display=="block"){var
B=jc.childNodes[1].firstChild;if(B!=null)return B.getAttribute("jsxid");}var
bc=jc.nextSibling;if(bc!=null){return bc.getAttribute("jsxid");}else{var
Fc=this.getId();var
G=jc.parentNode.parentNode;while(G!=null&&G.id&&G.id.indexOf(Fc)==0){if(G.nextSibling!=null)return G.nextSibling.getAttribute("jsxid");G=G.parentNode.parentNode;}}}return null;};d.executeRecord=function(e){var
Cc=null;Cc=this.isOldEventProtocol();this.uK(Cc,e);};d.uK=function(b,e){var
Cc=null;if(e==null)Cc=this.H5();else if(!(e instanceof Array))Cc=[e];else Cc=e;for(var
bb=0;bb<Cc.length;bb++){var
Db=Cc[bb];if(Db==null||!this.Ih(Db))continue;var
rc=this.getRecordNode(Db);var
wc=rc.getAttribute("jsxexecute");if(wc){var
G={strRECORDID:Db};G.objRECORD=rc;if(b instanceof jsx3.gui.Event)G.objEVENT=b;this.eval(wc,G);}}if(b)this.doEvent("jsxexecute",{objEVENT:b,objRECORD:this.getRecordNode(Cc[0]),strRECORDIDS:Cc,strRECORDID:Cc[0]});};d.gg=function(m,e){var
qb=null;var
Q=m.srcElement();if(Q!=null&&jsx3.util.strEmpty(Q.getAttribute("jsxtype")))Q=Q.parentNode;if(Q!=null&&Q.getAttribute("jsxtype")!=null&&(Q.getAttribute("jsxtype")=="text"||Q.getAttribute("jsxtype")=="icon"))qb=Q.parentNode.parentNode.getAttribute("jsxid");if(qb)this.uK(m);};h.Tk={};h.Tk["click"]=true;h.Tk["dblclick"]=true;h.Tk["mouseover"]=true;h.Tk["mouseout"]=true;h.Tk["mouseup"]=true;h.Tk["mousedown"]=true;h.Tk["mousemove"]=true;h.Tk["keydown"]=true;h.Tk["focus"]=true;d.Vd=function(g,m,k){this.Qh(g,m,k,3);};d.zj=function(s){this.applyDynamicProperties();if(this.getParent()&&(s==null||isNaN(s.parentwidth)||isNaN(s.parentheight))){s=this.getParent().Ln(this);}else if(s==null)s={};s.boxtype="box";s.tagname="div";if(s.left==null)s.left=0;if(s.top==null)s.top=0;if(s.width==null)s.width="100%";if(s.height==null)s.height="100%";var
X,tb;if((X=this.getBorder())!=null&&X!="")s.border=X;if((tb=this.getPadding())!=null&&tb!="")s.padding=tb;return new
jsx3.gui.Painted.Box(s);};d.paint=function(){this.applyDynamicProperties();var
X=this.getId();var
qb=jsx3.util.strTrim(this.doTransform());if(!qb)qb=this.getNoDataMessage();qb=qb+('<img src="'+jsx3.gui.Block.SPACE+'"'+this.cn("focus","Uo")+' style="position:absolute;left:0px;top:0px;width:1px;height:1px;" '+this.vo()+"/>");var
zb="";if(this.getEnabled()==1)zb=this.qk(h.Tk,0);var
Jb=this.renderAttributes(null,true);var
A=this.vi(true);A.setAttributes(this.fo()+zb+' id="'+X+'"'+this.so()+' class="jsx30tree" '+Jb);A.setStyles(this.xp()+this.Dg()+this.mg()+this.Eo()+this.Oo()+this.Ak()+this.Wm()+this.Nh()+this.Af()+this.Dh()+this.ji());return A.paint().join(qb+'<div class="jsx30tree_drop_icon">&#160;</div>');};d.doTransform=function(j){var
Cc={};var
D=false;if(j==null){var
Ub=this.getXML().getRootNode();if(Ub){var
Ab=Ub.getChildIterator();if(Ab.hasNext())j=Ab.next().getAttribute("jsxid");}}else D=true;var
T=this.getUriResolver();var
yc=this.getIcon(),M=this.getIconMinus(),W=this.getIconPlus();if(j!=null)Cc.jsxrootid=j;Cc.jsxtabindex=this.getIndex()==null?0:this.getIndex();Cc.jsxselectedimage=h.SELECTEDIMAGE;Cc.jsxbordercolor=h.BORDERCOLOR;Cc.jsxicon=yc?T.resolveURI(yc):"";Cc.jsxiconminus=M?T.resolveURI(M):"";Cc.jsxiconplus=W?T.resolveURI(W):"";Cc.jsxtransparentimage=jsx3.gui.Block.SPACE;Cc.jsxdragtype="JSX_GENERIC";Cc.jsxid=this.getId();Cc.jsxuseroot=D?1:this.getRoot();Cc.jsxfragment=D?1:0;Cc.jsxpath=jsx3.getEnv("jsxabspath");Cc.jsxpathapps=jsx3.getEnv("jsxhomepath");Cc.jsxpathprefix=this.getUriResolver().getUriPrefix();var
ec=this.getXSLParams();for(var Bb in ec)Cc[Bb]=ec[Bb];var
Sb=this.jsxsupermix(Cc);Sb=this.yp(Sb);return Sb;};d.getNoDataMessage=function(){return this.jsxnodata==null?h.DEFAULTNODATAMSG:this.jsxnodata;};d.onSetChild=function(f){return false;};d.onDestroy=function(m){this.jsxsuper(m);this.onDestroyCached(m);};h.getVersion=function(){return "3.0.00";};});jsx3.Tree=jsx3.gui.Tree;
