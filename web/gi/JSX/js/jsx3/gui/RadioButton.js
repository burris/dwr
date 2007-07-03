/*
 * Copyright (c) 2001-2007, TIBCO Software Inc.
 * Use, modification, and distribution subject to terms of license.
 */
jsx3.require("jsx3.gui.Form","jsx3.gui.Block");jsx3.Class.defineClass("jsx3.gui.RadioButton",jsx3.gui.Block,[jsx3.gui.Form],function(k,f){k.UNSELECTED=0;k.SELECTED=1;k.DEFAULTCLASSNAME="jsx30radio";f.init=function(e,a,o,c,s,j,n,r,g){this.jsxsuper(e,a,o,c,s,j);this.setGroupName(r);this.setValue(n);this.setDefaultSelected(g==null?1:g);if(g!=null)this.setSelected(g);};f.getGroupName=function(){return this.jsxgroupname;};f.setGroupName=function(e){this.jsxgroupname=e;};f.Th=function(c,j){if(!c.leftButton()&&c.isMouseEvent())return;if(this.getSelected()!=1){var
oc=this.doEvent("jsxselect",{objEVENT:c});if(oc!==false)this.setSelected(1,j);}};f.Rn=function(p,i){if(p.enterKey()){this.Th(p,i);p.cancelAll();}};f.getDefaultSelected=function(){return this.jsxdefaultselected;};f.setDefaultSelected=function(i){this.jsxdefaultselected=i;return this;};f.getSelected=function(){return this.jsxselected!=null?this.jsxselected:this.getDefaultSelected();};f.setSelected=function(s,l){s=s!=null?s:1;this.jsxselected=s;if(l==null)l=this.getRendered();if(l){jsx3.html.selectSingleElm(l,0,0,0).checked=s==1;if(s==1){var
sb=this.getSiblings();for(var
K=0;K<sb.length;K++)sb[K].jsxselected=0;}}return this;};f.getSiblings=function(g){var
nb=[];var
Xb=this.getDocument();if(Xb==null)return nb;var
qc=this.getId();var
Y=Xb.getElementsByName(this.getGroupName());for(var
xc=0;xc<Y.length;xc++){var
nc=Y[xc];if(nc.nodeName.toLowerCase()=="input"&&nc.type.toLowerCase()=="radio"){var
Gc=nc.parentNode.parentNode.parentNode;if(Gc.id!=qc)nb.push(g?[jsx3.GO(Gc.id),Gc]:jsx3.GO(Gc.id));}}return nb;};k.getValue=function(n){var
x=document;if(x!=null){var
ib=x.getElementsByName(n);if(ib!=null){var
Z=ib.length;for(var
zc=0;zc<Z;zc++)if(ib[zc].checked)return ib[zc].value;}}};k.setValue=function(j,r){var
eb=document;if(eb==null)return null;var
jb=eb.getElementsByName(j);if(jb!=null){var
hc=jb.length;for(var
qb=0;qb<hc;qb++)if(jb[qb].value==r){var
Ib=jsx3.GO(jb[qb].parentNode.parentNode.parentNode.id);Ib.setSelected(1);return Ib;}}return null;};f.getValue=function(){return this.jsxvalue;};f.setValue=function(h){this.jsxvalue=h;return this;};f.getGroupValue=function(){if(this.getSelected()==1)return this.getValue();var
W=this.getSiblings();for(var
Lb=0;Lb<W.length;Lb++){var
kc=W[Lb];if(kc.getSelected()==1)return kc.getValue();}return null;};f.setGroupValue=function(n){if(this.getValue()==n){if(this.getSelected()!=1)this.setSelected(1);}else{this.jsxselected=0;var
B=this.getSiblings(true);for(var
qb=0;qb<B.length;qb++){var
sb=B[qb][0];var
bb=B[qb][1];var
ub=sb.getValue()==n;sb.jsxselected=ub?1:0;jsx3.html.selectSingleElm(bb,0,0,0).checked=ub;}}};f.doValidate=function(){this.setValidationState(this.getRequired()==0||this.getGroupValue()!=null?1:0);return this.getValidationState();};k.Tk={};k.Tk["click"]=true;k.Tk["keydown"]=true;f.Vd=function(j,c,l){this.Qh(j,c,l,3);};f.zj=function(b){if(this.getParent()&&(b==null||isNaN(b.parentwidth)||isNaN(b.parentheight))){b=this.getParent().Ln(this);}else if(b==null)b={};var
ab=this.getRelativePosition()!=0&&(!this.getRelativePosition()||this.getRelativePosition()==1);var
T,_b,tc,yb;if(b.tagname==null)b.tagname="span";if((T=this.getBorder())!=null&&T!="")b.border=T;if(ab&&(_b=this.getMargin())!=null&&_b!="")b.margin=_b;if(b.boxtype==null)b.boxtype=ab?"relativebox":"box";if(b.left==null)b.left=!ab&&!jsx3.util.strEmpty(this.getLeft())?this.getLeft():0;if(b.top==null)b.top=!ab&&!jsx3.util.strEmpty(this.getTop())?this.getTop():0;if(b.height==null)b.height=(tc=this.getHeight())!=null?tc:18;if(b.width==null)if((yb=this.getWidth())!=null)b.width=yb;var
N=new
jsx3.gui.Painted.Box(b);var
nc={};nc.tagname="div";nc.boxtype="inline";var
bc=new
jsx3.gui.Painted.Box(nc);N.Od(bc);nc={};nc.tagname="span";nc.boxtype="box";nc.width=16;nc.parentheight=N.Zh();nc.height=18;var
Bc=new
jsx3.gui.Painted.Box(nc);bc.Od(Bc);nc={};nc.tagname="input[radio]";nc.empty=true;nc.omitpos=true;var
u=new
jsx3.gui.Painted.Box(nc);Bc.Od(u);nc={};nc.tagname="span";nc.boxtype="inline";nc.top=2;nc.parentheight=N.Zh();nc.height="100%";nc.padding="0 0 0 18";var
W=new
jsx3.gui.Painted.Box(nc);N.Od(W);return N;};f.paint=function(){this.applyDynamicProperties();var
Yb=this.getEnabled()==1;var
Rb=Yb?this.qk(k.Tk,0):"";var
rc=this.renderAttributes(null,true);var
eb=this.vi(true);eb.setAttributes(' id="'+this.getId()+'"'+this.so()+' class="'+this.Wg()+'" unselectable="on" '+this.fo()+this.pl()+Rb+rc);eb.setStyles((eb.Oj()?"overflow-x:hidden;":"")+this.Nh()+this.Ak()+this.xp()+this.Wm()+this.Eo()+this.Dg()+this.Af()+this.Dh()+this.vl()+this.ji());var
zb=eb.tp(0);var
xc=zb.tp(0);xc.setAttributes(' class="jsx30radio_tristate" ');var
pc=xc.tp(0);pc.setAttributes(' type="radio" name="'+this.getGroupName()+'" value="'+this.getValue()+'" '+this.pl()+this.paintSelected()+this.vo());var
S=eb.tp(1);S.setAttributes(' unselectable="on" ');return eb.paint().join(zb.paint().join(xc.paint().join(pc.paint().join(""))+S.paint().join(this.im())));};f.Nh=function(){return this.getCursor()==null?"cursor:hand;":"cursor:"+this.getCursor()+";";};f.paintSelected=function(){return this.getSelected()==1?' checked="checked" ':"";};f.Wg=function(){var
X=this.getClassName();return k.DEFAULTCLASSNAME+(X?" "+X:"");};k.getVersion=function(){return "3.0.00";};f.emGetType=function(){return jsx3.gui.Matrix.EditMask.FORMAT;};f.emInit=function(o){this.jsxsupermix(o);this.subscribe("jsxselect",this,"H7");};f.emSetValue=function(i){this.jsxselected=Number(i)==1?1:0;};f.emGetValue=function(){var
fb=this.emGetSession();if(fb)return fb.column.getValueForRecord(fb.recordId);return null;};f.emBeginEdit=function(d,h,g,i,b,l,c){var
ic=jsx3.html.selectSingleElm(c,0,0,0,0,0);if(ic&&!ic.getAttribute("disabled")){this.jsxsupermix(d,h,g,i,b,l,c);ic.focus();}else return false;};f.emPaintTemplate=function(){this.jsxselected=0;this.setText("");this.setEnabled(0);var
nc=this.paint();this.setEnabled(1);var
tb=this.paint();var
Ub=this.To(tb,nc);Ub=Ub.replace(/<(input .*?)\/>/g,"<$1><xsl:if test=\"{0}='1'\"><xsl:attribute name=\"checked\">checked</xsl:attribute></xsl:if><xsl:if test=\"@jsxdisabled='1'\"><xsl:attribute name=\"disabled\">disabled</xsl:attribute></xsl:if></input>");return Ub;};f.H7=function(a){var
V=this.emGetSession();if(V){var
gc=V.column.getPath();var
Yb=V.matrix.getXML().selectNodeIterator("//record[@"+gc+"='1']");while(Yb.hasNext()){var
cb=Yb.next();cb.removeAttribute(gc);}V.column.setValueForRecord(V.recordId,"1");}};});jsx3.RadioButton=jsx3.gui.RadioButton;
