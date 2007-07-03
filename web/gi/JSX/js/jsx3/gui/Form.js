/*
 * Copyright (c) 2001-2007, TIBCO Software Inc.
 * Use, modification, and distribution subject to terms of license.
 */
jsx3.Class.defineInterface("jsx3.gui.Form",null,function(p,c){var
kc=jsx3.gui.Event;p.DEFAULTDISABLEDCOLOR="#a8a8b5";p.DEFAULTDISABLEDBACKGROUNDCOLOR="#d8d8e5";p.STATEINVALID=0;p.STATEVALID=1;p.STATEDISABLED=0;p.STATEENABLED=1;p.OPTIONAL=0;p.REQUIRED=1;c.doKeyBinding=function(a,h){var
hb=jsx3.gui.HotKey.valueOf(h,a);return this.Qu().registerHotKey(hb);};c.Qu=function(){var
zc=jsx3.gui.Window!=null;var
Jc=jsx3.gui.Dialog!=null;var
W=this;while(W!=null){if(zc&&W instanceof jsx3.gui.Window)return W.getRootBlock();if(Jc&&W instanceof jsx3.gui.Dialog)return W;var
jb=W.getParent();if(jb==null)return W.getServer();W=jb;}return null;};c.getKeyBinding=function(){return this.jsxkeycode==null?null:this.jsxkeycode;};c.setKeyBinding=function(k){this.jsxkeycode=k;return this;};c.getDisabledBackgroundColor=function(){return this.jsxdisabledbgcolor;};c.setDisabledBackgroundColor=function(r){this.jsxdisabledbgcolor=r;return this;};c.Dg=function(){var
v=this.getEnabled()!=0?this.getBackgroundColor():this.getDisabledBackgroundColor();return v?"background-color:"+v+";":"";};c.getDisabledColor=function(){return this.jsxdisabledcolor;};c.setDisabledColor=function(e){this.jsxdisabledcolor=e;return this;};c.getEnabled=function(){return this.jsxenabled==null?1:this.jsxenabled;};c.getValue=function(){return this.jsxvalue;};c.setValue=function(d){this.jsxvalue=d;return this;};c.setEnabled=function(k,g){if(this.jsxenabled!=k){this.jsxenabled=k;if(g)this.repaint();}return this;};c.Eo=function(){if(this.getEnabled()!=0){var
Tb=this.getColor();return Tb?"color:"+Tb+";":"";}else return "color:"+(this.getDisabledColor()?this.getDisabledColor():p.DEFAULTDISABLEDCOLOR)+";";};c.pl=function(){return this.getEnabled()==1?"":' disabled="disabled" ';};c.vo=function(){return jsx3.gui.Block.prototype.vo.call(this,this.getIndex()||Number(0));};c.getRequired=function(){return this.jsxrequired==null?0:this.jsxrequired;};c.setRequired=function(e){this.jsxrequired=e;return this;};c.getValidationState=function(){return this._jsxuW==null?1:this._jsxuW;};c.setValidationState=function(a){this._jsxuW=a;return this;};c.doValidate=jsx3.Method.newAbstract();c.doReset=function(){this.setValidationState(1);return this;};p.validate=function(i,l){var
Db=i.getDescendantsOfType(jsx3.gui.Form);if(i.instanceOf(jsx3.gui.Form))Db.unshift(i);var
V=1;for(var
xc=0;xc<Db.length;xc++){var
kb=Db[xc].doValidate();if(l)l(Db[xc],kb);if(kb!=1)V=kb;}return V;};p.reset=function(g){var
lb=g.getDescendantsOfType(jsx3.gui.Form);if(g.instanceOf(jsx3.gui.Form))lb.unshift(g);for(var
R=0;R<lb.length;R++)lb[R].doReset();};p.getVersion=function(){return "3.00.00";};c.emInit=function(e){if(this.emGetType()==jsx3.gui.Matrix.EditMask.NORMAL){this.setRelativePosition(0,true);this.setDisplay("none",true);}};c.emGetType=function(){return jsx3.gui.Matrix.EditMask.NORMAL;};c.emPaintTemplate=function(){throw new
jsx3.Exception("Not implemented.");};c.To=function(o,d){return "<xsl:choose xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\"><xsl:when test=\"@jsxnomask='1'\"></xsl:when><xsl:when test=\"@jsxdisabled='1'\">"+d+"</xsl:when>"+"<xsl:otherwise>"+o+"</xsl:otherwise>"+"</xsl:choose>";};c.emBeginEdit=function(m,b,d,r,l,n,s){if(this.emGetType()==jsx3.gui.Matrix.EditMask.NORMAL){this.setRelativePosition(0,true);this.emUpdateDisplay(b,d);this.setDisplay("",true);this.setZIndex(10,true);this.focus();this.emFocus();}this.emSetValue(m);};c.emEndEdit=function(){if(this.emGetType()==jsx3.gui.Matrix.EditMask.NORMAL)this.emRestoreDisplay();return this.emGetValue();};c.emSetValue=function(i){this.setValue(i);};c.emGetValue=function(){var
Fb=this.getValue();return Fb!=null?Fb.toString():null;};c.emUpdateDisplay=function(o,s){var
Fb=this.emGetSession();var
Mb=this.getWidth(),nb=this.getHeight();Fb.width=Mb;Fb.height=nb;var
Cc=isNaN(Mb)?o.W:Math.min(parseInt(Mb),o.W);var
uc=isNaN(nb)?o.H:Math.min(parseInt(nb),o.H);this.setDimensions(o.L,o.T,Cc,uc,true);};c.emRestoreDisplay=function(){this.setDisplay("none",true);var
qc=this.emGetSession();this.setWidth(qc.width,false);this.setHeight(qc.height,false);};c.emFocus=function(){};});jsx3.Form=jsx3.gui.Form;
