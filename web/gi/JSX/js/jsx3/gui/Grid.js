/*
 * Copyright (c) 2001-2007, TIBCO Software Inc.
 * Use, modification, and distribution subject to terms of license.
 */
jsx3.require("jsx3.gui.List");jsx3.Class.defineClass("jsx3.gui.Grid",jsx3.gui.List,null,function(l,o){var
B=jsx3.util.Logger.getLogger(l.jsxclass.getName());var
Ub=jsx3.gui.Event;l.DEFAULTXSLURL=jsx3.resolveURI("jsx:///xsl/"+(jsx3.CLASS_LOADER.IE?"ie":"fx")+"/jsx30grid.xsl");l.SELECTBGIMAGE="url("+jsx3.resolveURI("jsx:///images/grid/select.gif")+")";l.DEFAULTBACKGROUND="background-image:url("+jsx3.resolveURI("jsx:///images/list/grid.gif")+");";l.DEFAULTBACKGROUNDHEAD="background-image:url("+jsx3.resolveURI("jsx:///images/list/header.gif")+");";jsx3.html.loadImages("jsx:///images/grid/select.gif","jsx:///images/list/grid.gif","jsx:///images/list/header.gif");l.DEFAULTBACKGROUNDCOLOR="#c8cfd8";l.DEFAULTBACKGROUNDCOLORHEAD="#c8cfd8";l.DEFAULTROWCLASS="jsx30list_r2";o.init=function(n){this.jsxsuper(n);};o.Hs=function(){this._jsxxe=null;this._jsxcellindex=null;this._jsxrowid=null;};o.getTabListener=function(){return this.jsxtablistener;};o.setTabListener=function(q){this.jsxtablistener=q;return this;};o.paint=function(){this.resetMask();this.Hs();return this.jsxsuper();};o.getClassName=function(){return this.jsxclassname==null?l.DEFAULTROWCLASS:this.jsxclassname;};o.getXSL=function(){return this.Mn(l.DEFAULTXSLURL);};o.doValidate=function(){return this.setValidationState(1).getValidationState();};o.Dg=function(){return "background-color:"+(this.getBackgroundColor()?this.getBackgroundColor():l.DEFAULTBACKGROUNDCOLOR)+";";};o.mg=function(){return this.getBackground()?this.getBackground()+";":l.DEFAULTBACKGROUND;};o.de=function(b,k){this.resetMask();this.jsxsuper(b,k);};o.resetMask=function(m){if(m||(m=this.getActiveMask())!=null)m.setVisibility("hidden",true).setLeft(0,true).setTop(0,true);};o.doSort=function(n){var
qc;if(qc=this.getActiveMask())this.onAfterEdit(null,qc);this.resetMask();this.jsxsuper(n);};o.repaintBody=function(){this.resetMask();this.jsxsuper();};o.doBlurItem=function(e){};o.doFocusItem=function(f,s){var
qb=Ub.getCurrent();var
oc=f.ownerDocument;var
ic=f.parentNode.id.substring(this.getId().length+1);if(!this.Ih(ic))return;var
vc=f!=this._jsxxe||s;if(vc&&this._jsxcurmask!=null&&(s==true||s!=true&&!(this._jsxcurmask instanceof jsx3.gui.TextBox))){this.onAfterEdit(this._jsxxe,this._jsxcurmask);}else if(vc&&this._jsxcurmask!=null)this.resetMask();try{f.focus();if(this._jsxxe!=null)this._jsxxe.style.backgroundImage=this._jsxxe.prevBG!=null?this._jsxxe.prevBG:"";if(this.getGrowBy()>0&&f.parentNode==f.parentNode.parentNode.lastChild)this.appendRow();}catch(Kc){var
vb=oc.getElementById(this._jsxrowid);if(vb!=null)vb.childNodes[this._jsxcellindex].style.backgroundImage="";return false;}f.prevBG=f.style.backgroundImage;f.style.backgroundImage=l.SELECTBGIMAGE;this._jsxxe=f;this._jsxcellindex=f.cellIndex;this._jsxrowid=f.parentNode.id;var
Jb=this.Le()[this._jsxcellindex];if(s==null){var
db=f.getAttribute("jsxmask");if(!jsx3.util.strEmpty(db)&&db!="jsxnull"){var
lb=Jb.getDescendantOfName(db)||this.getDescendantOfName(db);this.O0(qb,f,lb);}else this.doEvent("jsxselect",{objEVENT:qb,strRECORDID:ic,intCOLUMNINDEX:this._jsxcellindex});}};o.O0=function(c,j,r){this.resetMask();this._jsxcurmask=r;var
x=this.Le()[this._jsxcellindex].getPath().replace(/@/g,"");var
rc=this.getSelectedId();r.setValue();var
jc=this.doEvent("jsxbeforeedit",{objEVENT:c,strATTRIBUTENAME:x,strRECORDID:rc,objMASK:r,intCOLUMNINDEX:this._jsxcellindex});if(jc!==false&&j!=null&&r!=null){var
kb=j.ownerDocument;var
db=this.getHeaderHeight()===0||this.getHeaderHeight()?this.getHeaderHeight():jsx3.gui.List.DEFAULTHEADERHEIGHT;r._jsxvalidrow=j.parentNode.id;var
ib=kb.getElementById(this.getId()+"_jsxbody");var
yc=this.getRecord(rc);var
Ac=yc[x];if(Ac==null)Ac="";var
Tb=this.getAbsolutePosition(this.getRendered(),j);if(r instanceof jsx3.gui.TextBox){r.setLeft(Tb.L+ib.scrollLeft,true);r.setTop(Tb.T-db+ib.scrollTop,true);r.setWidth(Tb.W-1,true);r.setHeight(Tb.H-1,true);r.setValue(Ac);r._jsxprevmaskvalue=Ac;r.setVisibility("",true);if((j=r.getRendered())&&j.scrollHeight>j.offsetHeight)r.setHeight(Tb.H-1+Tb.H,true);if(r.getType()==1){r.focus();r.getRendered().select();}else{r.focus();if(kb.selection){var
vc=kb.selection.createRange();vc.move("sentence",-1);vc.moveEnd("character",Ac.length);vc.select();}}}else if(r instanceof jsx3.gui.ToolbarButton||r instanceof jsx3.gui.Menu){r.setLeft(Tb.L+Tb.W-r.getAbsolutePosition().W+ib.scrollLeft+(r instanceof jsx3.gui.Menu?2:0),true);r.setTop(Tb.T-db+ib.scrollTop-2,true);r.setVisibility("",true);r._jsxvalue=Ac==""?null:Ac;r._jsxprevmaskvalue=Ac;if(c.ctrlKey())if(r instanceof jsx3.gui.Menu){r.showMenu(c,r.getRendered(),1);}else r.focus();}else if(r instanceof jsx3.gui.Select){if(r.getValue()==null){r.setValue(Ac==""?null:Ac);r.setText(Ac==null?"":Ac);}r.setLeft(Tb.L+ib.scrollLeft,true);r.setTop(Tb.T-db+ib.scrollTop,true);r.setWidth(Tb.W-1,true);r.setHeight(Tb.H-1,true);r._jsxprevmaskvalue=r.getValue();r.setVisibility("",true);if(c.ctrlKey()){r.show();}else r.focus();}delete this._jsxisblur;}};o.doMaskKeyDown=function(q,s){if(s==null)s=Ub.getCurrent();var
dc=false;var
tb=s.keyCode();var
_=tb>36&&tb<41;if((s.enterKey()||s.tabKey())&&!s.ctrlKey()||_&&(s.ctrlKey()||s.altKey())){if(s.enterKey()&&s.shiftKey()||tb==38){s.setKeyCode(38);}else if(s.enterKey()||tb==40){s.setKeyCode(40);}else if(s.tabKey()&&s.shiftKey()&&!(!this.getTabListener()||this.getTabListener()==1)){try{this.focus();return;}catch(Kc){}}else if(s.tabKey()&&!(!this.getTabListener()||this.getTabListener()==1))try{this.getRendered().lastChild.focus();return;}catch(Kc){}this._jsxisblur=this.getActiveMask()&&this.getActiveMask() instanceof jsx3.gui.TextBox;this.Rn(s,q);dc=true;}else if(s.ctrlKey()&&s.enterKey()){var
Hb=this.getDocument().selection.createRange();Hb.text="\n";Hb.select();dc=true;}else if(_)dc=true;if(dc)s.cancelBubble();};o.getSelectedId=function(){if(this._jsxrowid!=null){var
Wb=this.getRendered();if(Wb){var
Bc=Wb.ownerDocument.getElementById(this._jsxrowid);if(Bc!=null)return this._jsxrowid.substring(this.getId().length+1);}this.Hs();}return null;};o.getActiveMask=function(){return this._jsxcurmask;};o.getActiveCell=function(){return this._jsxxe;};o.getActiveRow=function(){var
O;return (O=this.getActiveCell())?O.parentNode:null;};o.getActiveAttribute=function(){if(this._jsxcellindex){var
qc=this.Le()[this._jsxcellindex];if(qc)return qc.getPath().replace(/@/g,"");}return null;};o.onAfterEdit=function(d,p,b,n){var
fb=Ub.getCurrent();var
Jc=this.Le()[this._jsxcellindex].getPath().replace(/@/g,"");var
Sb=this.getSelectedId();if(d==null)d=this._jsxxe;var
t=d&&d.parentNode?d.parentNode.id:null;if(p._jsxvalidrow==null||p._jsxvalidrow!=t){B.warn("onAfterEdit called for invalid row "+t);return;}if(!(jsx3.util.strEmpty(d.getAttribute("jsxmask"))||d.getAttribute("jsxmask")=="jsxnull"))if(p==null||typeof p.getValue=="function"&&p.getValue()!=p._jsxprevmaskvalue){var
ec=this.doEvent("jsxafteredit",{objEVENT:fb,strATTRIBUTENAME:Jc,strRECORDID:Sb,objMASK:p,objGUI:d,intCOLUMNINDEX:this._jsxcellindex});if(ec!==false&&p!=null){this.updateCell(Jc,Sb,d,p);if(b&&p instanceof jsx3.gui.Menu)this.getActiveCell().focus();}}if(p!=null&&n!==true){this.resetMask(p);delete this._jsxcurmask;delete p._jsxvalidrow;}};o.updateCell=function(g,f,d,p){if(p==null)p=this.getActiveMask();if(d==null)d=this._jsxxe;if(p&&d){if(g==null)g=this.Le()[this._jsxcellindex].getPath().replace(/@/g,"");if(f==null)f=this.getSelectedId();var
K=typeof p.getMaskValue=="function"?p.getMaskValue():p.getValue();if(K==null)K="";this.insertRecordProperty(f,g,K,true);}};o.Rn=function(a,d){if(this.jsxsupermix(a,d))return;if(this._jsxxe==null||this._jsxxe.parentNode==null)return;var
Cc=this._jsxxe;var
V=this.Le().length;var
tc=a.keyCode();var
dc=tc>=37&&tc<=40||tc==9&&(!this.getTabListener()||this.getTabListener()==1);var
zb=dc;if(dc){var
F=null;var
y=Cc==Cc.parentNode.firstChild;var
nb=Cc.cellIndex>=V-1;var
yb=Cc.parentNode==Cc.parentNode.parentNode.firstChild;var
eb=Cc.parentNode==Cc.parentNode.parentNode.lastChild;if(tc==37||a.shiftKey()&&tc==9){if(tc==9)tc=37;if(y){if(yb)F=Cc;else F=Cc.parentNode.previousSibling.childNodes[V-1];}else F=Cc.previousSibling;}else if(tc==38){if(yb)F=Cc;else F=Cc.parentNode.previousSibling.childNodes[Cc.cellIndex];}else if(tc==39||tc==9){if(tc==9)tc=39;if(nb){if(eb)F=Cc;else F=Cc.parentNode.nextSibling.childNodes[0];}else F=Cc.nextSibling;}else if(tc==40)if(eb)F=Cc;else F=Cc.parentNode.nextSibling.childNodes[Cc.cellIndex];this.doFocusItem(F,true);}else if(tc==13){}else if(tc==9&&a.shiftKey()){this.focus();zb=true;}else if(tc==9){this.getRendered().lastChild.focus();zb=true;}if(zb){a.cancelBubble();a.cancelReturn();}};o.doExecute=function(k,m){this.Wf(this.isOldEventProtocol(),k,m);};o.Wf=function(a,f,r){if(f==null&&this._jsxrowid)f=this._jsxrowid.substring(this.getId().length+1);if(r==null)r=this._jsxcellindex;if(f==null)return;if(!this.Ih(f))return;var
A=this.getRecordNode(f);if(A!=null)this.eval(A.getAttribute("jsxexecute"),{strRECORDID:f,intCOLUMNINDEX:r});if(a)this.doEvent("jsxexecute",{objEVENT:a instanceof Ub?a:null,strRECORDID:f,intCOLUMNINDEX:r});};o.Th=function(n,r){var
lb=n.srcElement();if(lb.tagName=="TBODY"||lb.tagName=="TR")return;var
_b=this.getRendered();while(lb.tagName!="TD"&&lb!=_b)lb=lb.parentNode;if(lb.tagName=="TD"){if(lb.parentNode.getAttribute("JSXDragId")==null)return;if(lb.cellIndex==this.Le().length)return;lb.focus();n.cancelBubble();n.cancelReturn();}};o.Zf=function(){var
rc="";var
Xb=this.Le();var
pc=Xb.length;for(var
fc=0;fc<pc;fc++){var
pb=Xb[fc];var
Zb=pb.getChildren();for(var
ab=0;ab<Zb.length;ab++)rc=rc+Zb[ab].paint();}return rc;};o.redrawRecord=function(k,n){if(n==0)this.resetMask();this.jsxsuper(k,n);};l.getVersion=function(){return "3.0.00";};});jsx3.Grid=jsx3.gui.Grid;
