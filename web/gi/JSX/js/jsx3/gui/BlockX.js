/*
 * Copyright (c) 2001-2007, TIBCO Software Inc.
 * Use, modification, and distribution subject to terms of license.
 */
jsx3.require("jsx3.xml.Cacheable","jsx3.gui.Block");jsx3.Class.defineClass("jsx3.gui.BlockX",jsx3.gui.Block,[jsx3.xml.Cacheable],function(a,g){g.init=function(n,k,f,l,i){this.jsxsuper(n,k,f,l,i);};g.paint=function(){this.applyDynamicProperties();return this.jsxsuper(this.doTransform());};g.getXSLString=function(){return this.jsxxsl;};g.setXSLString=function(h){this.jsxxsl=h;return this;};g.getXSLURL=function(){return this.jsxxslurl;};g.setXSLURL=function(m){this.jsxxslurl=m;return this;};g.getXSL=function(){var
Ob=jsx3.xml.XslDocument;var
cc=this.getXSLId();var
Yb=this.getServer().getCache();var
Dc=Yb.getDocument(cc);if(Dc==null){if(this.getXSLString()!=null){Dc=(new
Ob()).loadXML(this.getXSLString());}else if(this.getXSLURL()!=null){Dc=(new
Ob()).load(this.getUriResolver().resolveURI(this.getXSLURL()));}else Dc=jsx3.getSharedCache().getOrOpenDocument(jsx3.xml.Cacheable.DEFAULTSTYLESHEET,null,Ob.jsxclass);if(Dc.hasError()){jsx3.util.Logger.getLogger(a.jsxclass.getName()).error(jsx3._msg("xml.err_load_xsl",this,Dc.getError()));return Dc;}Yb.setDocument(cc,Dc);}return Dc;};g.onDestroy=function(k){this.jsxsuper(k);this.onDestroyCached(k);};a.getVersion=function(){return "3.00.00";};});jsx3.BlockX=jsx3.gui.BlockX;
