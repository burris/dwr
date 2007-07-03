/*
 * Copyright (c) 2001-2007, TIBCO Software Inc.
 * Use, modification, and distribution subject to terms of license.
 */
jsx3.Class.defineClass("jsx3.app.UserSettings",null,null,function(o,g){var
C=jsx3.xml.Entity;var
A=jsx3.util.Logger.getLogger(o.jsxclass.getName());o.PERSIST_SESSION=1;o.PERSIST_INDEFINITE=2;g.QY=null;g.dV=null;g.zI=null;g.init=function(e,n){if(n==null)n=2;this.QY=e;this.dV=n;var
wc=this.CJ();this.zI=o.ux(wc);};g.get=function(i){var
Fb=this.zI;for(var
wb=0;wb<arguments.length;wb++){if(typeof Fb!="object"||Fb instanceof Array)return null;Fb=Fb[arguments[wb]];}return Fb;};g.set=function(a,k){var
oc=this.zI;for(var
Mc=0;Mc<arguments.length-2;Mc++){var
ab=oc[arguments[Mc]];if(typeof ab!="object"||ab instanceof Array)ab=oc[arguments[Mc]]=null;if(ab==null)ab=oc[arguments[Mc]]={};oc=ab;}oc[arguments[arguments.length-2]]=arguments[arguments.length-1];return oc;};g.remove=function(m){var
fb=this.zI;for(var
ac=0;ac<arguments.length-1;ac++){var
Zb=fb[arguments[ac]];if(Zb==null||typeof Zb!="object"||Zb instanceof Array)return;fb=Zb;}delete fb[arguments[arguments.length-1]];};g.clear=function(){this.zI={};var
fc=this.KY();var
pb=this.QY.getSettings();var
gb=pb.get("user-settings","domain");var
kb=pb.get("user-settings","path");this.QY.deleteCookie(fc,kb,gb);};g.save=function(){var
S=o.tE(this.zI);S=S.replace(/\*/g,"%2A");S=S.replace(/\+/g,"%2B");S=S.replace(/</g,"*");S=S.replace(/>/g,"+");S=escape(S);var
Hb=S.length;if(Hb>4096)A.warn(jsx3._msg("usrset.large",Hb));this.Rx(S);};g.KY=function(){return this.QY.getEnv("NAMESPACE")+(this.dV==1?"_ses":"_ind");};g.CJ=function(){var
xc=this.KY();var
hb=this.QY.getCookie(xc,true);if(hb){hb=hb.replace(/\*/g,"<");hb=hb.replace(/\+/g,">");hb=unescape(hb);}return hb;};g.Rx=function(e){var
Qb=this.KY();var
qc=this.QY.getSettings();var
gc=qc.get("user-settings","domain");var
zb=qc.get("user-settings","path");var
Ab=new
Date();var
ac=this.dV==1?null:new
Date(Ab.getFullYear()+1,Ab.getMonth(),Ab.getDate());this.QY.setCookie(Qb,e,ac,zb,gc,null,true);};o.ux=function(r){if(!r)return {};var
Xb=new
jsx3.xml.Document();Xb.loadXML(r);return o.UW(Xb.getRootNode());};o.UW=function(j){var
Cc=j.getNodeName();if(Cc=="s"){return j.getValue();}else if(Cc=="n"){return Number(j.getValue());}else if(Cc=="m"){return j.getChildNodes().map(function(i){return [i.getAttribute("n"),o.UW(i)];},false,true);}else if(Cc=="a"){return j.getChildNodes().map(function(m){return o.UW(m);}).toArray(true);}else if(Cc=="b"){return j.getValue()=="1";}else if(Cc=="u"){return null;}else{A.warn(jsx3._msg("usrset.deser",Cc));return null;}};o.tE=function(f){var
Tb=new
jsx3.xml.Document();Tb.loadXML("<m/>");var
cc=Tb.getRootNode();for(var ob in f)o.tC(f[ob],ob,cc);return cc.getXML();};o.tC=function(p,l,q){var
Gb=null;var
Nc=typeof p;if(p==null||Nc=="undefined"){Gb=q.createNode(1,"u");}else if(Nc=="string"){Gb=q.createNode(1,"s");Gb.setValue(p);}else if(Nc=="number"){Gb=q.createNode(1,"n");Gb.setValue(p);}else if(Nc=="boolean"){Gb=q.createNode(1,"b");Gb.setValue(p?"1":"0");}else if(Nc=="object"){if(p instanceof Array){Gb=q.createNode(1,"a");for(var
fc=0;fc<p.length;fc++)o.tC(p[fc],fc.toString(),Gb);}else{Gb=q.createNode(1,"m");for(var kc in p)o.tC(p[kc],kc,Gb);}}else if(Nc=="function"){}else throw new
jsx3.Exception(jsx3._msg("usrset.persist",Nc));Gb.setAttribute("n",l);q.appendChild(Gb);};g.toString=function(){return this.jsxsuper()+this.QY.getAppPath();};});jsx3.UserSettings=jsx3.app.UserSettings;
