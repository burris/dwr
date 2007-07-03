/*
 * Copyright (c) 2001-2007, TIBCO Software Inc.
 * Use, modification, and distribution subject to terms of license.
 */
jsx3.require("jsx3.xml.Cacheable","jsx3.gui.Form","jsx3.gui.Block","jsx3.gui.Column");jsx3.Class.defineClass("jsx3.gui.List",jsx3.gui.Block,[jsx3.gui.Form,jsx3.xml.Cacheable,jsx3.xml.CDF],function(m,o){var
tb=jsx3.gui.Event;var
ec=jsx3.gui.Interactive;var
vc=jsx3.xml.CDF;var
wc=jsx3.util.Logger.getLogger(m.jsxclass.getName());m.DEFAULTXSLURL=jsx3.resolveURI("jsx:///xsl/"+(jsx3.CLASS_LOADER.IE?"ie":"fx")+"/jsx30list.xsl");m.SELECTBGIMAGE="url("+jsx3.resolveURI("jsx:///images/list/select.gif")+")";m.DEFAULTBACKGROUNDHEAD="background-image:url("+jsx3.resolveURI("jsx:///images/list/header.gif")+");";jsx3.html.loadImages("jsx:///images/list/select.gif","jsx:///images/list/header.gif");m.DEFAULTBACKGROUNDCOLOR="#F3F2F4";m.DEFAULTBACKGROUNDCOLORHEAD="#c8cfd8";m.SORTASCENDING="ascending";m.SORTDESCENDING="descending";m.DEFAULTHEADERHEIGHT=20;m.MULTI=1;m.SINGLE=0;m.NOTSELECTABLE=2;m.RESIZEBARBGCOLOR="#2050df";m.DEFAULTROWCLASS="jsx30list_r1";o.init=function(a){this.jsxsuper(a);this._jsxxe=null;this._jsxu0=null;this._jsxS_=null;this._jsxrT=null;};o.onRemoveChild=function(a,g){this.jsxsuper(a,g);this.resetXslCacheData();this.repaint();};o.paintChild=function(i,s){if(!s){this.resetXslCacheData();this.repaint();}};o.Mn=function(e){var
J=this.jsxsupermix(e);if(J.getSourceURL()==e)J=J.cloneDocument();this._configXSL(J);return J;};o.getXSL=function(){return this.Mn(m.DEFAULTXSLURL);};o._configXSL=function(c){var
t=c.selectSingleNode("//xsl:comment[.='JSXUNCONFIGURED']");if(t!=null){t.setValue("JSXCONFIGURED");var
cb=this.Le();var
Z=cb.length;if(Z>0)for(var
qc=0;qc<=Z;qc++){var
ab=new
jsx3.xml.Document();var
rc=qc==Z?cb[Z-1].paintXSLString(true):cb[qc].paintXSLString();ab.loadXML(rc);if(ab.hasError()){wc.error("Error loading XSL for column #"+qc+" of "+this+": "+ab.getError());}else t.getParent().insertBefore(ab.getRootNode(),t);}}};o.clearXSL=function(){this.resetXslCacheData();return this;};m.yK=function(g){return g&&g.getDisplay()!="none";};o.Le=function(){return this.getChildren().filter(m.yK);};o.doValidate=function(){var
C=this.getSelectedNodes().size()>0||this.getRequired()==0;this.setValidationState(C?1:0);return this.getValidationState();};o.getResizable=function(){return this.jsxresize==null?1:this.jsxresize;};o.setResizable=function(f){this.jsxresize=f;return this;};o.de=function(n,r){if(!n.leftButton())return;tb.publish(n);if(this.getCanResize()!=0){var
Bc=r;var
Sb=this.getRendered().childNodes[1];var
Q=parseInt(Bc.parentNode.parentNode.parentNode.parentNode.parentNode.style.left);var
wb=Bc.parentNode.parentNode.offsetLeft+Q;Sb.style.left=wb+"px";this._jsxS_=wb;this._jsxrT=Bc.parentNode.parentNode.cellIndex;var
C=this._jsxrT-1;var
qc=this.doEvent("jsxbeforeresize",{objEVENT:n,intINDEX:C,intCOLUMNINDEX:C})===false;if(!qc){Sb.style.visibility="visible";jsx3.gui.Event.subscribe("mouseup",this,"si");jsx3.gui.Interactive.Uk(n,Sb,false,true);}else Sb.style.left="-10px";}n.cancelReturn();n.cancelBubble();};o.si=function(e,h){var
e=e.event;jsx3.gui.Event.unsubscribe("mouseup",this,"si");if(h==null)h=this.getRendered().childNodes[1];e.releaseCapture(h);var
Kb=parseInt(h.style.left);var
Sb=Kb-this._jsxS_;var
nb=this._jsxrT-1;var
S=this.Le();var
eb=this.getDocument();var
qc=eb.getElementById(this.getId()+"_jsxhead");var
Ic=qc.childNodes[0].childNodes[0].childNodes[0].childNodes[nb];var
kc=Ic.offsetWidth;var
qb=S[nb].getWidth()+"";var
jc;if(jc=qb.indexOf("%")>-1){var
ub=this.getAbsolutePosition().W;var
Dc=kc+Sb;Dc=parseInt(Dc/ub*1000)/10;if(Dc<2)Dc=2;Dc=Dc+"%";}else{var
Dc=kc+Sb;if(Dc<4)Dc=4;}h.style.left="-10px";var
ic={objEVENT:e,intDIFF:Sb,intINDEX:nb,intOLDWIDTH:kc,vntWIDTH:Dc,intCOLUMNINDEX:nb};var
H=this.doEvent("jsxafterresize",ic);if(!(H===false)){var
M=H instanceof Object&&H.vntWIDTH?H.vntWIDTH:Dc;S[nb].setWidth(M);this.resetXslCacheData();this.repaintBody();this.repaintHead();}};o.ph=function(b,k){if(!b.leftButton())return;tb.publish(b);var
yb=k;var
X=this.getDocument().getElementById(this.getId()+"_jsxghost");X.innerHTML="";jsx3.html.setInnerText(X,"");var
Zb=yb.childNodes[0].cloneNode(true);var
E=parseInt(yb.parentNode.parentNode.parentNode.style.left);var
Gb={};Gb.boxtype="box";Gb.tagname="div";Gb.left=yb.offsetLeft+E;Gb.top=0;Gb.parentheight=yb.offsetHeight;Gb.parentwidth=parseInt(yb.offsetWidth);Gb.width="100%";Gb.height="100%";Gb.border="solid 1px #ffffff;solid 1px #9898a5;solid 1px #9898a5;solid 1px #ffffff";Gb.padding=parseInt(yb.childNodes[0].offsetTop)+" "+(yb.style.paddingRight?parseInt(yb.style.paddingRight):0)+" "+(yb.style.paddingBottom?parseInt(yb.style.paddingBottom):0)+" "+(yb.style.paddingLeft?parseInt(yb.style.paddingLeft):0);var
Q=new
jsx3.gui.Painted.Box(Gb);X.style.left=Q.pp()+"px";X.style.top=Q.Bd()+"px";X.style.width=Q.Oj()+"px";X.style.height=Q.Ae()+"px";X.style.fontName=yb.style.fontName;X.style.fontSize=yb.style.fontSize;X.style.textAlign=yb.style.textAlign;X.style.fontWeight=yb.style.fontWeight;X.style.visibility="visible";jsx3.gui.Painted.Be(X,Q.Ue(),"padding");X.appendChild(Zb);this._jsxS_=yb.offsetLeft+E;this._jsxrT=yb.cellIndex;jsx3.gui.Event.subscribe("mouseup",this,"Dk");jsx3.gui.Interactive.Uk(b,X,false,true);};o.Jh=function(p,i){var
Kc=p.getType()=="click"?i.cellIndex:this._jsxrT;var
zb=this.Le()[Kc];var
Rb=this.getChildren().indexOf(zb);if(this.getCanSort()!=0&&zb!=null&&zb.getCanSort()!=0){var
P={objEVENT:p,intCOLUMNINDEX:Rb};var
Tb=this.doEvent("jsxbeforesort",P);if(Tb!==false){var
Wb=Tb instanceof Object&&Tb.intCOLUMNINDEX!=null?Tb.intCOLUMNINDEX:Rb;this.HK(p,Wb);}}};o.Dk=function(s,j){var
s=s.event;jsx3.gui.Event.unsubscribe("mouseup",this,"Dk");var
Eb=this.getDocument().getElementById(this.getId()+"_jsxghost");if(j==null)var
j=Eb;s.releaseCapture(Eb);Eb.style.visibility="hidden";if(this._jsxS_==parseInt(Eb.style.left)){this.Jh(s,j);}else if(this.getCanReorder()!=0){var
ab=parseInt(Eb.style.left);var
jb=this.Le();var
_=this.getChildren().length;var
t=jb[0].getRendered().parentNode;var
Dc=this.getChildren().indexOf(jb[this._jsxrT]);var
Cb=0;for(var
hc=0;hc<_;hc++)if(m.yK(this.getChild(hc))){var
W=t.childNodes[Cb].offsetLeft;if(ab<W){if(Dc!=hc)this.Wk(Dc,hc-1);jsx3.EventHelp.reset();return;}Cb++;}if(Dc!=_-1)this.Wk(Dc,_-1);}};o.setSortColumn=function(i){this.HK(this.isOldEventProtocol(),i);};o.HK=function(n,l){this.jsxsortcolumn=l;this.doSort();if(n)this.doEvent("jsxaftersort",{objEVENT:n instanceof jsx3.gui.Event?n:null,intCOLUMNINDEX:l});return this;};o.getSortColumn=function(){return this.jsxsortcolumn;};o.dn=function(){var
F=this.jsxsortcolumn!=null?this.getChild(this.jsxsortcolumn)==null?null:this.getChild(this.jsxsortcolumn).getSortPath():this.getSortPath();return F?F.substring(1):"";};o.Wk=function(s,d){var
t=this.getChildren();var
Tb=t.length;var
S=this.getChild(s);if(d<s){for(var
Ob=s;Ob>d;Ob--)if(Ob>0)t[Ob]=t[Ob-1];t[d+1]=S;}else{for(var
Ob=s;Ob<=d;Ob++)if(Ob<=Tb-2)t[Ob]=t[Ob+1];t[d]=S;}this.resetXslCacheData();this.repaint();this.getServer().getDOM().onChange(0,this.getId(),this.getChild(0).getId());};o.doSort=function(g){if(g!=null){this.setSortDirection(g);}else this.setSortDirection(this.getSortDirection()=="ascending"?"descending":"ascending");this.repaintBody();this.repaintHead();};o.getSortPath=function(){return this.jsxsortpath==null?"":this.jsxsortpath;};o.setSortPath=function(l){this.jsxsortpath=l;return this;};o.getSortDirection=function(){return this.jsxsortdirection==null?"ascending":this.jsxsortdirection;};o.setSortDirection=function(c){this.jsxsortdirection=c;return this;};o.getMultiSelect=function(){return this.jsxmultiselect==null?1:this.jsxmultiselect;};o.setMultiSelect=function(k){this.jsxmultiselect=k;if(k==2)this.deselectAllRecords();return this;};o.getCanReorder=function(){return this.jsxreorder==null?1:this.jsxreorder;};o.setCanReorder=function(e){this.jsxreorder=e;return this;};o.getCanSort=function(){return this.jsxsort==null?1:this.jsxsort;};o.setCanSort=function(q){this.jsxsort=q;return this;};o.getBackgroundColorHead=function(){return this.jsxbgcolorhead;};o.setBackgroundColorHead=function(a){this.jsxbgcolorhead=a;return this;};o.getBackgroundHead=function(){return this.jsxbghead;};o.setBackgroundHead=function(n){this.jsxbghead=n;return this;};o.getHeaderHeight=function(){return this.jsxheaderheight;};o.setHeaderHeight=function(s){this.jsxheaderheight=s;return this;};m.FG=function(d,c,n,l){return "<span id='JSX' style='font-family:Verdana;font-size:10px;padding:0px;height:22px;width:200px;overflow:hidden;text-overflow:ellipsis;filter:progid:DXImageTransform.Microsoft.Gradient(GradientType=1, StartColorStr=#eedfdfe8, EndColorStr=#00ffffff);'><table style='font-family:verdana;font-size:10px;color:#a8a8a8;' cellpadding='3' cellspacing='0'>"+jsx3.html.getOuterHTML(d).replace(/id=/g,"tempid=").replace(/BACKGROUND/g,"bg").replace(/class=/g,"jsxc=")+"</table></span>";};m.doBlurItem=function(l){var
Z=l.getAttribute("JSXDragId");var
cc=l.id.substring(0,l.id.length-(Z.length+1));var
Eb=jsx3.GO(cc);l.style.fontWeight="normal";if(Eb!=null)Eb._jsxxe=null;};m.doFocusItem=function(a){var
Kc=a.getAttribute("JSXDragId");var
_=a.id.substring(0,a.id.length-(Kc.length+1));var
lc=jsx3.GO(_);if(lc==null){wc.warn("No list with id "+_+".");return;}if(!lc.Ih(Kc))return;a.focus();a.style.fontWeight="bold";lc._jsxxe=a;};o.Sf=function(b,k){if(this.getCanDrag()==1&&b.leftButton()){var
Y=b.srcElement();var
yb=this.sG(Y);if(yb[0]!=null){if(!this.Ih(yb[0]))return;tb.publish(b);this.doDrag(b,yb[2],m.FG,{strRECORDID:yb[0],intCOLUMNINDEX:yb[1]});}}};o.ZY=function(e,s){var
Eb=this.sG(e.srcElement());if(this.getCanDrop()==1&&jsx3.EventHelp.isDragging()&&jsx3.EventHelp.JSXID!=this){if(jsx3.EventHelp.DRAGTYPE=="JSX_GENERIC"){var
lb=jsx3.EventHelp.JSXID.getId();var
ab=jsx3.EventHelp.DRAGID;var
vb=jsx3.GO(lb);if(vb==null)return;var
Nc=jsx3.gui.isMouseEventModKey(e);var
Ub=vb.doEvent("jsxadopt",{objEVENT:e,strRECORDID:ab,strRECORDIDS:[ab],objTARGET:this,bCONTROL:Nc});var
S={objEVENT:e,objSOURCE:vb,strDRAGID:ab,strDRAGTYPE:jsx3.EventHelp.DRAGTYPE,strRECORDID:Eb[0],intCOLUMNINDEX:Eb[1],bALLOWADOPT:Ub!==false};var
_=this.doEvent(Nc?"jsxctrldrop":"jsxdrop",S);if(Ub!==false&&_!==false&&vb.instanceOf(jsx3.xml.CDF))this.adoptRecord(vb,ab);}}else if(e.rightButton()){var
Ic;if((Ic=this.getMenu())!=null){var
rc=this.getServer().getJSX(Ic);if(rc!=null){var
Lc={objEVENT:e,objMENU:rc,strRECORDID:Eb[0],intCOLUMNINDEX:Eb[1]};var
sb=this.doEvent("jsxmenu",Lc);if(sb!==false){if(sb instanceof Object&&sb.objMENU instanceof jsx3.gui.Menu)rc=sb.objMENU;rc.showContextMenu(e,this,Eb[0]);}}}}};o.sG=function(p){var
Jb=null;var
ib=null;var
Mc=null;while(p!=null&&Jb==null){if(p.tagName&&p.tagName.toLowerCase()=="td")ib=p.getAttribute("cellIndex");else if(p.tagName&&p.tagName.toLowerCase()=="tr"){Jb=p.getAttribute("JSXDragId");Mc=p;}p=p.parentNode;}return [Jb,Jb?ib:null,Mc];};o.EQ=function(p,g,h){if(!this.Ih(g.getAttribute("JSXDragId")))return;if(!this.Ih(h.getAttribute("JSXDragId")))return;if(this.getMultiSelect()==2)return;var
ab=0;var
Ob=this.getDocument().getElementById(this.getId()+"_jsxbody").childNodes[0].childNodes[0];var
M=[],Hb=[];for(var
Zb=Ob.childNodes.length-1;Zb>=0;Zb--){if(Ob.childNodes[Zb]==h)ab++;if(Ob.childNodes[Zb]==g)ab++;if(ab>=1&&ab<=2){var
v=Ob.childNodes[Zb];M.push(v.getAttribute("JSXDragId"),v);}if(ab==2)break;}this.i_(p,M,Hb,false);m.doFocusItem(g);};o.Rn=function(a,l){if(this.jsxsupermix(a,l))return;if(this._jsxxe==null)return;var
kc=this.getId().length;var
Cb=a.keyCode();var
J=this.getMultiSelect()==1;var
Db=false;var
gb=jsx3.gui.isMouseEventModKey(a);if(Cb==38){if(this._jsxxe==this._jsxxe.parentNode.firstChild)return;if(J&&gb){m.doFocusItem(this._jsxxe.previousSibling);}else if(J&&a.shiftKey()){this.EQ(a,this._jsxxe.previousSibling,this._jsxu0);}else{var
ob=this._jsxxe.previousSibling;this.W2(a,ob.getAttribute("JSXDragId"),ob,false);}Db=true;}else if(Cb==40){if(this._jsxxe==this._jsxxe.parentNode.lastChild)return;if(J&&gb){m.doFocusItem(this._jsxxe.nextSibling);}else if(J&&a.shiftKey()){this.EQ(a,this._jsxxe.nextSibling,this._jsxu0);}else{var
ob=this._jsxxe.nextSibling;this.W2(a,ob.getAttribute("JSXDragId"),ob,false);}Db=true;}else if(Cb==13){this.Wf(a);Db=true;}else if(Cb==32){if(J&&gb){var
pc=this._jsxxe.getAttribute("JSXDragId");if(this.isSelected(pc)){this.RJ(a,pc,this._jsxxe);}else this.W2(a,pc,this._jsxxe,true);}else if(J&&a.shiftKey()){this.EQ(a,a.srcElement(),this._jsxu0);}else{var
ob=this._jsxxe;this.W2(a,ob.getAttribute("JSXDragId"),ob,false);}Db=true;}else if(Cb==9&&a.shiftKey()){this.focus();Db=true;}else if(Cb==9){this.getRendered().lastChild.focus();Db=true;}if(Db)a.cancelAll();};o.Th=function(j,c){var
db=false;var
z=j.srcElement();if(z.tagName&&z.tagName.toLowerCase()=="tbody"||z==c){this.G4(j,this.getSelectedIds(),[]);return;}var
bc=this.getRendered();while(jsx3.util.strEmpty(z.getAttribute("JSXDragId"))&&z!=bc)z=z.parentNode;if(!z||!z.getAttribute("JSXDragId")){this.G4(j,this.getSelectedIds(),[]);return;}var
Ab=this.getMultiSelect()==1;var
J=jsx3.gui.isMouseEventModKey(j);if(Ab&&j.shiftKey()&&this._jsxu0!=null){this.EQ(j,z,this._jsxu0);db=true;}else if(Ab&&J){var
lb=z.getAttribute("JSXDragId");if(this.isSelected(lb)){this.RJ(j,lb,z);}else{this.W2(j,lb,z,true);m.doFocusItem(z);}db=true;}else{if(this.isSelected(z.getAttribute("JSXDragId"))){if(J||j.shiftKey())this.RJ(j,z.getAttribute("JSXDragId"),z);}else this.W2(j,z.getAttribute("JSXDragId"),z,false);db=true;}if(db){j.cancelBubble();j.cancelReturn();}};o.gg=function(q,k){this.Wf(q);};o.executeRecord=function(d){var
Ec=this.getRecordNode(d);if(Ec!=null)this.eval(Ec.getAttribute("jsxexecute"),{strRECORDID:d});};o.doExecute=function(i){this.Wf(this.isOldEventProtocol(),i!=null?[i]:null);};o.Wf=function(r,q){if(q==null)q=this.getSelectedIds();for(var
B=0;B<q.length;B++){var
kb=q[B];var
Jc=this.getRecordNode(kb);if(Jc.getAttribute("jsxunselectable")=="1")continue;this.eval(Jc.getAttribute("jsxexecute"),{strRECORDID:kb});}if(q.length>0&&r)this.doEvent("jsxexecute",{objEVENT:r instanceof tb?r:null,strRECORDID:q[0],strRECORDIDS:q});};o.isSelected=function(p){return this.getXML().selectSingleNode("//record[@jsxid='"+p+"' and @"+"jsxselected"+"='1']")!=null;};o.doSelect=function(b,e,k,i){this.W2(!k&&this.isOldEventProtocol(),b,null,true);if(b&&i)this.revealRecord(b);return this;};o.selectRecord=function(c){if(!this.Ih(c))return;if(this.getMultiSelect()==2)return;this.W2(false,c,null,true);return this;};o.deselectRecord=function(n){this.RJ(false,n,null);return this;};o.deselectAllRecords=function(){this.G4(false,this.getSelectedIds(),[]);return this;};o.W2=function(d,c,q,e){var
V=this.getRecordNode(c);if(!V||V.getAttribute("jsxselected")=="1"||V.getAttribute("jsxunselectable")=="1"||this.getMultiSelect()==2)return false;var
sb=e&&this.getMultiSelect()==1;if(!sb)this.deselectAllRecords();V.setAttribute("jsxselected","1");q=q||this.Ny(c);if(q!=null){if(!sb){this._jsxu0=q;m.doFocusItem(q);}q.style.backgroundImage=m.SELECTBGIMAGE;}if(d){this.doEvent("jsxselect",{objEVENT:d instanceof tb?d:null,strRECORDID:c,strRECORDIDS:[c]});this.doEvent("jsxchange",{objEVENT:d instanceof tb?d:null});}return true;};o.i_=function(k,c,e,l){if(!l)this.deselectAllRecords();for(var
Ac=0;Ac<c.length;Ac++){var
ab=this.W2(false,c[Ac],e[Ac],true);if(!ab){c.splice(Ac,1);e.splice(Ac,1);Ac--;}}if(k&&c.length>0){this.doEvent("jsxselect",{objEVENT:k,strRECORDID:c[0],strRECORDIDS:c});this.doEvent("jsxchange",{objEVENT:k});}};o.RJ=function(k,n,a){var
nc=this.getRecordNode(n);if(!nc||nc.getAttribute("jsxselected")!="1")return false;nc.removeAttribute("jsxselected");a=a||this.Ny(n);if(a!=null){if(this._jsxu0==a){delete this._jsxu0;m.doBlurItem(a);}a.style.backgroundImage="";}if(k){this.doEvent("jsxselect",{objEVENT:k instanceof tb?k:null,strRECORDID:null,strRECORDIDS:[]});this.doEvent("jsxchange",{objEVENT:k instanceof tb?k:null});}return true;};o.G4=function(q,r,a){for(var
Nc=0;Nc<r.length;Nc++){var
Db=this.RJ(false,r[Nc],a[Nc]);if(!Db){r.splice(Nc,1);a.splice(Nc,1);Nc--;}}if(q&&r.length>0){this.doEvent("jsxselect",{objEVENT:q,strRECORDID:r[0],strRECORDIDS:r});this.doEvent("jsxchange",{objEVENT:q});}};o.focusRecord=function(n){var
cc=this.Ny(n);if(cc!=null)cc.focus();return this;};o.doDeselect=function(a,f){this.RJ(this.isOldEventProtocol(),a,null);return this;};o.getActiveRow=function(){return this._jsxu0;};o.revealRecord=function(k,l){var
Pb=this.Ny(k);if(Pb){var
eb=l?l.getRendered():this.getRendered();if(eb)jsx3.html.scrollIntoView(Pb,eb,0,10);}};o.Ny=function(a){var
zc=this.getDocument();return zc!=null?zc.getElementById(this.getId()+"_"+a):null;};o.redrawRecord=function(a,l){if(l==1){this.appendRow(this.getRecord(a),a);}else if(a!=null&&l==0){var
rc;if((rc=this.Ny(a))!=null)rc.parentNode.removeChild(rc);}else if(a!=null&&l==2)this.updateRow(a);};o.getSelectedNodes=function(){return this.getXML().selectNodes("//record[@"+"jsxselected"+"='1']");};o.getSelectedIds=function(){return this.getSelectedNodes().map(function(h){return h.getAttribute("jsxid");}).toArray(true);};o.getValue=function(){var
cb=this.getSelectedIds();return this.getMultiSelect()==1?cb:cb[0];};o.setValue=function(k){if(k instanceof Array){if(this.getMultiSelect()!=1)throw new
jsx3.IllegalArgumentException("strRecordId",k);}else k=k!=null?[k]:[];this.i_(false,k,[],false);return this;};o.Wh=function(i,d){if(this.getCanSpy()==1&&this.getEvent("jsxspy")){var
Yb=this.sG(i.srcElement());if(Yb[0]){m._curSpyRow=Yb[2];this.applySpyStyle(Yb[2]);var
_=i.clientX()+jsx3.EventHelp.DEFAULTSPYLEFTOFFSET;var
v=i.clientY()+jsx3.EventHelp.DEFAULTSPYTOPOFFSET;var
gb=this;i.bg();m.ET=window.setTimeout(function(){if(gb._jsxm5)return;var
tc={objEVENT:i,strRECORDID:Yb[0],intCOLUMNINDEX:Yb[1]};var
hb=gb.doEvent("jsxspy",tc);if(hb){jsx3.gui.Interactive.hideSpy();gb.showSpy(hb,_,v);}},jsx3.EventHelp.SPYDELAY);}}};o.gn=function(){if(m._curSpyRow){this.removeSpyStyle(m._curSpyRow);delete m._curSpyRow;}window.clearTimeout(m.ET);jsx3.gui.Interactive.hideSpy();};m.Tk={};m.Tk["mouseover"]=true;m.Tk["mouseout"]=true;m.Tk["click"]=true;m.Tk["dblclick"]=true;m.Tk["keydown"]=true;m.Tk["mousedown"]=true;m.Tk["mouseup"]=true;o.Vd=function(d,a,n){var
X=this.getDocument();if(X!=null){var
fc=X.getElementById(this.getId()+"_jsxbody");if(fc!=null){var
zb=this.getHeaderHeight()!=null?this.getHeaderHeight():m.DEFAULTHEADERHEIGHT;fc.style.height=Math.max(0,d.parentheight-zb)+"px";}}};o.paint=function(){this.applyDynamicProperties();this._jsxu0=null;var
gc=this.getParent().Ln(this);var
yb=this.getId();var
z="";var
qc="<span"+this.cn("mousedown","de",1)+' id="'+yb+'_jsxcolresize" style="background-color:'+m.RESIZEBARBGCOLOR+';" class="jsx30list_colresize"></span>';var
y=this.getHeaderHeight()!=null?this.getHeaderHeight():m.DEFAULTHEADERHEIGHT;var
W='<div id="'+yb+'" class="jsx30list" '+'style="'+""+this.Dh()+this.Af()+this.Oo()+this.Dg()+this.mg()+'"'+this.so()+this.renderAttributes()+">";W=W+'<table class="jsx30list_table" border="0" cellpadding="0" cellspacing="0" style="">';if(y>0){W=W+('<tr><td height="'+y+'" style="position:relative;overflow:hidden;">');W=W+('<div id="'+yb+'_jsxhead" class="jsx30list_headspan" style="'+this.xm()+this.yi()+'">');W=W+this.ym();W=W+"</div>";W=W+('<div id="'+yb+'_jsxghost"'+' class="jsx30list_ghost">&#160;</div>');W=W+"</td></tr>";z=" onscroll=\"this.parentNode.parentNode.parentNode.childNodes[0].childNodes[0].childNodes[0].childNodes[0].style.left = -this.scrollLeft + 'px';\" ";}var
K=this.qk(m.Tk,5);var
Qb=gc.parentheight-y;W=W+('<tr><td height="'+(y==0?"100%":Qb)+'" valign="top" style="position:relative;height:'+Qb+"px"+'">');W=W+('<div id="'+yb+'_jsxbody"'+K+z+' style="'+this.Dg()+this.getBorder()+";height:"+Qb+"px"+'" class="jsx30list_bodyspan">');W=W+this.Ek();W=W+this.Zf();W=W+"</div>";W=W+"</td></tr>";W=W+"</table>";W=W+qc;W=W+"</div>";return W;};o.Dg=function(){return "background-color:"+(this.getBackgroundColor()?this.getBackgroundColor():m.DEFAULTBACKGROUNDCOLOR)+";";};o.mg=function(){return this.getBackground()?this.getBackground()+";":"";};o.xm=function(){return "background-color:"+(this.getBackgroundColorHead()?this.getBackgroundColorHead():m.DEFAULTBACKGROUNDCOLORHEAD)+";";};o.yi=function(){return this.getBackgroundHead()?this.getBackgroundHead()+";":m.DEFAULTBACKGROUNDHEAD;};o.Wg=function(){return this.getClassName()?this.getClassName():m.DEFAULTROWCLASS;};o._c=function(){return "height:"+(this.getHeaderHeight()?this.getHeaderHeight():m.DEFAULTHEADERHEIGHT)+"px;";};o.Zf=function(){return "";};o.ym=function(){var
qc='<table cellspacing="0" cellpadding="3" border="0" style="position:absolute;left:0px;top:0px;table-layout:fixed;'+this._c()+'">';qc=qc+('<tr style="'+this._c()+'" '+this.fo()+">");var
L=this.Le();var
U=this.getChildren();var
B=U.length;var
jc=0;for(var
xb=0;jc<=L.length;xb++)if(U[xb]==null||m.yK(U[xb])){if(jc==L.length){if(L.length>0)qc=qc+L[L.length-1].paint(true);}else if(xb<U.length){var
X=xb==this.getSortColumn()?this.getSortDirection():null;qc=qc+U[xb].paint(false,X);}jc++;}qc=qc+"</tr></table>";return qc;};o.Ek=function(){var
E='<table jsxid="'+this.getId()+'" cellspacing="0" cellpadding="3" border="0" style="table-layout:fixed;'+this.mg()+this.xp()+this.Ak()+this.Wm()+';">';E=E+this.doTransform();E=E+"</table>";return E;};o.repaintBody=function(){var
zb=this.getDocument();if(zb!=null){var
mb=zb.getElementById(this.getId()+"_jsxbody");if(mb!=null)jsx3.html.setOuterHTML(mb.childNodes[0],this.Ek());}};o.repaintHead=function(){var
w=this.getDocument();if(w!=null){var
Hb=w.getElementById(this.getId()+"_jsxhead");if(Hb!=null){jsx3.html.setOuterHTML(Hb.childNodes[0],this.ym());this.scrollHead();}}};o.scrollHead=function(){var
K=this.getDocument();var
ib=K.getElementById(this.getId()+"_jsxbody");if(ib&&ib.scrollLeft!=0){var
sc=K.getElementById(this.getId()+"_jsxhead");if(sc!=null)sc.childNodes[0].style.left=-ib.scrollLeft+"px";}};o.doTransform=function(n){var
lb={};if(n)lb.jsxrowid=n;lb.jsxtabindex=isNaN(this.getIndex())?0:this.getIndex();lb.jsxselectionbg=m.SELECTBGIMAGE;lb.jsxtransparentimage=jsx3.gui.Block.SPACE;lb.jsxid=this.getId();lb.jsxsortpath=this.dn();lb.jsxsortdirection=this.getSortDirection();lb.jsxrowclass=this.Wg();lb.jsxsorttype=this.getSortType();var
Mc=this.getXSLParams();for(var _b in Mc)lb[_b]=Mc[_b];var
mb=this.jsxsupermix(lb);mb=this.yp(mb);return mb;};m.onDelete=function(j,c){var
oc=jsx3.html.getJSXParent(c);if(oc instanceof m)oc.deleteRecord(j);};m.onCheck=function(i,d,p,c,e){var
_b=jsx3.gui.Event.getCurrent();if(d.substring(0,1)=="@")d=d.substring(1);var
z=jsx3.html.getJSXParent(p);if(c)p.checked=!p.checked;var
X=p.checked;var
w=X?e[0]:e[1];z.insertRecordProperty(i,d,w,false);z.doEvent("jsxafteredit",{objEVENT:_b,strATTRIBUTENAME:d,strATTRIBUTEVALUE:w,strRECORDID:i,objGUI:p,objMASK:null});if(_b)_b.cancelReturn();};m.onRadio=function(q,f,h,c,p){if(f.substring(0,1)=="@")f=f.substring(1);if(c)h.checked=true;m.onCheck(q,f,h,false,p);if(c){var
Bb=jsx3.html.getJSXParent(h);var
Db=Bb.getRecordNode(q);var
gb;if(Db!=null&&(gb=Db.getAttribute("jsxgroupname"))!=null){var
O=Bb.getXML().selectNodes("//record[@jsxgroupname='"+gb+"']");for(var
ab=0;ab<O.getLength();ab++){var
yc=O.getItem(ab);if(yc.getAttribute("jsxid")!=q)O.getItem(ab).setAttribute(f,p[1]);}}}};o.appendRow=function(l,j){var
qc=this.getDocument();if(qc!=null){var
dc=this.getId();var
Fb=qc.getElementById(dc+"_jsxbody").childNodes[0].childNodes[0];var
nb=true;if(j==null){j=jsx3.xml.CDF.getKey();nb=false;}if(l==null)l={jsxid:j};this.doEvent("jsxbeforeappend",{objMASTERRECORD:l});if(nb==false)this.insertRecord(l,null,false);var
eb=m.UN(this.doTransform(j));if(eb!=""){var
xc=new
jsx3.xml.Document();xc.loadXML(eb);if(!xc.hasError()){var
qb=qc.createElement("TR");var
S=xc.getRootNode();m.dP(S,qb);var
kc=S.selectNodes("td");for(var
K=0;K<kc.getLength();K++){S=kc.getItem(K);var
Ub=qc.createElement("TD");m.dP(S,Ub);qb.appendChild(Ub);var
ic=S.getChildNodes(true);var
gc="";for(var
rb=0;rb<ic.getLength();rb++)gc=gc+ic.getItem(rb).toString();Ub.innerHTML=gc;}Fb.appendChild(qb);this.doEvent("jsxafterappend",{objMASTERRECORD:l,objTR:qb});}else wc.warn("A new row could not be appended to "+this+" because of an XML error: "+xc.getError());}}};o.updateRow=function(p){var
t;if(this.getRecordNode(p)!=null&&(t=this.Ny(p))!=null){var
Cb=m.UN(this.doTransform(p));if(Cb!=""){var
Gc=new
jsx3.xml.Document();Gc.loadXML(Cb);if(!Gc.hasError()){var
Fc=Gc.getRootNode();m.dP(Fc,t);var
lb=Fc.selectNodes("td");for(var
Jb=0;Jb<lb.getLength();Jb++){Fc=lb.getItem(Jb);var
E=t.childNodes.item(Jb);m.dP(Fc,E);var
fb=Fc.getChildNodes(true);var
Zb="";for(var
wb=0;wb<fb.getLength();wb++)Zb=Zb+fb.getItem(wb).toString().replace(/&lt;/g,"<").replace(/&gt;/g,">").replace(/&amp;/g,"&");E.innerHTML=Zb;}}else jsx3.util.Logger.doLog("list.update.1","A row could not be updated, due to the following reasons(s): "+Gc.getError(),3,false);}}};m.dP=function(s,g){var
Rb=s.getAttributes();for(var
zc=0;zc<Rb.getLength();zc++){var
rb=Rb.getItem(zc);var
qb=rb.getNodeName();var
Lb=/(on(?:mousedown|click|focus|blur|mouseup|scroll|keydown|keypress))/gi;var
Pb=rb.getValue();if(qb.match(Lb)){g[qb.toLowerCase()]=new
Function(Pb);}else if(qb=="class"){g.className=Pb;}else if(qb=="style"){jsx3.gui.Painted.Be(g,Pb);}else g.setAttribute(qb,Pb);}};m.Kq=function(k,d){var
Ic=k.getAttributes();for(var
bc=0;bc<Ic.getLength();bc++){var
Bc=Ic.getItem(bc);var
W=Bc.getNodeName();var
C=/(on(?:mousedown|click|focus|blur|mouseup|scroll|mouseup|keydown|keypress))/gi;var
zb=Bc.getValue();if(W.match(C)){d[W]=new
Function(zb);}else if(W!="class"){d.setAttribute(W,zb);}else d.className=zb;}if(!d.tagName||d.tagName.toLowerCase()!="tr")d.style.position="relative";};m.UN=function(e){var
Jc=/(<(?:img|input)[^>]*)(>)/gi;e=e.replace(Jc,function(g,f,c){return f+"/>";});e=e.replace(/&nbsp;/g,"&#160;").replace(/&/g,"&amp;");return e;};o.getGrowBy=function(){return this.jsxgrowby;};o.setGrowBy=function(g){this.jsxgrowby=g;return this;};o.getAutoExpand=function(){return jsx3.Boolean.valueOf(this.getGrowBy());};o.setAutoExpand=function(c){return this.setGrowBy(c?1:0);};o.getSortType=function(){if(this.jsxsorttype==null){if(this.jsxsortcolumn!=null)return this.getChild(this.jsxsortcolumn)==null?"text":this.getChild(this.jsxsortcolumn).getDataType();var
C=this.getSortPath();for(var
Dc=this.getChildren().length-1;Dc>=0;Dc--){var
X=this.getChild(Dc);if(X instanceof jsx3.gui.Column&&X.getSortPath()==C)return this.getChild(Dc).getDataType();}return "text";}else return this.jsxsorttype;};o.setSortType=function(s){this.jsxsorttype=s;return this;};o.getMaskProperties=function(){return jsx3.gui.Block.MASK_NO_EDIT;};o.getWrap=function(){return this.jsxwrap==null?1:this.jsxwrap;};o.setWrap=function(h){this.resetXslCacheData();this.jsxwrap=h;return this;};o.onSetChild=function(j){return j instanceof jsx3.gui.Column;};o.Ih=function(p){var
v=this.getRecord(p);return v!=null&&(v["jsxunselectable"]==null||v["jsxunselectable"]!="1");};o.onDestroy=function(h){this.jsxsuper(h);this.onDestroyCached(h);this._jsxm5=true;};m.getVersion=function(){return "3.0.00";};});jsx3.gui.List.prototype.getResizeable=jsx3.gui.List.prototype.getResizable;jsx3.gui.List.prototype.setResizeable=jsx3.gui.List.prototype.setResizable;jsx3.gui.List.prototype.getCanResize=jsx3.gui.List.prototype.getResizable;jsx3.gui.List.prototype.setCanResize=jsx3.gui.List.prototype.setResizable;jsx3.gui.List.prototype.doClearSelections=jsx3.gui.List.prototype.deselectAllRecords;jsx3.gui.List.prototype.deselectRecords=jsx3.gui.List.prototype.deselectAllRecords;jsx3.List=jsx3.gui.List;
