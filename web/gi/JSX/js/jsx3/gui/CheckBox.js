/*
 * Copyright (c) 2001-2007, TIBCO Software Inc.
 * Use, modification, and distribution subject to terms of license.
 */
jsx3.require("jsx3.gui.Form","jsx3.gui.Block");jsx3.Class.defineClass("jsx3.gui.CheckBox",jsx3.gui.Block,[jsx3.gui.Form],function(n,f){n.UNCHECKED=0;n.CHECKED=1;n.PARTIAL=2;n.DEFAULTCLASSNAME="jsx30checkbox";f.init=function(g,r,m,e,b,q,d){this.jsxsuper(g,r,m,e,b,q);this.setDefaultChecked(d==null?1:d);this.jsxchecked=d;};f.getDefaultChecked=function(){return this.jsxdefaultchecked;};f.setDefaultChecked=function(c){this.jsxdefaultchecked=c;return this;};f.getChecked=function(){return this.jsxchecked!=null?this.jsxchecked:this.getDefaultChecked();};f.setChecked=function(l){if(this.jsxchecked!=l){this.jsxchecked=l;this.rJ();if(this.isOldEventProtocol())this.doEvent("jsxtoggle",{intCHECKED:l});}return this;};f.Th=function(s,m){if(!s.leftButton()&&s.isMouseEvent())return;if(this.getEnabled()==1){var
Vb=this.getChecked()==1?0:1;this.jsxchecked=Vb;this.rJ(m);this.doEvent("jsxtoggle",{objEVENT:s,intCHECKED:Vb});}};f.rJ=function(g){if(g==null)g=this.getRendered();if(g!=null){jsx3.html.selectSingleElm(g,0,0,0).checked=this.jsxchecked==1;jsx3.html.selectSingleElm(g,0,0,1).style.visibility=this.jsxchecked==2?"visible":"hidden";}};f.Rn=function(l,a){if(l.enterKey()){this.Th(l,a);l.cancelAll();}};n.Tk={};n.Tk["click"]=true;n.Tk["keydown"]=true;f.Vd=function(p,m,b){this.Qh(p,m,b,3);};f.zj=function(s){if(this.getParent()&&(s==null||isNaN(s.parentwidth)||isNaN(s.parentheight))){s=this.getParent().Ln(this);}else if(s==null)s={};var
tb=this.getRelativePosition()!=0&&(!this.getRelativePosition()||this.getRelativePosition()==1);var
ib,F,Eb,yb;if(s.tagname==null)s.tagname="span";if((ib=this.getBorder())!=null&&ib!="")s.border=ib;if(tb&&(F=this.getMargin())!=null&&F!="")s.margin=F;if(s.boxtype==null)s.boxtype=tb?"relativebox":"box";if(s.left==null)s.left=!tb&&!jsx3.util.strEmpty(this.getLeft())?this.getLeft():0;if(s.top==null)s.top=!tb&&!jsx3.util.strEmpty(this.getTop())?this.getTop():0;if(s.height==null)s.height=(Eb=this.getHeight())!=null?Eb:18;if(s.width==null)if((yb=this.getWidth())!=null)s.width=yb;var
fc=new
jsx3.gui.Painted.Box(s);var
pc={};pc.tagname="div";pc.boxtype="inline";var
oc=new
jsx3.gui.Painted.Box(pc);fc.Od(oc);var
pc={};pc.tagname="span";pc.boxtype="box";pc.width=16;pc.parentheight=fc.Zh();pc.height=18;pc.left=0;pc.top=0;var
uc=new
jsx3.gui.Painted.Box(pc);oc.Od(uc);var
pc={};pc.tagname="input[checkbox]";pc.empty=true;pc.omitpos=true;var
Nb=new
jsx3.gui.Painted.Box(pc);uc.Od(Nb);var
pc={};pc.tagname="span";pc.boxtype="box";pc.left=3;pc.top=7;pc.width=7;pc.height=2;var
Ib=new
jsx3.gui.Painted.Box(pc);uc.Od(Ib);var
pc={};pc.tagname="span";pc.boxtype="inline";pc.top=2;pc.parentheight=fc.Zh();pc.height=18;pc.padding="0 0 0 18";var
Bc=new
jsx3.gui.Painted.Box(pc);fc.Od(Bc);return fc;};f.paint=function(){this.applyDynamicProperties();var
wc=this.getEnabled()==1;var
Ub=wc?this.qk(n.Tk,0):"";var
Fc=this.renderAttributes(null,true);var
Y=this.getChecked()==2?"visible":"hidden";var
O=wc?"":"background-color:#999999;";var
ac=this.vi(true);ac.setAttributes(' id="'+this.getId()+'"'+this.so()+' class="'+this.Wg()+'" unselectable="on" '+this.fo()+this.pl()+Ub+Fc);ac.setStyles((ac.Oj()?"overflow-x:hidden;":"")+this.Nh()+this.Ak()+this.xp()+this.Wm()+this.Eo()+this.Dg()+this.Af()+this.Dh()+this.vl()+this.ji());var
v=ac.tp(0);var
wb=v.tp(0);wb.setAttributes(' class="jsx30checkbox_tristate" ');var
U=wb.tp(0);U.setAttributes(' type="checkbox" name="'+this.getName()+'" '+this.pl()+this.z2()+this.vo());var
Hc=wb.tp(1);Hc.setAttributes(' class="jsx30checkbox_partial" ');Hc.setStyles("visibility:"+Y+";"+O);var
Jc=ac.tp(1);Jc.setAttributes(' unselectable="on" ');return ac.paint().join(v.paint().join(wb.paint().join(U.paint().join("")+Hc.paint().join("&#160;"))+Jc.paint().join(this.im())));};f.Nh=function(){return this.getCursor()==null?"cursor:pointer;":"cursor:"+this.getCursor()+";";};f.z2=function(){return this.getChecked()==1?' checked="checked" ':"";};f.Wg=function(){var
eb=this.getClassName();return n.DEFAULTCLASSNAME+(eb?" "+eb:"");};f.doValidate=function(){this.setValidationState(this.getRequired()==0||this.getChecked()==1?1:0);return this.getValidationState();};n.getVersion=function(){return "3.0.00";};f.emGetType=function(){return jsx3.gui.Matrix.EditMask.FORMAT;};f.emInit=function(q){this.jsxsupermix(q);this.subscribe("jsxtoggle",this,"kQ");};f.emSetValue=function(s){this.jsxchecked=Number(s)==1?1:0;};f.emGetValue=function(){var
B=this.emGetSession();if(B)return B.column.getValueForRecord(B.recordId);return null;};f.emBeginEdit=function(j,a,b,s,k,c,r){var
ab=jsx3.html.selectSingleElm(r,0,0,0,0,0);if(ab&&!ab.getAttribute("disabled")){this.jsxsupermix(j,a,b,s,k,c,r);ab.focus();}else return false;};f.emPaintTemplate=function(){this.jsxchecked=0;this.setText("");this.setEnabled(0);var
yc=this.paint();this.setEnabled(1);var
kb=this.paint();var
u=this.To(kb,yc);u=u.replace(/<(input .*?)\/>/g,"<$1><xsl:if test=\"{0}='1'\"><xsl:attribute name=\"checked\">checked</xsl:attribute></xsl:if></input>");return u;};f.kQ=function(m){var
fb=this.emGetSession();if(fb){var
_=m.context.intCHECKED;this.jsxchecked=_;fb.column.setValueForRecord(fb.recordId,_.toString());}};});jsx3.CheckBox=jsx3.gui.CheckBox;
