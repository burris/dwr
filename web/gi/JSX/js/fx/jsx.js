/*
 * Copyright (c) 2001-2007, TIBCO Software Inc.
 * Use, modification, and distribution subject to terms of license.
 */
Array.prototype.indexOf=function(j,g){if(g==null)g=0;for(var
Kb=g;Kb<this.length;Kb++)if(this[Kb]==j)return Kb;return -1;};Array.prototype.lastIndexOf=function(f,n){if(n==null)n=this.length-1;for(var
rc=n;rc>=0;rc--)if(this[rc]==f)return rc;return -1;};Array.prototype.contains=function(o){return this.indexOf(o)>=0;};Array.prototype.remove=function(l){var
bb=this.indexOf(l);if(bb>=0)return this.splice(bb,1)[0];return null;};Array.prototype.clone=function(){return this.concat();};Array.prototype.pushAll=function(s){if(typeof s=="array"&&s.length>0){for(var
Ob=0;Ob<s.length;Ob++)this.push(s[Ob]);}else if(typeof s=="object"&&typeof s.length=="number"&&s.length>0)for(var
Ob=0;Ob<s.length;Ob++)this.push(s[Ob]);};Array.prototype.contentsEqual=function(l){if(l==null)return false;if(this.length!=l.length)return false;for(var
U=0;U<l.length;U++)if(this[U]!=l[U])return false;return true;};Array.prototype.filter=function(r){var
Sb=[];for(var
T=0;T<this.length;T++)if(r(this[T]))Sb.push(this[T]);return Sb;};Array.prototype.map=function(i,f,g){var
Mc=null;if(f){if(g){Mc={};for(var
dc=0;dc<this.length;dc++){var
mb=i(this[dc]);for(var
xb=0;xb<mb.length;xb=xb+2)Mc[mb[dc]]=mb[dc+1];}}else{Mc=[];for(var
dc=0;dc<this.length;dc++){var
vc=i(this[dc]);if(vc instanceof Array)Mc.pushAll(vc);else Mc.push(vc);}}}else if(g){Mc={};for(var
dc=0;dc<this.length;dc++){var
W=i(this[dc]);Mc[W[0]]=W[1];}}else{Mc=new
Array(this.length);for(var
dc=0;dc<this.length;dc++)Mc[dc]=i(this[dc]);}return Mc;};Math.modpos=function(k,f){return jsx3.util.numMod(k,f);};Math.isNaN=function(q){return jsx3.util.numIsNaN(q);};Number.prototype.roundTo=function(n){return jsx3.util.numRound(this,n);};Number.prototype.zeroPad=function(e){var
rb=""+this;while(rb.length<e)rb="0"+rb;return rb;};Date.prototype.getLastDateOfMonth=function(){var
Ab=this.getMonth();return Date.AI[Ab]||((new
Date(this.getYear(),Ab,29)).getMonth()==Ab?29:28);};Date.prototype.equals=function(g){return g!=null&&g instanceof Date&&g.valueOf()==this.valueOf();};Date.prototype.compareTo=function(d){var
Mb=this.valueOf();var
hb=d.valueOf();return Mb==hb?0:Mb>hb?1:-1;};Date.AI=[31,null,31,30,31,30,31,31,30,31,30,31];String.prototype.trim=function(){return jsx3.util.strTrim(this);};String.prototype.doReplace=function(r,o){var
L=new
RegExp(r,["g"]);return this.replace(L,o);};String.prototype.escapeHTML=function(){return jsx3.util.strEscapeHTML(this);};String.prototype.doTruncate=function(r){return jsx3.util.strTruncate(this,r,"...",1);};String.prototype.toAbsolute=function(){var
Jc;if(this.substring(0,1)=="/"||this.substring(0,7).toUpperCase()=="HTTP://"||this.substring(0,8).toUpperCase()=="HTTPS://"){Jc=this.toString();}else if(this.substring(0,4)=="JSX/"){Jc=jsx3.getEnv("jsxabspath")+this;}else Jc=jsx3.getEnv("jsxhomepath")+this;return Jc;};String.prototype.urlTo=function(e){var
ob=null;var
Mb=this.lastIndexOf("/");if(Mb==this.length-1)ob=this+e;else if(Mb<0)ob=e;else ob=this.substring(0,Mb+1)+e;ob=ob.replace(/\\/g,"/");var
rc=ob.split("/");for(var
U=0;U<rc.length;U++){var
hc=rc[U];if(hc=="."){rc.splice(U--
,1);}else if(hc=="..")if(U>0&&rc[U-1]!=".."){rc.splice(U--
,1);rc.splice(U--
,1);}}return rc.join("/");};String.prototype.endsWith=function(r){return jsx3.util.strEndsWith(this,r);};String.prototype.constrainLength=function(p,e){return jsx3.util.strTruncate(this,p,e,0.6666666666666666);};String.prototype.toBase64=function(){return jsx3.util.strEncodeBase64(this);};String.prototype.fromBase64=function(){return jsx3.util.strDecodeBase64(this);};if(jsx3.lang==null)jsx3.lang={};jsx3.lang.STACK_MAX=50;jsx3.lang.getCaller=function(r){var
Mc=(r!=null?r:0)+1;for(var
Gc=arguments.callee;Gc!=null;Gc=Gc.caller){if(--Mc>=0)continue;return Gc.caller;}return null;};jsx3.lang.getStack=function(j){var
Ub=[];var
Xb=(j!=null?j:0)+1;for(var
kc=arguments.callee;kc!=null&&Ub.length<jsx3.lang.STACK_MAX;kc=kc.caller){if(--Xb>=0)continue;Ub[Ub.length]=kc.caller;}return Ub;};if(window["jsx3"]==null)window["jsx3"]={};if(jsx3.lang==null)jsx3.lang={};jsx3.lang.yh=new
window.Object();jsx3.lang.nj=new
window.Object();jsx3.lang.Mk=function(){return function(){if(arguments[0]!=jsx3.lang.yh){var
dc=this.getClass?this.getClass():null;throw new
jsx3.Exception(jsx3._msg("obj.no_inst",dc||this));}};};jsx3.lang.Do=function(){return function(){if(arguments[0]!==jsx3.lang.nj)this.init.apply(this,arguments);};};jsx3.lang.Object=function(){this.init();};window._jsxDY=function(l,p){p.init=function(){};p.getClass=function(){return this.__jsxclass__.jsxclass;};p.equals=function(d){return this===d;};p.clone=function(){return this.getClass().bless(this);};p.instanceOf=function(s){if(s instanceof jsx3.lang.Class){return s.isInstance(this);}else if(typeof s=="function"&&s.prototype!=null){return this instanceof s||s.jsxclass!=null&&s.jsxclass.isInstance(this);}else if(typeof s=="string"){s=jsx3.lang.Class.forName(s);if(s!=null)return s.isInstance(this);}throw new
jsx3.IllegalArgumentException("objClass",s);};p.toString=function(){return "@"+this.getClass().getName();};p.jsxsuper=function(r){var
Cc=jsx3.lang.getCaller();var
gc=Cc!=null?Cc.jsxmethod:null;if(gc==null||!(gc instanceof jsx3.lang.Method))throw new
jsx3.Exception(jsx3._msg("obj.super_funct",Cc));if(gc.isStatic())throw new
jsx3.Exception(jsx3._msg("obj.super_static",gc));var
qc=gc.getDeclaringClass();var
Hb=qc.yo(gc);if(Hb==null)throw new
jsx3.Exception(jsx3._msg("obj.super_none",gc));var
Ac=Hb.apply(this,arguments);if(typeof Ac!="undefined")return Ac;};p.jsxsupermix=function(g){var
hb=jsx3.lang.getCaller();var
Ob=hb!=null?hb.jsxmethod:null;if(Ob==null||!(Ob instanceof jsx3.lang.Method))throw new
jsx3.Exception(jsx3._msg("obj.supmx_funct",hb));if(Ob.isStatic())throw new
jsx3.Exception(jsx3._msg("obj.supmx_static",Ob));var
Hc=Ob.getDeclaringClass();var
vc=Hc.ko(Ob);if(vc==null)throw new
jsx3.Exception(jsx3._msg("obj.supmx_none",Ob));var
J=vc.apply(this,arguments);if(typeof J!="undefined")return J;};p.isInstanceOf=function(a,j,o){if(this.getClass()&&(typeof a!="string"||jsx3.lang.Class.forName(a)!=null))return this.instanceOf(a);var
Fb=jsx3.getClass(this.getInstanceOf());if(Fb==null)Fb=this.constructor;if(typeof Fb=="function"){var
Cc=Fb[j?j:"INTERFACES"];var
lb=Cc?Cc[a]:null;if(lb==1){return true;}else if(o){return false;}else return this.isInstanceOf(a.replace(/jsx3/g,"jsx3.gui"),j,true);}return false;};p.isSubclassOf=function(e){return this.isInstanceOf(e,"SUPERS");};p.getInstanceOf=function(){if(this.getClass())return this.getClass().getName();return this.jsxinstanceof?this.jsxinstanceof:this.constructor.className;};p.setInstanceOf=function(b){this.jsxinstanceof=b;return this;};p.getInstanceOfPackage=function(){if(this.getClass())return this.getClass().getPackageName();var
bb=this.getInstanceOf();if(bb==null)return "";var
I=bb.lastIndexOf(".");if(I>=0)return bb.substring(0,I);else return "";};p.getInstanceOfClass=function(){if(this.getClass()){var
ec=this.getClass().getName();return ec.substring(ec.lastIndexOf(".")+1);}var
nb=this.getInstanceOf();if(nb==null)return "";var
Cb=nb.lastIndexOf(".");if(Cb>=0)return nb.substring(Cb+1);else return nb;};p.debug=function(){jsx3.require("jsx3.ide.Debugger");if(!jsx3.ide.doDebug)throw new
jsx3.Exception("The JS debugger is not defined. It is probably not supported on this platform.");jsx3.ide.DEBUG_ARGS=arguments.callee.caller.arguments;var
kc=jsx3.ide.createExpressionObject(arguments.callee.caller.toString().replace(/\}\s*else/g,"}\r\nelse"));var
Jc=jsx3._e(this.getInstanceOf());Jc.jsxMethod=jsx3.ide.doDebug;return this.jsxMethod(kc);};p.eval=function(e,b){return jsx3.eval.call(this,e,b);};};window._jsxDY(jsx3.lang.Object,jsx3.lang.Object.prototype);window._jsxDY=null;jsx3.lang.Object.prototype.__noSuchMethod__=function(g,k){throw new
jsx3.Exception(jsx3._msg("class.nsm",this.getClass().getName()+"#"+g+"()"));};window.inheritance=jsx3.lang.Object;if(window["jsx3"]==null)window["jsx3"]={};if(jsx3.lang==null)jsx3.lang={};jsx3.lang.Method=jsx3.lang.Mk();jsx3.lang.Method.prototype=new
jsx3.lang.Object();jsx3.lang.Method.prototype.constructor=jsx3.lang.Method;window._jsxDY=function(d,f){d.z1=/^\s*function(\s+\w+)?\s*\(\s*([^\)]*?)\s*\)/;f.dC=function(){if(d.z1.exec(this.getFunction().toString())){var
Z=RegExp.$2;this.cR=Z?Z.split(/\s*,\s*/):[];}else this.cR=[];};f.getName=function(){return this.c8;};f.getArity=function(){if(this.cR==null)this.dC();return this.cR.length;};f.getParameterNames=function(){if(this.cR==null)this.dC();return this.cR.concat();};f.getParameterName=function(h){if(this.cR==null)this.dC();return this.cR[h];};f.getDeclaringClass=function(){return this.vg;};f.isPackageMethod=function(){return this.vg instanceof jsx3.lang.Package;};f.isStatic=function(){return this.Ag;};f.isAbstract=function(){return this.Gg;};f.getFunction=function(){if(this._function!=null)return this._function;if(this.isPackageMethod()){return this.vg.getNamespace()[this.c8];}else if(this.Ag){return this.vg.getConstructor()[this.c8];}else return this.vg.getConstructor().prototype[this.c8];};f.apply=function(j,i){return this.getFunction().apply(j,i);};f.call=function(n){var
fb=arguments;if(fb.length>11)throw new
jsx3.Exception(jsx3._msg("method.call",+fb.length));return this.getFunction().call(fb[0],fb[1],fb[2],fb[3],fb[4],fb[5],fb[6],fb[7],fb[8],fb[9],fb[10]);};f.toString=function(){return this.vg.getName()+"."+this.c8;};d.newAbstract=function(n){var
ub="";for(var
rb=0;rb<arguments.length;rb++){if(!arguments[rb].match(/^[a-zA-Z_]\w*$/))throw new
jsx3.IllegalArgumentException("paramNames["+rb+"]",arguments[rb]);ub=ub+("'"+arguments[rb]+"', ");}var
Kc='var method = arguments.callee.jsxmethod;if (method instanceof jsx3.lang.Method) {  throw new jsx3.Exception("method " + method.getName() + " in class " + method.getDeclaringClass() +    " is abstract and may not be invoked");} else {  throw new jsx3.Exception("invoked abstract method improperly initialized");}';var
Xb=jsx3.eval("new Function("+ub+"'"+Kc+"');");Xb.Gg=true;return Xb;};d.newDelegate=function(o,l){var
Yb="return this."+l+"."+o+".apply(this."+l+", arguments);";return new
Function(Yb);};d.argsAsArray=function(n,e,l){if(e==null)e=0;if(l==null)l=n.length;else l=Math.min(l,n.length);var
v=l-e;if(v<=0)return [];var
Dc=new
Array(v);for(var
qc=0;qc<v;qc++)Dc[qc]=n[qc+e];return Dc;};};window._jsxDY(jsx3.lang.Method,jsx3.lang.Method.prototype);window._jsxDY=null;if(window["jsx3"]==null)window["jsx3"]=new
window.Object();if(jsx3.lang==null)jsx3.lang=new
window.Object();jsx3.lang.Class=jsx3.lang.Mk();jsx3.lang.Class.prototype=new
jsx3.lang.Object();jsx3.lang.Class.prototype.__jsxclass__=jsx3.lang.Class;window._jsxDY=function(a,e){a.K6={"jsx3.lang.Object":1,"jsx3.lang.Method":1,"jsx3.lang.ClassLoader":1,"jsx3.lang.Class":2};a.W3=["toString","valueOf"];a.wy={prototype:1,constructor:1,jsxclass:1,__jsxclass__:1};a.ST=null;a.defineClass=function(c,l,q,o){this.pM(c,l,q,o,false);};a.defineInterface=function(p,f,b){this.pM(p,f,null,b,true);};a.pM=function(b,k,r,p,h){if(a.ST==null&&a.forName&&a.forName("jsx3.util.Logger.Manager")&&jsx3.util.Logger.Manager.getManager())a.ST=jsx3.util.Logger.getLogger("jsx3.lang.Class");var
xc=b.split(".");var
Rb=xc.pop();var
_=this.go(xc);var
hb=this.K6[b]!=null;var
Bc=null;if(k==null){Bc=h||b=="jsx3.lang.Object"?window.Object:jsx3.lang.Object;}else if(k instanceof a){Bc=k.getConstructor();}else if(typeof k=="function"&&k.prototype!=null){Bc=k;}else a.R3(jsx3._msg("class.bad_super",k));var
V=false;if(!hb){if(Bc.jsxclass!=null){if(h&&!Bc.jsxclass.isInterface())a.R3(jsx3._msg("class.int_ext_class",b,Bc.jsxclass));if(!h&&Bc.jsxclass.isInterface())a.R3(jsx3._msg("class.class_ext_int",b,Bc.jsxclass));}if(typeof _[Rb]=="function"){V=true;}else if(h){_[Rb]=jsx3.lang.Mk();}else if(typeof _[Rb]=="object"){var
Nc=_[Rb];_[Rb]=jsx3.lang.Do();for(var Nb in Nc)_[Rb][Nb]=Nc[Nb];}else _[Rb]=jsx3.lang.Do();_[Rb].prototype=this.yH(Bc,h);}_[Rb].prototype.__jsxclass__=_[Rb];var
t=_[Rb];if(xc.join(".")=="jsx3.lang")jsx3[Rb]=t;var
fc=a.gj(a);fc.c8=b;fc.it=t;if(Bc!=null)fc.EO=Bc.jsxclass;fc.CK=h;fc.OE=[];fc.HM=[];fc.B4=[];var
qc=fc.xF=[];var
Lc=fc.cG=[];fc.Iw={};fc.sy={};if(t.jsxclass!=null)a.R3(jsx3._msg("class.redefine",b,t.jsxclass));t.jsxclass=fc;try{p(t,t.prototype);}catch(Kc){var
zb=jsx3.NativeError?jsx3.NativeError.wrap(Kc):null;a.R3(jsx3._msg("class.def_error",b,zb||Kc.description),zb);}for(var Nb in t){if(a.wy[Nb])continue;if(typeof t[Nb]=="function"){this.lC(t[Nb],fc,Nb,true);}else qc[qc.length]=Nb;}for(var
R=0;R<a.W3.length;R++){var
ub=a.W3[R];if(t[ub]!=null&&t[ub]!=window.Function.prototype[ub]&&t[ub].jsxmethod==null)this.lC(t[ub],fc,ub,true);}for(var Nb in t.prototype){if(a.wy[Nb])continue;var
ic=t.prototype[Nb];if(typeof ic=="function"){if(Bc==null||ic!=Bc.prototype[Nb])this.lC(ic,fc,Nb,false);}else Lc[Lc.length]=Nb;}for(var
R=0;R<a.W3.length;R++){var
ub=a.W3[R];if(t.prototype[ub]!=null&&t.prototype[ub]!=window.Object.prototype[ub]&&t.prototype[ub].jsxmethod==null)this.lC(t.prototype[ub],fc,ub,false);}if(!V&&!h&&!(typeof t.prototype.init=="function"))a.R3(jsx3._msg("class.no_init",b));if(r instanceof Array)for(var
R=r.length-1;R>=0;R--)a.iW(fc,t,r[R]);if(a.ST)a.ST.trace("loaded "+b);jsx3.CLASS_LOADER.sp(fc);};a.iW=function(c,r,p){if(typeof p=="function"&&p.jsxclass!=null)p=p.jsxclass;else if(!(p instanceof a))a.R3(jsx3._msg("class.bad_int",c,p));if(!p.isInterface())a.R3(jsx3._msg("class.class_imp_class",c,p));var
Xb=p.getConstructor().prototype;for(var tb in Xb){var
B=Xb[tb];var
W=typeof B=="function"?B.jsxmethod:null;if(W==null)continue;var
mc=r.prototype[tb];if(mc==null){r.prototype[tb]=B;}else if(!mc.jsxmethod.getDeclaringClass().equals(c))r.prototype[tb]=B;}c.OE.unshift(p);};a.go=function(p){var
mb=window;for(var
R=0;R<p.length;R++){var
kc=p[R];if(mb[kc]==null)mb[kc]=new
window.Object();mb=mb[kc];}return mb;};a.lC=function(l,s,j,o){if(l.jsxmethod instanceof jsx3.lang.Method)if(l.jsxmethod.getDeclaringClass().equals(s))a.R3(jsx3._msg("class.redef_method",l.jsxmethod,s+"."+j));else return;var
M=a.gj(jsx3.lang.Method);M._function=l;M.vg=s;M.c8=j;M.Ag=o;M.Gg=Boolean(l.Gg);l.jsxmethod=M;var
wc=o?s.HM:s.B4;wc[wc.length]=M;};a.yH=function(b,k){if(b==Object)return {};return new
b(k?jsx3.lang.yh:jsx3.lang.nj);};a.gj=function(d){return new
d(jsx3.lang.yh);};a.R3=function(i,s){if(a.ST){a.ST.fatal(i,s);}else if(jsx3.Exception){var
Db=new
jsx3.Exception(i,s);window.alert(Db.printStackTrace());}else window.alert(i);};};window._jsxDY(jsx3.lang.Class,jsx3.lang.Class.prototype);window._jsxDY=null;jsx3.lang.Class.defineClass("jsx3.lang.Class",null,null,function(n,k){n.forName=function(q){var
Wb=q.split(/\./g);var
tc=window;var
B;for(var
bc=0;bc<Wb.length;bc++){var
kb=Wb[bc];if(!kb)return null;B=typeof tc;if(B=="object"||B=="function"){tc=tc[kb];}else return null;}B=typeof tc;return B=="object"||B=="function"?tc.jsxclass:null;};k.getName=function(){return this.c8;};k.getPackage=function(){var
lc=this.c8;while(true){var
Ub=lc.lastIndexOf(".");if(Ub<0)break;lc=lc.substring(0,Ub);var
nc=jsx3.lang.Package.forName(lc);if(nc!=null)return nc;if(n.forName(lc)==null)break;}return null;};k.getPackageName=function(){var
yb=this.getPackage();if(yb){return yb.getName();}else{var
Xb=this.c8.lastIndexOf(".")+1;return Xb>=0?this.c8.substring(0,Xb-1):"";}};k.getConstructor=function(){if(this.it!=null)return this.it;try{return jsx3.eval(this.c8);}catch(Kc){return null;}};k.getSuperClass=function(){return this.EO;};k.isInterface=function(){return this.CK;};k.toString=function(){return this.c8;};k.newInstance=function(l){if(arguments.length>10)throw new
jsx3.Exception(jsx3._msg("class.new_inst"));var
z=arguments;var
lb=this.getConstructor();return new
lb(z[0],z[1],z[2],z[3],z[4],z[5],z[6],z[7],z[8],z[9]);};k.isInstance=function(i){var
D=i.__jsxclass__?i.__jsxclass__.jsxclass:null;return D!=null&&this.isAssignableFrom(D);};k.isAssignableFrom=function(p){if(this.equals(p))return true;if(p.xW==null)p.G1();return p.xW[this.getName()]==true;};k.G1=function(){this.xW={};for(var
dc=0;dc<this.OE.length;dc++){var
rc=this.OE[dc];this.xW[rc.getName()]=true;if(rc.xW==null)rc.G1();for(var F in rc.xW)this.xW[F]=true;}if(this.EO!=null){this.xW[this.EO.getName()]=true;if(this.EO.xW==null)this.EO.G1();for(var F in this.EO.xW)this.xW[F]=true;}};k.mixin=function(p,l,s){if(s){for(var
qc=0;qc<s.length;qc++){var
gc=this.getInstanceMethod(s[qc]);if(gc&&p[gc.getName()]==null||!l)p[gc.getName()]=gc.getFunction();}}else for(var
qc=0;qc<this.B4.length;qc++){var
gc=this.B4[qc];if(p[gc.getName()]==null||!l)p[gc.getName()]=gc.getFunction();}};k.bless=function(b){if(this.isInterface())throw new
jsx3.Exception(jsx3._msg("class.bless_int",this));var
Cc=n.yH(this.getConstructor());if(b!=null)for(var Ic in b)if(!(typeof b[Ic]=="function"))Cc[Ic]=b[Ic];return Cc;};k.newInnerClass=function(j){if(this.isInterface()){return n.gj(this.getConstructor());}else return this.newInstance.apply(this,arguments);};k.getStaticMethods=function(){return this.HM.concat();};k.getInstanceMethods=function(){return this.B4.concat();};k.getStaticMethod=function(h){for(var
jc=0;jc<this.HM.length;jc++)if(h==this.HM[jc].getName())return this.HM[jc];return null;};k.getInstanceMethod=function(l){for(var
Bc=0;Bc<this.B4.length;Bc++)if(l==this.B4[Bc].getName())return this.B4[Bc];return null;};k.getGetter=function(i){i=i.charAt(0).toUpperCase()+i.substring(1);return this.IJ("get"+i)||this.IJ("is"+i);};k.getSetter=function(i){i=i.charAt(0).toUpperCase()+i.substring(1);return this.IJ("set"+i);};k.getStaticFieldNames=function(){return this.xF.concat();};k.getInstanceFieldNames=function(){return this.cG.concat();};k.getInterfaces=function(){return this.OE.concat();};k.addInterface=function(g){var
wb=null;if(this.isInterface())wb="class.int_imp_int";else if(!g.isInterface())wb="class.class_imp_class";else if(g.isAssignableFrom(this))wb="class.already_imp";if(wb)throw new
jsx3.Exception(jsx3._msg(wb,this,g));n.iW(this,this.getConstructor(),g);delete this.xW;};k.getInheritance=function(){var
ic=this.OE.concat();if(this.EO!=null){ic[ic.length]=this.EO;ic.push.apply(ic,this.EO.getInheritance());}return ic;};k.getClasses=function(){var
H=this.getConstructor();var
Db=[];for(var lc in H)if(typeof H[lc]=="function"&&H[lc].jsxclass instanceof n){Db[Db.length]=H[lc].jsxclass;Db.push.apply(Db,H[lc].jsxclass.getClasses());}return Db;};k.IJ=function(g,j){var
cc=null;if(!j)cc=this.getInstanceMethod(g);var
u=this.getInheritance();for(var
zb=0;cc==null&&zb<u.length;zb++)cc=u[zb].getInstanceMethod(g);return cc;};k.P6=function(o,r){var
xc=null;if(!r)xc=this.getInstanceMethod(o);if(xc==null&&this.EO!=null)xc=this.EO.P6(o);return xc;};k.Bv=function(l){var
Zb=null;for(var
w=0;w<this.OE.length&&Zb==null;w++)Zb=this.OE[w].getInstanceMethod(l);if(Zb==null&&this.EO!=null)Zb=this.EO.Bv(l);return Zb;};k.yo=function(d){var
Sb=d.getName();var
H=this.Iw["m:"+Sb];if(typeof H=="undefined")this.Iw["m:"+Sb]=H=this.P6(Sb,true);return H;};k.ko=function(e){var
Tb=e.getName();var
mb=this.sy["m:"+Tb];if(typeof mb=="undefined")this.sy["m:"+Tb]=mb=this.Bv(Tb);return mb;};});jsx3.lang.Class.defineClass("jsx3.lang.Object",null,null,function(){});jsx3.lang.Class.defineClass("jsx3.lang.Method",null,null,function(){});jsx3.lang.Class.jsxclass.EO=jsx3.lang.Object.jsxclass;jsx3.Class.defineClass("jsx3.lang.Exception",null,null,function(n,o){var
xc=jsx3.lang.Method;n.Pq=false;n.gm=null;o.init=function(f,l){n.gm=this;this.V2=f;this.JL=l;this.kD=[];this.k5();if(n.Pq&&window.onerror==null)window.alert(f+this.printStackTrace());};o.toString=function(){return this.V2;};o.getMessage=function(){return this.V2;};o.getCause=function(){return this.JL;};o.getStack=function(){return this.kD;};n.sK=[jsx3.Object.jsxclass.getInstanceMethod("jsxsuper"),jsx3.Object.jsxclass.getInstanceMethod("jsxsupermix"),jsx3.Object.jsxclass.getInstanceMethod("__noSuchMethod__")];n.formatStack=function(k){var
Ic="";for(var
oc=0;oc<k.length;oc++){var
yb=k[oc];if(yb==null)continue;if(yb.jsxmethod instanceof xc){var
wb=k[oc+1];if(wb!=null&&jsx3.util.arrIndexOf(n.sK,wb.jsxmethod)>=0)if(yb==xc.prototype.apply)continue;if(jsx3.util.arrIndexOf(n.sK,yb.jsxmethod)>=0)continue;if(Ic.length>0)Ic=Ic+"\n";Ic=Ic+"    at ";Ic=Ic+yb.jsxmethod.getDeclaringClass().getName();Ic=Ic+(yb.jsxmethod.isStatic()?"#":".");Ic=Ic+(yb.jsxmethod.getName()+"()");}else{if(Ic.length>0)Ic=Ic+"\n";Ic=Ic+"    at ";if(yb.jsxclass instanceof jsx3.lang.Class){Ic=Ic+(yb.jsxclass.getName()+"()");}else{var
Y=yb.toString();if(Y.match(new
RegExp("^function(\\s+\\w+)?\\s*\\(([^\\)]*)\\)\\s*{"))){var
rb=RegExp.$1||"anonymous";var
Kb=RegExp.$2;var
V=RegExp.rightContext;V=jsx3.util.strTruncate(jsx3.util.strTrim(V).replace(/\s+/g," "),70);Ic=Ic+(jsx3.util.strTrim(rb)+"("+jsx3.util.strTrim(Kb).split(/\s*,\s*/).join(", ")+")"+(V?" { "+V:""));}else Ic=Ic+"anonymous()";}}}return Ic;};o.printStackTrace=function(){var
B=this.getClass().getName()+": "+this+"\n"+n.formatStack(this.kD);if(this.JL!=null)B=B+("\nCaused By:\n"+this.JL.printStackTrace());return B;};o.k5=function(){var
Fb=jsx3.lang.getStack(1);var
y=-1;for(var
X=0;X<Fb.length;X++)if(Fb[X].jsxclass!=null){y=X;break;}if(y>=0)Fb.splice(0,y+1);this.kD=Fb;};});jsx3.Class.defineClass("jsx3.lang.IllegalArgumentException",jsx3.lang.Exception,null,function(p,h){h.init=function(r,c){this.jsxsuper(jsx3._msg("exc.ill_arg",r,c));};});jsx3.Class.defineClass("jsx3.lang.NativeError",jsx3.lang.Exception,null,function(r,b){var
bc=jsx3.Exception;r.NU=false;r.fU=true;r.wrap=function(j){if(j instanceof Error)return new
r(j);else if(j instanceof bc)return j;else return new
bc(""+j);};r.initErrorCapture=function(e){window.onerror=arguments.length>0?e:r.j9;};r.stopErrorCapture=function(q){window.onerror=null;};r.yB="uncaught exception:";r.j9=function(f,a,k){try{if(!r.NU&&jsx3.Class.forName("jsx3.util.Logger")!=null&&jsx3.util.Logger.GLOBAL!=null){if(f.indexOf(r.yB)>=0)if(bc.gm!=null){var
y=jsx3.lang.getStack(0);if(y.length<2||y.contentsEqual(bc.gm.getStack())){if(y.length<2)jsx3.util.Logger.GLOBAL.logStack(2,jsx3._msg("error.trap",f,r.ZA(k),a),1);jsx3.util.Logger.GLOBAL.error(jsx3._msg("error.uncaught"),bc.gm);bc.gm=true;return true;}}jsx3.util.Logger.GLOBAL.logStack(2,jsx3._msg("error.trap",f,r.ZA(k),a),1);return true;}else if(r.fU){if(f.indexOf(r.yB)>=0)if(bc.gm!=null){var
y=jsx3.lang.getStack(0);if(y.contentsEqual(bc.gm.getStack())){window.alert(jsx3._msg("error.uncaught")+"\n"+bc.gm.printStackTrace());return true;}}var
y=jsx3.lang.getStack(0);window.alert(jsx3._msg("error.trap",f,r.ZA(k),a)+"\n"+bc.formatStack(y));return true;}else return false;}catch(Kc){window.alert(jsx3._msg("error.trap_err",r.wrap(Kc),f,r.ZA(k),a));}};b.ey=null;b.init=function(j){if(!(j instanceof Error))throw new
jsx3.IllegalArgumentException("objError",j);this.jsxsuper();this.ey=j;};b.getMessage=function(){return this.ey.message!=null?this.ey.message.replace(/\s*$/,""):"";};b.getFileName=function(){return this.ey.fileName;};b.getLineNumber=function(){return r.ZA(this.ey.lineNumber);};r.ZA=function(p){if(jsx3.util.numIsNaN(p))return null;return p;};b.getName=function(){return this.ey.name;};b.isStructural=function(){return false;};b.getType=function(){if(this.ey instanceof EvalError)return "EvalError";if(this.ey instanceof RangeError)return "RangeError";if(this.ey instanceof ReferenceError)return "ReferenceError";if(this.ey instanceof SyntaxError)return "SyntaxError";if(this.ey instanceof TypeError)return "TypeError";return "Error";};b.toString=function(){var
kb=this.getLineNumber();var
xc=this.getFileName();var
tc=this.getMessage();if(kb||xc){tc=tc+(" (type:"+this.getType()+", ");if(kb)tc=tc+("line:"+kb);if(xc){if(kb)tc=tc+", ";tc=tc+("file:"+xc);}tc=tc+")";}return tc;};});jsx3.lang.Package=jsx3.lang.Mk();jsx3.lang.Class.defineClass("jsx3.lang.Package",null,null,function(s,k){var
hc=jsx3.lang.Class;var
eb=jsx3.lang.Method;s.TW=[];s.definePackage=function(l,f){var
t=hc.go(l.split("."));var
ab=false;var
rc=null;if(t.jsxpackage!=null){if(jsx3.Class.forName("jsx3.util.Logger"))jsx3.util.Logger.getLogger("jsx3.lang").info(jsx3._msg("pkg.redefine",l));rc=t.jsxpackage;ab=true;rc.xF=[];rc.HM=[];}else{rc=hc.gj(s);rc.AX=l;rc.xF=[];rc.HM=[];t.jsxpackage=rc;}try{f(t);}catch(Kc){var
D=jsx3.NativeError.wrap(Kc);throw new
jsx3.Exception(jsx3._msg("pkg.def_error",l,D),D);}for(var lc in t){if(lc=="jsxpackage")continue;if(typeof t[lc]=="function"){if(t[lc].jsxclass==null)this.lC(t[lc],rc,lc);}else if(t[lc]==null||typeof t[lc]!="object"||t[lc].jsxpackage==null)rc.xF.push(lc);}if(t.__noSuchMethod__==null)t.__noSuchMethod__=function(a,e){throw new
jsx3.Exception(jsx3._msg("class.nsm",l+"#"+a+"()"));};s.TW.push(rc);jsx3.CLASS_LOADER.kd(rc);};s.lC=function(d,a,p){if(d.jsxmethod instanceof eb)if(d.jsxmethod.getDeclaringClass().equals(a)&&d.jsxmethod.getName()!=p){throw new
jsx3.Exception(jsx3._msg("class.redef_method",d.jsxmethod,a+"."+p));}else{if(d.jsxmethod.getDeclaringClass().equals(a)&&jsx3.util.arrIndexOf(a.HM,d.jsxmethod)<0)a.HM.push(d.jsxmethod);return;}var
t=hc.gj(eb);t.vg=a;t.c8=p;t.Ag=true;d.jsxmethod=t;a.HM.push(t);};s.forName=function(l){try{var
lc=jsx3.eval(l);if(typeof lc=="object")return lc.jsxpackage;}catch(Kc){}return null;};s.getPackages=function(){return s.TW.concat();};k.AX=null;k.sH=null;k.HM=null;k.xF=null;k.getName=function(){return this.AX;};k.getNamespace=function(){if(this.sH!=null)return this.sH;try{return jsx3.eval(this.AX);}catch(Kc){return null;}};k.getClasses=function(){var
xb=[];var
Nc=this.getNamespace();for(var R in Nc)if(typeof Nc[R]=="function"&&Nc[R].jsxclass instanceof hc)if(Nc[R].jsxclass.getPackage()==this&&this.getName()+"."+R==Nc[R].jsxclass.getName()){xb[xb.length]=Nc[R].jsxclass;xb.push.apply(xb,Nc[R].jsxclass.getClasses());}return xb;};k.getStaticMethods=function(){return this.HM.concat();};k.getStaticMethod=function(m){for(var
B=0;B<this.HM.length;B++)if(m==this.HM[B].getName())return this.HM[B];return null;};k.getStaticFieldNames=function(){return this.xF.concat();};k.toString=function(){return this.AX;};});jsx3.Package.definePackage("jsx3",function(){jsx3.ADDINSPATH="JSX/addins/";jsx3.XMLREGKEY="Msxml2.FreeThreadedDOMDocument.3.0";jsx3.XSLREGKEY="Msxml2.XSLTemplate.3.0";jsx3.HTTPREGKEY="Msxml2.XMLHTTP.3.0";jsx3.getXmlVersion=function(){return 4;};jsx3.DESERIALIZE="JSX30DESERIALIZE";jsx3.INITIALIZE="JSX30INITIALIZE";jsx3.STARTUP_EVENT=null;jsx3.CACHE=null;jsx3.EVENT=null;jsx3.getSharedCache=function(){if(jsx3.CACHE==null)jsx3.CACHE=new
jsx3.app.Cache();return jsx3.CACHE;};jsx3.getSystemCache=function(){if(jsx3.kB==null)jsx3.kB=new
jsx3.app.Cache();return jsx3.kB;};jsx3.eval=function(s,g){if(s!=null&&s!==""){var
nc="";if(g){var
_ec=g;var
ec=[];for(var db in _ec)ec[ec.length]="var "+db+" = _ec."+db+";";nc=ec.join("");}return eval(nc+s);}};jsx3.resolveURI=function(f){return jsx3.net.URIResolver.DEFAULT.resolveURI(f).toString();};jsx3.makeCallback=function(l,i,r){var
db=[];for(var
B=2;B<arguments.length;B++)db[db.length]=arguments[B];return function(){db[db.length]=arguments;l.apply(i,db);};};jsx3.clone=function(n){if(typeof n!="object")return n;var
z={};for(var W in n)z[W]=n[W];return z;};jsx3.LV={};jsx3.LV["jsx3.gui.MatrixColumn"]="jsx3.gui.Matrix.Column";jsx3.require=function(r){for(var
M=0;M<arguments.length;M++){var
A=arguments[M];A=jsx3.LV[A]||A;if(jsx3.Class.forName(A)==null)jsx3.CLASS_LOADER.loadClass(A);}};jsx3.rU=[];jsx3.XG=[];jsx3.oE=null;jsx3.sleep=function(d,b,i,h){if(b&&jsx3.XG[b])if(h)jsx3.XG[b][0]=null;else return;var
wb=[d,b,i];var
Ab=jsx3.rU;Ab[Ab.length]=wb;jsx3.XG[b]=wb;if(jsx3.oE==null)jsx3.oE=window.setTimeout(jsx3.ow,0);};jsx3.QUEUE_DONE="queueDone";jsx3.ow=function(){if(jsx3.lang.getCaller()!=null){jsx3.oE=window.setTimeout(jsx3.ow,0);return;}var
P=null;while(jsx3.rU.length>0&&(P==null||P[0]==null))P=jsx3.rU.shift();if(P){jsx3.oE=window.setTimeout(jsx3.ow,0);var
kb=P[0];var
Fc=P[1];var
Kc=P[2];delete jsx3.XG[Fc];kb.apply(Kc);}else{jsx3.oE=null;jsx3.publish({subject:jsx3.QUEUE_DONE});}};jsx3.startup=function(){if(window.OpenAjax){OpenAjax.registerLibrary("gi","http://www.tibco.com/gi",jsx3.getVersion());OpenAjax.registerGlobals("gi",["gi","jsx3","jsx","tibco"]);}};jsx3.destroy=function(){if(jsx3.app&&jsx3.app.Server){var
bb=jsx3.app.Server.allServers();for(var
Gb=0;Gb<bb.length;Gb++)try{bb[Gb].destroy();}catch(Kc){}}if(jsx3.gui&&jsx3.gui.Event){var
T="BEFOREUNLOAD BLUR CHANGE CLICK DOUBLECLICK ERROR FOCUS KEYDOWN KEYPRESS KEYUP LOAD MOUSEDOWN MOUSEMOVE MOUSEOUT MOUSEOVER MOUSEUP MOUSEWHEEL UNLOAD RESIZE".split(/\s+/);for(var
Gb=0;Gb<T.length;Gb++)jsx3.gui.Event.unsubscribeAll(jsx3.gui.Event[T[Gb]]);}jsx3.NativeError.stopErrorCapture();var
cb=document.getElementsByTagName("script");for(var
Gb=0;Gb<cb.length;Gb++){var
fc=cb.item(Gb);fc.parentNode.removeChild(fc);}jsx3.CLASS_LOADER.destroy();window.jsx3=null;};jsx3.getClass=function(f){try{var
bc=eval(f);return typeof bc=="function"?bc:null;}catch(Kc){return null;}};jsx3._e=function(o){try{var
Ic=eval(o+".prototype");return typeof Ic=="object"&&typeof Ic.constructor=="function"?Ic:null;}catch(Kc){return null;}};jsx3.getClassConstants=function(q){var
t=jsx3.getClass(q);if(t!=null){var
J=[];for(var z in t)if(z.toUpperCase()==z)J[J.length]=q+"."+z;return J;}};jsx3.getInstanceMethods=function(e){var
Jb=jsx3._e(e);var
xb=[];for(var y in Jb)if(typeof Jb[y]=="function"){var
Dc=Jb[y].toString();xb[xb.length]=Dc.substring(9,Dc.indexOf(")")+1);}return xb;};jsx3.getClassMethods=function(g){var
zc=jsx3.getClass(g);var
Sb="";for(var G in zc)if(typeof zc[G]=="function"){var
cc=zc[G].toString();Sb=Sb+(G+cc.substring(8,cc.indexOf(")")+1)+"\n");}return Sb;};jsx3.doInherit=function(h,p,f){var
ec=jsx3.getClass(h);var
L=jsx3.getClass(p);if(L==null){jsx3.util.Logger.doLog("INHR01","Super class '"+p+"' of '"+h+"' not properly defined",1,false);return;}if(ec.isInherited==null||f!=null&&f){if(!f){ec.SUPER=p;ec.SUPERS={};for(var X in L.SUPERS){ec.SUPERS[X]=L.SUPERS[X];ec.SUPERS[h]=1;}}ec.className=h;if(ec.INHERITANCE==null)ec.INHERITANCE=[h];if(L.INHERITANCE)for(var
Ab=L.INHERITANCE.length-1;Ab>=0;Ab--)ec.INHERITANCE.splice(1,0,L.INHERITANCE[Ab]);else ec.INHERITANCE.splice(1,0,p);if(ec.INTERFACES==null)ec.INTERFACES={};if(L.INTERFACES){for(var X in L.INTERFACES)ec.INTERFACES[X]=L.INTERFACES[X];}else ec.INTERFACES[p]="1";ec.INTERFACES[h]="1";if(!(f!=null&&f))ec.isInherited=true;var
sb=jsx3._e(p);var
y=jsx3._e(h);for(var X in sb)if(typeof y[X]!="function")y[X]=sb[X];}};jsx3.doImplement=function(r,g){jsx3.doInherit(r,g,true);};jsx3.doMixin=function(p,b){var
eb=jsx3._e(b);for(var zb in eb)if(typeof eb[zb]=="function")p[zb]=eb[zb];};jsx3.doDefine=function(m,b){var
v=jsx3.getClass(m);if(v.isDefined==null){v.isDefined=true;b();}};jsx3.out=function(c,q,o,p){if(jsx3.Class.forName("jsx3.util.Logger"))jsx3.util.Logger.doLog(c,q,o,p);};window.doInherit=jsx3.doInherit;window.doImplement=jsx3.doImplement;window.doMixin=jsx3.doMixin;window.doDefine=jsx3.doDefine;jsx3.log=function(h){if(jsx3.Class.forName("jsx3.util.Logger")&&jsx3.util.Logger.GLOBAL){if(jsx3.GQ){for(var
Hc=0;Hc<jsx3.GQ.length;Hc++)jsx3.util.Logger.GLOBAL.info(jsx3.GQ[Hc]);delete jsx3.GQ;}jsx3.util.Logger.GLOBAL.info(h);}else{var
yb=jsx3.GQ;if(!yb)jsx3.GQ=yb=[];yb[yb.length]=h;}};});jsx3.Package.definePackage("jsx3.app",function(){});jsx3.Boolean={};jsx3.Boolean.TRUE=1;jsx3.Boolean.FALSE=0;jsx3.Boolean.valueOf=function(j){return j?1:0;};jsx3.Package.definePackage("jsx3.gui",function(j){j.po=function(k,f){var
pb=[];for(var
gb=0;gb<arguments.length-1;gb=gb+2){k=arguments[gb];if(k._jsxRs)continue;k._jsxRs=true;f=arguments[gb+1];var
hb={};for(var nb in f)hb[nb]=nb=="className"?k.className:k.style[nb];pb.push(k,hb,f);}j.bv(pb,0,6);};j.bv=function(p,s,b){if(s==b){for(var
zc=0;zc<p.length-2;zc=zc+3){var
jc=p[zc];jc._jsxRs=null;}return;}for(var
zc=0;zc<p.length-2;zc=zc+3){var
jc=p[zc];var
z=s%2==0?p[zc+2]:p[zc+1];for(var _ in z)if(_=="className")jc.className=z[_];else jc.style[_]=z[_];}window.setTimeout(function(){j.bv(p,s+1,b);},75);};j.isMouseEventModKey=function(q){if(jsx3.app.Browser.macosx)return q.metaKey();else return q.ctrlKey();};});jsx3.Package.definePackage("jsx3.lang",function(b){});jsx3.Package.definePackage("jsx3.net",function(f){});jsx3.Class.defineInterface("jsx3.net.URIResolver",null,function(f,m){f.lF=function(){if(this.V1==null)this.V1=new
jsx3.net.URI(jsx3.getEnv("jsxabspath"));return this.V1;};f.Gy=function(){var
S=jsx3.getEnv("jsxhomepath");if(S==null)return new
jsx3.net.URI(jsx3.getEnv("jsxscriptapppath"));if(this.vs==null)this.vs=new
jsx3.net.URI(S);return this.vs;};f.DEFAULT=f.jsxclass.newInnerClass();f.DEFAULT.resolveURI=function(r){var
Db=jsx3.net.URI.valueOf(r);var
zb=Db.getScheme();var
Nc=Db.getPath();var
E=null;if(zb){var
Mb=jsx3.net.URI.fromParts(null,null,null,null,Nc,Db.getQuery(),Db.getFragment());if(zb=="jsx"){E=f.lF().resolve("JSX"+Mb);}else if(zb=="jsxapp"){var
gb=f.getResolver(Db);E=gb.resolveURI(Mb.toString().substring(1));}else if(zb=="jsxaddin"){var
O=Db.getHost();var
A=O.split("!",2).join(":");var
P=jsx3.System.getLoadedAddinByKey(A);E=P!=null?P.resolveURI(Mb.toString().substring(1)):Db;}else if(zb=="jsxuser"){E=f.Gy().resolve(Mb.toString().substring(1));}else E=Db;}else if(Nc.indexOf("JSX"+"/")==0){E=f.lF().resolve(Db);}else if(Nc.indexOf("JSXAPPS"+"/")==0){E=f.Gy().resolve(Db);}else if(Nc.indexOf("/")==0){E=Db;}else if(Nc.indexOf("GI_Builder/")==0){E=f.lF().resolve(Db);}else if(Nc.indexOf("..")>=0){var
dc=jsx3.app.Browser.getLocation();E=dc.relativize(dc.resolve(Db));}else E=Db;return E;};f.DEFAULT.getUriPrefix=function(){return f.lF().toString();};f.DEFAULT.relativizeURI=function(g,n){return jsx3.net.URI.valueOf(g);};f.JSX=f.jsxclass.newInnerClass();f.JSX.getURI=function(){if(this._uri==null)this._uri=f.lF().resolve("JSX"+"/");return this._uri;};f.JSX.resolveURI=function(c){var
rc=jsx3.net.URI.valueOf(c);if(!f.isAbsoluteURI(rc)){return f.DEFAULT.resolveURI(this.getURI().resolve(rc.toString()));}else return f.DEFAULT.resolveURI(rc);};f.JSX.getUriPrefix=function(){return f.lF()+"JSX"+"/";};f.JSX.relativizeURI=function(l,s){var
Jb=this.getURI().relativize(l);if(Jb.isAbsolute()||s)return Jb;else return jsx3.net.URI.fromParts("jsx",null,null,null,"/"+Jb.getPath(),Jb.getQuery(),Jb.getFragment());};f.USER=f.jsxclass.newInnerClass();f.USER.resolveURI=function(j){var
u=jsx3.net.URI.valueOf(j);if(!f.isAbsoluteURI(u)){return f.DEFAULT.resolveURI(f.Gy().resolve(u));}else return f.DEFAULT.resolveURI(u);};f.USER.getUriPrefix=function(){return f.Gy().toString();};f.USER.relativizeURI=function(n,b){var
Wb=f.Gy().relativize(n);if(Wb.isAbsolute()||b)return Wb;else return jsx3.net.URI.fromParts("jsxuser",null,null,null,"/"+Wb.getPath(),Wb.getQuery(),Wb.getFragment());};f.isAbsoluteURI=function(j){var
eb=jsx3.net.URI.valueOf(j);if(eb.getScheme()!=null)return true;var
D=eb.getPath();return D.indexOf("/")==0||D.indexOf("JSX"+"/")==0||D.indexOf("JSXAPPS"+"/")==0||D.indexOf("GI_Builder/")==0;};f.getResolver=function(r){var
C=jsx3.net.URI.valueOf(r);var
S=C.getScheme();if(S)if(S=="jsx"){return f.JSX;}else if(S=="jsxapp"){var
ic=C.getHost().replace(/!/g,"/");var
Qb=jsx3.System.getLoadedAppByPath(ic);return Qb!=null?Qb:new
jsx3.net.ServerURIResolver(ic);}else if(S=="jsxaddin"){var
O=C.getHost();var
gb=O.split("!",2).join(":");return jsx3.System.getLoadedAddinByKey(gb);}else if(S=="jsxuser")return f.USER;return f.DEFAULT;};m.resolveURI=jsx3.Method.newAbstract("strURI");m.getUriPrefix=jsx3.Method.newAbstract();m.relativizeURI=jsx3.Method.newAbstract("strURI","bRel");});jsx3.Class.defineClass("jsx3.net.ServerURIResolver",null,[jsx3.net.URIResolver],function(n,l){var
qc=jsx3.net.URIResolver;l.init=function(g){this._host=g;this._uri=new
jsx3.net.URI(jsx3.getEnv("jsxhomepath")+"JSXAPPS"+"/"+g.replace(/!/g,"/")+"/");};l.resolveURI=function(a){var
kb=jsx3.net.URI.valueOf(a);if(!qc.isAbsoluteURI(kb)){return qc.DEFAULT.resolveURI(this._uri.resolve(kb.toString()));}else return qc.DEFAULT.resolveURI(kb);};l.getUriPrefix=function(){return this._uri.toString();};l.relativizeURI=function(f,m){var
ib=this._uri.relativize(f);if(ib.isAbsolute()||m)return ib;else return jsx3.net.URI.fromParts("jsxapp",null,this._host,null,"/"+ib.getPath(),ib.getQuery(),ib.getFragment());};l.toString=function(){return this._uri.toString();};});jsx3.Package.definePackage("jsx3.xml",function(r){});jsx3.Package.definePackage("jsx3.util",function(c){c.compareVersions=function(k,j){var
wc=k.split(/\./);var
W=j.split(/\./);var
Dc=Math.max(wc.length,W.length);for(var
xc=0;xc<Dc;xc++){var
T=parseInt(wc[xc])||Number(0);var
Ac=parseInt(W[xc])||Number(0);if(T>Ac)return 1;if(T<Ac)return -1;}return 0;};c.numMod=function(i,d){return i<0?i%d+d:i%d;};c.numIsNaN=function(m){return m==null||m===""||isNaN(m);};c.numRound=function(n,o){return Math.round(n/o)*o;};c.strEmpty=function(o){return o==null||o==="";};c.arrIndexOf=function(g,l){for(var
F=0;F<g.length;F++)if(g[F]===l)return F;return -1;};c.SB=/(^\s*)|(\s*$)/g;c.strTrim=function(q){return q.replace(c.SB,"");};c.strEscapeHTML=function(o){return o.replace(/&/g,"&amp;").replace(/</g,"&lt;").replace(/>/g,"&gt;").replace(/\"/g,"&quot;");};c.strTruncate=function(k,o,q,f){if(q==null)q="...";if(f==null)f=1;if(k.length>o&&q.length<o){var
tb=o-q.length;var
gc=Math.round(tb*f);var
N=k.substring(0,gc);var
Nb=k.substring(k.length-(tb-gc));return N+q+Nb;}else return k;};c.strEndsWith=function(h,g){var
bb=h.lastIndexOf(g);return bb>=0&&bb==h.length-g.length;};c.Qq="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";c.strEncodeBase64=function(l){var
nb=c.Qq;var
W=new
Array(Math.ceil(l.length*4/3));var
eb=0,Jc=0,qb=l.length;for(;eb<=qb-3;eb=eb+3){var
z=(l.charCodeAt(eb)&255)<<16|(l.charCodeAt(eb+1)&255)<<8|l.charCodeAt(eb+2)&255;W[Jc++
]=nb.charAt((z&16515072)>>18);W[Jc++
]=nb.charAt((z&258048)>>12);W[Jc++
]=nb.charAt((z&4032)>>6);W[Jc++
]=nb.charAt(z&63);}if(eb<qb){var
Nb=eb<qb-1;var
z=(l.charCodeAt(eb)&255)<<16;if(Nb)z=z|(l.charCodeAt(eb+1)&255)<<8;W[Jc++
]=nb.charAt((z&16515072)>>18);W[Jc++
]=nb.charAt((z&258048)>>12);if(Nb)W[Jc++
]=nb.charAt((z&4032)>>6);else W[Jc++
]="=";W[Jc++
]="=";}return W.join("");};c.strDecodeBase64=function(h){var
pc=c.Qq;var
nb=new
Array(Math.ceil(h.length/4));var
Ec=0,qc=0,P=h.length;for(;Ec<P;Ec=Ec+4){var
Kb=(pc.indexOf(h.charAt(Ec))&255)<<18|(pc.indexOf(h.charAt(Ec+1))&255)<<12|(pc.indexOf(h.charAt(Ec+2))&255)<<6|pc.indexOf(h.charAt(Ec+3))&255;nb[qc++
]=String.fromCharCode((Kb&16711680)>>16,(Kb&65280)>>8,Kb&255);}if(h.charCodeAt(Ec-2)==61)nb[qc-1]=nb[qc-1].substring(0,1);else if(h.charCodeAt(Ec-1)==61)nb[qc-1]=nb[qc-1].substring(0,2);return nb.join("");};});jsx3.Class.defineClass("jsx3.util.List",null,null,function(m,o){m.wrap=function(g){if(g instanceof m){return g;}else if(g instanceof Array){return new
m(g,true);}else throw new
jsx3.IllegalArgumentException("a",g);};o.init=function(l,h){if(typeof l=="number"){this.ei=new
Array(l);}else if(l instanceof m){this.ei=l.ei.concat();}else{l=m.vN(l);if(l instanceof Array){this.ei=h?l:l.concat();}else this.ei=[];}this.Y7=-1;};o.size=function(){return this.ei.length;};o.get=function(k){return this.ei[k];};o.set=function(i,k){this.ei[i]=k;};o.iterator=function(){return new
m.Iterator(this);};o.clear=function(){this.ei.splice(0,this.ei.length);};o.indexOf=function(p,r){if(r==null)r=0;var
Tb=this.size();for(var
sb=r;sb<Tb;sb++)if(this.get(sb)===p)return sb;return -1;};o.lastIndexOf=function(d,f){if(f==null)f=this.size()-1;for(var
eb=f;eb>=0;eb--)if(this.get(eb)===d)return eb;return -1;};o.contains=function(h){return this.indexOf(h)>=0;};o.remove=function(f){var
vb=this.indexOf(f);if(vb>=0)return this.ei.splice(vb,1)[0];return null;};o.removeAt=function(n,b){if(arguments.length==2){return m.wrap(this.ei.splice(n,b-n));}else return this.ei.splice(n,1)[0];};o.clone=function(){return new
m(this);};o.add=function(q,n){var
bc=this.ei;if(n==null)bc[bc.length]=q;else bc.splice(n,0,q);};o.addAll=function(l,q){if(l instanceof m)l=l.toArray(true);else l=m.vN(l);if(l instanceof Array){if(q==null)this.ei.push.apply(this.ei,l);else this.ei=this.ei.slice(0,q).concat(l,this.ei.slice(q));}else throw new
jsx3.IllegalArgumentException("a",l);};m.vN=function(s){if(s==null||s instanceof Array){return s;}else if(typeof s.length=="number"){var
H=new
Array(s.length);for(var
Z=0;Z<s.length;Z++)H[Z]=s[Z];return H;}else return s;};o.slice=function(i,a){return m.wrap(arguments.length>1?this.ei.slice(i,a):this.ei.slice(i));};o.sort=function(e){if(e)this.ei.sort(e);else this.ei.sort();};o.toArray=function(q){return q?this.ei:this.ei.concat();};o.equals=function(d){if(this===d)return true;if(!(d instanceof m))return false;var
mc=this.size();if(mc!=d.size())return false;for(var
oc=0;oc<mc;oc++)if(this.get(oc)!==d.get(oc))return false;return true;};o.filter=function(r){var
ub=[];var
wc=this.size();for(var
Fb=0;Fb<wc;Fb++){var
Rb=this.get(Fb);if(r(Rb))ub[ub.length]=Rb;}return m.wrap(ub);};o.map=function(e,j,c){var
xb=this.size();if(j){if(c){var
cb={};for(var
Zb=0;Zb<xb;Zb++){var
Nb=e(this.get(Zb));for(var
B=0;B<Nb.length;B=B+2)cb[Nb[B]]=Nb[B+1];}return cb;}else{var
cb=[];for(var
Zb=0;Zb<xb;Zb++){var
Ib=e(this.get(Zb));if(Ib instanceof Array)cb.push.apply(cb,Ib);else cb[cb.length]=Ib;}return m.wrap(cb);}}else if(c){var
cb={};for(var
Zb=0;Zb<xb;Zb++){var
jc=e(this.get(Zb));cb[jc[0]]=jc[1];}return cb;}else{var
cb=new
Array(xb);for(var
Zb=0;Zb<xb;Zb++)cb[Zb]=e(this.get(Zb));return m.wrap(cb);}};o.toString=function(){return "["+this.ei+"]";};o.reset=function(){this.Y7=-1;return this;};o.next=function(){return this.get(
++this.Y7);};o.move=function(k){this.Y7=k;return this;};o.hasNext=function(){return this.Y7<this.size()-1;};o.getIndex=function(){return this.Y7;};o.getItem=function(i){return this.get(i);};o.getLength=function(){return this.size();};});jsx3.Class.defineInterface("jsx3.util.Iterator",null,function(n,r){r.next=jsx3.Method.newAbstract();r.hasNext=jsx3.Method.newAbstract();r.remove=jsx3.Method.newAbstract();});jsx3.Class.defineClass("jsx3.util.List.Iterator",null,[jsx3.util.Iterator],function(n,r){r.init=function(b){this.eh=b;this.wn=b?b.size():0;this.hK=0;};r.next=function(){return this.eh.get(this.hK++);};r.hasNext=function(){return this.hK<this.wn;};r.remove=function(){if(this.hK>0){this.eh.removeAt(
--this.hK);this.wn--;}};});jsx3.Class.defineClass("jsx3.app.AddIn",null,[jsx3.net.URIResolver],function(d,j){var
C=jsx3.net.URIResolver;d.PROTOTYPES_DIR="prototypes/";j.init=function(m,r){var
Eb=jsx3.System.addinKeyToPath(m);this.Gn=m;this.h1=Eb;this.ip=new
jsx3.net.URI(Eb);this.Cp=jsx3.app.Browser.getLocation().resolve(this.ip);this.p8=r;};j.getId=function(){return this.getSettings().get("id");};j.getName=function(){return this.getSettings().get("name");};j.getDescription=function(){return this.getSettings().get("description");};j.getVersion=function(){return this.getSettings().get("version");};j.getJsxVersion=function(){return this.getSettings().get("jsxversion")||"3.1";};j.getKey=function(){return this.Gn;};j.getPath=function(){return this.h1;};j.getSettings=function(){if(this.p8==null)this.p8=new
jsx3.app.Settings(3,this);return this.p8;};j.resolveURI=function(i){var
fc=jsx3.net.URI.valueOf(i);if(jsx3.util.compareVersions(this.getJsxVersion(),"3.2")>=0&&!C.isAbsoluteURI(fc)){return C.DEFAULT.resolveURI(this.ip.resolve(fc));}else return C.DEFAULT.resolveURI(fc);};j.getUriPrefix=function(){return this.ip.toString();};j.relativizeURI=function(e,l){var
t=jsx3.app.Browser.getLocation();var
mb=this.Cp.relativize(t.resolve(e));if(mb.isAbsolute()||l)return mb;else return jsx3.net.URI.fromParts("jsxaddin",null,this.getKey().replace(/:/,"!"),null,"/"+mb.getPath(),mb.getQuery(),mb.getFragment());};j.toString=function(){return this.Gn;};});jsx3.Class.defineInterface("jsx3.util.EventDispatcher",null,function(c,m){c.i5=1;c.vS=2;c.Lz=3;c.nX=4;c.Ju=5;m._jsxVI=null;c.SUBJECT_ALL="*";m.subscribe=function(j,s,f){var
G=typeof s;var
vc=typeof f;var
w=null;if(G=="object"){if(vc=="function"){w=[c.i5,s,f];}else if(vc=="string")w=[c.vS,s,f];}else if(G=="string"){if(vc=="function"){w=[c.Lz,s,f];}else if(vc=="string")w=[c.nX,s,f];}else if(G=="function")w=[c.Ju,s];if(w==null&&G=="object"&&s.call&&s.apply)w=[c.Ju,s];if(w==null)throw new
jsx3.IllegalArgumentException("objHandler, objFunction","{"+typeof s+"}, {"+typeof f+"}");if(!(j instanceof Array))j=[j];for(var
bb=0;bb<j.length;bb++){var
cc=this.b1();var
C=cc[j[bb]];if(C==null)C=cc[j[bb]]=new
jsx3.util.List();C.add(w);}};m.unsubscribe=function(h,b){if(!(h instanceof Array))h=[h];for(var
Hc=0;Hc<h.length;Hc++){var
Rb=this.b1()[h[Hc]];if(Rb!=null)for(var
eb=Rb.iterator();eb.hasNext();)if(eb.next()[1]===b)eb.remove();}};m.unsubscribeAll=function(h){delete this.b1()[h];};m.unsubscribeAllFromAll=function(){this._jsxVI={};};m.publish=function(a){if(a.target==null)a.target=this;var
rc=a.subject;if(rc==null)throw new
jsx3.IllegalArgumentException("objEvent",a);var
jb=this.b1()[rc];var
ic=this.b1()["*"];if((jb==null||jb.size()==0)&&(ic==null||ic.size()==0))return 0;var
F=new
jsx3.util.List();if(jb!=null)F.addAll(jb);if(ic!=null)F.addAll(ic);for(var
Mc=F.iterator();Mc.hasNext();){var
ub=Mc.next();var
Ab=ub[0];var
mb=ub[1];var
wb=ub[2];if(Ab==c.i5){wb.call(mb,a);}else if(Ab==c.vS){mb[wb](a);}else if(Ab==c.Lz){var
Bc=this.getServer().getJSX(mb);if(Bc)wb.call(Bc,a);}else if(Ab==c.nX){var
Bc=this.getServer().getJSX(mb);if(Bc)Bc[wb](a);}else if(Ab==c.Ju){mb.call(null,a);}else{}}return F.size();};m.getSubscriberCount=function(k){var
sc=this.b1()[k];return sc!=null?sc.size():0;};m.b1=function(){if(this._jsxVI==null)this._jsxVI={};return this._jsxVI;};});jsx3.util.EventDispatcher.jsxclass.mixin(jsx3);jsx3.EventDispatcher=jsx3.util.EventDispatcher;jsx3.Class.defineClass("jsx3.net.URI",null,null,function(s,f){s.i3="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";s.T0="0123456789";s.ov=s.i3+s.T0;s.B5=s.ov+"_-!.~'()*";s.FR=",;:$&+=";s.nC=s.FR+"?/[]@";s.FK="%";s._p=new
RegExp("^["+s.i3+"][\\-\\.\\+"+s.i3+"]*\\:");f.E9=null;f.RS=null;f.GI=null;f.ft=null;f.Br=null;f.h1=null;f.dq=null;f.Fz=null;f.K5=null;f.mC=null;s.fromParts=function(k,p,e,m,o,r,l){var
sc=s.jsxclass.bless();var
wb=arguments;var
B=null,N=null;if(wb.length==3){sc.RS=wb[0];N=s.encode(wb[1],s.B5+s.nC+s.FK);sc.GI=s.decode(wb[1]);sc.ft=s.decode(wb[2]);}else if(wb.length==7){sc.RS=wb[0];sc.Fz=s.decode(wb[1]);sc.K5=wb[2];sc.mC=wb[3];sc.h1=s.decode(wb[4]);sc.dq=s.decode(wb[5]);sc.ft=s.decode(wb[6]);}else throw new
jsx3.IllegalArgumentException("arguments",jsx3.Method.argsAsArray(wb));if(sc.Br==null&&sc.K5!=null){sc.Br=B=sc.K5;if(sc.Fz){sc.Br=sc.Fz+"@"+sc.Br;B=s.encode(sc.Fz,s.B5+s.FR+s.FK)+"@"+B;}if(sc.mC){sc.Br=sc.Br+":"+sc.mC;B=B+":"+sc.mC;}}if(sc.GI==null){sc.GI=N="";if(sc.h1){sc.GI=sc.h1;N=s.encode(sc.h1,s.B5+s.FR+s.FK+"/@");}if(sc.Br!=null){sc.GI="//"+sc.Br+sc.GI;N="//"+B+N;}if(sc.dq){sc.GI=sc.GI+"?"+sc.dq;N=N+"?"+s.encode(sc.dq,s.B5+s.FR+s.FK);}}if(sc.E9==null){sc.E9=N;if(sc.RS)sc.E9=sc.RS+":"+sc.E9;if(sc.ft!=null)sc.E9=sc.E9+"#"+s.encode(sc.ft,s.B5+s.nC+s.FK);}return sc;};f.init=function(j){if(j==null)j="";if(typeof j!="string")j=j.toString();this.E9=j;var
Jb=j;var
Ub;if(s._p.test(Jb)){var
Bc=RegExp.lastMatch;this.RS=Jb.substring(0,Bc.length-1);Jb=Jb.substring(Bc.length);}if((Ub=Jb.indexOf("#"))>=0){this.ft=s.decode(Jb.substring(Ub+1));Jb=Jb.substring(0,Ub);}this.GI=Jb;var
Z=this.RS!=null;var
Eb=Z&&Jb.indexOf("/")!=0;if(!Eb){if(Jb.indexOf("//")==0){Ub=Jb.indexOf("/",2);this.Br=Jb.substring(2,Ub>=0?Ub:Jb.length);Jb=Ub>=0?Jb.substring(Ub):"";}if((Ub=Jb.indexOf("?"))>=0){this.dq=s.decode(Jb.substring(Ub+1));Jb=Jb.substring(0,Ub);}this.h1=s.decode(Jb);var
Mb=this.Br;if(Mb){if((Ub=Mb.indexOf("@"))>=0){this.Fz=s.decode(Mb.substring(0,Ub));Mb=Mb.substring(Ub+1);}if((Ub=Mb.indexOf(":"))>=0){this.mC=parseInt(Mb.substring(Ub+1));Mb=Mb.substring(0,Ub);}}this.K5=Mb;}};f.normalize=function(){if(jsx3.util.strEmpty(this.h1))return this;var
Lb=this.h1.split("/");s.sF(Lb);var
u=Lb.join("/");return u==this.h1?this:s.fromParts(this.RS,this.Fz,this.K5,this.mC,u,this.dq,this.ft);};s.sF=function(g){var
Nb=g[0]!=="";for(var
Lc=g.length-1;Lc>=0;Lc--)if(g[Lc]==".")g.splice(Lc,1);for(var
Lc=0;Lc<g.length;Lc++)if(Lc>0&&g[Lc]==".."&&g[Lc-1]!=".."){g.splice(Lc-1,2);Lc=Lc-2;}if(Nb&&g[0]!=null&&g[0].indexOf(":")>=0)g.unshift(".");};f.resolve=function(e){e=s.valueOf(e);if(this.E9=="")return e;if(e.isAbsolute()||this.isOpaque())return e;if(e.ft&&!e.h1&&!e.RS&&!e.Br&&!e.dq)return s.fromParts(this.RS,this.Fz,this.K5,this.mC,this.h1,this.dq,e.ft);var
Vb=this.RS;var
wc=e.dq;var
oc=e.ft;var
sb=null,Mc=null,yb=null,gc=null;if(e.Br!=null){sb=e.Fz;Mc=e.K5;yb=e.mC;gc=e.h1;}else{sb=this.Fz;Mc=this.K5;yb=this.mC;if(e.h1.indexOf("/")==0){gc=e.h1;}else{var
U=this.h1.split("/");U.pop();U.push.apply(U,e.h1.split("/"));s.sF(U);gc=U.join("/");}}return s.fromParts(Vb,sb,Mc,yb,gc,wc,oc);};f.relativize=function(b){b=s.valueOf(b);if(this.E9=="")return b;if(this.isOpaque()||b.isOpaque())return b;if(this.RS!=b.RS)return b;var
Hc=this.Br!=null?this.Br:"";var
Sb=b.Br!=null?b.Br:"";if(Hc!=Sb)return b;var
D=this.h1||"";var
wb=b.h1||"";var
cc=D.split("/");cc.pop();var
C=wb.split("/");var
wc=[];var
X=0;while(X<cc.length&&X<C.length){if(cc[X]!=C[X])break;X++;}var
eb=null;if(X<2&&D.indexOf("/")==0){eb=wb;}else{for(var
Dc=X;Dc<cc.length;Dc++)wc[wc.length]="..";for(var
Dc=X;Dc<C.length;Dc++)wc[wc.length]=C[Dc];eb=wc.join("/");}return s.fromParts(null,null,null,null,eb,b.dq,b.ft);};f.getAuthority=function(){return this.Br;};f.getFragment=function(){return this.ft;};f.getHost=function(){return this.K5;};f.getPath=function(){return this.h1;};f.getPort=function(){return this.mC;};f.getQuery=function(){return this.dq;};f.getQueryParam=function(g){var
u=this.dq;if(u){var
T=0;var
bb=g.length;var
mc=null;while((mc=u.indexOf(g,T))>=0){if(mc==0||u.charAt(mc-1)=="&"){var
fb=u.charAt(mc+bb);if(fb=="&"||jsx3.util.strEmpty(fb)){return true;}else if(fb=="="){var
Fc=u.indexOf("&",mc+bb+1);return Fc>=0?u.substring(mc+bb+1,Fc):u.substring(mc+bb+1);}}T=mc+bb;}}return null;};f.getQueryParams=function(){var
db={};if(this.dq){var
Mb=this.dq.split("&");for(var
K=0;K<Mb.length;K++){var
u=Mb[K];var
Lb=u.indexOf("=");if(Lb>=0){db[u.substring(0,Lb)]=u.substring(Lb+1);}else db[u]=true;}}return db;};f.getScheme=function(){return this.RS;};f.getSchemeSpecificPart=function(){return this.GI;};f.getUserInfo=function(){return this.Fz;};f.isAbsolute=function(){return this.RS!=null;};f.isOpaque=function(){return this.RS!=null&&this.GI.indexOf("/")!=0;};f.equals=function(p){if(this===p)return true;if(!(p instanceof jsx3.net.URI))return false;var
Wb=this.RS;var
gb=p.RS;if(Wb==null&&gb!=null||Wb!=null&&gb==null)return false;if(Wb!=null&&Wb.toLowerCase()!=gb.toLowerCase())return false;if(this.ft!=p.ft)return false;if(this.isOpaque()){if(!p.isOpaque())return false;return this.GI==p.GI;}else return this.h1==p.h1&&this.dq==p.dq&&this.Br==p.Br;};f.toString=function(){return this.E9;};s.encode=function(q,j){if(q==null)return null;if(j==null)j=s.B5;var
sb=new
RegExp("^["+j.replace(/(\W)/g,"\\$1")+"]*$");if(q.match(sb))return q;var
z=q.length;var
P=new
Array(z);for(var
C=0;C<z;C++){var
nc=q.charAt(C);if(j.indexOf(nc)<0){var
Cb=nc.charCodeAt(0);if(Cb<16){P[C]="%0"+Cb.toString(16).toUpperCase();}else if(Cb<256){P[C]="%"+Cb.toString(16).toUpperCase();}else P[C]=nc;}else P[C]=nc;}return P.join("");};s.decode=function(k){if(k==null)return null;if(k.indexOf("%")<0)return k;var
K=k.length;var
Ob=new
Array(K);var
P=0;for(var
gb=0;gb<k.length;gb++){var
ab=k.charAt(gb);if(ab=="%"){var
Ub=k.substring(gb+1,gb+3);if(Ub.match(/[^a-fA-F0-9]/)){Ob[P++
]=ab;}else{Ob[P++
]=String.fromCharCode(parseInt(Ub,16));gb=gb+2;}}else Ob[P++
]=ab;}return Ob.join("");};s.valueOf=function(b){if(jsx3.util.strEmpty(b))return s.K9;return b instanceof s?b:new
s(b);};s.K9=new
s();});jsx3.Class.defineClass("jsx3.gui.Event",null,null,function(k,a){k.BEFOREUNLOAD="beforeunload";k.BLUR="blur";k.CHANGE="change";k.CLICK="click";k.DOUBLECLICK="dblclick";k.ERROR="error";k.FOCUS="focus";k.KEYDOWN="keydown";k.KEYPRESS="keypress";k.KEYUP="keyup";k.LOAD="load";k.MOUSEDOWN="mousedown";k.MOUSEMOVE="mousemove";k.MOUSEOUT="mouseout";k.MOUSEOVER="mouseover";k.MOUSEUP="mouseup";k.MOUSEWHEEL="mousewheel";k.UNLOAD="unload";k.RESIZE="resize";k.KEY_ALT=18;k.KEY_ARROW_DOWN=40;k.KEY_ARROW_LEFT=37;k.KEY_ARROW_RIGHT=39;k.KEY_ARROW_UP=38;k.KEY_BACKSPACE=8;k.KEY_CONTROL=17;k.KEY_DELETE=46;k.KEY_END=35;k.KEY_ENTER=13;k.KEY_ESCAPE=27;k.KEY_HOME=36;k.KEY_INSERT=45;k.KEY_META=-1;k.KEY_PAGE_DOWN=34;k.KEY_PAGE_UP=33;k.KEY_SHIFT=16;k.KEY_SPACE=32;k.KEY_TAB=9;k.KEY_0=48;k.KEY_9=57;k.KEY_A=65;k.KEY_Z=90;k.KEY_NP0=96;k.KEY_NP9=105;k.KEY_NPDIV=111;k.KEY_NPMUL=106;k.KEY_NPSUB=109;k.KEY_NPADD=107;k.KEY_NPDEC=110;k.KEY_F1=112;k.KEY_F15=126;k.cy=[];k.ND=[];k.wQ=jsx3.util.EventDispatcher.jsxclass.newInnerClass();k.LT=[];var
y=null;k.t0=function(){if(k._LOG==null)if(jsx3.Class.forName("jsx3.util.Logger")!=null){y=jsx3.util.Logger;k._LOG=y.getLogger(k.jsxclass.getName());}return k._LOG;};k._registerWindow=function(h){var
Ec=k.t0();if(Ec!=null&&Ec.isLoggable(5))Ec.debug("registering window "+h.name);k.cy.push(h);k.ND.push({});k.LT.push({});};k._deregisterWindow=function(d){var
J=jsx3.util.arrIndexOf(k.cy,d);if(J>=0){var
ub=k.t0();if(ub!=null&&ub.isLoggable(5))ub.debug("deregistering window "+d.name);k.cy.splice(J,1);k.ND.splice(J,1);k.LT.splice(J,1);}else throw new
jsx3.Exception("Window "+d+" not registered.");};k._registerWindow(window);k.subscribe=function(d,f,l){k.wQ.subscribe(d,f,l);var
kc="on"+d;var
J=k.t0();if(J!=null&&J.isLoggable(5))J.debug("Subscribing to event "+d+": "+f.toString().substring(0,50).replace(/\s+/g," "));for(var
Ic=0;Ic<k.cy.length;Ic++)try{var
sb=k.cy[Ic];var
bc=k.gH(sb,d);if(bc.attachEvent&&k.cX(d)){var
Ec=k.LT[Ic];if(!Ec[d]){if(J!=null&&J.isLoggable(5))J.debug("attaching event listener "+d+" to "+bc+".");bc.attachEvent(kc,k.q3);Ec[d]=true;}}else if(bc.addEventListener&&k.l2(d)){var
Ec=k.LT[Ic];if(!Ec[d]){if(J!=null&&J.isLoggable(5))J.debug("adding event listener "+d+" to "+bc+".");bc.addEventListener(d,k.q3,false);Ec[d]=true;}}else{var
T=k.ND[Ic];if(bc[kc]!=k.q3){if(J!=null&&J.isLoggable(5))J.debug("setting event handler "+kc+" on "+bc+".");if(bc[kc]!=null)T[kc]=bc[kc];bc[kc]=k.q3;}}}catch(Kc){if(J!=null&&J.isLoggable(5))J.debug("error subscribing to event "+d,jsx3.NativeError.wrap(Kc));k._deregisterWindow(sb);Ic--;}};k.L3=[];k.y_=function(q){var
ab=k.wrap(q);var
C=ab.srcElement();var
lb=k.L3.concat();var
Tb=k.t0();L3:for(var
ob=0;ob<lb.length;ob++){var
mb=lb[ob];var
nb=mb[0];var
Eb=mb[1];var
Ib=mb[2];var
J=C;while(J!=null){if(J==Eb)continue L3;J=J.parentNode;}if(Tb!=null&&Tb.isLoggable(5))Tb.debug("_focusHandler  lost focus:"+Eb+" ("+nb+")");var
x={target:k,event:ab};if(typeof Ib=="function")Ib.call(nb,x);else nb[Ib](x);}};k.subscribeLoseFocus=function(r,d,e){var
Tb=k.t0();if(Tb!=null&&Tb.isLoggable(5))Tb.debug("subscribeLoseFocus "+r+" "+d);k.L3.push([r,d,e]);if(k.L3.length==1){if(Tb!=null&&Tb.isLoggable(5))Tb.debug("... adding event listener to "+d.ownerDocument);d.ownerDocument.addEventListener("focus",k.y_,true);}};k.unsubscribeLoseFocus=function(p){var
D=k.t0();if(D!=null&&D.isLoggable(5))D.debug("unsubscribeLoseFocus "+p);var
Xb=null;for(var
tc=0;tc<k.L3.length;tc++)if(k.L3[tc][0]==p){Xb=k.L3[tc][1].ownerDocument;k.L3.splice(tc--
,1);}if(k.L3.length==0&&Xb!=null){if(D!=null&&D.isLoggable(5))D.debug("... removing event listener from "+Xb);Xb.removeEventListener("focus",k.y_,true);}};k.preventSelection=function(c){};k.unsubscribe=function(f,d){var
Pb=k.t0();if(Pb!=null&&Pb.isLoggable(5))Pb.debug("Unsubscribing from event "+f+": "+d.toString().substring(0,50).replace(/\s+/g," "));k.wQ.unsubscribe(f,d);if(k.wQ.getSubscriberCount(f)==0)k.bz(f);};k.unsubscribeAll=function(b){var
Db=k.t0();if(Db!=null&&Db.isLoggable(5))Db.debug("Unsubscribing all from event "+b+".");k.wQ.unsubscribeAll(b);k.bz(b);};k.publish=function(l){var
kc={subject:l.getType(),target:k,event:l};k.T3(kc);};k.T3=function(m){var
tc="on"+m.subject.toLowerCase();var
E=k.t0();if(E!=null&&E.isLoggable(6))E.trace("Publishing event: "+tc+".");var
Q=k.ND[0];if(Q[tc]!=null)Q[tc]();k.wQ.publish(m);};k.q3=function(l){var
bc=new
k(l!=null?l:window.event);var
qb=k.t0();if(qb!=null&&qb.isLoggable(6))qb.trace("Handling event: "+bc.getType()+".");var
B={subject:bc.getType(),target:k,event:bc};k.T3(B);if(B.returnValue)return B.returnValue;};k.bz=function(r){var
yb="on"+r;var
H=k.t0();for(var
ic=0;ic<k.cy.length;ic++)try{var
T=k.cy[ic];var
P=k.gH(T,r);if(P.attachEvent&&k.cX(r)){var
rb=k.LT[ic];if(rb[r]){if(H!=null&&H.isLoggable(5))H.debug("detaching event listener "+r+" from "+P);P.detachEvent(yb,k.q3);rb[r]=false;}}else if(P.removeEventListener&&k.l2(r)){var
rb=k.LT[ic];if(rb[r]){if(H!=null&&H.isLoggable(5))H.debug("removing event listener "+r+" from "+P+".");P.removeEventListener(r,k.q3,false);rb[r]=false;}}else{var
N=k.ND[ic];if(H!=null&&H.isLoggable(5))H.debug("unsetting event handler "+yb+" on "+P+".");if(N[yb]!=null){P[yb]=N[yb];delete N[yb];}else P[yb]=null;}}catch(Kc){if(H!=null&&H.isLoggable(5))H.debug("error subscribing to event "+r,jsx3.NativeError.wrap(Kc));k._deregisterWindow(T);ic--;}};k.gH=function(r,q){return q=="beforeunload"||q=="unload"||q=="resize"?r:r.document;};k.cX=function(s){return s!="beforeunload";};k.l2=function(g){return g!="beforeunload";};a.init=function(i,q){this.SL=i;if(q)this._clone=jsx3.clone(i);};a.bg=function(){if(this._clone==null)this._clone=jsx3.clone(this.SL);this._clone._jsxEt=true;};k.wrap=function(b,n){return b instanceof k?b:new
k(b,n);};k.getCurrent=function(c){return window.event?new
k(window.event,c):null;};a.Hx=function(){try{if(this.SL==null)return this._clone;else if(this.SL.currentTarget!=null)return this.SL;}catch(Kc){}this.SL=null;return this._clone;};a.event=function(){return this.Hx();};a.getType=function(){return this.Hx().type;};a.srcElement=function(){var
L=this.Hx();return L.target||L.srcElement;};a.toElement=function(){var
S=this.Hx();return S.type=="mouseout"?S.relatedTarget:S.target;};a.fromElement=function(){var
K=this.Hx();return K.type=="mouseover"?K.relatedTarget:K.target;};a.isMouseEvent=function(){var
ob=this.getType()||"";return ob.indexOf("mouse")==0||ob=="click"||ob=="dblclick";};a.isKeyEvent=function(){return (this.getType()||"").indexOf("key")==0;};a.setCapture=function(n){};a.releaseCapture=function(m){};a.keyCode=function(){var
Bc=this.Hx();return Bc.keyCode;};a.clientX=function(){var
Ic=this.Hx();return Ic?Ic.clientX:Number.NaN;};a.clientY=function(){var
nb=this.Hx();return nb?nb.clientY:Number.NaN;};a.getOffsetX=function(){var
dc=this.Hx().target;var
K=this.Hx().clientX;return K-jsx3.html.getRelativePosition(dc.ownerDocument.body,dc).L;};a.getOffsetY=function(){var
Ub=this.Hx().target;var
qb=this.Hx().clientY;return qb-jsx3.html.getRelativePosition(Ub.ownerDocument.body,Ub).T;};a.getScreenX=function(){return this.Hx().screenX;};a.getScreenY=function(){return this.Hx().screenY;};a.getTrueX=function(){return this.Hx().clientX;};a.getTrueY=function(){return this.Hx().clientY;};a.getWheelDelta=function(){var
Bc=-1*this.Hx().detail;return Bc;};a.shiftKey=function(){var
Ob=this.Hx();return Ob.shiftKey;};a.ctrlKey=function(){var
ib=this.Hx();return ib.ctrlKey;};a.altKey=function(){var
Pb=this.Hx();return Pb.altKey;};a.metaKey=function(){var
cb=this.Hx();return cb.metaKey;};a.enterKey=function(){return this.Hx().keyCode==13;};a.spaceKey=function(){return this.Hx().keyCode==32;};a.tabKey=function(){return this.Hx().keyCode==9;};a.rightArrow=function(){return this.Hx().keyCode==39;};a.leftArrow=function(){return this.Hx().keyCode==37;};a.upArrow=function(){return this.Hx().keyCode==38;};a.downArrow=function(){return this.Hx().keyCode==40;};a.deleteKey=function(){return this.Hx().keyCode==46;};a.backspaceKey=function(){return this.Hx().keyCode==8;};a.insertKey=function(){return this.Hx().keyCode==45;};a.homeKey=function(){return this.Hx().keyCode==36;};a.endKey=function(){return this.Hx().keyCode==35;};a.pageUpKey=function(){return this.Hx().keyCode==33;};a.pageDownKey=function(){return this.Hx().keyCode==34;};a.escapeKey=function(){return this.Hx().keyCode==27;};a.exists=function(){return this.Hx()!=null;};a.cancelBubble=function(){var
cc=this.Hx();cc._jsxhz=true;if(!cc._jsxEt)cc.stopPropagation();};a.cancelReturn=function(){this.Hx().returnValue=false;};a.cancelKey=function(){var
P=this.Hx();if(!P._jsxEt){P.stopPropagation();P.preventDefault();}};a.cancelAll=function(){this.cancelBubble();this.cancelKey();this.cancelReturn();};a.leftButton=function(){var
Ub=this.Hx();if(jsx3.app.Browser.macosx&&Ub.ctrlKey)return false;var
Yb=this.getType();if(Yb=="mousedown"||Yb=="mouseup"){return Ub.button==0;}else if(Yb=="click"||Yb=="dblclick")return Ub.button==0;return false;};a.rightButton=function(){var
Mc=this.Hx();var
Kb=this.getType();if(Kb=="mousedown"||Kb=="mouseup")return Mc.button==2||jsx3.app.Browser.macosx&&Mc.ctrlKey;else return false;};a.button=function(){var
cb=this.Hx();return cb.button;};a.setReturn=function(o){this.Hx().returnValue=o;};a.setKeyCode=function(f){var
Mc=this.Hx();if(Mc.charCode==13){var
qc=this.getDocument().createEvent("KeyEvents");qc.initKeyEvent("keypress",true,true,this.getDocument().defaultView,Mc.ctrlKey(),Mc.altKey(),Mc.shiftKey(),false,0,f);Mc.preventDefault();Mc.target.dispatchEvent(qc);}};a.isModifierKey=function(){var
xc=this.Hx();return xc.keyCode==16||xc.keyCode==17||xc.keyCode==18||xc.keyCode==-1;};a.hasModifier=function(s){return !s&&this.shiftKey()||this.ctrlKey()||this.altKey()||this.metaKey();};a.isArrowKey=function(){var
pb=this.keyCode();return pb>=37&&pb<=40;};a.isFunctionKey=function(){var
wb=this.keyCode();return wb>=112&&wb<=126;};a.getAttribute=function(q){return this.Hx()[q];};a.setAttribute=function(q,i){this.Hx()[q]=i;};a.removeAttribute=function(s){this.Hx()[s]=null;};k.dispatchMouseEvent=function(e,h,b){var
H=document.createEvent("MouseEvent");H.initMouseEvent(h,true,true,window,0,0,0,0,0,false,false,false,false,0,e);if(b)for(var xc in b)H[xc]=b[xc];e.dispatchEvent(H);};k.dispatchKeyEvent=function(d,q,c,s,p,g,n){var
Ac=document.createEvent("KeyEvent");Ac.initMouseEvent(q,true,true,window,0,0,0,0,0,false,p,g,s,0,d);Ac.keyCode=c;if(n)for(var rc in n)Ac[rc]=n[rc];d.dispatchEvent(Ac);};window.addEventListener("DOMMouseScroll",function(o){var
Mb=o.target||o.srcElement;while(Mb!=null&&!o._jsxhz){if(Mb.getAttribute){var
Rb=Mb.getAttribute("onmousewheel");if(Rb)jsx3.eval.call(Mb,Rb,{event:o});}Mb=Mb.parentNode;}},false);a.isFakeOut=function(o){if(this.getType()=="mouseout"){var
F=this.toElement();try{while(F!=null){if(F==o)return true;F=F.parentNode;}}catch(Kc){return false;}}return false;};a.isFakeOver=function(o){if(this.getType()=="mouseover"){var
ib=this.fromElement();try{while(ib!=null){if(ib==o)return true;ib=ib.parentNode;}}catch(Kc){return false;}}return false;};a.toString=function(){var
I=this.Hx();if(I==null)return "@jsx3.gui.Event <empty>";var
T=[];for(var cc in I)if(typeof I[cc]!="function")T[T.length]=cc;T.sort();var
mc=["@jsx3.gui.Event "];for(var
Yb=0;Yb<T.length;Yb++)mc[mc.length]=T[Yb]+":"+I[T[Yb]]+" ";return mc.join("");};});jsx3.gui.Event.subscribe("unload",jsx3.destroy);jsx3.Class.defineClass("jsx3.app.Browser",null,null,function(a,s){a.WIN32="win32";a.LINUX="linux";a.MACOSX="macosx";a.OTHER="other";a.getLocaleString=function(){var
Ec=window.navigator.language;var
Ab=Ec.split(/[_-]/);if(Ab.length>0){Ab[0]=Ab[0].toLowerCase();if(Ab.length>1)Ab[1]=Ab[1].toUpperCase();}return Ab.join("_");};a.isTableMoveBroken=function(h){return true;};a.tQ=null;a.getStyleClass=function(q){if(a.tQ==null){a.tQ={};for(var
Gb=0;Gb<document.styleSheets.length;Gb++){var
sb=document.styleSheets[Gb];for(var
Ac=0;Ac<sb.cssRules.length;Ac++){var
uc=sb.cssRules[Ac];a.tQ[uc.selectorText]=uc.style;}}}return a.tQ[q];};a.getLocation=function(){if(a.VG==null)a.VG=new
jsx3.net.URI(window.location.href);return a.VG;};a.getSystem=function(){if(a.Ry==null){var
v=navigator.platform;var
E=navigator.userAgent;var
Ob="other";if(v.indexOf("Win")==0)Ob="win32";else if(v.indexOf("Linux")==0)Ob="linux";else if(E.indexOf("Mac OS X")!=-1)Ob="macosx";a.Ry=Ob;}return a.Ry;};a[a.getSystem()]=true;});jsx3.Class.defineClass("jsx3.app.Settings",null,null,function(i,s){i.DOMAIN_SYSTEM=1;i.DOMAIN_PROJECT=2;i.DOMAIN_ADDIN=3;i.uJ="JSX/settings.xml";i.PATH_PROJECT="/config.xml";i.qv="/config.xml";i.u_="JSX_SETTINGS";s.init=function(g,d){var
Hb=null;var
hb=null;var
Mb=null;if(g instanceof jsx3.xml.Document){this.bn(null,null,g.getSourceURL(),g);return;}else if(g==1){Hb=jsx3.getSystemCache();hb=i.u_;Mb=i.uJ;}else if(g==2){if(typeof d=="object"){Hb=d.getCache();hb=i.u_;Mb=d.getAppPath()+i.PATH_PROJECT;}else if(typeof d=="string")Mb=d+i.PATH_PROJECT;}else if(g==3){Hb=jsx3.getSystemCache();var
Pb=d instanceof jsx3.app.AddIn?d.getPath():jsx3.System.addinKeyToPath(d);hb=i.u_+"_addin_"+Pb;Mb=Pb+i.qv;}else throw new
jsx3.IllegalArgumentException("intDomain",g);this.bn(Hb,hb,Mb);};s.bn=function(r,d,q,f){if(r!=null)f=r.getDocument(d,true);if(f==null){f=new
jsx3.xml.Document();if(q!=null){this.ij(f,q);if(f.hasError()){jsx3.util.Logger.GLOBAL.warn(jsx3._msg("sets.error",q,f.getError()));f=(new
jsx3.xml.Document()).loadXML('<data jsxid="jsxroot"/>');}}else{jsx3.util.Logger.GLOBAL.warn(jsx3._msg("sets.no_url"));f=(new
jsx3.xml.Document()).loadXML('<data jsxid="jsxroot"/>');}if(r!=null)r.setDocument(d,f,true);}this.h1=q;this._h=f;this.pd=f.getRootNode();this.hj=r;this.Xf=d;if(r!=null)this.Lm=r.getTimestamp(d);};s.ij=function(d,a){d.load(a);};s.get=function(q){var
eb=this.m9(arguments);if(typeof eb=="undefined"){var
Jc=this.getNode.apply(this,arguments);if(Jc==null)return null;eb=i.i2(Jc);this.xv(eb,arguments);}return eb;};s.getMapInArrayByField=function(q,h,f){var
Jb=[];for(var
kb=0;kb<arguments.length-2;kb++)Jb.push(arguments[0]);h=arguments[arguments.length-2];f=arguments[arguments.length-1];var
Vb=this.getNode.apply(this,Jb);if(Vb){var
Nc=Vb.selectSingleNode("./record[@type='map' and record[@jsxid='"+h+"' and .='"+f+"']]");if(Nc!=null)return i.i2(Nc);}return null;};s.getMapsInArrayByField=function(r,h,g){var
tb=[];for(var
qb=0;qb<arguments.length-2;qb++)tb.push(arguments[0]);h=arguments[arguments.length-2];g=arguments[arguments.length-1];var
V=this.getNode.apply(this,tb);if(V){var
Bb=V.selectNodes("./record[@type='map' and record[@jsxid='"+h+"' and .='"+g+"']]");return Bb.map(function(k){return i.i2(k);}).toArray(true);}return [];};s.getNode=function(k){var
ub=this.pd;var
hb="/data";for(var
Ec=0;ub!=null&&Ec<arguments.length;Ec++)hb=hb+("/record[@jsxid='"+arguments[Ec]+"']");return ub.selectSingleNode(hb);};s.xv=function(q,o){if(o.length==0){this._cache=q;}else{if(this._cache==null)this._cache={_jsxJQ:true};var
kc=this._cache;for(var
Tb=0;Tb<o.length-1;Tb++){var
_b=o[Tb];if(kc[_b]==null)kc[_b]={_jsxJQ:true};kc=kc[_b];}kc[o[o.length-1]]=q;}};s.m9=function(b){if(this.hj){var
Db=this.hj.getTimestamp(this.Xf);if(Db>this.Lm){this.Fk();this.Lm=Db;return;}}var
x=this._cache;for(var
z=0;x!=null&&z<b.length;z++)x=x[b[z]];return x!=null&&x._jsxJQ?i.UNDEF:x;};s.Fk=function(){delete this._cache;};i.c0={array:function(h){var
M=h.selectNodeIterator("./record");var
yb=[];while(M.hasNext()){var
Gb=M.next();var
Ub=i.c0[Gb.getAttribute("type")];yb[yb.length]=Ub?Ub(Gb):Gb.getValue();}return yb;},map:function(r){var
Tb=r.selectNodeIterator("./record");var
eb={};while(Tb.hasNext()){var
Lb=Tb.next();var
bb=i.c0[Lb.getAttribute("type")];eb[Lb.getAttribute("jsxid")]=bb?bb(Lb):Lb.getValue();}return eb;}};i.c0["number"]=function(o){return Number(o.getValue());};i.c0["boolean"]=function(h){return h.getValue()==="true";};i.c0["null"]=function(f){return null;};i.c0["string"]=function(g){return g.getValue();};i.i2=function(a){var
Bc=a.getNodeName()=="data"?"map":a.getAttribute("type");var
cc=i.c0[Bc];return cc!=null?cc(a):a.getValue();};s.toString=function(){return this.jsxsuper()+this.h1;};});jsx3.Settings=jsx3.app.Settings;jsx3.Class.defineClass("jsx3.xml.Entity",null,null,function(m,a){m.TYPEELEMENT=1;m.TYPEATTRIBUTE=2;m.TYPETEXT=3;m.TYPECDATA=4;m.TYPECOMMENT=8;m.eE={1:true,2:true,3:true,4:true,7:true,8:true};a.init=function(p){this.bX=p;this.Nu=p.nodeType;if(!m.eE[this.Nu]){this.Kl(300,jsx3._msg("xml.wrap_type",this.Nu));}else if(this.ey)this.Kl(0);};a.createNode=function(d,k,n){var
qc=this.Ku();var
C=null;if(d==2){if(n){C=qc.createAttributeNS(n,k);}else C=qc.createAttribute(k);}else if(d==3){C=qc.createTextNode(k);}else if(d==4){C=qc.createCDATASection(k);}else if(d==8){C=qc.createComment(k);}else if(n){C=qc.createElementNS(n,k);}else C=qc.createElement(k);return new
m(C);};a.cloneNode=function(j){if(this.Nu==1){var
Lc=this.bX.cloneNode(j);return new
m(Lc);}else this.Kl(301,jsx3._msg("xml.clone_tp",this.Nu));};a.appendChild=function(k){var
Gc=k.bX;if(this.bX!=null&&Gc!=null&&this.Nu==1){this.bX.appendChild(Gc);}else this.Kl(302,jsx3._msg("xml.err_append",k));return this;};a.insertBefore=function(d,l){if(l==null){if(this.Nu==1){this.appendChild(d);return d;}}else{var
I=d.bX;if(this.Nu==1&&l.Nu!=2&&d.Nu!=2)if(l.getParent()!=null&&l.getParent().equals(this)){var
w=new
m(this.bX.insertBefore(I,l.bX));return w;}return null;}};a.replaceNode=function(s,l){var
ab=s.bX;if(this.Nu==1&&l.Nu==1&&s.Nu==1)if(l.getParent()!=null&&l.getParent().equals(this)&&l.getParent()!=null&&l.getParent().equals(this)){var
M=new
m(this.bX.replaceChild(ab,l.bX));return M;}return null;};a.setAttribute=function(g,h){if(h!=null)this.bX.setAttribute(g,String(h));else this.removeAttribute(g);return this;};a.getAttribute=function(i){return this.bX?this.bX.getAttribute(i):null;};a.getAttributeNode=function(j){if(this.bX!=null&&this.Nu==1){var
D=this.bX.getAttributeNode(j);if(D!=null)return new
m(D);}};a.setAttributeNode=function(c){var
kc=c.bX;this.bX.setAttributeNodeNS(kc);return this;};a.getAttributes=function(){if(this.bX!=null&&this.Nu==1)return new
m.List(this.bX.attributes);else return null;};a.getAttributeNames=function(){var
Ub=this.bX.attributes;var
pb=new
Array(Ub.length);for(var
Z=0;Z<pb.length;Z++)pb[Z]=Ub[Z].nodeName;return pb;};a.getRootNode=function(){return this.bX?new
m(this.Ku(1)):null;};a.getParent=function(){return this.bX!=this.Ku(1)?new
m(this.bX.parentNode):null;};a.getChildIterator=function(i){return new
m.ChildIterator(this.bX?this.bX.childNodes:[],i);};a.getChildNodes=function(b){if(!this.bX)return new
m.List([]);var
Y=this.bX.childNodes;var
eb=[];for(var
Kc=0;Kc<Y.length;Kc++){var
fc=Y[Kc];if(fc.nodeType==1||b&&(fc.nodeType==3||fc.nodeType==4))eb[eb.length]=fc;}return new
m.List(eb);};a.removeChild=function(i){var
fc=i.getParent();return fc!=null&&fc.equals(this)?new
m(this.bX.removeChild(i.bX)):null;};a.removeChildren=function(){var
Pb=this.bX.childNodes;for(var
Ib=Pb.length-1;Ib>=0;Ib--)this.bX.removeChild(Pb[Ib]);};a.removeAttribute=function(d){if(this.Nu==1)this.bX.removeAttribute(d);};a.removeAttributeNode=function(o){this.bX.removeAttributeNode(o.bX);return this;};a.equals=function(d){return d.bX==this.bX;};a.getNodeType=function(){return this.Nu;};a.getNodeName=function(){return this.bX.nodeName;};a.getNamespaceURI=function(){var
dc=this.bX.namespaceURI;if(dc==null)dc="";return dc;};a.selectSingleNode=function(b,j){if(!this.bX)return null;return this.jm(b,j,0);};a.selectNodes=function(k,s){if(!this.bX)return new
m.List([]);return this.jm(k,s,1);};a.selectNodeIterator=function(d,h){if(!this.bX)return new
m.SelectIterator();return this.jm(d,h,2);};a.getBaseName=function(){var
oc=this.getNodeName();var
S=oc.indexOf(":");return S>=0?oc.substring(S+1):oc;};a.getPrefix=function(){var
Kb=this.getNodeName();var
mc=Kb.indexOf(":");return mc>=0?Kb.substring(0,mc):"";};a.getXML=function(){return this.toString();};a.toString=function(){var
W="@"+this.getClass().getName();if(this.bX!=null&&!this.hasError()){if(this.getNodeType()==2){return this.getNodeName()+'="'+this.getValue()+'"';}else return (new
XMLSerializer()).serializeToString(this.bX);}else return this.hasError()?jsx3._msg("xml.str_err",W,this.getError()):jsx3._msg("xml.str_empty",W);};a.getValue=function(){if(this.Nu==1){var
sc=new
Array(this.bX.childNodes.length);for(var
Ob=0;Ob<this.bX.childNodes.length;Ob++){var
Lc=this.bX.childNodes[Ob];if(Lc.nodeType==3||Lc.nodeType==4)sc[Ob]=Lc.nodeValue;else sc[Ob]=Lc.textContent;}return sc.join("");}else return this.bX.nodeValue;};a.setValue=function(l){if(l==null)l="";if(this.Nu==1){this.removeChildren();this.appendChild(this.createNode(3,l));}else this.bX.nodeValue=l;return this;};m.qq=new
XPathEvaluator();m.UQ=[XPathResult.FIRST_ORDERED_NODE_TYPE,XPathResult.ORDERED_NODE_ITERATOR_TYPE,XPathResult.ORDERED_NODE_SNAPSHOT_TYPE];a.jm=function(b,j,s){if(typeof j=="object")j=jsx3.xml.Document.Ii(j);var
rb=this.bX.ownerDocument;var
Hb=rb.documentElement;var
Cb=j?m.Uh(j,Hb):m.g5(rb)||m.qq.createNSResolver(Hb);var
Ac=null;try{Ac=m.qq.evaluate(b,this.bX,Cb,m.UQ[s],null);}catch(Kc){}if(s==1){var
Hc=null;var
oc=[];if(Ac)while(Hc=Ac.iterateNext())oc[oc.length]=Hc;return new
m.List(oc);}else if(s==2){return new
m.SelectIterator(Ac);}else return Ac&&Ac.singleNodeValue?new
m(Ac.singleNodeValue):null;};m.g5=function(j){if(!j._jsxoj)if(j._jsxdg)j._jsxoj=m.Uh(j._jsxdg);return j._jsxoj;};m.Uh=function(b){var
Cb=(new
DOMParser()).parseFromString("<foo "+b+"/>","text/xml");return m.qq.createNSResolver(Cb.documentElement);};a.Ku=function(s){if(s==null){return this.bX.ownerDocument;}else if(s==1){var
V=this.bX.ownerDocument;return V!=null?V.documentElement:null;}else if(s==2)return this.bX.documentElement;};a.getNative=function(){return this.bX;};a.getFirstChild=function(){if(this.Nu==1){var
zc=this.bX.firstChild;while(zc!=null&&zc.nodeType!=1)zc=zc.nextSibling;if(zc!=null)return new
m(zc);}return null;};a.getLastChild=function(){if(this.Nu==1){var
pc=this.bX.lastChild;while(pc!=null&&pc.nodeType!=1)pc=pc.previousSibling;if(pc!=null)return new
m(pc);}return null;};a.getPreviousSibling=function(){if(this.Nu==1){var
qc=this.bX.previousSibling;while(qc!=null&&qc.nodeType!=1)qc=qc.previousSibling;if(qc!=null)return new
m(qc);}return null;};a.getNextSibling=function(){if(this.Nu==1){var
eb=this.bX.nextSibling;while(eb!=null&&eb.nodeType!=1)eb=eb.nextSibling;if(eb!=null)return new
m(eb);}return null;};a.transformNode=function(e,o,q){jsx3.require("jsx3.xml.Template");var
yc=new
jsx3.xml.Template(e);if(o)yc.setParams(o);return yc[q?"transformToObject":"transform"](this);};m.zN=function(){};m.zN.prototype.toString=function(){return "["+this.code+"]"+(typeof this.description!="undefined"?" "+this.description:"");};a.Kl=function(j,b){if(this.ey==null)this.ey=new
m.zN();this.ey.code=j;this.ey.description=b;};a.getError=function(){if(!this.ey)this.Kl(0);return this.ey;};a.hasError=function(){return this.ey!=null&&this.ey.code!=0;};a.getOwnerDocument=function(){return this.bX?new
jsx3.xml.Document(this.Ku()):null;};m.getVersion=function(){return "3.0.0";};});jsx3.Entity=jsx3.xml.Entity;jsx3.Class.defineClass("jsx3.xml.Entity.List",jsx3.util.List,null,function(s,i){var
Lc=jsx3.Exception;i.init=function(m){this.jsxsuper(null,true);this.ei=m;};i.get=function(j){var
gb=this.ei[j];return gb!=null?new
jsx3.xml.Entity(gb):gb;};var
qb="Not implemented";i.add=function(){throw new
Lc(qb);};i.addAll=function(){throw new
Lc(qb);};i.set=function(){throw new
Lc(qb);};i.remove=function(){throw new
Lc(qb);};i.removeAt=function(){throw new
Lc(qb);};i.sort=function(){throw new
Lc(qb);};i.slice=function(l,j){return new
s(arguments.length>1?this.ei.slice(l,j):this.ei.slice(l));};i.toString=function(){return "["+this.toArray()+"]";};i.clone=function(){return new
s(this.ei.concat());};i.toArray=function(){var
ec=this.size();var
Y=new
Array(ec);for(var
zc=0;zc<ec;zc++)Y[zc]=this.get(zc);return Y;};});jsx3.Class.defineClass("jsx3.xml.Entity.ChildIterator",null,[jsx3.util.Iterator],function(n,r){r.init=function(q,k){this.YS=q;this.hK=0;this.l8=k;this.CT();this.bX=null;};r.next=function(){if(!this._next)return null;if(this.bX){this.bX.init(this._next);}else this.bX=new
jsx3.xml.Entity(this._next);this.CT();return this.bX;};r.hasNext=function(){return this._next!=null;};r.CT=function(){this._next=null;var
M=this.YS;var
Hc=M.length;while(this._next==null&&this.hK<Hc){var
u=M[this.hK];if(u.nodeType==1||this.l8&&(u.nodeType==3||u.nodeType==4))this._next=u;this.hK++;}};});jsx3.Class.defineClass("jsx3.xml.Entity.SelectIterator",null,[jsx3.util.Iterator],function(p,a){a.init=function(m){this.ZD=m;this.rI=0;this.bX=null;};a.next=function(){var
Gb=this.ZD.snapshotItem(this.rI++);if(!Gb)return null;if(this.bX){this.bX.init(Gb);}else this.bX=new
jsx3.xml.Entity(Gb);return this.bX;};a.hasNext=function(){return this.ZD&&this.rI<this.ZD.snapshotLength;};});jsx3.Collection=jsx3.xml.Entity.List;jsx3.util.Collection=jsx3.Collection;jsx3.Class.defineClass("jsx3.xml.Document",jsx3.xml.Entity,[jsx3.util.EventDispatcher],function(e,m){var
Mb=jsx3.xml.Entity;e.ON_RESPONSE="response";e.ON_ERROR="error";e.ON_TIMEOUT="timeout";e.SEARCHABLE_NAMESPACE="http://xsd.tns.tibco.com/gi/cxf/2006";e.SEARCHABLE_PREFIX="jsx_xmlns";e.DV=/xmlns:([^=]*)=['\"]([^\"^']*)['\"]/g;e.VZ=(new
jsx3.net.URI(window.location.href)).getHost()!=document.domain;m.init=function(j){if(j==null){try{this.O_=window.document.implementation.createDocument("","",null);}catch(Kc){this.Kl(101,jsx3._msg("xml.parser",jsx3.NativeError.wrap(Kc)));delete this.O_;}}else{this.O_=j;this.jsxsuper(j.documentElement);}};m.load=function(q,a){this.oJ=q.toString();var
Jb=jsx3.net.URIResolver.DEFAULT.resolveURI(q);this.Kl(0);var
Bc=this.getAsync()?true:false;if(e.VZ){this.As(Jb,a,Bc);return this;}this.O_.async=Bc;if(this.getAsync()){jsx3.sleep(function(){if(a>0)this._jsx_4=window.setTimeout(jsx3.makeCallback(function(){this.iC();},this),a);this.nO(Jb,a,true);if(this.hasError()){this.BY();this.publish({subject:"error"});}},null,this);}else this.nO(Jb,null,false);return this;};m.EY=function(f){Mb.prototype.init.call(this,f);};e.XV=netscape.security.PrivilegeManager.enablePrivilege;e.t3="UniversalBrowserRead";m.nO=function(p,s,r){e.ev(6,jsx3._msg("xml.doc_load",p));try{if(p.getScheme()&&p.getScheme()!="file"){this._jsxclonedoc=true;e.XV(e.t3);}if(r){this._jsxzB=jsx3.makeCallback(function(){this.Z6();},this);this.O_.addEventListener("load",this._jsxzB,false);}this.O_.load(p.toString());if(!r){this.RP();if(!this.B6(this.O_))this.EY(this.O_.documentElement);}}catch(Kc){this.B6(this.O_,jsx3.NativeError.wrap(Kc));}};m.loadXML=function(o){this.oJ=null;this.Kl(0);try{this.O_=(new
DOMParser()).parseFromString(o,"text/xml");if(!this.B6(this.O_))this.EY(this.O_.documentElement);}catch(Kc){this.B6(this.O_,jsx3.NativeError.wrap(Kc));}return this;};m.RP=function(){if(this._jsxclonedoc){delete this._jsxclonedoc;try{e.XV(e.t3);}catch(Kc){}var
Y=(new
XMLSerializer()).serializeToString(this.O_);this.O_=(new
DOMParser()).parseFromString(Y,"text/xml");}};m.Z6=function(){this.BY();this.RP();if(this.B6(this.O_)){this.publish({subject:"error"});}else if(this.O_.documentElement==null){this.Kl(105,jsx3._msg("xml.doc_bad"));this.publish({subject:"error"});}else{this.EY(this.O_.documentElement);this.publish({subject:"response"});}};m.BY=function(){window.clearTimeout(this._jsx_4);this._jsx_4=null;try{e.XV(e.t3);}catch(Kc){}try{this.O_.removeEventListener("load",this._jsxzB,false);}catch(Kc){}delete this._jsxzB;};m.dE=function(){if(this.oK.readyState==4){var
F=this.oK;this.lz();if(!(F.status==0||F.status>=200&&F.status<300)){this.Kl(102,jsx3._msg("xml.doc_status",this.getSourceURL(),F.status));this.publish({subject:"error"});}else{var
Cc=F.responseText;try{this.O_=(new
DOMParser()).parseFromString(Cc,"text/xml");if(!this.B6(this.O_))this.EY(this.O_.documentElement);jsx3.sleep(function(){this.publish({subject:"response"});},null,this);}catch(Kc){this.B6(this.O_,Kc);this.publish({subject:"error"});}}}};m.lz=function(){try{window.clearTimeout(this._jsx_4);this._jsx_4=null;this.oK.onreadystatechange=new
Function();delete this.oK;}catch(ac){e.ev(6,jsx3._msg("xml.unknown",jsx3.NativeError.wrap(ac)));}};m.J7=function(){this.lz();this.Kl(111,jsx3._msg("xml.timeout"));this.publish({subject:"timeout"});};m.As=function(f,i,l){e.ev(6,jsx3._msg("xml.doc_load",f));try{if(i>0&&l)this._jsx_4=window.setTimeout(jsx3.makeCallback(function(){this.J7();},this),i);var
Rb=new
XMLHttpRequest();this.oK=Rb;Rb.open("GET",f.toString(),l);Rb.send(null);if(l){if(this.oK.readyState==4){this.O_=(new
DOMParser()).parseFromString(kb,"text/xml");if(!this.B6(this.O_))this.EY(this.O_.documentElement);jsx3.sleep(function(){this.publish({subject:"response"});},null,this);}else{var
tb=this;Rb.onreadystatechange=function(){tb.dE();};}}else if(!(Rb.status==0||Rb.status>=200&&Rb.status<300)){this.Kl(102,jsx3._msg("xml.doc_status",f,Rb.status));}else{var
kb=Rb.responseText;try{this.O_=(new
DOMParser()).parseFromString(kb,"text/xml");if(!this.B6(this.O_))this.EY(this.O_.documentElement);}catch(Kc){this.B6(this.O_,Kc);}}}catch(Kc){this.B6(this.O_,Kc);}};m.getSourceURL=function(){return this.oJ;};m.B6=function(h,o){if(h!=null){var
oc=h.parseError;if(oc!=null&&oc.errorCode!="0"){var
Nc=jsx3._msg("xml.err_fmt",oc.errorCode,oc.line,oc.linepos,jsx3.util.strTrim(String(oc.reason)),jsx3.util.strTruncate(oc.srcText),oc.url);this.Kl(oc.errorCode,Nc);return true;}var
ib=h.documentElement;if(ib==null){if(o)this.Kl(158,jsx3._msg("xml.doc_bad_ex",o));else this.Kl(108,jsx3._msg("xml.doc_bad"));return true;}else if(ib.tagName=="parsererror"&&ib.namespaceURI&&ib.namespaceURI.match(/^http:\/\/www\.mozilla\.org\/(.+\/)?parsererror.xml/i)){this.Kl(109,ib.textContent.replace(/[\n\r]/g," "));return true;}}if(o!=null){this.Kl(110,jsx3._msg("xml.unknown",jsx3.NativeError.wrap(o)));return true;}return false;};m.getValidateOnParse=function(){return this.O_.validateOnParse;};m.setValidateOnParse=function(f){this.O_.validateOnParse=f;};m.getResolveExternals=function(){return this.O_.resolveExternals;};m.setResolveExternals=function(r){this.O_.resolveExternals=r;};m.cloneDocument=function(){try{e.XV(e.t3);}catch(Kc){}try{var
vc=new
e(this.O_.cloneNode(true));}catch(Kc){var
vc=new
e();vc.loadXML(this.getXML());}return vc;};m.iC=function(){this.BY();this.Kl(112,jsx3._msg("xml.timeout"));this.publish({subject:"timeout"});};m.toString=function(){if(this.O_!=null&&!this.hasError()){return (new
XMLSerializer()).serializeToString(this.O_);}else return this.jsxsuper();};m.getXmlVersion=function(){return this.O_.xmlVersion;};m.getXmlEncoding=function(){return this.O_.xmlEncoding;};m.getXmlStandalone=function(){return this.O_.xmlStandalone;};m.serialize=function(i,h,c){if(i===true)i=this.getXmlVersion()||"1.0";if(h===true)h=this.getXmlEncoding();var
ac=i||h||c;if(ac){var
Vb="<?xml";if(i)Vb=Vb+(' version="'+i+'"');if(h)Vb=Vb+(' encoding="'+h+'"');if(c!=null)Vb=Vb+(' standalone="'+(c?"yes":"no")+'"');Vb=Vb+"?>\n";var
Ic=new
Array(this.O_.childNodes.length+1);Ic[0]=Vb;for(var
Wb=0;Wb<this.O_.childNodes.length;Wb++){var
ec=this.O_.childNodes[Wb];if(ec.nodeType!=7||ec.nodeName!="xml"){var
Sb=new
Mb(ec);Ic[Wb+1]=Sb.hasError()?"<!-- "+Sb+" -->":Sb.toString();}}}else{var
Ic=new
Array(this.O_.childNodes.length);for(var
Wb=0;Wb<this.O_.childNodes.length;Wb++){var
ec=this.O_.childNodes[Wb];var
Sb=new
Mb(ec);Ic[Wb]=Sb.hasError()?"<!-- "+Sb+" -->":Sb.toString();if(ec.nodeType==7||ec.nodeName=="xml")Ic[Wb]+="\n";}}return Ic.join("");};m.createDocumentElement=function(j,q){if(q){var
hb=this.O_.createElementNS(q,j);}else var
hb=this.O_.createElement(j);if(this.O_.documentElement!=null)this.O_.replaceChild(hb,this.O_.documentElement);else this.O_.appendChild(hb);this.EY(this.O_.documentElement);return new
jsx3.xml.Entity(hb);};m.createProcessingInstruction=function(c,i){var
Hc=this.O_.createProcessingInstruction(c,i);this.O_.appendChild(Hc);};m.setAsync=function(d){this._jsxxR=d;return this;};m.getAsync=function(l){return this._jsxxR==null?false:this._jsxxR;};m.setSelectionLanguage=function(a){return this;};m.getSelectionLanguage=function(){return "XPath";};e.Ii=function(k){var
nc=[];for(var xc in k)nc[nc.length]="xmlns:"+k[xc]+"='"+xc+"'";return nc.join(" ");};m.setSelectionNamespaces=function(q){if(typeof q=="object")q=e.Ii(q);this.O_._jsxdg=q;this.O_._jsxoj=null;return this;};m.getSelectionNamespaces=function(r){return this.O_._jsxdg?this.O_._jsxdg:"";};m.createNamespaceAxis=function(){var
pc=this.getRootNode();var
t=pc.toString();var
L="";do{var
D=new
RegExp("xmlns:"+"jsx_xmlns"+L+"([^=]*)=['\"]([^\"^']*)['\"]","g");var
sc=t.search(D);if(sc>=0)L=L==""?0:L+1;}while(sc>=0);this.nr(pc,"jsx_xmlns"+L);this.loadXML(this.getXML());return "jsx_xmlns"+L;};m.nr=function(d,o){var
sb=d.cloneNode(false).getXML();var
lc;while(lc=e.DV.exec(sb))if(RegExp.$1!=o){var
O=d.createNode(2,o+":"+RegExp.$1,e.SEARCHABLE_NAMESPACE);O.setValue(RegExp.$2);d.setAttributeNode(O);}for(var
Gc=d.getChildIterator();Gc.hasNext();)this.nr(Gc.next(),o);};m.getDeclaredNamespaces=function(i){this._jsxmO={};var
mc=this.getRootNode();if(mc)this._getDeclaredNamespaces(mc,{index:0},i);return this._jsxmO;};m._getDeclaredNamespaces=function(j,b,p){var
oc=j.getNamespaceURI();if(oc!=""){var
dc;if(!this._jsxmO[oc]||p&&(dc=j.getPrefix())!=""&&typeof p[dc]!="undefined")if(dc){this._jsxmO[oc]=dc;}else{b.index+=1;this._jsxmO[oc]="jsx"+b.index;}}if(j.getNodeType()==1)for(var
Eb=j.selectNodeIterator("attribute::* | child::*");Eb.hasNext();){var
bc=Eb.next();if(bc.getNodeType()==1||bc.getNodeType()==2)this._getDeclaredNamespaces(bc,b,p);}};m.getNativeDocument=function(){return this.O_;};e.ev=function(s,p){if(e.ST==null)if(jsx3.util.Logger){e.ST=jsx3.util.Logger.getLogger(e.jsxclass.getName());if(e.ST==null)return;}else return;e.ST.log(s,p);};e.getVersion=function(){return "3.0.0";};});jsx3.Document=jsx3.xml.Document;jsx3.Class.defineClass("jsx3.xml.Template",null,null,function(p,s){p.DISABLE_OUTPUT_ESCAPING=1;p.b9={};p.supports=function(n){return p.b9[n]||Boolean(0);};s.init=function(e){if(e.hasError())throw new
jsx3.Exception(jsx3._msg("temp.init_err",e.getError()));if(e.getBaseName()=="stylesheet"){try{this.WQ=new
XSLTProcessor();this.WQ.importStylesheet(e.getNativeDocument());}catch(Kc){this.Kl(202,jsx3._msg("temp.nat_err",jsx3.NativeError.wrap(Kc)));}}else this.Kl(201,jsx3._msg("temp.root_elm"));};s.setParam=function(l,r){if(!this.cR)this.cR=new
jsx3.util.List();if(this.cR.indexOf(l)<0)this.cR.add(l);this.WQ.setParameter("",l,r!=null?r.toString():"");};s.ON=function(f,k){var
A=f instanceof jsx3.xml.Document?f.getNativeDocument():f.getNative();var
U=this.WQ.transformToDocument(A);if(U){return k?new
jsx3.xml.Document(U):(new
XMLSerializer()).serializeToString(U);}else{this.Kl(203,jsx3._msg("temp.empty"));return null;}};s.reset=function(){if(this.cR){for(var
U=this.cR.iterator();U.hasNext();)this.WQ.removeParameter("",U.next());this.cR.clear();}};s.setParams=function(j){for(var zb in j)this.setParam(zb,j[zb]);};s.transform=function(c,i){if(this.hasError())throw new
jsx3.Exception(jsx3._msg("temp.temp_err",this.getError()));if(c.hasError())throw new
jsx3.Exception(jsx3._msg("temp.doc_err",c.getError()));try{return this.ON(c,i);}catch(Kc){this.Kl(204,jsx3._msg("temp.err",jsx3.NativeError.wrap(Kc)));return null;}};s.transformToObject=function(c){return this.transform(c,true);};});jsx3.xml.Entity.jsxclass.mixin(jsx3.xml.Template.prototype,true,["getError","hasError","Kl"]);jsx3.Class.defineClass("jsx3.xml.XslDocument",jsx3.xml.Document,null,function(f,s){s.setParam=function(l,p){this.o8().setParam(l,p);};s.setParams=function(h){this.o8().setParams(h);};s.reset=function(){if(this._N)this._N.reset();};s.transform=function(d){return this.o8().transform(d);};s.transformToObject=function(a){return this.o8().transformToObject(a);};s.o8=function(){if(this._N==null)this._N=new
jsx3.xml.Template(this);return this._N;};s.load=function(c){delete this._N;return this.jsxsuper(c);};s.loadXML=function(e){delete this._N;return this.jsxsuper(e);};s.hasError=function(){return this.jsxsuper()||this._N!=null&&this._N.hasError();};s.getError=function(){var
pc=null;if(this._N)pc=this._N.getError();if(!pc)pc=this.jsxsuper();return pc;};f.wrap=function(a){return new
f(a.getNativeDocument());};s.cloneDocument=function(){return f.wrap(this.jsxsuper());};s.isMutable=function(){return true;};});jsx3.Class.defineClass("jsx3.xml.Processor",null,null,function(o,p){var
rb=jsx3.xml.Template;o.DISABLE_OUTPUT_ESCAPING=1;o.supports=function(q){return rb.supports(q);};p.init=function(l,c,b){this.lw=l;this.R_=c;this.cR=b;};p.setXML=function(j){this.lw=j;return this;};p.setXSL=function(c){this.R_=c;return this;};p.setParams=function(a){this.cR=a;return this;};p.transformToObject=function(){return this.transform(true);};p.transform=function(a){var
mb=new
rb(this.R_);if(!mb.hasError()){if(this.cR)mb.setParams(this.cR);var
D=mb.transform(this.lw,a);if(!mb.hasError())return D;}var
ab=mb.getError();this.Kl(ab.code,ab.description);return null;};});jsx3.xml.Entity.jsxclass.mixin(jsx3.xml.Processor.prototype,true,["getError","hasError","Kl"]);jsx3.Class.defineClass("jsx3.net.Request",null,[jsx3.util.EventDispatcher],function(q,p){q.STATUS_OK=200;q.STATUS_ERROR=400;q.EVENT_ON_RESPONSE="response";q.EVENT_ON_TIMEOUT="timeout";q._Y={};p.init=function(m){if(m!=null)q._Y[m]=this;try{this._request=new
XMLHttpRequest();}catch(Kc){throw new
jsx3.Exception(jsx3._msg("req_inst"),jsx3.NativeError.wrap(Kc));}};p.abort=function(){if(this._timeoutto){window.clearTimeout(this._timeoutto);delete this._timeoutto;}this._request.onreadystatechange=new
Function();this._request.abort();return this;};p.getAllResponseHeaders=function(){return this._request.getAllResponseHeaders();};p.getResponseHeader=function(f){return this._request.getResponseHeader(f);};p.getStatusText=function(){return this._request.statusText;};p.getStatus=function(){var
qc=this.hT!=null?this.hT:this._request.status;return qc==0?200:qc;};p.getResponseText=function(){return this._request.responseText;};p.getResponseXML=function(){var
Bc=this.getResponseText();var
Bb=new
jsx3.xml.Document();Bb.loadXML(Bc);if(!Bb.hasError())return Bb;else q.ev(2,jsx3._msg("req.bad_xml",this.oJ,Bb.getError()));return null;};p.setRequestHeader=function(f,i){this._request.setRequestHeader(f,String(i));return this;};p.getReadyState=function(){return this._request.readyState;};p.open=function(a,r,l,m,h){this.hT=0;r=r.toString();this.WJ=Boolean(l);this.P2=a;this.oJ=r;try{if(window.netscape&&netscape.security)netscape.security.PrivilegeManager.enablePrivilege("UniversalBrowserRead");}catch(Kc){q.ev(5,jsx3._msg("req.netsc",jsx3.NativeError.wrap(Kc)));}try{q.ev(6,jsx3._msg("req.open",r));this._request.open(a,r,this.WJ,m,h);}catch(Kc){this.hT=400;q.ev(2,jsx3._msg("req.err_open",r,jsx3.NativeError.wrap(Kc)));}return this;};q.cancelRequest=function(c){var
pb=q._Y[c];if(pb)pb.abort();};q.getRequest=function(f){return q._Y[f];};p.getURL=function(){return this.oJ;};p.setTimeouts=function(c,k,f,n){return this;};p.send=function(i,r){if(this.hT==400)throw new
jsx3.Exception(jsx3._msg("req.err_state"));var
H=false;try{this._request.send(i);if(this.WJ)this.hT=0;else delete this.hT;}catch(Kc){this.hT=400;q.ev(2,jsx3._msg("req.err_send",this.oJ,jsx3.NativeError.wrap(Kc)));H=this;}if(this.WJ)if(H||this._request.readyState==4){jsx3.sleep(function(){this.publish({subject:"response"});},null,this);}else{var
oc=this;this._request.onreadystatechange=function(){oc.Lw();};if(!isNaN(r)&&r>0)this._timeoutto=window.setTimeout(function(){oc.x9();},r);}return this;};p.x9=function(){delete this._timeoutto;this.abort();this.hT=408;this.publish({subject:"timeout"});};p.Lw=function(){if(this._request.readyState==4){delete this.hT;if(this._timeoutto){window.clearTimeout(this._timeoutto);delete this._timeoutto;}this._request.onreadystatechange=new
Function();this.publish({subject:"response"});}};p.toString=function(){return this.jsxsuper()+" "+this.P2+" "+this.getStatus()+" "+this.oJ;};q.ev=function(n,b){if(q.ST==null)if(jsx3.util.Logger){q.ST=jsx3.util.Logger.getLogger(q.jsxclass.getName());if(q.ST==null)return;}else return;q.ST.log(n,b);};q.getVersion=function(){return "3.00.00";};});jsx3.HttpRequest=jsx3.net.Request;jsx3.Class.defineClass("jsx3.util.Logger",null,null,function(h,m){var
qb=jsx3.Method;var
Ub=jsx3.Exception;h.OFF=0;h.FATAL=1;h.ERROR=2;h.WARN=3;h.INFO=4;h.DEBUG=5;h.TRACE=6;h.qS=1;h.qB=6;h.GLOBAL=null;h.getLogger=function(n){var
Jc=h.Manager.getManager();if(Jc==null)return null;var
fc=Jc.getLogger(n);if(fc==null){fc=new
h(n);Jc.addLogger(fc);}return fc;};h.FM=[null,"FATAL","ERROR","WARN","INFO","DEBUG","TRACE"];h.levelAsString=function(r){return h.FM[r]||"";};m.c8=null;m.XK=null;m.y6=null;m.D6=4;m.Kv=null;m.l4=true;m.q1=null;m.init=function(k){this.c8=k;};m.getName=function(){return this.c8;};m.addHandler=function(n){if(this.XK==null)this.XK=new
jsx3.util.List();this.XK.add(n);};m.removeHandler=function(b){if(this.XK!=null)this.XK.remove(b);};m.getLevel=function(){return this.y6;};m.getEffectiveLevel=function(){return this.D6;};m.setLevel=function(c){c=Math.max(0,Math.min(h.qB,c));this.y6=c;this.hH();};m.hH=function(){var
Ec=null;if(this.y6!=null){Ec=this.y6;}else if(this.Kv!=null){Ec=this.Kv.D6;}else Ec=m.D6;if(Ec!=this.D6){this.D6=Ec;if(this.q1!=null)for(var
Mc=this.q1.iterator();Mc.hasNext();)Mc.next().hH();}};m.getParent=function(){return this.Kv;};m.setParent=function(o){if(this.Kv!=null)this.Kv.q1.remove(this);this.Kv=o;if(this.Kv!=null){if(this.Kv.q1==null)this.Kv.q1=new
jsx3.util.List();this.Kv.q1.add(this);}this.hH();};m.getUseParentHandlers=function(){return this.l4;};m.setUseParentHandlers=function(i){this.l4=i;};m.GN=function(p){var
Dc=this;var
yc=p.getLevel();while(Dc!=null){if(Dc.XK!=null)for(var
C=Dc.XK.iterator();C.hasNext();){var
O=C.next();if(O.isLoggable(yc))try{O.handle(p);}catch(Kc){Kc=jsx3.NativeError.wrap(Kc);h.getLogger(h.jsxclass.getName()).error(jsx3._msg("logr.err_hand",O.getName(),Kc),Kc);}}if(!Dc.getUseParentHandlers())break;Dc=Dc.getParent();}};m.log=function(g,i,o){g=Math.max(g,h.qS);if(this.D6<g)return;var
Y=o instanceof Array?o:qb.argsAsArray(arguments,2);var
T=new
h.Record(i,Y,g,this.getName(),jsx3.lang.getCaller(1),null);this.GN(T);};m.logError=function(k,e,r){k=Math.max(k,h.qS);if(this.D6<k)return;var
Cb=new
h.Record(e,null,k,this.getName(),jsx3.lang.getCaller(1),r);this.GN(Cb);};m.logStack=function(b,n,q){b=Math.max(b,h.qS);if(this.D6<b)return;var
v=new
h.Record(n,null,b,this.getName(),jsx3.lang.getStack(q!=null?q:0),null);this.GN(v);};m.isLoggable=function(l){l=Math.max(l,h.qS);return this.D6>=l;};m.fatal=function(i,o){if(o==null||o instanceof Array)this.log(1,i,o);else if(o instanceof Ub)this.logError(1,i,o);else if(this.D6>=1)this.log(1,i,qb.argsAsArray(arguments,1));};m.error=function(i,o){if(o==null||o instanceof Array)this.log(2,i,o);else if(o instanceof Ub)this.logError(2,i,o);else if(this.D6>=2)this.log(2,i,qb.argsAsArray(arguments,1));};m.warn=function(a,d){if(d==null||d instanceof Array)this.log(3,a,d);else if(d instanceof Ub)this.logError(3,a,d);else if(this.D6>=3)this.log(3,a,qb.argsAsArray(arguments,1));};m.info=function(b,c){if(c==null||c instanceof Array)this.log(4,b,c);else if(c instanceof Ub)this.logError(4,b,c);else if(this.D6>=4)this.log(4,b,qb.argsAsArray(arguments,1));};m.debug=function(q,g){if(g==null||g instanceof Array)this.log(5,q,g);else if(g instanceof Ub)this.logError(5,q,g);else if(this.D6>=5)this.log(5,q,qb.argsAsArray(arguments,1));};m.trace=function(s,e){if(e==null||e instanceof Array)this.log(6,s,e);else if(e instanceof Ub)this.logError(6,s,e);else if(this.D6>=6)this.log(6,s,qb.argsAsArray(arguments,1));};m.toString=function(){return this.jsxsuper()+" "+this.getName();};h.reset=function(){};h.doLog=function(s,a,l,f){if(l==null)l=4;else if(l<4)l=4;else l=5;if(h.GLOBAL){var
bc=a!=null?"("+s+") "+a:s;if(f||f==null)h.GLOBAL.logStack(l,bc,1);else h.GLOBAL.log(l,bc);}};h.logError=function(k,e){var
I="";for(var M in k){if(I)I=I+" ";I=I+(M+":"+k[M]);}h.doLog("ERRO01",I,e,false);};h.getMinPriority=function(){return 3;};h.getLog=function(){return [];};h.errorToString=function(c){var
ec="";ec=ec+("TIME: "+new
Date(c.timestamp)+"\n");ec=ec+("CODE: "+c.code+"\n");ec=ec+("DESC: "+c.description+"\n");return ec;};h.toString=function(){return "";};});jsx3.Class.defineClass("jsx3.util.Logger.Manager",null,null,function(f,b){var
Wb=jsx3.Exception;var
Zb=jsx3.util.Logger;f.SC="jsx:/../logger.xml";f.j1="global";f.fx=null;f.uw=-1;b.initialize=function(p){if(!p){p=new
jsx3.xml.Document();p.load(jsx3.getEnv("jsx_logger_config")||f.SC);}if(p.hasError()){window.alert(jsx3._msg("logr.err_conf",p.getError(),jsx3.resolveURI(p.getSourceURL())));p.loadXML("<configuration/>");}this.fE=p;var
Fc=this.zZ();this.Ws(Fc);};f.getManager=function(){if(f.fx==null){f.fx=new
f();Zb.GLOBAL=new
Zb(f.j1);f.fx.addLogger(Zb.GLOBAL);}return f.fx;};b.fE=null;b.C8=null;b.XK=null;b.init=function(j){this.C8={};this.XK={};};b.QV=function(i){var
mb=this.zZ("[@lazy='true' and @class='"+i.getName()+"']");this.Ws(mb);};b.Ws=function(p){for(var
uc=0;uc<p.length;uc++){var
Yb=p[uc];var
Hb=this.getHandler(Yb);var
bb=this.fE.selectNodeIterator("/configuration/logger[handler-ref/@name='"+Yb+"']");while(bb.hasNext()){var
Db=bb.next();var
hc=Db.getAttribute("name");var
Jc=this.getLogger(hc);if(Jc!=null)Jc.addHandler(Hb);}}};b.zZ=function(k){var
C=[];if(!this.fE)return C;var
jc=this.fE.selectNodeIterator("/configuration/handler"+(k!=null?k:""));var
Jb=this.zt==null;while(jc.hasNext()){var
H=jc.next();var
Jc=H.getAttribute("name");if(this.getHandler(Jc)!=null)continue;var
uc=H.getAttribute("class");var
Ic=H.getAttribute("lazy")=="true";var
nb=H.getAttribute("require")=="true";var
Rb=jsx3.Class.forName(uc);if(Rb==null&&nb){if(this.zt==null)this.zt=[];this.zt.push(uc);this.XK[Jc]=f.uw;continue;}if(Rb){var
xb=Rb.newInstance(Jc);this.c6(xb,H);xb.onAfterInit();var
pb=H.getAttribute("level");if(pb&&typeof Zb[pb]=="number")xb.setLevel(Zb[pb]);this.addHandler(xb);C[C.length]=Jc;}else if(!Ic&&!nb){window.alert(jsx3._msg("logr.no_class",uc));}else this.XK[Jc]=f.uw;}if(Jb&&this.zt!=null){var
tb=this;var
Hc=new
jsx3.util.Job("logger.require");Hc.run=function(){tb.BO();};jsx3.CLASS_LOADER.addJob(Hc,"jsx.js");}return C;};b.BO=function(p){for(var
Cc=0;Cc<this.zt.length;Cc++)jsx3.require(this.zt[Cc]);delete this.zt;var
yb=this.zZ("[@require='true']");this.Ws(yb);};b.c6=function(s,c){var
N=s.getClass();for(var
Z=c.selectNodeIterator("./property");Z.hasNext();){var
R=Z.next();var
cc=R.getAttribute("name");var
fc=R.getAttribute("value");var
Mb=R.getAttribute("eval")=="true";var
eb=N.getSetter(cc);if(eb!=null){if(Mb)try{fc=isNaN(fc)?jsx3.eval(fc):Number(fc);}catch(Kc){throw new
Wb(jsx3._msg("logr.bn_eval",cc,fc,s),jsx3.NativeError.wrap(Kc));}eb.apply(s,[fc]);}else throw new
Wb(jsx3._msg("logr.bn_setr",cc,N));}};b.addLogger=function(s){var
eb=s.getName();this.C8[eb]=s;if(this.fE){var
Qb=this.fE.selectSingleNode("/configuration/logger[@name='"+eb+"']");if(Qb!=null){var
R=Qb.getAttribute("level");if(R&&typeof Zb[R]=="number")s.setLevel(Zb[R]);var
Jc=Qb.getAttribute("useParent")!="false";s.setUseParentHandlers(Jc);var
Ib=Qb.selectNodeIterator("./handler-ref");while(Ib.hasNext()){var
J=Ib.next();var
ac=J.getAttribute("name");var
x=this.getHandler(ac);if(x!=null){s.addHandler(x);}else if(this.XK[ac]!=f.uw)throw new
Wb(jsx3._msg("logr.no_hand",eb,ac));}this.c6(s,Qb);}}if(eb!=f.j1){var
tb=eb.lastIndexOf(".");var
bb=tb>=0?eb.substring(0,tb):f.j1;s.setParent(Zb.getLogger(bb));}};b.addHandler=function(a){this.XK[a.getName()]=a;};b.getLogger=function(k){return this.C8[k];};b.getHandler=function(i){var
gc=this.XK[i];return gc==f.uw?null:gc;};b.getHandlerNames=function(){var
B=[];for(var wc in this.XK)B[B.length]=wc;return B;};});jsx3.Class.defineClass("jsx3.util.Logger.Record",null,null,function(e,n){e.lq=1;n.D4=null;n.dO=null;n.V2=null;n.cR=null;n.D6=null;n.e_=null;n.kD=null;n.ey=null;n.init=function(h,o,d,q,k,g){this.D4=e.lq++;this.dO=new
Date();this.V2=h;this.cR=o;this.D6=d;this.e_=q;this.kD=k;this.ey=g;};n.getSerial=function(){return this.D4;};n.getDate=function(){return this.dO;};n.getMessage=function(){return this.V2;};n.getParameters=function(){return this.cR;};n.getLevel=function(){return this.D6;};n.getLoggerName=function(){return this.e_;};n.getFunction=function(){return typeof this.kD=="function"?this.kD:null;};n.getStack=function(){return this.kD instanceof Array?this.kD:null;};n.getError=function(){return this.ey;};});jsx3.Class.defineClass("jsx3.util.Logger.Handler",null,null,function(o,e){var
Q=jsx3.util.Logger;var
pb=jsx3.util.Logger.Manager;o.registerHandlerClass=function(s){pb.getManager().QV(s);};e.c8="";e.D6=null;e.init=function(a){this.c8=a;};e.onAfterInit=function(){};e.getName=function(){return this.c8;};e.getLevel=function(){return this.D6;};e.setLevel=function(h){h=Math.max(0,Math.min(Q.qB,h));this.D6=h;};e.isLoggable=function(d){return this.D6==null||this.D6>=d;};e.handle=jsx3.Method.newAbstract("objRecord");});jsx3.Class.defineClass("jsx3.util.Logger.MemoryHandler",jsx3.util.Logger.Handler,null,function(c,p){p.WZ=null;p.kI=100;p.init=function(h){this.jsxsuper(h);this.WZ=[];};p.handle=function(g){this.WZ[this.WZ.length]=g;if(this.WZ.length>this.kI)this.WZ.shift();};p.clearBuffer=function(){this.WZ=[];};p.getBufferSize=function(){return this.kI;};p.setBufferSize=function(d){this.kI=Math.max(1,d);if(this.WZ.length>this.kI)this.WZ.splice(0,this.WZ.length-this.kI);};p.getRecords=function(e){if(e==null)e=this.WZ.length;return this.WZ.slice(this.WZ.length-e);};});jsx3.Class.defineClass("jsx3.util.Logger.FormatHandler",jsx3.util.Logger.Handler,null,function(e,f){f.QM="%d %t %n (%l) - %M";f.Up="";f.init=function(p){this.jsxsuper(p);};f.format=function(k){var
L=k.getDate();var
Yb=k.getFunction();var
Nc=k.getMessage()||"";var
pc=this.ot();var
jc=jsx3.util.Logger.levelAsString(k.getLevel());var
ac=pc?pc.format(k.getSerial(),k.getLoggerName(),jc,Nc,Yb!=null?Yb.jsxmethod!=null?Yb.jsxmethod.toString():Yb.toString():"",L):L+" "+k.getLoggerName()+" ("+jc+") "+Nc;var
Z=k.getError();var
I=k.getStack();if(Z!=null){ac=ac+("\n"+Z.printStackTrace());}else if(I!=null)ac=ac+("\n"+jsx3.Exception.formatStack(I));return ac;};f.getFormat=function(){return this.QM;};f.setFormat=function(n){this.QM=n;this.UB=null;};f.ot=function(){if(this.UB==null&&jsx3.util.MessageFormat){var
Bb=this.QM||"";Bb=Bb.replace(/\%s/g,"{0}");Bb=Bb.replace(/\%n/g,"{1}");Bb=Bb.replace(/\%l/g,"{2}");Bb=Bb.replace(/\%M/g,"{3}");Bb=Bb.replace(/\%f/g,"{4}");Bb=Bb.replace(/\%d/g,"{5,date,yyyy-MM-dd}");Bb=Bb.replace(/\%t/g,"{5,date,HH:mm:ss.SSS}");this.UB=new
jsx3.util.MessageFormat(Bb);}return this.UB;};f.getResourceUrls=function(){return this.Up;};f.setResourceUrls=function(m){this.Up=m;};});jsx3.Class.defineClass("jsx3.util.Logger.AlertHandler",jsx3.util.Logger.FormatHandler,null,function(p,b){b.PX=10;b.px=0;b.UE=false;b.handle=function(f){if(this.UE)return;this.px++;try{if(this.PX>0&&this.px%this.PX==0)if(!window.confirm(jsx3._msg("logr.alrt_ctd",this.getName()))){this.UE=true;return;}window.alert(this.format(f));}catch(Kc){window.alert(jsx3._msg("logr.alrt_err",jsx3.NativeError.wrap(Kc)));}};b.getConfirmInterval=function(){return this.PX;};b.setConfirmInterval=function(f){this.PX=f;};});jsx3.ERROR=jsx3.util.Logger;jsx3.Class.defineClass("jsx3.util.Locale",null,null,function(b,j){j.init=function(a,d){this.vu=a?a.toLowerCase():"";this.AT=d?d.toUpperCase():"";};b.ENGLISH=new
b("en");b.US=new
b("en","US");b.UK=new
b("en","GB");j.getLanguage=function(){return this.vu;};j.getCountry=function(){return this.AT;};j.getDisplayLanguage=function(g){return jsx3.System.getLocaleProperties(g).get("string.lang."+this.vu)||"";};j.getDisplayCountry=function(q){return jsx3.System.getLocaleProperties(q).get("string.terr."+this.AT)||"";};j.getDisplayName=function(o){var
B=this.getDisplayLanguage(o);var
kb=this.getDisplayCountry(o);if(!B)return kb;if(!kb)return B;var
nb=jsx3.System.getLocaleProperties(o).get("format.locale.displayname");return (new
jsx3.util.MessageFormat(nb)).format(B,kb);};j.getSearchPath=function(){var
K=[this];if(this.AT!=""||this.vu!=""){if(this.AT!=""&&this.vu!="")K.push(new
b(this.vu));K.push(new
b(""));}return K;};j.equals=function(a){return this===a||a instanceof b&&a.vu==this.vu&&a.AT==this.AT;};j.toString=function(){if(this.AT)return this.vu+"_"+this.AT;else return this.vu;};b.valueOf=function(r){var
_b=r.split(/[\-_]/);return new
b(_b[0],_b[1]);};});jsx3.Class.defineClass("jsx3.util.NumberFormat",null,null,function(h,o){h.getIntegerInstance=function(p){return h.DU(p,".integer");};h.getNumberInstance=function(d){return h.DU(d,"");};h.getCurrencyInstance=function(n){return h.DU(n,".currency");};h.getPercentInstance=function(i){return h.DU(i,".percent");};h.DU=function(r,m){var
hb=jsx3.System.getLocaleProperties(r);var
oc="format.number"+m+"._instance";var
Cc=hb.get(oc);if(!hb.containsKey(oc)||Cc==null){var
Nb=hb.get("format.number"+m);Cc=new
h(Nb,r);hb.set("format.number"+m+"._instance",Cc);}return Cc;};o.nP=0;o.qN="";o.P8="";o.EK=null;o.dM=null;o.aU=false;o.uG=Number.MAX_VALUE;o.c_=0;o.HD=0;o.Qw=0;o.k2=1;o.mV=false;o.init=function(d,l){this.QM=d;this.mz=l||jsx3.System.getLocale();this.xJ();};o.getLocale=function(){return this.mz;};o.setLocale=function(q){this.mz=q;this.xJ();};o.format=function(l){var
hc=jsx3.System.getLocaleProperties(this.mz);if(isNaN(l)){return hc.get("number.NaN");}else{if(typeof l!="number")l=Number(l);var
bc=l>=0;var
ub=bc?this.qN:this.EK!=null?this.EK:hc.get("number.minus")+this.qN;var
ac=bc?this.P8:this.dM!=null?this.dM:this.P8;var
Vb=null;if(!isFinite(l)){Vb=hc.get("number.infinity");}else{l=this.k2*Math.abs(l);var
jc=h.cW(l);var
Ec=jc[0];var
ib=jc[1];if(this.HD<Ec.length-ib){var
yb=Ec.splice(ib+this.HD,Ec.length-ib-this.HD);if(h.jz(Ec,yb))ib++;}var
_b=ib>=0?Ec.slice(0,ib):Ec;var
B=ib>=0?Ec.slice(ib):[];h.d_(_b,this.uG,this.c_,true);h.d_(B,this.HD,this.Qw,false);var
xb=hc.get("number.zero");h.bE(_b,xb);h.bE(B,xb);if(this.nP>0){var
v=this.mV?hc.get("number.currency.grouping")||hc.get("number.grouping"):hc.get("number.grouping");for(var
w=_b.length-this.nP;w>=1;w=w-this.nP)_b.splice(w,0,v);}Vb=_b.join("");if(this.aU||B.length>0)Vb=Vb+((this.mV?hc.get("number.currency.decimal")||hc.get("number.decimal"):hc.get("number.decimal"))+B.join(""));}return ub+Vb+ac;}};h.cW=function(a){if(a<0)throw new
jsx3.Exception();var
uc=Math.log(a)*Math.LOG10E;if(!isFinite(uc)){if(a==0)return [[0],0];throw new
jsx3.Exception();}var
_b=a.toString();var
Nb=[];var
B=null;var
x="0".charCodeAt(0);var
ib=".".charCodeAt(0);for(var
u=0;u<_b.length;u++){var
M=_b.charCodeAt(u);if(M>=x&&M<=x+9){Nb[Nb.length]=M-x;}else if(M==ib){}else break;}if(uc>=0){var
jc=Math.floor(uc+1.00001);if(Nb.length>jc){B=jc;}else{if(Nb.length<jc)for(var
u=Nb.length;u<jc;u++)Nb[Nb.length]=0;B=Nb.length;}}else{var
wb=Math.ceil(-1.00001-uc);var
rb=Nb.indexOf(0);Nb.splice(0,rb+1);for(var
u=0;u<wb;u++)if(Nb[u]!=0)Nb.splice(u,0,0);B=0;}return [Nb,B];};h.d_=function(g,n,d,k){if(g.length>n){if(k){g.splice(0,g.length-n);}else g.splice(n,g.length-n);}else if(g.length<d){var
Hb=k?"unshift":"push";for(var
eb=g.length;eb<d;eb++)g[Hb]("0");}};h.jz=function(b,r){if(r[0]>=5)for(var
Ob=b.length-1;Ob>=0;Ob--){var
Nc=b[Ob]+1;if(Nc>=10){b[Ob]=0;if(Ob==0){b.unshift(1);return true;}}else{b[Ob]=Nc;break;}}return false;};h.bE=function(b,r){var
Wb=r.charCodeAt(0);for(var
nb=0;nb<b.length;nb++)b[nb]=String.fromCharCode(b[nb]+Wb);};h.DG="0#,.";o.xJ=function(){var
tb=jsx3.System.getLocaleProperties(this.mz);var
w=this.QM;var
Yb=0;var
rb=w.length;var
Ib=1;var
Wb=null,y=null;while(Yb<rb){var
db=w.charAt(Yb);if(Ib==1){if(db=="'"){var
F=w.indexOf("'",Yb+1);if(F==Yb+1){this.qN+="'";Yb=Yb+2;}else if(F>=0){this.qN+=w.substring(Yb+1,F);Yb=F+1;}else throw new
jsx3.Exception(jsx3._msg("nmfmt.sq",Yb,this));}else if(h.DG.indexOf(db)>=0){Wb=Yb;Ib++;}else{this.qN+=this._2(db,tb);Yb++;}}else if(Ib==2){if(h.DG.indexOf(db)>=0){Yb++;}else{y=Yb;Ib++;}}else if(Ib==3){if(db=="'"){var
F=w.indexOf("'",Yb+1);if(F==Yb+1){this.P8+="'";Yb=Yb+2;}else if(F>=0){this.P8+=w.substring(Yb+1,F);Yb=F+1;}else throw new
jsx3.Exception(jsx3._msg("nmfmt.sq",Yb,this));}else if(db==";"){this.EK="";this.dM="";Ib++;}else this.P8+=this._2(db,tb);Yb++;}else if(Ib==4){if(db=="'"){var
F=w.indexOf("'",Yb+1);if(F==Yb+1){this.EK+="'";Yb=Yb+2;}else if(F>=0){this.EK+=w.substring(Yb+1,F);Yb=F+1;}else throw new
jsx3.Exception(jsx3._msg("nmfmt.sq",Yb,this));}else if(h.DG.indexOf(db)>=0){Ib++;}else{this.EK+=this._2(db,tb);Yb++;}}else if(Ib==5){if(h.DG.indexOf(db)>=0){Yb++;}else Ib++;}else if(Ib==6){if(db=="'"){var
F=w.indexOf("'",Yb+1);if(F==Yb+1){this.dM+="'";Yb=Yb+2;}else if(F>=0){this.dM+=w.substring(Yb+1,F);Yb=F+1;}else throw new
jsx3.Exception(jsx3._msg("nmfmt.sq",Yb,this));}else this.dM+=this._2(db,tb);Yb++;}}if(y==null)y=rb;if(Wb==null)throw new
jsx3.Exception(jsx3._msg("nmfmt.numpt",w));this.ZX(w.substring(Wb,y));};o.ZX=function(g){var
W=g.indexOf(".");if(W<0)W=g.length;else if(W==g.length-1)this.aU=true;var
Fb=g.lastIndexOf(",");if(Fb>=0){var
G=W-Fb-1;if(G<1)throw new
jsx3.Exception(jsx3._msg("nmfmt.gpdec",g));this.nP=G;}for(var
vc=0;vc<W;vc++)if(g.charAt(vc)=="0")this.c_++;for(var
vc=W+1;vc<g.length;vc++)if(g.charAt(vc)=="0"){this.Qw++;this.HD++;}else if(g.charAt(vc)=="#")this.HD++;};o._2=function(g,d){if(g=="\u00A4"){this.mV=true;return d.get("number.currency");}else if(g=="%"){this.k2=100;return d.get("number.percent");}else if(g=="\u2030"){this.k2=1000;return d.get("number.permille");}else if(g=="-"){return d.get("number.minus");}else return g;};o.toString=function(){return this.QM;};});jsx3.Class.defineClass("jsx3.util.DateFormat",null,null,function(r,e){r.SHORT=1;r.MEDIUM=2;r.LONG=3;r.FULL=4;r.LY=2;r.r4=[null,"short","medium","long","full"];r.getDateInstance=function(k,f){var
w=jsx3.System.getLocaleProperties(f).get("format.date."+r.r4[k||r.LY]);if(w==null)throw new
jsx3.IllegalArgumentException("intType",k);return new
r(w,f);};r.getTimeInstance=function(s,q){var
lc=jsx3.System.getLocaleProperties(q).get("format.time."+r.r4[s||r.LY]);if(lc==null)throw new
jsx3.IllegalArgumentException("intType",s);return new
r(lc,q);};r.getDateTimeInstance=function(o,f,n){var
gc=jsx3.System.getLocaleProperties(n);var
Nb=gc.get("format.date."+r.r4[o||r.LY]);var
qc=gc.get("format.time."+r.r4[f||r.LY]);if(Nb==null)throw new
jsx3.IllegalArgumentException("intDateType",o);if(qc==null)throw new
jsx3.IllegalArgumentException("intTimeType",f);var
cc=new
jsx3.util.MessageFormat(gc.get("format.datetime"));return new
r(cc.format(qc,Nb),n);};r.v3={G:function(b,m,s){var
wb=b.getFullYear()<1;return r.eV(s.pv(m<4?"date.era":"date.era.long")[wb?0:1]);},y:function(l,d,j){return r.V6(l.getFullYear(),d);},M:function(a,l,k){return r.YW(k,a.getMonth(),l);},d:function(q,i,o){return r.uH(q.getDate(),i);},E:function(f,q,d){return r.eV(d.pv(q<3?"date.day.narrow":q<4?"date.day.abbrev":"date.day")[f.getDay()]);},H:function(g,p,c){return r.uH(g.getHours(),p);},h:function(d,o,b){return r.uH(d.getHours()%12||Number(12),o);},m:function(l,d,j){return r.uH(l.getMinutes(),d);},s:function(i,a,g){return r.uH(i.getSeconds(),a);},S:function(h,s,f){return r.uH(h.getMilliseconds(),s);},a:function(l,p,c){return r.eV(c.pv("time.ampm")[Math.floor(l.getHours()/12)]);},z:function(m,n,k){var
Ib=r.m3(m,k);return "GMT"+Ib[0]+":"+Ib[1];},Z:function(j,b,h){var
_=r.m3(j,h);return _[0]+_[1];}};r.V6=function(q,p){if(p==2){var
Xb=""+q;return Xb.substring(Xb.length-2);}else{if(q<1)q=1-q;return r.uH(q,p);}};r.uH=function(a,m){var
gb=a.toString().split("");while(gb.length<m)gb.unshift(0);return gb.join("");};r.eV=function(d,j){if(j==null||j>=4||d.length<=j)return d;else return d.substring(0,j);};r.YW=function(q,d,i){if(i<=2)return r.uH(d+1,i);else return r.eV(q.pv(i<4?"date.month.abbrev":"date.month")[d],i);};r.m3=function(b,a){var
V=a.getTimeZoneOffset(b);var
fb=V<0?"-":"+";V=Math.abs(V);var
uc=Math.floor(V/60).toString();var
tc=Math.floor(V%60).toString();if(uc.length<2)uc="0"+uc;if(tc.length<2)tc="0"+tc;return [fb+uc,tc];};r.Np={G:function(o,s,c,g,m,k,n){var
S=r.A0(s,c,[o.pv("date.era"),o.pv("date.era.long")],g,false,k);var
u=S[0],D=S[1];if(u>=0){n.bc=u==0;return D;}else return -1;},y:function(i,f,p,a,g,d,k){if(a<=2){var
Pb=r.Gq(f,p,a,null,d);var
Rb=Number(Pb);if(!isNaN(Rb)){if(Pb.length==2){var
ec=new
Date();var
Ic=ec.getFullYear();var
V=100*Math.floor(Ic/100)+Rb;if(V>=Ic+20){V=V-100;}else if(V<Ic-80)V=V+100;Rb=V;}g.setUTCFullYear(Rb);return Pb.length;}else return -1;}else{var
ab=r.Gq(f,p,a,null,d);return r.KO(ab,g,"setUTCFullYear");}},M:function(q,p,f,i,o,m,c){if(i<=2){var
V=r.Gq(p,f,i,2,m);var
bc=Number(V);if(!isNaN(bc)){o.setUTCMonth(bc-1);return V.length;}else return -1;}else{var
_b=r.A0(p,f,[q.pv("date.month.abbrev"),q.pv("date.month")],i,false,m);var
Ic=_b[0],fb=_b[1];if(Ic>=0){o.setUTCMonth(Ic);return fb;}else return -1;}},d:function(n,a,b,f,l,j,o){var
ab=r.Gq(a,b,f,2,j);return r.KO(ab,l,"setUTCDate");},E:function(q,p,f,i,o,m,c){var
Ec=r.A0(p,f,[q.pv("date.day.narrow"),q.pv("date.day"),q.pv("date.day.abbrev")],i,false,m);var
w=Ec[0],hb=Ec[1];if(w>=0){return hb;}else return 0;},H:function(s,o,g,k,q,j,a){var
jc=r.Gq(o,g,k,2,j);var
Mc=Number(jc);if(!isNaN(Mc)){a.hours24=Mc;return jc.length;}else return -1;},h:function(h,g,o,s,f,d,l){var
Ub=r.Gq(g,o,s,2,d);var
hb=Number(Ub);if(!isNaN(hb)){l.hours12=hb;return Ub.length;}else return -1;},m:function(h,g,o,s,f,d,l){var
E=r.Gq(g,o,s,2,d);return r.KO(E,f,"setUTCMinutes");},s:function(s,o,g,k,q,j,a){var
bc=r.Gq(o,g,k,2,j);return r.KO(bc,q,"setUTCSeconds");},S:function(a,n,h,l,o,p,s){var
E=r.Gq(n,h,l,3,p);return r.KO(E,o,"setUTCMilliseconds");},a:function(j,a,q,b,h,f,m){var
zc=r.OY(a,q,j.pv("time.ampm"),b,false,f);var
Tb=zc[0],Bc=zc[1];if(Tb>=0){m.pm=Tb==1;return Bc;}else return -1;},z:function(f,i,m,q,d,b,n){var
Cb=i.substring(m,m+3);var
sb=i.charAt(m+3);var
Lc=Number(i.substring(m+4,m+6));var
ab=Number(i.substring(m+7,m+9));if(Cb.toLowerCase()=="gmt"&&(sb=="+"||sb=="-")&&!isNaN(Lc)&&!isNaN(ab)){var
V=60*Lc+ab;if(sb=="-")V=V*-1;n.timezone=V;return 9;}else return -1;},Z:function(d,k,p,o,b,s,f){var
J=k.charAt(p);var
zc=Number(k.substring(p+1,p+3));var
xb=Number(k.substring(p+3,p+5));if((J=="+"||J=="-")&&!isNaN(zc)&&!isNaN(xb)){var
ib=60*zc+xb;if(J=="-")ib=ib*-1;f.timezone=ib;return 5;}else return -1;}};r.PE=function(a,b,j){if(a.indexOf(j,b)==b)return j.length;else return -1;};r.Gq=function(g,o,b,p,m){var
O=m==null||typeof m=="string"&&!r.EW(m,0);if(m instanceof Array)O=O||m[0]=="M"&&m[1]>2||m[0]=="E"||m[0]=="a";if(O){var
Qb=o;while(r.EW(g,Qb))Qb++;return g.substring(o,Qb);}else{for(var
D=0;D<b;D++)if(!r.EW(g,o+D))return "x";return g.substring(o,o+b);}};r.A0=function(g,o,m,s,n,a){var
H=[];for(var
Ac=0;Ac<m.length;Ac++)H.push.apply(H,m[Ac]);var
hc=r.OY(g,o,H,s,n,a);hc[0]=hc[0]%m[0].length;return hc;};r.OY=function(l,j,k,n,s,h){var
hb=-1;var
Jc=0;if(!s)l=l.toLowerCase();for(var
hc=0;hc<k.length;hc++){var
U=0;var
gc=s?k[hc]:k[hc].toLowerCase();while(l.length>U&&gc.length>U&&l.charAt(j+U)==gc.charAt(U))U++;if(U>Jc){Jc=U;hb=hc;}}return [hb,Jc];};r.KO=function(g,s,p){var
rc=Number(g);if(!isNaN(rc)){s[p](rc);return g.length;}else return -1;};r.EW=function(a,k){var
_b=a.charCodeAt(k);return _b>=48&&_b<=57;};e.init=function(k,o){this.QM=k;this.sD=null;this.mz=o||jsx3.System.getLocale();this.w5();};e.getLocale=function(){return this.mz;};e.setLocale=function(q){this.mz=q;};e.getTimeZoneOffset=function(b){return this.sD!=null?this.sD:-1*(b||new
Date()).getTimezoneOffset();};e.setTimeZoneOffset=function(n){this.sD=n;};e.pv=function(j){return jsx3.System.getLocaleProperties(this.mz).get(j);};e.w5=function(){var
Yb=[];this.Cy=Yb;var
bb=this.QM;var
gc=bb.length;var
Z=0;var
fb=[];var
Bc=/[a-zA-Z']/g;while(Z<gc){var
Ub=bb.charAt(Z);if(Ub=="'"){var
dc=bb.indexOf("'",Z+1);if(dc==Z+1){fb[fb.length]="'";Z=Z+2;}else if(dc>=0){fb[fb.length]=bb.substring(Z+1,dc);Z=dc+1;}else throw new
jsx3.Exception(jsx3._msg("dtfmt.sq",Z,this));}else if(r.v3[Ub]){var
Wb=1;while(bb.charAt(Z+Wb)==Ub)Wb++;var
A=fb.join("");if(A.length>0){Yb[Yb.length]=A;fb.splice(0,fb.length);}Yb[Yb.length]=[Ub,Wb];Z=Z+Wb;}else if(Ub.match(Bc)){throw new
jsx3.Exception(jsx3._msg("dtfmt.token",Z,bb));}else{Bc.lastIndex=Z+1;if(Bc.exec(bb)){fb[fb.length]=bb.substring(Z,Bc.lastIndex-1);Z=Bc.lastIndex-1;}else{fb[fb.length]=bb.substring(Z);break;}}}var
A=fb.join("");if(A.length>0){Yb[Yb.length]=A;fb.splice(0,fb.length);}};e.format=function(s){if(!(s instanceof Date)){if(!isNaN(s)){s=new
Date(Number(s));}else s=new
Date(s);if(isNaN(s))throw new
jsx3.IllegalArgumentException("objDate",s);}var
hc=new
Array(this.Cy.length);var
yc=new
Date();yc.setTime(s.getTime()+(this.getTimeZoneOffset(s)+s.getTimezoneOffset())*1000*60);for(var
Sb=0;Sb<this.Cy.length;Sb++){var
Wb=this.Cy[Sb];if(Wb instanceof Array){var
fc=Wb[0];var
Ob=Wb[1];hc[Sb]=r.v3[fc](yc,Ob,this);}else hc[Sb]=Wb;}return hc.join("");};e.parse=function(b){var
P=new
Date();P.setTime(0);var
wb=0;var
U={};for(var
Ub=0;Ub<this.Cy.length;Ub++){var
Kb=this.Cy[Ub];var
X=-1;if(Kb instanceof Array){X=r.Np[Kb[0]](this,b,wb,Kb[1],P,this.Cy[Ub+1],U);}else X=r.PE(b,wb,Kb);if(X<0)throw new
jsx3.Exception(jsx3._msg("dtfmt.parse",b,this));wb=wb+X;}if(U.bc)P.setUTCFullYear(1-P.getUTCFullYear());if(U.hours24){P.setUTCHours(U.hours24);}else if(U.hours12){var
Tb=U.hours12;if(U.pm)Tb=Tb+12;P.setUTCHours(Tb);}if(U.timezone!=null){P.setTime(P.getTime()-U.timezone*1000*60);}else P.setTime(P.getTime()-this.getTimeZoneOffset(P)*1000*60);return P;};e.getFormat=function(){return this.QM;};e.toString=function(){return this.QM;};});jsx3.Class.defineClass("jsx3.util.MessageFormat",null,null,function(k,j){var
Eb=jsx3.util.NumberFormat;var
L=jsx3.util.DateFormat;j.init=function(d,l){this.QM=d;this.mz=l||jsx3.System.getLocale();this.xJ();};j.getLocale=function(){return this.mz;};j.setLocale=function(f){this.mz=f;this.xJ();};j.format=function(b){var
t=new
Array(this.Cy.length);var
Db=arguments[0] instanceof Array?arguments[0]:arguments;for(var
w=0;w<t.length;w++){var
Tb=this.Cy[w];if(Tb instanceof Array){var
Dc=Tb[0];var
Hb=Tb[1];var
yb=Db[Dc];if(Dc>=Db.length){t[w]="{"+Dc+"}";}else if(yb==null){t[w]="null";}else if(Hb!=null){t[w]=Hb.format(yb);}else if(yb instanceof Date&&L){t[w]=L.getDateTimeInstance(1,1,this.mz).format(yb);}else if(typeof yb=="string"){t[w]=yb;}else if(typeof yb=="number"&&Eb){t[w]=Eb.getNumberInstance(this.mz).format(yb);}else t[w]=yb.toString();}else t[w]=this.Cy[w];}return t.join("");};j.xJ=function(){var
Tb=[];this.Cy=Tb;var
kb=this.QM;var
lb=kb.length;var
fb=0;var
Ec=false;var
U=[];while(fb<lb){var
P=kb.indexOf("'",fb);var
wc=kb.indexOf("{",fb);if(P>=0&&(P<wc||wc<0)){if(P>fb)U[U.length]=kb.substring(fb,P);var
oc=kb.indexOf("'",P+1);if(oc==P+1){U[U.length]="'";fb=oc+1;}else if(oc>=0){U[U.length]=kb.substring(P+1,oc);fb=oc+1;}else throw new
jsx3.Exception(jsx3._msg("msfmt.sq",P,this));}else if(wc>=0){if(wc>fb)U[U.length]=kb.substring(fb,wc);Tb[Tb.length]=U.join("");U.splice(0,U.length);fb=wc+1;var
Xb=[];while(true){var
C=kb.charAt(fb);if(C=="")throw new
jsx3.Exception(jsx3._msg("msfmt.bracket",lb-Xb.length-1,this));if(C=="'"){if(kb.charAt(fb+1)=="'"){Xb[Xb.length]=C;fb=fb+2;}else{Ec=!Ec;fb=fb+1;}}else if(Ec){Xb[Xb.length]=C;fb++;}else if(C=="}"){fb++;break;}else{Xb[Xb.length]=C;fb++;}}Tb[Tb.length]=this.us(Xb.join(""));}else{U[U.length]=kb.substring(fb);break;}}var
gc=U.join("");if(gc.length>0)Tb[Tb.length]=gc;};k.a3={date:"getDateInstance",time:"getTimeInstance",datetime:"getDateTimeInstance"};j.us=function(f){var
lb=f.split(",");var
tc=Number(lb[0]);if(isNaN(tc))throw new
jsx3.Exception(jsx3._msg("msfmt.bad_ind",f,this));if(lb.length>1){var
xb=lb[1];var
x=lb.slice(2).join(",");if(k.a3[xb]){if(!L)return [tc,null];var
Bb=k.a3[xb];var
vb=null;if(x=="short")vb=1;else if(x=="medium")vb=2;else if(x=="long")vb=3;else if(x=="full")vb=4;if(vb!=null||jsx3.util.strEmpty(x))return [tc,xb=="datetime"?L[Bb](vb,vb,this.mz):L[Bb](vb,this.mz)];return [tc,new
L(x,this.mz)];}else if(xb=="number"){if(!Eb)return [tc,null];if(jsx3.util.strEmpty(x))return [tc,Eb.getNumberInstance(this.mz)];else if(x=="integer")return [tc,Eb.getIntegerInstance(this.mz)];else if(x=="percent")return [tc,Eb.getPercentInstance(this.mz)];else if(x=="currency")return [tc,Eb.getCurrencyInstance(this.mz)];else return [tc,new
Eb(x,this.mz)];}else throw new
jsx3.Exception(jsx3._msg("msfmt.bad_type",f,this));}else return [tc,null];};j.toString=function(){return this.QM;};});jsx3.Package.definePackage("jsx3.html",function(r){var
kc=jsx3.gui.Event;r.MODE_IE_QUIRKS=0;r.MODE_FF_QUIRKS=1;r.MODE_IE_STRICT=2;r.MODE_FF_STRICT=3;r.getMode=function(e){if(r.BC==null){var
mb=e!=null?e.ownerDocument:document;var
u=e||document.getElementsByTagName("body")[0];r.BC=0;var
hb='<input type="text" id="_jsx3_html_b1" style="position:absolute;top:0px;left:-120px;width:100px;height:30px;padding:8px;margin:0px;"/>';jsx3.html.insertAdjacentHTML(u,"beforeEnd",hb);var
Jb=mb.getElementById("_jsx3_html_b1");if(Jb.offsetHeight!=30){r.BC=jsx3.CLASS_LOADER.IE?2:3;}else{var
Kc='<div id="_jsx3_html_b2" style="position:absolute;top:0px;left:-116px;width:100px;height:24px;padding:8px;"></div>';jsx3.html.insertAdjacentHTML(u,"beforeEnd",Kc);var
Mc=mb.getElementById("_jsx3_html_b2");if(parseInt(Mc.offsetWidth)>100)r.BC=1;u.removeChild(Mc);}u.removeChild(Jb);}return r.BC;};r.getScrollSizeOffset=function(d,o){return 0;};r.addEventListener=function(c,m,f){m=m.replace(/^on/,"");c.addEventListener(m,typeof f=="function"?f:new
Function("event",f),false);};r.removeEventListener=function(i,g,l){g=g.replace(/^on/,"");i.removeEventListener(g,l,false);};r._FOCUSABLE={input:true,textarea:true,select:true,body:true,a:true,img:true,button:true,frame:true,iframe:true,object:true};r.isFocusable=function(d){return d.focus!=null&&(parseInt(d.tabIndex)>=0||r._FOCUSABLE[d.tagName.toLowerCase()]);};r.createRule=function(o,n,d){if(!d)d=document;var
A=d.getElementsByTagName("head")[0];var
Q=typeof d.createElementNS!="undefined"?d.createElementNS("http://www.w3.org/1999/xhtml","style"):d.createElement("style");var
Y=d.createTextNode(o+" {"+n+"}");Q.appendChild(Y);Q.setAttribute("type","text/css");Q.setAttribute("media","screen");A.appendChild(Q);};r.getRuleByName=function(c){var
Tb=document.styleSheets;for(var
xb=0;xb<Tb.length;xb++){var
N=Tb[xb];for(var
Bb=0;Bb<N.cssRules.length;Bb++)if(N.cssRules[Bb].selectorText==c)return N.cssRules[Bb];}return null;};r.copy=function(l){netscape.security.PrivilegeManager.enablePrivilege("UniversalXPConnect");var
Vb=Components.classes["@mozilla.org/widget/clipboard;1"].createInstance(Components.interfaces.nsIClipboard);if(Vb){var
ec=Components.classes["@mozilla.org/widget/transferable;1"].createInstance(Components.interfaces.nsITransferable);if(ec){ec.addDataFlavor("text/unicode");var
lc=Components.classes["@mozilla.org/supports-string;1"].createInstance(Components.interfaces.nsISupportsString);lc.data=l;ec.setTransferData("text/unicode",lc,l.length*2);var
Hb=Components.interfaces.nsIClipboard;Vb.setData(ec,null,Hb.kGlobalClipboard);}}};r.paste=function(){netscape.security.PrivilegeManager.enablePrivilege("UniversalXPConnect");var
Hb=Components.classes["@mozilla.org/widget/clipboard;1"].getService(Components.interfaces.nsIClipboard);if(Hb){var
zb=Components.classes["@mozilla.org/widget/transferable;1"].createInstance(Components.interfaces.nsITransferable);if(zb){zb.addDataFlavor("text/unicode");Hb.getData(zb,Hb.kGlobalClipboard);var
pb={};var
U={};zb.getTransferData("text/unicode",pb,U);if(pb)pb=pb.value.QueryInterface(Components.interfaces.nsISupportsString);return pb?pb.data.substring(0,U.value/2):null;}}return null;};r.getRelativePosition=function(f,g){var
L={W:g.offsetWidth,H:g.offsetHeight};var
yb=g.scrollLeft;var
mc=g.scrollTop;var
Mb=0;var
_=0;var
Rb=g.offsetTop;var
ac=g.offsetLeft;var
dc=g;var
Q=0;var
Ec=0;var
Eb;if(g.offsetParent){Ec=Ec-g.offsetParent.scrollLeft;Q=Q-g.offsetParent.scrollTop;Eb=g.offsetParent.style.borderLeftWidth?parseInt(g.offsetParent.style.borderLeftWidth):0;if(!isNaN(Eb))Mb=Mb+Eb;Eb=g.offsetParent.style.borderTopWidth?parseInt(g.offsetParent.style.borderTopWidth):0;if(!isNaN(Eb))_=_+Eb;}while((g=g.offsetParent)!=null&&g!=f){Rb=Rb+g.offsetTop;ac=ac+g.offsetLeft;if(g.offsetParent){Eb=g.offsetParent.style.borderLeftWidth?parseInt(g.offsetParent.style.borderLeftWidth):0;if(!isNaN(Eb))Mb=Mb+Eb;Eb=g.offsetParent.style.borderTopWidth?parseInt(g.offsetParent.style.borderTopWidth):0;if(!isNaN(Eb))_=_+Eb;Ec=Ec+g.offsetParent.scrollLeft;Q=Q+g.offsetParent.scrollTop;}if(g.offsetParent&&g.offsetParent.offsetParent){var
cc=g.offsetParent.scrollTop;if(!isNaN(cc))Q=Q-cc;var
rb=g.offsetParent.scrollLeft;if(!isNaN(rb))Ec=Ec-rb;}}g=dc;while((g=g.parentNode)!=null&&g!=f)if(g.parentNode&&g.parentNode.parentNode&&!(g.parentNode.tagName&&g.parentNode.tagName.toUpperCase()=="BODY")){var
cc=g.parentNode.scrollTop;if(!isNaN(cc)&&cc>0)Q=Q-cc;var
rb=g.parentNode.scrollLeft;if(!isNaN(rb)&&rb>0)Ec=Ec-rb;}L.L=ac+Ec+2*Mb;L.T=Rb+Q+2*_;return L;};r.scrollIntoView=function(l,a,d,s){var
wc=l.parentNode;while(wc!=null){var
tc=wc.tagName.toLowerCase();if(tc=="span"||tc=="div"){var
L=r.getRelativePosition(wc,l);if(wc.clientWidth+wc.scrollLeft<=L.L){wc.scrollLeft=L.L+l.offsetWidth-wc.clientWidth+d;}else if(wc.clientWidth+wc.scrollLeft<L.L+l.offsetWidth&&d!=null)wc.scrollLeft=L.L+l.offsetWidth-wc.clientWidth+d;if(wc.scrollLeft>=L.L+l.offsetWidth){wc.scrollLeft=L.L-d;}else if(wc.scrollLeft>L.L&&d!=null)wc.scrollLeft=L.L-d;if(wc.clientHeight+wc.scrollTop<=L.T){wc.scrollTop=L.T+l.offsetHeight-wc.clientHeight+s;}else if(wc.clientHeight+wc.scrollTop<L.T+l.offsetHeight&&s!=null)wc.scrollTop=L.T+l.offsetHeight-wc.clientHeight+s;if(wc.scrollTop>=L.T+l.offsetHeight){wc.scrollTop=L.T-s;}else if(wc.scrollTop>L.T&&s!=null)wc.scrollTop=L.T-s;}if(wc==a)break;wc=wc.parentNode;}};r.getOuterHTML=function(f){if(window.SVGElement&&f instanceof SVGElement){return (new
XMLSerializer()).serializeToString(f);}else{var
wb=[];switch(f.nodeType){case 1:wb[wb.length]="<"+f.nodeName.toLowerCase();if(f.namespaceURI)wb[wb.length]=' xmlns="'+f.namespaceURI+'"';for(var
N=0;N<f.attributes.length;N++){var
cc=f.attributes.item(N);if(cc.nodeValue!=null)wb[wb.length]=" "+cc.nodeName+'="'+cc.nodeValue+'"';}if(f.childNodes.length==0)wb[wb.length]="/>";else wb[wb.length]=">"+f.innerHTML+"</"+f.nodeName.toLowerCase()+">";break;case 3:wb[wb.length]=f.nodeValue;break;case 4:wb[wb.length]="<![CDATA["+f.nodeValue+"]]>";break;case 5:wb[wb.length]="&"+f.nodeName+";";break;case 8:wb[wb.length]="<!--"+f.nodeValue+"-->";break;}return wb.join("");}};r.setOuterHTML=function(l,d){if(window.SVGElement&&l instanceof SVGElement){if(!d){l.parentNode.removeChild(l);}else{var
lc=l.ownerDocument.createRange();lc.setStartBefore(l);var
yb=lc.createContextualFragment(d);l.parentNode.replaceChild(yb,l);}}else try{var
lc=l.ownerDocument.createRange();lc.setStartBefore(l);var
yb=lc.createContextualFragment(d);l.parentNode.replaceChild(yb,l);}catch(Kc){var
J=typeof d=="string"?d.substring(0,50):d;throw new
jsx3.Exception(jsx3._msg("html.set_outer",l,J),jsx3.NativeError.wrap(Kc));}};r.setInnerText=function(a,b){for(var
gb=a.childNodes.length-1;gb>=0;gb--)a.removeChild(a.childNodes[gb]);a.appendChild(a.ownerDocument.createTextNode(b));};r.insertAdjacentHTML=function(e,c,p){if(c.toLowerCase()=="beforeend"){var
D=e.ownerDocument.createRange();D.setStartAfter(e);var
cb=D.createContextualFragment(p);e.appendChild(cb);return p;}else if(c.toLowerCase()=="beforebegin"){var
D=e.ownerDocument.createRange();D.setStartBefore(e);var
cb=D.createContextualFragment(p);e.parentNode.insertBefore(cb,e);return p;}else throw new
jsx3.Exception(jsx3._msg("html.adj",c));};r.updateCSSOpacity=function(m,p){m.style.MozOpacity=p.toString();};r.getCSSOpacity=function(e){return "-moz-opacity:"+e+";";};r.getCSSFade=function(d){return r.getCSSPNG(d?jsx3.resolveURI("jsx:///images/icons/h.png"):jsx3.resolveURI("jsx:///images/icons/v.png"));};r.getCSSPNG=function(e){return "background-image:url("+e+");";};r.getJSXParent=function(l){while(l!=null){if(l.id&&l.id.indexOf("_jsx_")==0){var
Bb=jsx3.GO(l.id);if(Bb!=null)return Bb;}l=l.parentNode;}return null;};r.removeOutputEscaping=function(b){var
mc=jsx3.util.List.wrap([b]);while(mc.size()>0){var
nc=mc.removeAt(0);if(nc.nodeName.toLowerCase()=="span"&&nc.className=="disable-output-escp"){nc.innerHTML=nc.innerHTML.replace(/&lt;/g,"<").replace(/&gt;/g,">").replace(/&quot;/g,'"').replace(/&amp;/g,"&").replace(/&([a-zA-Z_]+);/g,r.dA);nc.className="";}else mc.addAll(nc.childNodes);}};r.removeOutputEscapingSpan=function(n){return n.replace(/<span class=\"disable-output-escp\">([\s\S]*?)<\/span>/g,function(c,i){return i.replace(/&lt;/g,"<").replace(/&gt;/g,">").replace(/&quot;/g,'"').replace(/&amp;/g,"&").replace(/&([a-zA-Z_]+);/g,r.dA);});};r.oq={nbsp:160,copy:169,reg:174,deg:176,middot:183,le:8804,ge:8805,lt:60,gt:62,euro:8364,ndash:8211,mdash:8212,lsquo:8216,rsquo:8217,ldquo:8220,rdquo:8221,permil:8240};r.dA=function(l,a){var
fb=r.oq[a];return fb?"&#"+fb+";":l;};r.QT="jsx_image_loader";r.loadImages=function(a){var
sb=document.getElementById(r.QT);if(sb==null){var
wb=document.getElementsByTagName("body")[0];if(wb){sb=document.createElement("div");sb.id=r.QT;sb.style.display="none";wb.insertBefore(sb,wb.firstChild);}else return;}var
Qb=a instanceof Array?a:arguments;for(var
hc=0;hc<Qb.length;hc++){if(!Qb[hc])continue;var
Nb=jsx3.resolveURI(Qb[hc]);var
yb=r.QT+"_"+Nb;if(document.getElementById(yb)==null){var
v=document.createElement("img");v.setAttribute("id",yb);v.setAttribute("src",Nb);sb.appendChild(v);}}};r.updateRule=function(m,e,f){var
jc=jsx3.html.getRuleByName(m);if(jc)jc.style[e]=f;};r.getElementById=function(d,p,k){return this.findElements(d,function(f){return f.id==p;},k,false,false,true);};r.getElementByTagName=function(k,i,s){i=i.toLowerCase();return this.findElements(k,function(c){return c.tagName.toLowerCase()==i;},s,false,false,true);};r.getElementsByTagName=function(k,i,s){i=i.toLowerCase();return this.findElements(k,function(o){return o.tagName.toLowerCase()==i;},s,true,false,true);};r.findElements=function(m,g,a,e,c,o){var
rc=a?"unshift":"push";var
mb=e?[]:null;var
Mc=o?[m]:this.nodesToArray(m.childNodes);while(Mc.length>0){var
Y=Mc.shift();if(g.call(null,Y))if(e)mb[mb.length]=Y;else return Y;if(!c)Mc[rc].apply(Mc,this.nodesToArray(Y.childNodes));}return mb;};r.getElmUpByTagName=function(e,m,q){return r.findElementUp(e,function(h){return h.nodeName.toLowerCase()==m;},q);};r.findElementUp=function(o,f,h){var
v=o.ownerDocument.documentElement;var
_=h?o:o.parentNode;while(_!=null){if(f.call(null,_))return _;if(_==v)break;_=_.parentNode;}return null;};r.selectSingleElm=function(f,b){var
qb=1,zb=arguments;if(arguments.length==2)if(typeof b=="string"){qb=0;zb=b.split(/\//g);}else if(b instanceof Array){qb=0;zb=b;}var
Lb=f;for(var
Kc=qb;Lb!=null&&Kc<zb.length;Kc++){var
tc=zb[Kc];if(!isNaN(tc)){var
Bc=Number(tc);var
Tb=Lb.childNodes.length;var
Yb=0,M=0;for(;Yb<Tb&&M<Bc;Yb++)if(Lb.childNodes[Yb].nodeType==1)M++;Lb=Lb.childNodes[Yb];}else throw new
jsx3.Exception();}return Lb;};r.nodesToArray=function(d){var
bc=new
Array(d.length);for(var
Ec=0;Ec<d.length;Ec++)bc[Ec]=d[Ec];return bc;};r.getSelection=function(l){return new
r.Selection(l);};r.focusNext=function(q,o){var
zc=q;while(zc.lastChild)zc=zc.lastChild;while(!r.isFocusable(zc)&&zc!=q)zc=zc.previousSibling||zc.parentNode;if(zc!=q||r.isFocusable(zc))if(zc.onfocus!=null){var
mc=zc.onfocus;zc.onfocus=null;zc.focus();jsx3.sleep(function(){zc.onfocus=mc;});}else zc.focus();};r.focusPrevious=function(p,d){var
N=this.findElements(p,function(j){return r.isFocusable(j);},true,false,false,true);if(N!=null)if(N.onfocus!=null){var
Fb=N.onfocus;N.onfocus=null;N.focus();jsx3.sleep(function(){N.onfocus=Fb;});}else N.focus();};});jsx3.Class.defineClass("jsx3.html.Selection",null,null,function(i,c){c.init=function(l){this.WD={elm:l,start:l.selectionStart,end:l.selectionEnd,scrollt:l.scrollTop,scrolll:l.scrollLeft};};c.getStartIndex=function(){return this.WD.start;};c.getEndIndex=function(){return this.WD.end;};c.setRange=function(k,r){this.WD.start=k;this.WD.end=r;this.WD.elm.setSelectionRange(k,r);};c.getOffsetLeft=function(){if(this.WD.pos==null)this.WD.pos=jsx3.html.getRelativePosition(null,this.WD.elm);return this.WD.pos.L;};c.getOffsetTop=function(){if(this.WD.pos==null)this.WD.pos=jsx3.html.getRelativePosition(null,this.WD.elm);return this.WD.pos.T;};c.getText=function(){return this.WD.elm.value.substring(this.WD.start,this.WD.end);};c.setText=function(b){this.WD.elm.value=this.WD.elm.value.substring(0,this.WD.start)+b+this.WD.elm.value.substring(this.WD.end);this.WD.elm.setSelectionRange(this.WD.start,this.WD.start+b.length);this.WD.elm.end=this.WD.elm.selectionEnd;};c.insertCaret=function(h){this.WD.elm.focus();if(h=="end"){this.WD.elm.setSelectionRange(this.WD.elm.end,this.WD.elm.end);}else throw new
jsx3.Exception();this.WD.elm.scrollTop=this.WD.scrollt;this.WD.elm.scrollLeft=this.WD.scrolll;};});jsx3.Class.defineClass("jsx3.app.Cache",null,[jsx3.util.EventDispatcher],function(c,l){c.EVENT_CHANGE="change";l.init=function(){this.hK={};this.MX=[];this.wI={};};l.addParent=function(o){this.MX.push(o);};l.clearById=function(k){if(this.hK[k]!=null){delete this.hK[k];this.onChange();}};l.isSystem=function(r){return false;};l.clearByTimestamp=function(g){if(g instanceof Date)g=g.getTime();var
Bb=false;for(var t in this.hK){var
yb=this.hK[t];if(yb.PL<g){delete this.hK[t];Bb=true;}}if(Bb)this.onChange();};l.getDocument=function(k){if(this.hK[k]!=null)return this.hK[k].kE;for(var
F=0;F<this.MX.length;F++){var
B=this.MX[F].getDocument(k);if(B!=null)return B;}return null;};l.getOrOpenDocument=function(d,j,i){if(j==null)j=d.toString();return this.getDocument(j)||this.openDocument(d,j,i);};l.openDocument=function(i,e,d){if(d==null)d=jsx3.xml.Document.jsxclass;if(e==null)e=i.toString();var
Qb=d.newInstance();Qb.load(i);this.setDocument(e,Qb);return Qb;};l.openDocumentAsync=function(p,q,f,m){var
zc=jsx3.xml.Document;if(f==null)f=zc.jsxclass;if(q==null)q=p.toString();if(this.wI[q])return;delete this.hK[q];var
tb=f.newInstance();tb.setAsync(true);tb.subscribe("*",this,function(j){if(this.wI[q]){this.setDocument(q,tb);delete this.wI[q];}tb.unsubscribe("*",this);if(m)m(tb);});this.wI[q]=true;tb.load(p);};l.setDocument=function(d,o,p){if(d==null)throw new
jsx3.IllegalArgumentException("strId",d);if(o==null)throw new
jsx3.IllegalArgumentException("objDocument",o);var
Bc={};Bc.PL=(new
Date()).getTime();Bc.kE=o;this.hK[d]=Bc;delete this.wI[d];if(p!==false)this.onChange();};l.getTimestamp=function(r){var
L=this.hK[r];return L!=null?L.PL:null;};l.onChange=function(){this.publish({subject:"change"});};l.keys=function(){var
ic=[];for(var H in this.hK)ic[ic.length]=H;return ic;};l.destroy=function(){delete this.hK;delete this.MX;};});jsx3.Cache=jsx3.app.Cache;jsx3.Class.defineClass("jsx3.app.Properties",null,null,function(m,d){var
pc=jsx3.util.Logger.getLogger(m.jsxclass.getName());m.MD="_global";d.init=function(){this.MX=[];this.q1=[];this.OF=[m.MD];this.nV={};this.nV[m.MD]={};this.AV={};this.kF=false;this.DM={};this.ML=false;};d.loadXML=function(e,b){if(b==null){b=m.MD;}else if(jsx3.util.arrIndexOf(this.OF,b)<0)this.OF.splice(1,0,b);var
L=this.nV[b];if(L==null)L=this.nV[b]={};for(var
wb=e.selectNodeIterator("./record");wb.hasNext();){var
kb=wb.next();var
Nc=kb.getAttribute("jsxid");var
eval=kb.getAttribute("eval");var
Hc=kb.getAttribute("jsxtext");if(eval=="1"||eval=="true")try{Hc=isNaN(Hc)?jsx3.eval(Hc):Number(Hc);}catch(Kc){pc.warn(jsx3._msg("props.eval",Nc,Hc),jsx3.NativeError.wrap(Kc));}L[Nc]=Hc;}this.kF=true;};d.addParent=function(h){this.MX.splice(0,0,h);h.q1.push(this);this.ML=true;};d.removeParent=function(e){var
t=jsx3.util.arrIndexOf(this.MX,e);if(t>=0){this.MX.splice(t,1);e.Ez(this);}this.ML=true;};d.Ez=function(h){var
lc=jsx3.util.arrIndexOf(this.q1,h);if(lc>=0)this.q1.splice(lc,1);};d.removeAllParents=function(){for(var
jb=0;jb<this.MX.length;jb++)this.MX[jb].Ez(this);this.MX=[];this.DM={};};d.getParents=function(){return this.MX.concat();};d.containsKey=function(l){if(this.kF)this.CY();return typeof this.AV[l]!="undefined";};d.getKeys=function(){if(this.kF)this.CY();var
cc=[];for(var Qb in this.AV)cc[cc.length]=Qb;return cc;};d.get=function(j){if(this.kF)this.CY();if(typeof this.AV[j]!="undefined")return this.AV[j];if(this.VK())this.Zr();return this.DM[j];};d.VK=function(){for(var
U=0;U<this.MX.length&&!this.ML;U++){var
Bc=this.MX[U];this.ML=Bc.kF||Bc.VK();}return this.ML;};d.set=function(e,n){if(typeof n=="undefined")throw new
jsx3.IllegalArgumentException("strValue",n);this.nV[m.MD][e]=n;this.AV[e]=n;this.S1();};d.remove=function(n){for(var Sb in this.nV)delete this.nV[Sb][n];delete this.AV[n];this.S1();};d.CY=function(){this.kF=false;var
mb=this.AV={};for(var
ab=this.OF.length-1;ab>=0;ab--){var
ob=this.nV[this.OF[ab]];for(var Db in ob)mb[Db]=ob[Db];}};d.Zr=function(){this.ML=false;var
B=this.DM={};for(var
Mb=this.MX.length-1;Mb>=0;Mb--){var
Y=this.MX[Mb];if(Y.kF)Y.CY();if(Y.VK())Y.Zr();var
cc=Y.AV;var
Ub=Y.DM;for(var Vb in Ub)B[Vb]=Ub[Vb];for(var Vb in cc)B[Vb]=cc[Vb];}};d.S1=function(){for(var
Ac=0;Ac<this.q1.length;Ac++)this.q1[Ac].ML=true;};});jsx3.Class.defineClass("jsx3.app.PropsBundle",jsx3.app.Properties,null,function(s,r){var
U=jsx3.util.Locale;var
xb=jsx3.util.Logger.getLogger(s.jsxclass.getName());s.j1="__root";s.ps=".xml";s.Gx=".";s.sN="meta";s.PM="default";s.Xp=-1;s.Yq={};s.nK={};s.getProps=function(g,m,i){g=g.toString();if(m==null)m=jsx3.System.getLocale();var
V=g+"::"+m.toString();if(s.nK[V]==null){if(s.Yq[g]==null){s.Au(g,s.j1,i);if(s.Yq[g]==null)s.R6(g,i);}if(s.Yq[g]==s.Xp)throw new
jsx3.Exception(jsx3._msg("propbn.err",g));var
ib=s.uU(g,m);var
eb=g+"::"+ib;if(s.nK[eb]==null)s.Au(g,ib,i);if(s.nK[eb]==s.Xp)throw new
jsx3.Exception(jsx3._msg("propbn.err_key",g,ib));eb=g+"::"+s.uU(g,m);s.nK[V]=s.nK[eb];}return s.nK[V];};s.Au=function(i,m,q){var
Dc=i+"::"+m;var
O=null;if(jsx3.util.strEndsWith(i,"/")){O=i+(m==s.j1?s.PM:m)+s.ps;}else{var
Fb=i.lastIndexOf(".");O=m==s.j1?i:i.substring(0,Fb)+s.Gx+m+i.substring(Fb);}var
lc=null;if(q!=null){lc=q.getOrOpenDocument(O);}else{lc=new
jsx3.xml.Document();lc.load(O);}if(!lc.hasError()){if(lc.getAttribute("jsxnamespace")=="propsbundle"){s.wU(i,lc);s.x5(i,lc);}else s.DF(i,m,lc,q);}else{xb.error(jsx3._msg("propbn.err_file",O,lc.getError()));s.nK[Dc]=s.Xp;}};s.DF=function(n,i,e,b){var
J=new
s();J.loadXML(e);J._locale=U.valueOf(i==s.j1?"":i);s.nK[n+"::"+i]=J;if(i!=s.j1){var
y=U.valueOf(i).getSearchPath()[1];if(y!=null)J.addParent(s.getProps(n,y,b));}};s.x5=function(o,j){for(var
zc=j.selectNodeIterator("/data/locale");zc.hasNext();){var
Db=zc.next();var
Jb=Db.getAttribute("key");if(jsx3.util.strEmpty(Jb))Jb=s.j1;s.DF(o,Jb,Db);s.Yq[o][Jb]=true;}};s.uU=function(a,g){var
Nc=s.Yq[a];var
ub=g.getSearchPath();for(var
kc=0;kc<ub.length;kc++)if(ub[kc].toString().length>0&&Nc[ub[kc].toString()])return ub[kc].toString();return s.j1;};s.R6=function(q,m){var
qc=null;if(jsx3.util.strEndsWith(q,"/")){qc=q+s.sN+s.ps;}else{var
N=q.lastIndexOf(".");qc=q.substring(0,N)+s.Gx+s.sN+q.substring(N);}var
Z=null;if(m!=null){Z=m.getDocument(qc)||m.openDocument(qc,qc);}else{Z=new
jsx3.xml.Document();Z.load(qc);}var
Q=false;if(!Z.hasError()){s.wU(q,Z);Q=true;}else xb.error("Error loading localized bundle meta file "+qc+": "+Z.getError());if(!Q)s.Yq[q]=s.Xp;};s.wU=function(k,b){var
nb=b.getAttribute("locales");if(nb==null){var
Mb=b.selectSingleNode("/data/record[@jsxid='locales']");if(Mb!=null)nb=Mb.getAttribute("jsxtext");}if(s.Yq[k]==null)s.Yq[k]={};if(nb!=null){var
S=nb.split(/\s*,\s*/);for(var
wc=0;wc<S.length;wc++)if(S[wc])s.Yq[k][S[wc]]=true;}};r.getLocale=function(){return this._locale;};s.clearCache=function(){s.Yq={};s.nK={};};});jsx3.Class.defineClass("jsx3.lang.System",null,null,function(g,o){g.LJSS=new
jsx3.app.Properties();g.JSS=new
jsx3.app.Properties();g.JSS.addParent(g.LJSS);g.H4={};g.getProperty=function(h){return g.JSS.get(h);};g.getLocale=function(){if(g.mz==null&&jsx3.util.Locale){var
Fc=jsx3.app.Browser.getLocaleString();if(Fc){var
gc=Fc.split("_");g.mz=new
jsx3.util.Locale(gc[0],gc[1]);}else g.mz=jsx3.util.Locale.US;}return g.mz;};g.setLocale=function(p){if(p!=g.mz){g.JSS.removeParent(g.getLocaleProperties());g.mz=p;g.JSS.addParent(g.getLocaleProperties());}};g.reloadLocalizedResources=function(){g.LJSS.removeAllParents();if(jsx3.app.PropsBundle){var
xb=jsx3.lang.ClassLoader.INCLUDES;for(var
t=0;t<xb.length;t++){var
F=F[t];if(F.type=="ljss"){var
R=jsx3.net.URIResolver.JSX.resolveURI(F.src);g.LJSS.addParent(jsx3.app.PropsBundle.getProps(R,g.getLocale(),jsx3.getSystemCache()));}}}};g.getLocaleProperties=function(m){var
Q=jsx3.resolveURI("jsx:///locale/locale.xml");var
R=jsx3.getSystemCache().getDocument(Q);if(R){if(m==null)m=g.getLocale();return jsx3.app.PropsBundle.getProps(Q,m);}else return new
jsx3.app.Properties();};g.getMessage=function(r,i){var
Qb=g.LJSS.get(r);var
Ab="";if(arguments.length>1){var
xc=jsx3.Method.argsAsArray(arguments,1);if(Qb!=null&&jsx3.util.MessageFormat){try{var
O=new
jsx3.util.MessageFormat(Qb);return O.format(xc);}catch(Kc){}}else Ab=" "+xc.join(" ");}if(Qb==null)Qb=r;return Qb+Ab;};jsx3.lang.System.GO=function(k,c){var
ac=null;if(k!=null)if(k.indexOf("_jsx_")==0){var
xb=jsx3.app.DOM.getNamespaceForId(k);if(c&&c!=xb)return null;if(g.H4[xb])ac=g.H4[xb].getJSXById(k);}else if(c){if(g.H4[c])ac=g.H4[c].getJSXByName(k);}else for(var Ic in g.H4)if((ac=g.H4[Ic].getJSXByName(k))!=null)return ac;return ac;};g.getApp=function(d){return g.H4[d];};g.getAllApps=function(){var
db=[];for(var I in g.H4)db.push(g.H4[I]);return db;};g.registerApp=function(f){var
Zb=f.getEnv("namespace");var
I=Zb.split(/\./);var
F=window;for(var
ac=0;ac<I.length-1;ac++){if(F[I[ac]]==null)F[I[ac]]={};F=F[I[ac]];}F[I[I.length-1]]=f;g.H4[Zb]=f;};g.deregisterApp=function(e){var
Jb=e.getEnv("namespace");var
_b=Jb.split(/\./);var
Gb=e.getEnv("system")?jsx3:window;for(var
Lb=0;Lb<_b.length-1;Lb++){if(Gb[_b[Lb]]==null)Gb[_b[Lb]]={};Gb=Gb[_b[Lb]];}if(Gb[_b[_b.length-1]]==e)if(Gb==window)Gb[_b[_b.length-1]]=null;else delete Gb[_b[_b.length-1]];if(g.H4[Jb]==e)delete g.H4[Jb];};g.activateApp=function(l){jsx3.registerApp(l);};g.getLoadedAppByPath=function(q){for(var Ab in g.H4){var
Q=g.H4[Ab];if(Q.getEnv("apppathrel")==q||Q.getEnv("apppath")==q)return Q;}return null;};g.getAddins=function(){return [];};g.RC=[];g.oY={};g.addinKeyToPath=function(b){if(b.indexOf("user:")==0){return jsx3.resolveURI("jsxuser:/addins/"+b.substring(5)+"/");}else return jsx3.resolveURI(jsx3.ADDINSPATH+b+"/");};g.registerAddin=function(f,e){var
E=f.split(/\./);var
_b=window;for(var
Ac=0;Ac<E.length-1;Ac++){var
sb=E[Ac];if(_b[sb]==null)_b[sb]={};_b=_b[sb];}_b[E[E.length-1]]=e;g.RC.push(e);g.oY[e.getKey()]=e;};g.getLoadedAddins=function(){return g.RC.concat();};g.getLoadedAddinByKey=function(b){return g.oY[b];};g.getVersion=function(){var
Lb="3.4.1";return Lb.match(/\d/)?Lb:"3.4.1";};});jsx3.GO=jsx3.lang.System.GO;jsx3.getApp=jsx3.lang.System.getApp;jsx3.registerApp=jsx3.lang.System.registerApp;jsx3.activateApp=jsx3.lang.System.activateApp;jsx3.deregisterApp=jsx3.lang.System.deregisterApp;jsx3.getAddins=jsx3.lang.System.getAddins;jsx3.getVersion=jsx3.lang.System.getVersion;jsx3.Class.defineInterface("jsx3.xml.CDF",null,function(e,b){e.ST=jsx3.util.Logger.getLogger(e.jsxclass.getName());e.DELETE=0;e.INSERT=1;e.UPDATE=2;e.INSERTBEFORE=3;e.ELEM_ROOT="data";e.ELEM_RECORD="record";e.ATTR_ID="jsxid";e.ATTR_TEXT="jsxtext";e.ATTR_EXECUTE="jsxexecute";e.ATTR_DISABLED="jsxdisabled";e.ATTR_SELECTED="jsxselected";e.ATTR_UNSELECTABLE="jsxunselectable";e.ATTR_IMG="jsximg";e.ATTR_TIP="jsxtip";e.ATTR_KEYCODE="jsxkeycode";e.Wp=["jsxtext","jsxtip","jsximg","jsxkeycode","jsxstyle","jsxclass"];e.Y9=1;b.insertRecord=function(q,i,c){if(q instanceof Object){var
Y=this.getXML();var
I=1;var
Jc=Y.selectSingleNode(this.Ef(q.jsxid));if(Jc!=null){I=2;}else{Jc=Y.createNode(1,"record");var
kc=i!=null?Y.selectSingleNode(this.Ef(i)):null;if(kc==null)kc=Y.getRootNode();kc.appendChild(Jc);}for(var pc in q)if(q[pc]!=null)Jc.setAttribute(pc,q[pc].toString());if(c!==false)this.redrawRecord(q["jsxid"],I);return Jc;}else throw new
jsx3.IllegalArgumentException("objRecord",q);};b.insertRecordNode=function(o,g,k){if(o instanceof jsx3.xml.Entity){var
yc=this.getXML();var
nb=g!=null?yc.selectSingleNode(this.Ef(g)):null;if(nb==null)nb=yc.getRootNode();nb.appendChild(o);if(k!==false)this.redrawRecord(o.getAttribute("jsxid"),1);}else throw new
jsx3.IllegalArgumentException("objRecordNode",o);};b.insertRecordProperty=function(r,l,g,m){var
O=this.getRecordNode(r);if(O!=null){O.setAttribute(l,g);if(m!==false)this.redrawRecord(r,2);}else e.ST.debug(jsx3._msg("cdf.prop_ins",r));return this;};b.deleteRecordProperty=function(f,s,a){var
cb=this.getXML();var
Pb=cb.selectSingleNode(this.Ef(f));if(Pb!=null){Pb.removeAttribute(s);if(a!==false)this.redrawRecord(f,2);}else e.ST.debug(jsx3._msg("cdf.prop_del",f));};b.redrawRecord=jsx3.Method.newAbstract("strRecordId","intAction");b.adoptRecord=function(g,d,p,r){var
zb=g;if(typeof g=="string")zb=jsx3.GO(g);if(zb!=null){var
Lc=zb.getRecordNode(d);if(Lc!=null){var
Ic=p==null?this.getXML().getRootNode():this.getRecordNode(p);if(Ic!=null){var
ac=Ic;while(ac!=null&&!ac.equals(Lc))ac=ac.getParent();if(ac==null){if(zb!=this){var
eb=this.getRecordNode(d);if(eb!=null){e.ST.debug(jsx3._msg("cdf.adopt_col",this,d));return;}}var
sb=zb.deleteRecord(d);this.insertRecordNode(sb,p,r);return this.getRecordNode(d);}else{}}else e.ST.debug(jsx3._msg("cdf.adopt_dest",this,d,p));}else e.ST.debug(jsx3._msg("cdf.adopt_src",this,d,zb));}else e.ST.debug("adoptRecord() no object with id: "+g);};b.insertRecordBefore=function(o,l,g){var
zc=this.getXML();var
z=zc.selectSingleNode(this.Ef(o.jsxid));if(z){e.ST.debug(jsx3._msg("cdf.before_col",o.jsxid,this));}else{var
Mb=zc.selectSingleNode(this.Ef(l));if(Mb!=null&&Mb.getParent()!=null){var
dc=this.insertRecord(o,Mb.getParent().getAttribute("jsxid"),false);if(dc){this.adoptRecordBefore(this,o.jsxid,l,g);return dc;}}else e.ST.debug(jsx3._msg("cdf.before_rec",l,this));}};b.adoptRecordBefore=function(d,j,c,q){var
L=d;if(typeof d=="string")L=jsx3.GO(d);if(L==this&&j==c){}else{var
ac=this.getRecordNode(c).getParent();var
Eb=ac.getAttribute("jsxid");var
Rb=this.adoptRecord(d,j,Eb,false);if(Rb){var
wc=this.getRecordNode(c);ac.insertBefore(Rb,wc);if(q!==false)this.redrawRecord(Rb.getAttribute("jsxid"),3);return Rb;}}};b.deleteRecord=function(r,m){var
ub=this.getXML();var
Tb=ub.selectSingleNode(this.Ef(r));if(Tb!=null){Tb=Tb.getParent().removeChild(Tb);if(m!==false)this.redrawRecord(r,0);return Tb;}return null;};b.getRecord=function(r){var
v=this.getRecordNode(r);if(v!=null){var
wc={};var
ec=v.getAttributeNames();for(var
Wb=0;Wb<ec.length;Wb++)wc[ec[Wb]]=v.getAttribute(ec[Wb]);return wc;}return null;};b.getRecordNode=function(f){var
nc=this.getXML();return nc.selectSingleNode(this.Ef(f));};b.Ef=function(o){return (o+"").indexOf("'")==-1?"//*[@jsxid='"+o+"']":'//*[@jsxid="'+o+'"]';};b.resetData=function(g){if(jsx3.xml.Cacheable&&this.instanceOf(jsx3.xml.Cacheable)){this.clearXmlData();if(g)this.repaint();}};b.reloadFromSource=function(g){if(jsx3.xml.Cacheable&&this.instanceOf(jsx3.xml.Cacheable))this.resetXmlCacheData();};b.assignIds=function(){var
Wb=this.getXML();for(var
Y=Wb.selectNodeIterator("//record[not(@jsxid)]");Y.hasNext();){var
bc=Y.next();bc.setAttribute("jsxid",e.getKey());}};e.n9=/\[(\w+)\]$/;b.convertProperties=function(s,n,o){if(n==null)n=e.Wp;else if(o)n.push.apply(n,e.Wp);if(jsx3.getXmlVersion()>=4&&!jsx3.CLASS_LOADER.SAF){var
w=new
Array(n.length);for(var
x=0;x<n.length;x++)w[x]="name()='"+n[x]+"'";var
rb=w.join(" or ");var
yc="substring(.,1,1)='{' and substring(.,string-length(.),1)='}'";var
C="//@*[("+rb+") and ("+yc+")]";for(var
x=this.getXML().selectNodeIterator(C);x.hasNext();){var
y=x.next();var
oc=y.getValue();var
Bc=oc.substring(1,oc.length-1);var
I=null;if(Bc.match(e.n9)){Bc=RegExp.leftContext;I=RegExp.$1;}var
ub=s.get(Bc);if(typeof ub!="undefined")if(I!=null&&ub instanceof Object)y.setValue(ub[I]);else y.setValue(ub);}}else{var
C="//@"+n.join(" | //@");for(var
Yb=this.getXML().selectNodeIterator(C);Yb.hasNext();){var
y=Yb.next();var
oc=y.getValue();if(oc.indexOf("{")==0&&jsx3.util.strEndsWith(oc,"}")){var
Bc=oc.substring(1,oc.length-1);var
I=null;if(Bc.match(e.n9)){Bc=RegExp.leftContext;I=RegExp.$1;}var
ub=s.get(Bc);if(typeof ub!="undefined")if(I!=null&&ub instanceof Object)y.setValue(ub[I]);else y.setValue(ub);}}}};e.newDocument=function(){var
F=new
jsx3.xml.Document();F.loadXML("<"+"data"+' jsxid="jsxroot"/>');return F;};e.getKey=function(){return "jsx_"+(e.Y9++
).toString(36);};e.getVersion=function(){return "3.00.00";};});jsx3.Class.defineClass("jsx3.xml.CDF.Document",jsx3.xml.Document,[jsx3.xml.CDF],function(h,p){p.getXML=function(){return this;};p.redrawRecord=function(e,c){};p.cloneDocument=function(){return h.wrap(this.jsxsuper());};h.newDocument=function(){var
zb=new
h();zb.loadXML("<"+"data"+' jsxid="jsxroot"/>');return zb;};h.wrap=function(s){return new
h(s.getNativeDocument());};});jsx3.CDF=jsx3.xml.CDF;jsx3.Class.defineClass("jsx3.app.DOM",null,[jsx3.util.EventDispatcher],function(e,q){e.XA={};e.U5={};e.j7={};e.Z9=0;e.TYPEADD=0;e.TYPEREMOVE=1;e.TYPEREARRANGE=2;e.EVENT_CHANGE="change";e.newId=function(d){var
lb=e.D_(d);return "_jsx_"+lb+"_"+e.NV(lb).toString(36);};e.D_=function(m){if(e.U5[m]==null){var
Ec=(e.Z9++
).toString(36);e.U5[m]=Ec;e.j7[Ec]=m;}return e.U5[m];};e.NV=function(m){if(e.XA[m]==null)e.XA[m]=0;return ++e.XA[m];};e.getNamespaceForId=function(i){var
G=i.substring(5,i.indexOf("_",5));return e.j7[G];};q.init=function(){this.O2={};this.Ky={};};q.destroy=function(){delete this.O2;delete this.Ky;};q.get=function(d){return this.O2[d]||this.getByName(d);};q.getByName=function(i){var
Jc=this.Ky[i];return Jc!=null?Jc.get(0):null;};e.l_=[];q.getAllByName=function(j){var
W=this.Ky[j];return W!=null?W.toArray():e.l_;};q.getById=function(f){return this.O2[f];};q.add=function(b){this.O2[b.getId()]=b;var
gc=b.getName();if(gc!=null&&gc!=="")if(this.Ky[gc]==null)this.Ky[gc]=jsx3.util.List.wrap([b]);else this.Ky[gc].add(b,0);};q.remove=function(i){delete this.O2[i.getId()];var
kb=this.Ky[i.getName()];if(kb!=null)kb.remove(i);};q.onNameChange=function(d,s){var
O=this.Ky[s];if(O!=null)O.remove(d);var
tb=d.getName();if(tb!=null&&tb!=="")if(this.Ky[tb]==null)this.Ky[tb]=jsx3.util.List.wrap([d]);else this.Ky[tb].add(d,0);};q.onChange=function(f,l,g){this.publish({subject:"change",type:f,parentId:l,jsxId:g});};});jsx3.DOM=jsx3.app.DOM;jsx3.Class.defineClass("jsx3.app.Server",null,[jsx3.util.EventDispatcher,jsx3.net.URIResolver],function(o,a){jsx3.util.EventDispatcher.jsxclass.mixin(o);var
Pb=jsx3.gui.Event;var
Qb=jsx3.net.URIResolver;var
Sb=jsx3.app.Browser;var
eb=null;var
nb=jsx3.util.Logger.getLogger(o.jsxclass.getName());o.Z_DIALOG=2;o.Z_DRAG=3;o.Z_MENU=4;o.EVENT_SERVER_INITED="serverInited";o.EVENT_SERVER_CREATED="serverCreated";o.BODY_NAME="JSXBODY";o.RN="JSX";o.Rp=new
jsx3.util.List();a.JSXROOT=null;a.JSXBODY=null;a.Cache=null;a.ENVIRONMENT=null;a.DOM=null;a.JSS=null;a.init=function(b,p,h,i){this.DOM=new
jsx3.app.DOM();this.Cache=new
jsx3.app.Cache();this.Cache.addParent(jsx3.getSharedCache());if(i!=null&&i.jsxsettings!=null){this._jsxHS=i.jsxsettings;delete i.jsxsettings;}this.ENVIRONMENT=i=i!=null?jsx3.clone(i):{};i.apppath=b.replace(/\/*$/,"");var
db=this.getSettings();var
Gb=db.get();for(var Lc in Gb){var
ic=Lc.toLowerCase();if(typeof i[ic]=="undefined"&&typeof Gb[Lc]!="object")i[ic]=Gb[Lc];}i.apppathuri=new
jsx3.net.URI(i.apppath+"/");if(i.jsxappbase)i.apppathuri=i.apppathuri.resolve(i.jsxappbase);var
Dc=i.apppath.indexOf("JSXAPPS");if(Dc>=0)i.apppathrel=i.apppath.substring(Dc+"JSXAPPS".length+1);i.apppathabs=Sb.getLocation().resolve(i.apppathuri);if(i["liquid"]==null)i["liquid"]=true;if(i["eventsvers"]==null)i["eventsvers"]=3;if(i["jsxversion"]==null)i["jsxversion"]="3.1";i.abspath=jsx3.getEnv("jsxabspath");i.guiref=p;i.namespace=i.jsxappns||i.namespace;if(i.namespace==null)throw new
jsx3.Exception(jsx3._msg("serv.no_ns",b));if(p&&this.getEnv("caption"))p.ownerDocument.title=this.getEnv("caption");if(p&&this.getEnv("cancelrightclick"))p.ownerDocument.oncontextmenu=new
Function("return false;");if(this.getEnv("cancelerror"))jsx3.NativeError.initErrorCapture();o.Rp.add(this);jsx3.registerApp(this);this.JSS=new
jsx3.app.Properties();this.LJSS=new
jsx3.app.Properties();this.JSS.addParent(this.LJSS);this.JSS.addParent(jsx3.System.JSS);o.publish({subject:o.EVENT_SERVER_INITED,target:this});if(h)this.paint();};a.gv=function(){jsx3.require("jsx3.gui.Block");eb=jsx3.gui.Block;if(this.JSXROOT)return;var
Cc=this.JSXROOT=this.y2("JSXROOT");Cc.setDynamicProperty("jsxbgcolor","@Solid DarkShadow");Cc.setRelativePosition(0);Cc.setOverflow(3);Cc.setAlwaysCheckHotKeys(true);Cc.setIndex(1);var
U=this.JSXBODY=new
eb("JSXBODY",0,0,"100%","100%","");U.setDynamicProperty("jsxbgcolor","@Solid Light");U.setRelativePosition(0);U.setZIndex(1);U.setOverflow(3).setIndex(0);Cc.setChild(U);};a.onResize=function(){if(jsx3.CLASS_LOADER.IE){window.clearTimeout(this.resize_timeout_id);var
P=this;this.resize_timeout_id=window.setTimeout(function(){P.o3();},250);}else this.o3();};a.o3=function(){var
ab=this.getEnv("GUIREF");if(ab)this.getRootBlock().Ch({left:0,top:0,parentwidth:ab.clientWidth,parentheight:ab.clientHeight},true);};a.getNextZIndex=function(b){if(this.sZ==null){this.sZ=[];this.sZ[0]=0;this.sZ[1]=1000;this.sZ[o.Z_DIALOG]=5000;this.sZ[o.Z_DRAG]=7500;this.sZ[o.Z_MENU]=10000;this.sZ[5]=25000;}return this.sZ[b]++;};o.allServers=function(){return o.Rp.toArray();};a.y2=function(m){if(this._jsxjf==null)this._jsxjf=[];var
uc=new
eb(m,0,0,"100%","100%","");uc._jsxvf=this.getEnv("NAMESPACE");uc._jsxid=jsx3.app.DOM.newId(this.getEnv("NAMESPACE"));uc._jsxgm=this;this.DOM.add(uc);this._jsxjf.push(uc);return uc;};a.getInvisibleRoot=function(){if(this.INVISIBLE==null)this.INVISIBLE=this.y2("JSXINVISIBLE");return this.INVISIBLE;};a.getEnv=function(g){return this.ENVIRONMENT[g.toLowerCase()];};o.Sr=function(k){var
sc=['<div class="jsx30block jsx30env">'];sc.push("<b>Version:</b> ","3.4.1; build 5","<br/>");sc.push("<b>XML Version:</b> ",jsx3.getXmlVersion(),"<br/>");sc.push("<b>System Locale:</b> ",jsx3.System.getLocale().getDisplayName(),"<br/>");sc.push("<b>Browser:</b> ",jsx3.CLASS_LOADER.getTypes().join(", "),"<br/>");sc.push("<b>Operating System:</b> ",jsx3.app.Browser.getSystem()+" ("+navigator.userAgent+")");sc.push("<hr/>");var
M=null;var
fb=o.allServers();for(var
V=0;V<fb.length;V++){var
t=fb[V];sc.push("<b>",t.getEnv("namespace"),"</b>","<div>");sc.push("<b>Path:</b> ",t.getAppPath(),"<br/>");sc.push("<b>Version:</b> ",t.getEnv("version"),"<br/>");sc.push("<b>GI Version:</b> ",t.getEnv("jsxversion"));sc.push("</div>");if(M==null){M=t.getRootBlock();if(M.getRendered()==null)M=null;}}sc.push("</div>");sc=sc.join("");if(M)M.showSpy(sc,Math.round(M.getRendered().clientWidth/2),Math.round(M.getRendered().clientHeight/2-100));else window.alert(sc);};a.getSettings=function(){if(this._jsxHS==null)this._jsxHS=new
jsx3.app.Settings(2,this);return this._jsxHS;};a.getAppPath=function(){return this.getEnv("apppath");};o.as=function(c){return c instanceof jsx3.gui.WindowBar&&c.getType()==3;};a.getTaskBar=function(j){if(!jsx3.gui.WindowBar)return null;if(j==null)j=this.JSXROOT;return j.findDescendants(o.as,false,false,false,true);};a.destroy=function(){var
tb=this.getEnv("onunload");if(tb)try{this.eval(tb);}catch(Kc){nb.error(jsx3._msg("serv.err_unload",this),jsx3.NativeError.wrap(Kc));}if(jsx3.Class.forName("jsx3.gui.Painted"))jsx3.gui.Painted.Box.unregisterServer(this,this.getEnv("LIQUID"));if(this.JSXROOT){var
ub=this.JSXROOT.getRendered();if(ub){if(ub.parentNode.id==o.RN)ub=ub.parentNode;ub.parentNode.removeChild(ub);}}if(this._jsxjf)for(var
L=0;L<this._jsxjf.length;L++){var
T=this._jsxjf[L];T.removeChildren();}delete this._jsxjf;this.DOM.unsubscribeAllFromAll();this.DOM.destroy();this.Cache.unsubscribeAll("change");this.Cache.destroy();jsx3.deregisterApp(this);o.Rp.remove(this);Pb.unsubscribe("keydown",this,"checkHotKeys");this.ENVIRONMENT={};};a.paint=function(c){jsx3.require("jsx3.gui.Alerts","jsx3.gui.Block");eb=jsx3.gui.Block;if(!jsx3.gui.Alerts.jsxclass.isAssignableFrom(o.jsxclass))o.jsxclass.addInterface(jsx3.gui.Alerts.jsxclass);jsx3.html.getMode(this.getEnv("GUIREF"));this.gv();jsx3.gui.Painted.Box.registerServer(this,this.getEnv("LIQUID"));if(this.getEnv("BODYHOTKEYS"))Pb.subscribe("keydown",this,"checkHotKeys");var
rc="Sr";this.registerHotKey(new
Function("jsx3.app.Server."+rc+"();"),74,true,true,true);this.registerHotKey(new
Function("if (jsx3.EventHelp.isDragging()) jsx3.EventHelp.reset();"),27,false,false,false);try{var
G=this.getEnv("GUIREF");var
Ac=this.getRootDocument();var
Ib="";var
tc=this.getEnv("OVERFLOW");if(tc==1){Ib="overflow:auto;";}else if(tc==2)Ib="overflow:hidden;";var
M,Lb="",hc="";if(this.getEnv("POSITION")==0){M="relative";}else{M="absolute";Lb="left:"+this.getEnv("LEFT")+";";hc="top:"+this.getEnv("TOP")+";";}var
R="width:"+this.getEnv("WIDTH")+";";var
Bb="height:"+this.getEnv("HEIGHT")+";";if(G){G.innerHTML='<div id="'+o.RN+'" style="position:'+M+";"+Ib+Lb+hc+R+Bb+'"></div>';G=G.lastChild;this.JSXROOT.ak({left:0,top:0,parentwidth:G.clientWidth,parentheight:G.clientHeight});}if(G)G.innerHTML=this.JSXROOT.paint();this.yd(c);}catch(Kc){nb.fatal(jsx3._msg("serv.err_paint",this),jsx3.NativeError.wrap(Kc));}o.publish({subject:o.EVENT_SERVER_CREATED,target:this});};a.yd=function(b){this.QO(b);};a.QO=function(b){var
_b=null;if(b){_b=this.JSXBODY.loadXML(b,true);}else{var
O=this.getEnv("objectseturl");if(O!="")_b=this.JSXBODY.load(O,true);}if(_b)_b.setPersistence(1);this.eval(this.getEnv("onload"));};a.setDimensions=function(m,p,g,q){if(m instanceof Array){p=m[1];g=m[2];q=m[3];m=m[0];}var
Wb=this.JSXROOT.getRendered();if(Wb){if(m)Wb.parentNode.style.left=m+"px";if(p)Wb.parentNode.style.top=p+"px";if(g)Wb.parentNode.style.width=g+"px";if(q)Wb.parentNode.style.height=q+"px";}};a.loadInclude=function(f,c,p,n){if(c==null)c="";var
Rb=n?"?timestamp="+(new
Date()).valueOf():"";if(p=="css"){jsx3.CLASS_LOADER.loadResource(f+Rb,c,p);}else if(p=="jss"||p=="ljss"&&!jsx3.app.PropsBundle){var
Ic=this.Cache.openDocument(f,c);if(Ic.hasError()){jsx3.util.Logger.GLOBAL.error(jsx3._msg("serv.err_jss",+f,Ic.getError()));}else this.getProperties().loadXML(Ic,c);}else if(p=="ljss"){this.LJSS.addParent(jsx3.app.PropsBundle.getProps(f,this.getLocale(),this.getCache()));}else if(p=="xml"||p=="xsl"){return this.Cache.openDocument(f,c);}else if(p=="script"){this.unloadInclude(c);jsx3.CLASS_LOADER.loadResource(f+Rb,c,p);}else if(p=="services"){jsx3.require("jsx3.net.Service");return (new
jsx3.net.Service(f)).setNamespace(this);}else throw new
jsx3.IllegalArgumentException("strType",p);};a.unloadInclude=function(r){var
Kb=this.getRootDocument().getElementById(r);try{if(Kb)Kb.parentNode.removeChild(Kb);}catch(Kc){nb.warn(jsx3._msg("serv.err_unload",r,this),jsx3.NativeError.wrap(Kc));}};a.loadResource=function(p){var
jb=this.getSettings();var
_=jb.getMapsInArrayByField("includes","id",p);var
Wb;for(var
O=0;O<_.length;O++){var
G=_[O];Wb=this.loadInclude(this.resolveURI(G.src),G.id,G.type);}if(_.length==0)nb.warn(jsx3._msg("serv.err_badid",p));return Wb;};a.setDynamicProperty=function(j,h){var
Zb=this.getProperties();Zb.set(j,h);};a.getDynamicProperty=function(l,d){var
Kb=this.getProperties().get(l);if(arguments.length>1&&jsx3.util.MessageFormat)try{var
gc=new
jsx3.util.MessageFormat(Kb);var
bb=new
Array(arguments.length-1);for(var
Ab=1;Ab<arguments.length;Ab++)bb[Ab-1]=arguments[Ab];return gc.format(bb);}catch(Kc){}return Kb;};a.setCookie=function(l,g,r,c,m,j,f){this.getRootDocument().cookie=l+"="+(f?g:escape(g))+(r?"; expires="+r.toGMTString():"")+(c?"; path="+c:"")+(m?"; domain="+m:"")+(j?"; secure":"");};a.getCookie=function(i,c){var
u=this.getRootDocument();var
dc=u.cookie;var
x=i+"=";var
jb=dc.indexOf("; "+x);if(jb==-1){jb=dc.indexOf(x);if(jb!=0)return null;}else jb=jb+2;var
tc=u.cookie.indexOf(";",jb);if(tc==-1)tc=dc.length;var
T=dc.substring(jb+x.length,tc);return c?T:unescape(T);};a.deleteCookie=function(h,r,q){this.setCookie(h,"",new
Date(1970,0,1),r,q);};a.getRootBlock=function(){if(this.JSXROOT==null)this.gv();return this.JSXROOT;};a.getAlertsParent=function(){return this.getRootBlock();};a.getBodyBlock=function(){if(this.JSXROOT==null)this.gv();return this.JSXBODY;};a.getRootObjects=function(){return this.JSXBODY.getChildren().concat();};a.getCache=function(){return this.Cache;};a.getProperties=function(){return this.JSS;};a.getDOM=function(){return this.DOM;};a.getJSX=function(f){return this.DOM.get(f);};a.getJSXByName=function(e){return this.DOM.getByName(e);};a.getJSXById=function(n){return this.DOM.getById(n);};a.beep=function(){if(!jsx3.gui.WindowBar)return;var
y=this.JSXROOT.findDescendants(function(e){return e instanceof jsx3.gui.WindowBar&&e.getType()==2;},false,false);if(y!=null)y.beep();};a.createAppWindow=function(r){jsx3.require("jsx3.gui.Window");if(this.WINDOWS==null)this.WINDOWS=this.y2("JSXWINDOWS");if(this.WINDOWS.getChild(r)!=null)throw new
jsx3.IllegalArgumentException("strName",r);var
wb=new
jsx3.gui.Window(r);this.WINDOWS.setChild(wb);return wb;};a.loadAppWindow=function(p){jsx3.require("jsx3.gui.Window");if(this.WINDOWS==null)this.WINDOWS=this.y2("JSXWINDOWS");var
rc=null;if(p instanceof jsx3.xml.Entity)rc=this.WINDOWS.loadXML(p,false);else rc=this.WINDOWS.load(p,false);if(rc==null)throw new
jsx3.Exception(jsx3._msg("serv.win_err",p));if(!(rc instanceof jsx3.gui.Window)){rc.getParent().removeChild(rc);throw new
jsx3.Exceptionjsx3._msg("serv.win_notwin",p,rc.getClass());}if(this.WINDOWS.getChild(rc.getName())!=rc){rc.getParent().removeChild(rc);throw new
jsx3.Exception(jsx3._msg("serv.win_name",p,rc.getName()));}return rc;};a.getAppWindow=function(p){if(this.WINDOWS!=null)return this.WINDOWS.getChild(p);return null;};a.getDocumentOf=function(c){var
Nb=c;while(Nb!=null){if(jsx3.gui.Window&&Nb instanceof jsx3.gui.Window)return Nb.getDocument();if(Nb._jsxgm!=null)return this.getRootDocument();Nb=Nb.getParent();}return this.getRootDocument();};a.getRootDocument=function(){var
qb=this.getEnv("GUIREF");return qb!=null?qb.ownerDocument:null;};a.getRenderedOf=function(m){var
uc=m.getId();var
D=this.getRootDocument();if(D==null)return null;var
ob=D.getElementById(uc);if(ob==null&&this.WINDOWS!=null){var
vb=this.WINDOWS.getChildren();for(var
_b=0;ob==null&&_b<vb.length;_b++){var
K=vb[_b].getDocument();if(K)ob=K.getElementById(uc);}}return ob;};a.registerHotKey=function(s,e,n,d,c){return this.getRootBlock().registerHotKey(s,e,n,d,c);};a.checkHotKeys=function(i){return this.getRootBlock().checkHotKeys(i.event);};a.getServer=function(){return this;};a.isAtLeastVersion=function(r){return jsx3.util.compareVersions(this.getEnv("jsxversion"),r)>=0;};a.resolveURI=function(p){var
ec=jsx3.net.URI.valueOf(p);if(this.isAtLeastVersion("3.2")&&!Qb.isAbsoluteURI(ec)){var
Mc=this.getEnv("apppathuri");return Qb.DEFAULT.resolveURI(Mc.resolve(ec.toString()));}else return Qb.DEFAULT.resolveURI(ec);};a.getUriPrefix=function(){return this.getEnv("apppathuri").toString();};a.relativizeURI=function(p,d){var
Db=Sb.getLocation();var
Cb=this.getEnv("apppathabs");var
sc=Cb.relativize(Db.resolve(p));if(sc.isAbsolute()||d){return sc;}else{var
gb=this.getEnv("apppathrel");if(gb){return jsx3.net.URI.fromParts("jsxapp",null,gb.replace(/\//g,"!"),null,"/"+sc.getPath(),sc.getQuery(),sc.getFragment());}else return jsx3.net.URI.fromParts(null,null,null,null,this.getEnv("apppath")+"/"+sc.getPath(),sc.getQuery(),sc.getFragment());}};a.getLocale=function(){if(this.mz==null)this.mz=this.getDefaultLocale();return this.mz!=null?this.mz:jsx3.System.getLocale();};a.setLocale=function(j){this.mz=j;};a.getDefaultLocale=function(){var
yb=this.getSettings().get("default_locale");if(yb==null)return null;yb=jsx3.util.strTrim(yb.toString());return yb.length>0&&jsx3.util.Locale?jsx3.util.Locale.valueOf(yb):null;};a.reloadLocalizedResources=function(){this.LJSS.removeAllParents();var
V=this.getSettings().getMapsInArrayByField("includes","type","ljss");for(var
rc=0;rc<V.length;rc++){var
zb=V[rc];this.loadInclude(this.resolveURI(zb.src),zb.id,zb.type,false);}};a.toString=function(){return this.jsxsuper()+" "+this.getAppPath()+":"+this.getEnv("namespace");};o.getVersion=function(){return "3.00.00";};});if(jsx3.gui.Alerts)jsx3.app.Server.jsxclass.addInterface(jsx3.gui.Alerts.jsxclass);jsx3.Server=jsx3.app.Server;jsx3.Class.defineClass("jsx3.app.Model",null,[jsx3.util.EventDispatcher],function(g,j){var
kb=jsx3.xml.Entity;var
Sb=jsx3.xml.Document;g.PERSISTNONE=0;g.PERSISTEMBED=1;g.PERSISTREF=2;g.PERSISTREFASYNC=3;g.CURRENT_VERSION="urn:tibco.com/v3.0";g.CIF_VERSION="http://xsd.tns.tibco.com/gi/cif/2006";g.FRAGMENTNS="JSXFRAG";g.ASYNC_LOAD_TIMEOUT=60000;g.Yv=jsx3.resolveURI("jsx:///xsl/cif_resolver.xsl");j._jsxid=null;j._jsxWC=null;j._jsxhK=null;j._jsxvf=null;j._jsxgm=null;j._jsxtq=null;j._jsxxS=null;j._jsxl_=null;j.init=function(p,o){this.jsxsuper();this.jsxinstanceof=o==null?"jsx3.app.Model":o;this.jsxname=p;};j.getChild=function(b){var
bc=null;if(this._jsxhK!=null){if(typeof b=="string"||isNaN(b)){var
vb=-1;var
db=this.getChildren();var
Bc=db.length;for(var
Ac=0;Ac<Bc;Ac++)if(b==db[Ac].getName()){bc=Ac;break;}}else bc=b;if(bc>=0&&bc<this._jsxhK.length)return this._jsxhK[bc];}return null;};j.getFirstChild=function(){return this.getChild(0);};j.getLastChild=function(){return this.getChild(this.getChildren().length-1);};j.getNextSibling=function(){if(!this._jsxWC)return null;return this._jsxWC.getChild(this.getChildIndex()+1);};j.getPreviousSibling=function(){if(!this._jsxWC)return null;return this._jsxWC.getChild(this.getChildIndex()-1);};j.getChildren=function(){if(this._jsxhK==null)this._jsxhK=[];return this._jsxhK;};j.getPersistence=function(){return this._jsxxS;};j.getPersistenceUrl=function(){return this.getMetaValue("url");};j.setPersistence=function(q){this._jsxxS=q;return this;};j.setChild=function(e,l,c,d){if(!this.onSetChild(e)||!e.onSetParent(this))return false;var
Qb=false;if(d==null&&this._jsxvf==null){throw new
jsx3.Exception(jsx3._msg("model.set_frag",e,this));}else if(d!=null){Qb=true;}else d=this._jsxvf;var
sb=this.getServer();if(d!="JSXFRAG"&&sb&&this._jsxvf==d){this.zL(e,d,e._jsxtq!=null,sb);}else this._jsxtq=1;var
K=this._jsxhK;if(!K)K=this._jsxhK=[];K[K.length]=e;e._jsxWC=this;if(l==null)l=0;e._jsxxS=l;if(c&&(l==2||l==3))e.setMetaValue("url",c.toString());if(!Qb&&d!="JSXFRAG")sb.getDOM().onChange(0,this.getId(),e.getId());return this;};j.onSetChild=function(m){return true;};j.onSetParent=function(a){return true;};j.onRemoveChild=function(n,a){};j.zL=function(l,f,b,o){l._jsxvf=f;l._jsxid=jsx3.app.DOM.newId(f);o.getDOM().add(l);if(b){delete l._jsxtq;var
cc=l.getChildren();var
ic=cc.length;for(var
tc=0;tc<ic;tc++)l.zL(cc[tc],f,true,o);}};j.removeChild=function(h){var
Kb=-1;if(!isNaN(h)){Kb=Number(h);}else if(h instanceof jsx3.app.Model){Kb=h._jsxWC==this?h.getChildIndex():-1;}else throw new
jsx3.IllegalArgumentException("vntItem",h);var
I=this.getChild(Kb);if(I!=null){var
xc=this.getServer();this.R5(Kb,xc);this.onRemoveChild(I,Kb);xc.getDOM().onChange(1,this.getId(),I.getId());}};j.R5=function(f,q,e){if(f>=0&&f<this.getChildren().length){var
Kb=this.getChild(f);if(!e)Kb.Zo(this);var
Z=Kb.getChildren().length;for(var
_b=Z-1;_b>=0;_b--)Kb.R5(_b,q,true);q.getDOM().remove(Kb);delete Kb._jsxWC;if(!e)this._jsxhK.splice(f,1);else if(f==0)this._jsxhK.splice(0,this._jsxhK.length);Kb.onDestroy(this);}else throw new
jsx3.IllegalArgumentException("intIndex",f);};j.removeChildren=function(h){var
nc=this.getServer();if(h==null){h=this.getChildren().concat();for(var
pc=h.length-1;pc>=0;pc--){h[pc].Zo(this);this.R5(pc,nc,true);}}else{var
gc=null;h=h.concat();for(var
pc=h.length-1;pc>=0;pc--){var
Kc=h[pc];if(typeof Kc=="number"){gc=Kc;h[pc]=this.getChild(gc);}else gc=Kc.getChildIndex();this.R5(gc,nc,false);}}if(h.length>0)this.onRemoveChild(h,null);return this;};j.getServer=function(){var
T=this;while(T){if(T._jsxgm)return T._jsxgm;T=T._jsxWC;}return null;};j.Ni=function(){var
oc=this.getServer();return oc!=null?oc.getLocale():jsx3.System.getLocale();};j.wj=function(c){return jsx3.System.getLocaleProperties(this.Ni()).get(c);};j.adoptChild=function(e,a,m){this.oZ(e.getChildIndex(),e,a,m,false);};j.adoptChildrenFrom=function(m,h,f){var
L=m.getChildren().concat();if(L.length>0){for(var
N=0;N<L.length;N++)this.oZ(0,L[N],h,f,true);m.onRemoveChild(L,null);}};j.p0=function(n,r){if(n==r||n==r-1)return false;var
T=this.getChildren();var
Bb=n<r?r-1:r;var
ab=T.splice(n,1);var
vc=T.splice(0,Bb);this._jsxhK=vc.concat(ab,T);this.getServer().getDOM().onChange(2,this.getId(),r);return true;};j.insertBefore=function(r,q,m){var
vb=true;if(!r._jsxWC){vb=this.setChild(r);}else if(r._jsxWC!=this)vb=this.oZ(r.getChildIndex(),r,false,true,false);if(!vb)return;vb=this.p0(r.getChildIndex(),q.getChildIndex());if(m!=false)this.repaint();return vb;};j.oZ=function(o,i,p,q,l){if(q){this.onSetChild(i);i.onSetParent(this);}else if(!this.onSetChild(i)||!i.onSetParent(this))return false;var
z=i._jsxWC;delete i._jsxWC;i.qo(true);if(z._jsxhK!=null)z._jsxhK.splice(o,1);i.Zo(z);if(!l)z.onRemoveChild(i,o);var
tb=z.getServer();var
rb=this.getServer();var
Lc=tb!=rb;if(Lc)this.N7(i,z,tb,rb);tb.getDOM().onChange(1,z.getId(),i.getId());var
vc=this._jsxhK;if(!vc)vc=this._jsxhK=[];vc[vc.length]=i;i._jsxWC=this;if(p!=false)this.Rd(i,l&&z._jsxhK.length>0);rb.getDOM().onChange(0,this.getId(),i.getId());return this;};j.Rd=function(o,l){};j.Zo=function(r){var
R=r.getServer().getRenderedOf(this);if(R&&R.tagName!="TD")R.parentNode.removeChild(R);};j.N7=function(d,m,b,o){b.getDOM().remove(d);if(d.getServer()!=this.getServer()||m==null)if(typeof d.resetCacheData=="function"){var
Pb=b.getCache().getDocument(d.getXMLId());var
L=b.getCache().getDocument(d.getXSLId());if(d.getShareResources()!=1)d.resetCacheData(b);if(Pb)o.getCache().setDocument(d.getXMLId(),Pb);if(L)o.getCache().setDocument(d.getXSLId(),L);}d._jsxvf=this._jsxvf;o.getDOM().add(d);var
gb=d.getChildren().length;for(var
D=0;D<gb;D++)d.N7(d.getChild(D),null,b,o);};j.doClone=function(a){var
X=this._jsxWC;var
Dc;if(X!=null){Dc=X.xN(this.toXMLDoc(),true);if(Dc)Dc[0].setPersistence(a);}else throw new
jsx3.Exception(jsx3._msg("model.clone_frag",this));return Dc?Dc[0]:null;};j.getDescendantOfName=function(n,e,r){return this.findDescendants(function(l){return l.getName()==n;},e,false,r,false);};j.getFirstChildOfType=function(l,a){if(a){var
vb=null;if(typeof l=="string")vb=jsx3.Class.forName(l);else if(typeof l=="function"&&l.jsxclass instanceof jsx3.Class)vb=l.jsxclass;else if(l instanceof jsx3.Class)vb=l;return this.findDescendants(function(b){return b.getClass().equals(vb);},false,false,true,false);}else return this.findDescendants(function(m){return m.instanceOf(l);},false,false,true,false);};j.getDescendantsOfType=function(k,b){return this.findDescendants(function(r){return r.instanceOf(k);},false,true,b,false);};j.findDescendants=function(h,k,n,l,f){var
ic=k?"unshift":"push";var
Fb=n?[]:null;var
Jb=f?[this]:this.getChildren().concat();while(Jb.length>0){var
vc=Jb.shift();if(h.call(null,vc))if(n)Fb[Fb.length]=vc;else return vc;if(!l)Jb[ic].apply(Jb,vc.getChildren());}return Fb;};j.onDestroy=function(o){};j.getId=function(){return this._jsxid;};j.getChildIndex=function(){var
jb=this._jsxWC;if(jb!=null)return jsx3.util.arrIndexOf(jb.getChildren(),this);return -1;};j.getName=function(){return this.jsxname;};j.setName=function(k){if(k!=null){var
Kb=this.jsxname;this.jsxname=k;var
X=this.getServer();if(X)X.getDOM().onNameChange(this,Kb);}return this;};j.getParent=function(){return this._jsxWC;};j.getAncestorOfType=function(a){return this.findAncestor(function(l){return l.instanceOf(a);},false);};j.getAncestorOfName=function(o){return this.findAncestor(function(m){return m.getName()==o;},false);};j.findAncestor=function(h,f){var
yb=f?this:this._jsxWC;while(yb!=null){if(h.call(null,yb))return yb;yb=yb._jsxWC;}return null;};j.toXML=function(n){return this.toXMLDoc(n).serialize(true,n!=null?n.charset:null);};j.toXMLDoc=function(a){if(a==null){a=this._jsxl_;if(a==null)a={};}else if(this._jsxl_!=null){a=jsx3.clone(a);for(var Ec in this._jsxl_)if(typeof a[Ec]=="undefined")a[Ec]=this._jsxl_[Ec];}var
yb=new
jsx3.xml.Document();var
M=yb.createDocumentElement("serialization",g.CURRENT_VERSION);M.setAttribute("jsxversion",g.Bw());for(var Ec in g.rq){var
nc=g.rq[Ec];var
nb=yb.createNode(1,nc,g.CURRENT_VERSION);nb.appendChild(yb.createNode(4,a[Ec],g.CURRENT_VERSION));M.appendChild(nb);}if(a.children){var
uc=this.getChildren().length;for(var
v=0;v<uc;v++)M.appendChild(this.getChild(v).sX(yb,a));}else M.appendChild(this.sX(yb,a));return yb;};g.Bw=function(){var
Yb=jsx3.System.getVersion().split(".");return Yb[0]+"."+Yb[1];};j.sX=function(m,k){var
qb=m.createNode(1,"object",g.CURRENT_VERSION);var
w=m.createNode(1,"variants",g.CURRENT_VERSION);var
L=m.createNode(1,"strings",g.CURRENT_VERSION);qb.appendChild(w);qb.appendChild(L);var
H={_jsxSj:"dynamics",jsxcustom:"properties",_jsxHk:"events",jsxxslparams:"xslparameters"};for(var Lc in H){var
xc=this[Lc];if(xc!=null&&typeof xc=="object"){var
Vb=g.c5(m,H[Lc],xc);if(Vb!=null)qb.appendChild(Vb);}}for(var Ac in this){if(typeof this[Ac]=="function"||Ac.indexOf("_jsx")==0&&Ac!="_jsxhK")continue;if(this[Ac]!=null&&typeof this[Ac]=="object"){if(Ac.toString()=="_jsxhK"){if(!(this[Ac] instanceof Array)){jsx3.util.Logger.GLOBAL.error(jsx3._msg("model.child_notarr",this,this[Ac]));continue;}var
Ub=this[Ac];var
Nc=Ub.length;if(Nc>0)for(var
cb=0;cb<Nc;cb++){var
hc=Ub[cb];var
yb=hc._jsxxS;if(yb==2||yb==3){if(yb==3&&cb!=Nc-1){jsx3.util.Logger.GLOBAL.warn(jsx3._msg("model.async_convt",this));yb=hc._jsxxS=2;}var
ac=m.createNode(1,"include",g.CURRENT_VERSION);ac.setAttribute("src",hc.getPersistenceUrl());ac.setAttribute("async",yb==3?"true":"false");qb.appendChild(ac);}else if(yb==1||k.persistall)qb.appendChild(hc.sX(m,k));}}else if(this[Ac] instanceof Array){var
xc=this[Ac];var
gc=new
Array(xc.length);for(var
cb=0;cb<xc.length;cb++){var
G=xc[cb];gc[cb]=typeof G=="boolean"||typeof G=="number"?G:"'"+G+"'";}w.setAttribute(Ac,"["+gc.join(",")+"]");}}else if(this[Ac]!=null&&(this._jsxSj==null||this._jsxSj[Ac]==null))if(typeof this[Ac]=="boolean"||typeof this[Ac]=="number"){w.setAttribute(Ac,this[Ac]);}else L.setAttribute(Ac,this[Ac]);}var
Lb=this.getClass();var
Hc=Lb!=null?Lb.getName():null;if(Hc==null)Hc=this.jsxinstanceof;qb.setAttribute("type",Hc);return qb;};g.c5=function(s,l,m){var
Kc=null;for(var H in m){if(Kc==null)Kc=s.createNode(1,l,g.CURRENT_VERSION);Kc.setAttribute(H,m[H]);}return Kc;};j.getNS=function(){return this._jsxvf;};j.getUriResolver=function(){var
zb=this;while(zb!=null){if(zb._jsxwv!=null)return zb._jsxwv;if(zb._jsxgm!=null)return zb._jsxgm;zb=zb._jsxWC;}return null;};j.load=function(c,e,m){var
y=(m||this.getUriResolver()).resolveURI(c);var
N=(new
Sb()).load(y);if(N.hasError())throw new
jsx3.Exception(jsx3._msg("model.bad_comp",y,N.getError()));return this.xN(N,e,null,y,c,null,null,m,null)[0];};j.loadXML=function(h,s,p){var
wc=h instanceof Sb?h:(new
Sb()).loadXML(h);if(wc.hasError()){var
nb=wc.getSourceURL();var
zb=nb?"model.bad_comp":"model.bad_compobj";throw new
jsx3.Exception(jsx3._msg(zb,nb,wc.getError()));}return this.xN(wc,s,null,wc.getSourceURL(),null,null,null,p,null)[0];};j.loadAndCache=function(l,b,c,d){if(c==null)c=this.getServer().getCache();var
Ub=(d||this.getUriResolver()).resolveURI(l);var
Fb=c.getOrOpenDocument(Ub);if(Fb.hasError())throw new
jsx3.Exception(jsx3._msg("model.bad_comp",Ub,Fb.getError()));return this.xN(Fb,b,null,Ub,l,null,c,d,null)[0];};g.GP=function(n){jsx3.require("jsx3.xml.Template");var
U=jsx3.getSystemCache().getOrOpenDocument(g.Yv,null,jsx3.xml.XslDocument.jsxclass);return U.transformToObject(n);};g.rq={name:"name",icon:"icon",description:"description",onbefore:"onBeforeDeserialize",onafter:"onAfterDeserialize"};j.xN=function(n,b,f,p,h,q,l,a,e){if(n==null)throw new
jsx3.IllegalArgumentException("objXML",n);if(n.getRootNode().getNamespaceURI().indexOf(g.CIF_VERSION)==0){n=g.GP(n);if(n==null)throw new
jsx3.IllegalArgumentException("objXML",n);}if(n.getRootNode().getNamespaceURI().indexOf(g.CURRENT_VERSION)!=0){throw new
jsx3.Exception(jsx3._msg("model.bad_vers",p,n.getRootNode().getAttribute("xmlns")));}else{var
w=n.getRootNode().getAttribute("jsxversion");if(w&&jsx3.util.compareVersions(w,jsx3.System.getVersion())>0)throw new
jsx3.Exception(jsx3._msg("model.future_vers",p,w));}var
K="/jsx1:serialization/";n.setSelectionNamespaces("xmlns:jsx1='"+g.CURRENT_VERSION+"'");var
cb=n.selectSingleNode(K+"jsx1:onBeforeDeserialize");if(cb!=null){var
P=cb.getValue();if(P&&!n._jsxQn)try{jsx3.eval(P,{objPARENT:this,objXML:n});n._jsxQn=true;}catch(Kc){jsx3.util.Logger.GLOBAL.error(jsx3._msg("model.onbefore",p),jsx3.NativeError.wrap(Kc));}}if(q==null)q=this._jsxvf;var
Ac=this.getUriResolver()||e;if(a==null){var
vc=jsx3.net.URIResolver.getResolver(h);if(vc!=jsx3.net.URIResolver.DEFAULT)a=vc;}else if(h)if(a.getUriPrefix()!=Ac.getUriPrefix()){h=jsx3.net.URI.valueOf(h);if(!jsx3.net.URIResolver.isAbsoluteURI(h))h=a.relativizeURI(h);}var
pc=this.getServer();if(e==null)e=pc;var
ub=a||Ac;var
E=n.selectNodeIterator(K+"jsx1:object | "+K+"jsx1:objects/jsx1:object");var
C=[];while(E.hasNext()){var
ac=E.next();var
Zb=this.uv(ac,p,q,e,l,ub,a);if(Zb!=null){C[C.length]=Zb;var
M=this.setChild(Zb,f,p,q);if(M===false)return false;if(C.length==1){if(h)Zb.setMetaValue("url",h.toString());for(var Mc in g.rq){var
kc=n.selectSingleNode(K+"jsx1:"+g.rq[Mc]);if(kc!=null)Zb.setMetaValue(Mc,kc.getValue());}}if(pc!=null)Zb.onAfterAttach();}}if(C.length>0&&pc)pc.getDOM().onChange(0,this.getId(),C[0].getId());if(b!=false)for(var
E=0;E<C.length;E++)this.Rd(C[E],E<C.length-1);return C;};g.META_FIELDS={url:1,name:1,icon:1,description:1,onafter:1,onattach:1,onbefore:1,unicode:1};j.getMetaValue=function(l){if(g.META_FIELDS[l])return this._jsxl_?this._jsxl_[l]:"";else throw new
jsx3.IllegalArgumentException("strKey",l);};j.setMetaValue=function(k,s){if(g.META_FIELDS[k]){if(this._jsxl_==null)this._jsxl_={};this._jsxl_[k]=s;}else throw new
jsx3.IllegalArgumentException("strKey",k);};j.uv=function(f,e,k,o,a,c,i){if(f==null)return null;var
Gb=f.getAttribute("type");var
gb=jsx3.Class.forName(Gb);if(gb==null)gb=jsx3.getClass(Gb);if(gb==null)try{gb=jsx3.CLASS_LOADER.loadClass(Gb);}catch(Kc){jsx3.util.Logger.GLOBAL.error(jsx3._msg("model.load_cls",Gb),jsx3.NativeError.wrap(Kc));}if(gb==null){jsx3.util.Logger.GLOBAL.error(jsx3._msg("model.bad_type",e,Gb));return null;}var
Fc=null;if(gb instanceof jsx3.Class){Fc=gb.bless();}else{Fc=new
gb(jsx3.DESERIALIZE);Fc.jsxinstanceof=Gb;}if(i)Fc._jsxwv=i;Fc._jsxvf=k;Fc.onBeforeAssemble(this,o);g.G_(Fc,f);g.iw(Fc,f);g.FU(Fc,f,"_jsxSj","jsx1:dynamics");g.FU(Fc,f,"jsxcustom","jsx1:properties");g.FU(Fc,f,"_jsxHk","jsx1:events");g.FU(Fc,f,"jsxxslparams","jsx1:xslparameters");var
ib=f.selectNodeIterator("jsx1:object | jsx1:include | jsx1:children/jsx1:object | jsx1:children/jsx1:include");while(ib.hasNext()){var
Mb=ib.next();if(Mb.getBaseName()=="object"){var
L=Fc.uv(Mb,e,k,o,a,c,null);if(L!=null)Fc.setChild(L,1,null,k);}else if(Mb.getBaseName()=="include"){var
nb=Mb.getAttribute("src");var
Dc=c.resolveURI(nb);var
Ub=true;if(Mb.getAttribute("async")=="true"){Ub=false;if(ib.hasNext()){jsx3.util.Logger.GLOBAL.warn(jsx3._msg("model.async_convt",Fc));Ub=true;}}if(Ub){var
u=a!=null?a.getOrOpenDocument(Dc):(new
Sb()).load(Dc);if(u.hasError())throw new
jsx3.Exception(jsx3._msg("model.bad_comp",Dc,f.getError()));Fc.xN(u,false,2,Dc,nb,k,a,null,o);}else Fc.lL(Dc,nb,k,a,o);}else throw new
jsx3.Exception();}Fc.onAfterAssemble(this,o);return Fc;};j.onBeforeAssemble=function(s,b){};j.onAfterAssemble=function(l,n){};j.onAfterAttach=function(){var
B=this.getChildren().concat();for(var
A=B.length-1;A>=0;A--)if(B[A]._jsxWC==this)B[A].onAfterAttach();var
hb=this.getMetaValue("onafter");if(hb)try{jsx3.eval(hb,{objJSX:this});}catch(Kc){var
cc=this.getMetaValue("url");jsx3.util.Logger.GLOBAL.error(jsx3._msg("model.onafter",cc),jsx3.NativeError.wrap(Kc));}};j.lL=function(i,q,k,d,m){var
nb=this;if(d!=null&&d.getDocument(i.toString())!=null){var
A=d.getDocument(i.toString());jsx3.sleep(function(){this.xN(A,true,3,i,q,k,d,null,m);},null,this);}else{var
A=new
Sb();A.setAsync(true);A.subscribe("response",function(l){if(d!=null)d.setDocument(i,l.target);nb.xN(l.target,true,3,i,q,k,d,null,m);});A.subscribe(["error","timeout"],function(f){throw new
jsx3.Exception(jsx3._msg("model.bad_comp",i,f.target.getError()));});A.load(i,g.ASYNC_LOAD_TIMEOUT);}};g.G_=function(b,d){var
Jc=d.selectSingleNode("jsx1:strings");if(Jc!=null){var
Ab=Jc.getAttributeNames();for(var
ab=0;ab<Ab.length;ab++){var
tb=Ab[ab];b[tb]=Jc.getAttribute(tb);}}};g.iw=function(h,q){var
ic=q.selectSingleNode("jsx1:variants");if(ic!=null){var
P=ic.getAttributeNames();for(var
Mb=0;Mb<P.length;Mb++){var
Ub=P[Mb];var
lb=ic.getAttribute(Ub);h[Ub]=isNaN(lb)?jsx3.eval(lb):Number(lb);}}};g.FU=function(o,f,k,s){var
t=f.selectSingleNode(s);if(t!=null){var
Xb=o[k]={};var
ub=t.getAttributeNames();for(var
Eb=0;Eb<ub.length;Eb++){var
qb=ub[Eb];Xb[qb]=t.getAttribute(qb);}}};j.toString=function(){return "@"+this.getClass().getName()+" "+this.getId()+"/"+this.getName();};g.getVersion=function(){return "3.00.00";};});jsx3.Model=jsx3.app.Model;jsx3.Class.defineClass("jsx3.gui.HotKey",null,[jsx3.util.EventDispatcher],function(p,o){var
Eb=jsx3.gui.Event;p.WAS_INVOKED="invoked";o.Ey=null;o.hI=null;o.Uq=false;o.Iz=false;o.fW=false;o._M=false;o.k9=true;o.JR=false;p.valueOf=function(k,s){var
wc=k.toLowerCase().split("+");var
Ab=wc.pop();var
C=wc.indexOf("ctrl")>=0;var
ub=wc.indexOf("shift")>=0;var
wb=wc.indexOf("alt")>=0;var
fc=wc.indexOf("meta")>=0;if(typeof Ab=="string"&&Ab.match(/^\[(\d+)\]$/))Ab=parseInt(RegExp.$1);return new
p(s||new
Function(""),Ab,ub,C,wb,fc);};o.init=function(m,d,f,e,c,j){if(!(typeof m=="function"))throw new
jsx3.IllegalArgumentException("callback",m);this.Ey=m;this.Uq=f==null?null:Boolean(f);this.Iz=e==null?null:Boolean(e);this._M=c==null?null:Boolean(c);this.fW=j==null?null:Boolean(j);this.hI=typeof d=="number"?d:p.keyDownCharToCode(d);if(this.hI==null)throw new
jsx3.IllegalArgumentException("key",d);};o.getKey=function(){var
D="";if(this.fW)D=D+"meta+";if(this._M)D=D+"alt+";if(this.Iz)D=D+"ctrl+";if(this.Uq)D=D+"shift+";var
fc=p.keyDownCodeToChar(this.hI);D=D+(fc!=null?fc:"["+this.hI+"]");return D;};o.getKeyCode=function(){return this.hI;};o.isMatch=function(j){var
Pb=j.keyCode()==this.hI&&(this.Uq==null||j.shiftKey()==this.Uq)&&(this.Iz==null||j.ctrlKey()==this.Iz)&&(this.fW==null||j.metaKey()==this.fW)&&(this._M==null||j.altKey()==this._M);return Pb;};o.invoke=function(q,n){if(this.JR||!this.k9)throw new
jsx3.Exception(jsx3._msg("gui.hk.dest",this));this.Ey.apply(q,n);this.publish({subject:"invoked"});};o.isEnabled=function(){return this.k9;};o.setEnabled=function(m){this.k9=m;};o.isDestroyed=function(){return this.JR;};o.destroy=function(){this.JR=true;delete this.Ey;};o.getFormatted=function(){var
U=null,Ob=null;if(jsx3.app.Browser.macosx){U="";Ob=p.O9;}else{U="+";Ob=p.bP;}var
pc="";if(this.Iz)pc=pc+(Ob.ctrl[0]+U);if(this._M)pc=pc+(Ob.alt[0]+U);if(this.Uq)pc=pc+(Ob.shift[0]+U);if(this.fW)pc=pc+(Ob.meta[0]+U);var
kb=p.keyDownCodeToChar(this.hI,true);pc=pc+(kb!=null?kb.length==1?kb.toUpperCase():kb:"["+this.hI+"]");return pc;};p.O9={meta:["\u2318",-1],alt:["\u2325",18],ctrl:["\u2303",17],shift:["\u21EA",16],enter:["\u21A9",13],esc:["\u238B",27],tab:["\u21E5",9],del:["\u2326",46],space:["\u2423",32],backspace:["\u232B",8],up:["\u2191",38],down:["\u2193",40],left:["\u2190",37],right:["\u2192",39],insert:["Insert",45],home:["\u2196",36],end:["\u2198",35],pgup:["\u21DE",33],pgdn:["\u21DF",34]};p.bP={meta:["Meta",-1],alt:["Alt",18],ctrl:["Ctrl",17],shift:["Shift",16],enter:["Enter",13],esc:["Esc",27],tab:["Tab",9],del:["Del",46],space:["Space",32],backspace:["Backspace",8],up:["Up",38],down:["Down",40],left:["Left",37],right:["Right",39],insert:["Insert",45],home:["Home",36],end:["End",35],pgup:["PgUp",33],pgdn:["PgDn",34]};o.toString=function(){return "@HotKey key:"+this.hI+" shift:"+this.Uq+" ctrl:"+this.Iz+" alt:"+this._M+" meta:"+this.fW;};p.qF={39:222,44:188,45:189,46:190,47:191,59:186,61:187,91:219,92:220,93:221,96:192};p.keyDownCharToCode=function(h){var
O=null;if(h.length==1){var
Sb=h.charCodeAt(0);if(Sb>=65&&Sb<=90)O=Sb;else if(Sb>=97&&Sb<=122)O=Sb-32;else if(Sb>=48&&Sb<=57)O=Sb;else O=p.qF[Sb];}else if(p.bP[h.toLowerCase()]){O=p.bP[h.toLowerCase()][1];}else if(h.match(/^[fF](\d\d?)$/))O=parseInt(RegExp.$1)+112-1;return O;};p.keyDownCodeToChar=function(m,e){var
Mc=null;if(m>=65&&m<=90)Mc=String.fromCharCode(m+97-65);else if(m>=48&&m<=57)Mc=String.fromCharCode(m);else if(m>=112&&m<=126)Mc="F"+(m-112+1);else{for(var nc in p.qF)if(p.qF[nc]==m){Mc=String.fromCharCode(nc);break;}if(Mc==null){var
nb=e&&jsx3.app.Browser.macosx?p.O9:p.bP;for(var nc in nb)if(nb[nc][1]==m){Mc=nb[nc][0];break;}}}return Mc;};});jsx3.Class.defineClass("jsx3.gui.Painted",jsx3.app.Model,null,function(r,f){r.MASK_NO_EDIT={NN:false,EE:false,SS:false,WW:false,MM:false};r.MASK_ALL_EDIT={NN:true,EE:true,SS:true,WW:true,MM:true};f.init=function(g){this.jsxsuper(g);};f.getAbsolutePosition=function(i,d){if(d==null)d=this.getRendered(i);if(d==null)return {L:0,T:0,W:0,H:0};if(i==null)i=this.BG().getRendered(d);return jsx3.html.getRelativePosition(i,d);};f.applyDynamicProperties=function(){if(this._jsxSj!=null){var
kc=this.getServer();if(kc==null)return;var
Ab=kc.getProperties();for(var jb in this._jsxSj)this[jb]=Ab.get(this._jsxSj[jb]);}};f.setDynamicProperty=function(b,m){if(this._jsxSj==null)this._jsxSj={};if(m==null){delete this._jsxSj[b];}else if(b!=null&&b!="")this._jsxSj[b]=m;return this;};f.getDynamicProperty=function(b){if(this._jsxSj)return this._jsxSj[b];};f.setAttribute=function(b,m){this.getAttributes()[b]=m;return this;};f.getAttribute=function(j){return this.getAttributes()[j];};f.getAttributes=function(){if(this.jsxcustom==null)this.jsxcustom={};return this.jsxcustom;};f.renderAttributes=function(p,c){var
lb=[];if(this.jsxcustom!=null){var
ac=jsx3.gui.Interactive&&this.instanceOf(jsx3.gui.Interactive);for(var vb in this.jsxcustom){var
mb=p!=null&&(p instanceof Array&&jsx3.util.arrIndexOf(p,vb)>=0||p[vb])||c&&ac&&jsx3.gui.Interactive.isBridgeEventHandler(vb);var
Dc=this.jsxcustom[vb];if(!mb&&Dc!=null)lb[lb.length]=" "+vb+'="'+Dc.replace(/\"/g,"&quot;")+'"';}}return lb.join("");};f.removeAttribute=function(c){delete this.getAttributes()[c];return this;};f.removeAttributes=function(){delete this.jsxcustom;return this;};f.focus=function(){var
Dc=this.getRendered();if(Dc!=null&&Dc.focus)Dc.focus();return Dc;};f.getMaskProperties=function(){return r.MASK_NO_EDIT;};f.getRendered=function(p){var
yb=null;if(p instanceof jsx3.gui.Event){if(p.srcElement())yb=p.srcElement().ownerDocument;}else if(p&&typeof p=="object")yb=p.ownerDocument||(p.getElementById?p:null);if(yb==null)yb=this.getDocument();return yb!=null?yb.getElementById(this.getId()):null;};f.containsHtmlElement=function(b){var
ub=this.getRendered(b);if(ub)while(b!=null){if(ub==b)return true;b=b.parentNode;}return false;};f.getDocument=function(){var
ec=this;while(ec!=null){if(jsx3.gui.Window&&ec instanceof jsx3.gui.Window)return ec.getDocument();else if(ec._jsxgm!=null)return ec._jsxgm.getRootDocument();ec=ec.getParent();}return null;};f.BG=function(){var
mb=this;while(mb!=null){if(jsx3.gui.Window&&mb instanceof jsx3.gui.Window)return mb.getRootBlock();else if(mb._jsxgm!=null)return mb._jsxgm.getRootBlock();mb=mb.getParent();}return null;};r.NN=null;f.repaint=function(){var
yc=this.getRendered();if(this.isDomPaint()){if(yc!=null){var
Sb=yc.previousSibling;var
rc=this.paintDom();if(rc!=yc)yc.parentNode.replaceChild(rc,yc);else if(rc.parentNode==null)Sb.parentNode.insertBefore(rc,Sb);}return null;}else{var
Rb=null;if(yc!=null){Rb=this.paint();jsx3.html.setOuterHTML(yc,Rb);r.u4(this,yc);var
Eb=yc.ownerDocument;if(Eb.recalc!=null)jsx3.sleep(function(){Eb.recalc(true);},"jsx3.gui.Painted.recalc");}return Rb;}};f.paint=jsx3.Method.newAbstract();f.onAfterPaint=function(n){};r.u4=function(c,j){var
sb=[c];while(sb.length>0){var
C=sb.shift();if(C.onAfterPaint!=f.onAfterPaint){var
D=C.getRendered(j);if(D)C.onAfterPaint(D);}var
Gb=C.getChildren();if(Gb.length>0)sb.unshift.apply(sb,Gb);}};f.isDomPaint=function(){return false;};f.paintDom=function(){throw new
jsx3.Exception();};f.SZ=function(){return '<span id="'+this.getId()+'" style="display:none;"></span>';};r._4=[];r.gt=function(l){r._4.push(l);jsx3.sleep(r.kK,"jsx3.gui.Painted.domPaint");};r.kK=function(){for(var
ob=0;ob<r._4.length;ob++){var
gb=r._4[ob];var
I=gb.getRendered();if(I!=null){var
U=gb.paintDom();I.parentNode.replaceChild(U,I);}}r._4.splice(0,r._4.length);};f.paintChild=function(c,s,n){if(n==null)n=this.getRendered();if(n!=null)if(c.isDomPaint()){n.appendChild(c.paintDom());}else{jsx3.html.insertAdjacentHTML(n,"beforeEnd",c.paint());r.u4(c,n);}};f.Rd=function(p,m){this.paintChild(p,m);};f.insertHTML=function(a){this.paintChild(a);return this;};f.paintChildren=function(i){if(i==null)i=this.getChildren();var
I=new
Array(i.length);for(var
fc=0;fc<i.length;fc++){var
ic=i[fc];if(ic.isDomPaint()){I[fc]=ic.SZ();r.gt(ic);}else I[fc]=ic.paint();}return I.join("");};f.vi=function(l,p){if(this._jsxHL)this.qo();if(this._jsxxx==null&&l)this._jsxxx=this.zj(p);return this._jsxxx;};f.ng=function(d){this._jsxxx=d;};f.fi=function(){this._jsxHL=true;};f.qo=function(g){var
Mb=[this];while(Mb.length>0){var
bc=Mb.shift();delete bc._jsxHL;delete bc._jsxIR;if(bc._jsxxx){delete bc._jsxxx;if(g){var
y=bc.getChildren();if(y.length>0)Mb.push.apply(Mb,y);}}}};r.Be=function(d,c,h){if(c){var
kb=jsx3.util.strTrim(c).split(/\s*;\s*/g);for(var
Cc=0;Cc<kb.length;Cc++){var
J=kb[Cc];if(J=="")continue;var
jb=J.split(/\s*:\s*/);if(jb&&jb.length==2){var
F=jb[0].replace(/(-\S)/gi,function(j,i){return i.substring(1).toUpperCase();});d.style[F]=jb[1];}}}else if(h){var
mc=["Top","Right","Bottom","Left"];for(var
Cc=0;Cc<4;Cc++){var
F=h+mc[Cc];d.style[F]="";}}};f.recalcBox=function(j){this.findDescendants(function(l){l.qo(false);},true,true,false,true);this.ak(this.getParent()?this.getParent().Ln(this):null,this.getRendered());if(j){var
bb=this.getRendered();if(bb!=null){var
kc=this.vi(true);for(var
pc=0;pc<j.length;pc++)if(j[pc]=="padding"){r.Be(bb,kc.Ue(),"padding");}else if(j[pc]=="margin"){r.Be(bb,kc.Md(),"margin");}else if(j[pc]=="border")r.Be(bb,kc.dd(),"border");}}};f.Ln=function(){var
U=this._jsxxx;return U!=null?{parentwidth:U.Si(),parentheight:U.Zh()}:{};};f.Jm=function(a){var
V=this._jsxIR?this._jsxIR[a]:null;return V;};f.li=function(h,s){if(!this._jsxIR)this._jsxIR=[];this._jsxIR[h]=s;return s;};f.zj=function(m){return new
r.Box({});};f.Vd=function(p,m,b){this.Qh(p,m,b,1);};f.Qh=function(k,h,g,l){if(l==1){this.fi();if(h!=null)g.addRepaint(this);}else if(l==2||l==4){var
ob=this.vi(true,k);var
Ac=ob.recalculate(k,h,g);if(Ac.w||Ac.h){if(!r._RESIZE_EVENT&&jsx3.gui.Interactive)r._RESIZE_EVENT={subject:"jsxafterresizeview"};if(r._RESIZE_EVENT)this.publish(r._RESIZE_EVENT);var
gb=this.getChildren();var
gc=l==4&&h?Math.max(0,h.childNodes.length-gb.length):0;for(var
Rb=gb.length-1;Rb>=0;Rb--){var
Lb=gb[Rb];var
V=Lb._jsxxx;if(V&&V.wG())continue;var
Ab=Rb+gc;var
L=h?h.childNodes[Ab]?h.childNodes[Ab]:true:null;g.add(Lb,{parentwidth:ob.Si(),parentheight:ob.Zh()},L,true);}}else{}}else if(l==3){var
ob=this.vi(true,k);if(h)ob.recalculate(k,h,g);}};f.Ch=function(c,s){var
Sb=new
r.Queue();Sb.add(this,c,s);Sb.start();};r.ix={};r.ix.add=function(c,e,d){c.IC(this,e,d);};r.ix.addRepaint=function(e){e.repaint();};f.ak=function(m,o){r.ix.add(this,m,o);};f.IC=function(e,m,j){var
w=this.vi(false);this.applyDynamicProperties();delete this._jsxIR;this.Vd(m,j,e);};});jsx3.Class.defineClass("jsx3.gui.Painted.Queue",jsx3.lang.Object,null,function(a,s){a.d1=250;a.Y9=0;a.lN=new
jsx3.util.List();a.hO=true;a.iF=false;a.enableChunking=function(g){a.hO=g;};a.HG=function(){a.doChunk();};a.doChunk=function(){if(a.hO){if(a.iF)return;a.iF=true;var
Sb=(new
Date()).getTime()+a.d1;var
Bb=(new
Date()).getTime();var
U=a.lN.removeAt(0);while(U!=null&&Bb<Sb)if(U.e8.length>0){var
Db=U.e8.shift();if(Db instanceof Array)Db[0].IC(U,Db[1],Db[2]);else Db.repaint();Bb=(new
Date()).getTime();}else{U.destroy();U=a.lN.removeAt(0);}if(U!=null){a.lN.add(U,0);jsx3.sleep(a.doChunk,"jsx3.gui.Painted.queue");}a.iF=false;}else while(a.lN.size()>0){var
U=a.lN.removeAt(0);while(U.e8.length>0){var
Db=U.e8.shift();if(Db instanceof Array)Db[0].IC(U,Db[1],Db[2]);else Db.repaint();}}};s.init=function(){this.D4=
++a.Y9;this.e8=[];a.lN.add(this);};s.add=function(l,r,q,h){if(q===true)q=l.getRendered();this.e8[h?"unshift":"push"]([l,r,q]);};s.addRepaint=function(r,b){this.e8[b?"unshift":"push"](r);};s.start=function(){a.HG();};s.destroy=function(){delete this.e8;a.lN.remove(this);};s.toString=function(){return "{Painted.Queue "+this.D4+" "+(this.e8!=null?this.e8.length:"-")+"}";};});jsx3.Class.defineClass("jsx3.gui.Painted.Box",jsx3.lang.Object,null,function(o,d){o.dI=/[^\d-]*([-]*[\d]*)[^\d-]*([-]*[\d]*)[^\d-]*([-]*[\d]*)[^\d-]*([-]*[\d]*)/;o.gB=/\b(\d*)px/g;o.O5=["boxtype","tagname","margin","padding","border","left","top","width","height","empty","container"];o.lO=["boxtype","left","top","width","height"];o.aL={width:"pU",height:"a1",top:"_Q",left:"f5",padding:"Zx",border:"KC",margin:"s1",tagname:"lt"};o.u1=["top","right","bottom","left"];o.I5=null;o.Du=["","display:-moz-inline-box;","display:inline-block;","display:-moz-inline-box;"];o.getCssFix=function(){return o.Du[jsx3.html.getMode()];};d.WL="";d.uX="";d.L4="";d.uZ=true;d.styles="";d.attributes="";d.init=function(r){this.implicit=r||{};this.calculate();};d.paint=function(){this.uZ=false;var
V=new
Array(2);var
qb="<"+this.Tt.tagname+" "+this.attributes;var
Gc=this.Oj();Gc=Gc!=null?"width:"+Math.max(0,Gc)+"px;":"";var
lc=this.Ae();lc=lc!=null?"height:"+Math.max(0,lc)+"px;":"";var
z=this.Tt.empty?'"/>':'">';if(this.Tt.boxtype=="box"){var
Hb=this.Tt.left;Hb=Hb==null?"left:0px;":"left:"+Hb+"px;";var
Kc=this.Tt.top;Kc=Kc==null?"top:0px;":"top:"+Kc+"px;";var
w=this.implicit.omitpos?"":"position:absolute;";V[0]=qb+' style="'+w+Gc+lc+Hb+Kc+this.Ue()+this.Md()+this.dd()+this.styles+z;}else if(this.Tt.boxtype=="relativebox"){var
w=this.implicit.omitpos?"":"position:relative;";V[0]=qb+' style="'+w+this.nw()+Gc+lc+this.Ue()+this.Md()+this.dd()+this.styles+z;}else{var
Hb=this.Tt.left;Hb=Hb==null?"":"left:"+Hb+"px;";var
Kc=this.Tt.top;Kc=Kc==null?"":"top:"+Kc+"px;";var
w=this.implicit.omitpos?"":"position:relative;";V[0]=qb+' style="'+w+Gc+lc+Hb+Kc+this.Ue()+this.Md()+this.dd()+this.styles+z;}V[1]=this.Tt.empty?"":"</"+this.Tt.tagname+">";return V;};d.setStyles=function(g){this.styles=g;return this;};d.setAttributes=function(r){this.attributes=r;return this;};d.nw=function(){return this.Tt.container&&(jsx3.html.getMode()==3||jsx3.html.getMode()==1)?"":o.getCssFix();};d.wG=function(){var
Lb=this.implicit;return (typeof Lb.width!="string"||Lb.width.indexOf("%")<0)&&(typeof Lb.height!="string"||Lb.height.indexOf("%")<0)&&(typeof Lb.left!="string"||Lb.left.indexOf("%")<0)&&(typeof Lb.top!="string"||Lb.top.indexOf("%")<0);};o._RECALC_VALS=[[[[{n:1},{h:1}],[{w:1},{w:1,h:1}]],[[{t:1},{t:1,h:1}],[{t:1,w:1},{t:1,w:1,h:1}]]],[[[{l:1},{l:1,h:1}],[{l:1,w:1},{l:1,w:1,h:1}]],[[{l:1,t:1},{l:1,t:1,h:1}],[{l:1,t:1,w:1},{l:1,t:1,w:1,h:1,a:1}]]]];d.recalculate=function(q,g,h){var
Ic=this.uZ;var
P=0,zc=0,sc=0,yb=0;for(var O in q)if(this.implicit[O]!=q[O]){this.implicit[O]=q[O];Ic=true;if(!sc&&(O=="width"||O=="parentwidth"))sc=1;if(!yb&&(O=="height"||O=="parentheight"))yb=1;}if(Ic){this.calculate(o.lO);if(g){var
mb=g.style;if(this.Tt.boxtype=="box"&&this.Tt.left!=null&&this.Tt.top!=null){if(parseInt(mb.left)!=this.Tt.left){mb.left=this.Tt.left+"px";P=1;}if(parseInt(mb.top)!=this.Tt.top){mb.top=this.Tt.top+"px";zc=1;}}if(q.parentheight!=null||q.parentwidth!=null||q.width!=null||q.height!=null){var
Bb=this.Oj();var
Yb=this.Ae();if(Bb!=null&&parseInt(mb.width)!=Bb){mb.width=Math.max(0,Bb)+"px";sc=1;}else sc=0;if(Yb!=null&&parseInt(mb.height)!=Yb){mb.height=Math.max(0,Yb)+"px";yb=1;}else yb=0;}}}this.uZ=false;return o._RECALC_VALS[P][zc][sc][yb];};o.fs={left:1,top:1};o.cQ=function(){};o.cQ.prototype={padding:"",margin:"",border:"",bwidth:0,bheight:0,btop:0,bleft:0,pwidth:0,pheight:0,ptop:0,pleft:0};d.calculate=function(n){if(!n)n=o.O5;if(!this.Tt)this.Tt=new
o.cQ();var
A=this.Tt;for(var
qb=0;qb<n.length;qb++){var
x=n[qb];var
Jc=this.implicit[x];if(o.fs[x]&&(Jc==null||Jc=="")&&this.implicit.boxtype=="box"){A[x]=0;}else{var
Qb=o.aL[x];if(Qb){if(Jc==="")Jc=null;this[Qb](Jc);}else this.Tt[x]=Jc;}}};o.registerServer=function(s,e){if(e)jsx3.gui.Event.subscribe("resize",s,"onResize");};o.unregisterServer=function(m,k){if(k)jsx3.gui.Event.unsubscribe("resize",m,"onResize");};d.pU=function(k){if(k==null){this.Tt.width=this.Tt.clientwidth=null;}else{if(typeof k=="string"&&k.indexOf("%")>=0)k=Math.round(this.implicit.parentwidth*parseInt(k)/100);else k=Number(k);this.Tt.width=k;this.Tt.clientwidth=Math.max(0,k-this.Tt.pwidth-this.Tt.bwidth);}};d.a1=function(m){if(m==null){this.Tt.height=this.Tt.clientheight=null;}else{if(typeof m=="string"&&m.indexOf("%")>=0)m=Math.round(this.implicit.parentheight*parseInt(m)/100);else m=Number(m);this.Tt.height=m;this.Tt.clientheight=Math.max(0,m-this.Tt.pheight-this.Tt.bheight);}};d.f5=function(g){this.Tt.left=typeof g=="string"&&g.indexOf("%")>=0?Math.round(this.implicit.parentwidth*parseInt(g)/100):g==null?g:Number(g);};d._Q=function(p){this.Tt.top=typeof p=="string"&&p.indexOf("%")>=0?Math.round(this.implicit.parentheight*parseInt(p)/100):p==null?p:Number(p);};d.lt=function(q){if(q==null){this.Tt.tagname=q;this.Tt.type=q;}else if(q.search(/input\[(\S*)\]/i)>-1){this.Tt.tagname="input";this.Tt.type=RegExp.$1.toLowerCase();}else this.Tt.tagname=q;};d.KC=function(r){if(r==null)r="";if(this.WL===r)return;this.WL=r;var
Ac=null,Jc=null;if(typeof r=="string"&&r.indexOf(":")>=0){var
nc=o.dr(r);if(typeof nc!="object")Ac=nc.split(";");}else{r=r.replace(/(^[;\s]*)|([;\s]*$)/g,"");if(r!=="")Ac=r.split(";");}if(Ac&&Ac.length>1){var
Vb=true;for(var
J=0;Vb&&J<Ac.length-1&&J<3;J++)if(Ac[J]!=Ac[J+1])Vb=false;if(Vb)Ac.splice(1,Ac.length);}if(!Ac){Jc=[0,0,0,0];}else if(Ac.length==1){var
eb=Ac[0].match(o.gB);var
R=eb?parseInt(eb[0]):0;if(isNaN(R))R=0;Jc=[R,R,R,R];}else{Jc=[];for(var
J=0;J<4;J++){var
eb=Ac[J].match(o.gB);var
R=eb?parseInt(eb[0]):0;if(isNaN(R))R=0;Jc[J]=R;}}this.Tt.bwidth=Jc[1]+Jc[3];this.Tt.bheight=Jc[0]+Jc[2];this.Tt.bleft=Jc[3];this.Tt.btop=Jc[0];if(Ac)for(var
J=0;J<Ac.length;J++)if(Ac[J].indexOf("pseudo")>=0)Ac[J]="";if(Ac==null){this.Tt.border="";}else if(Ac.length==1){this.Tt.border=Ac[0]?"border:"+(Jc[0]>0?Ac[0]:"0px")+";":"";}else if(Ac.length==4)this.Tt.border=(Ac[0]?"border-top:"+(Jc[0]>0?Ac[0]:"0px")+";":"")+(Ac[1]?"border-right:"+(Jc[1]>0?Ac[1]:"0px")+";":"")+(Ac[2]?"border-bottom:"+(Jc[2]>0?Ac[2]:"0px")+";":"")+(Ac[3]?"border-left:"+(Jc[3]>0?Ac[3]:"0px")+";":"");};d.s1=function(b){if(b==null)b="";if(this.uX===b)return;this.uX=b;var
_b=null;if(typeof b=="string"&&b.indexOf(":")>-1){var
Kc=o.gZ(b,"margin");if(typeof Kc!="object")_b=Kc.match(o.dI);}else if(typeof b=="number"){_b=[b];}else{b=jsx3.util.strTrim(String(b));if(b!=="")if(isNaN(b))_b=b.match(o.dI);else _b=[Number(b)];}if(_b==null)this.Tt.margin="";else if(_b.length==1)this.Tt.margin="margin:"+_b[0]+"px;";else this.Tt.margin="margin:"+_b[1]+"px "+_b[2]+"px "+_b[3]+"px "+_b[4]+"px;";};d.Zx=function(q){if(q==null)q="";if(this.L4===q)return;this.L4=q;var
X=null;if(typeof q=="string"&&q.indexOf(":")>-1){var
Nc=o.gZ(q,"padding");if(typeof Nc!="object")X=Nc.match(o.dI);}else if(typeof q=="number"){X=[q];}else{q=jsx3.util.strTrim(String(q));if(q!=="")if(isNaN(q))X=q.match(o.dI);else X=[Number(q)];}var
L=null;if(X==null){L=[0,0,0,0];this.Tt.padding="";}else if(X.length==1){var
hc=X[0];L=[hc,hc,hc,hc];this.Tt.padding="padding:"+hc+"px;";}else{L=[];for(var
Gb=1;Gb<5;Gb++){var
hc=parseInt(X[Gb]);if(isNaN(hc))hc=0;L[Gb-1]=hc;}this.Tt.padding="padding:"+L[0]+"px "+L[1]+"px "+L[2]+"px "+L[3]+"px;";}this.Tt.pwidth=L[1]+L[3];this.Tt.pheight=L[0]+L[2];this.Tt.ptop=L[0];this.Tt.pleft=L[3];};d.Od=function(n){var
Ic=this.q1;if(!Ic)Ic=this.q1=[];Ic[Ic.length]=n;};d.tp=function(n){return this.q1?this.q1[n]:null;};d.Pk=function(){return this.Tt.bleft+this.Tt.pleft;};d.Jo=function(){return this.Tt.btop+this.Tt.ptop;};d.Si=function(){return this.Tt.clientwidth;};d.Zh=function(){return this.Tt.clientheight;};d.Ll=function(){return this.Tt.width;};d.Fg=function(){return this.Tt.height;};d.getBorderWidth=function(){return this.Tt.bwidth;};d.Oj=function(){var
jc=this.Tt.type;var
lc=jsx3.html.getMode();var
Cb=lc==0||(jc=="text"||jc=="password"||this.Tt.tagname=="textarea")&&lc==1?this.Tt.width:this.Tt.clientwidth;return Cb===""||isNaN(Cb)?null:Cb;};d.Ae=function(){var
L=this.Tt.type;var
bc=jsx3.html.getMode();var
K=bc==0||(L=="text"||L=="password"||this.Tt.tagname=="textarea")&&bc==1?this.Tt.height:this.Tt.clientheight;return K===""||isNaN(K)?null:K;};d.pp=function(){return this.Tt.left;};d.Bd=function(){return this.Tt.top;};d.getBoxType=function(){return this.Tt.boxtype;};d.Md=function(){return this.Tt.margin||String("");};d.Ue=function(){return this.Tt.padding||String("");};d.dd=function(){return this.Tt.border||String("");};o.getBody=function(){return document.getElementsByTagName("body")[0];};o.getScrollSize=function(e){if(o.I5==null){var
jc=e||o.getBody();var
I='<div id="_jsx3_html_scr" class="jsx30block" style="padding:0px;margin:0px;border-width:0px;position:absolute;width:100px;height:100px;left:-100px;top:-100px;overflow:scroll;">&#160;</div>';jsx3.html.insertAdjacentHTML(jc,"beforeEnd",I);var
u=document.getElementById("_jsx3_html_scr");o.I5=100-parseInt(u.clientWidth);jc.removeChild(u);}return o.I5;};o.getScrollSizeOffset=function(i){var
gb=o.getScrollSize();return jsx3.html.getScrollSizeOffset(gb,i);};o.gZ=function(s,k){var
rb="not matched";var
Hc="0";var
C="0";var
S="0";var
J="0";var
ac=/(\s*(padding|padding-top|padding-right|padding-bottom|padding-left)\s*:\s*(\d+)(px)?\s*((\d+)(px)?)?\s*((\d+)(px)?)?\s*((\d+)(px)?)?\s*;)+/ig;var
U=/(\s*(margin|margin-top|margin-right|margin-bottom|margin-left)\s*:\s*(-*\d+)(px)?\s*((-*\d+)(px)?)?\s*((-*\d+)(px)?)?\s*((-*\d+)(px)?)?\s*;)+/ig;var
xc=k=="padding"?ac:U;var
H=s.split(";");if(H)for(var
gc=0;gc<H.length;gc++){var
yc=H[gc]+";";var
D=yc.search(xc);if(D>0){return {desc:"Missing Semicolon",cause:H[gc]};}else if(D==-1){if(H[gc].search(/[^\s*]/i)>=0)return {desc:"Mismatch Rule",cause:H[gc]};}else{rb=yc.replace(xc,function(i,h,g,f,e,q,c,b,a,p,j,n,m){if(g.match(/-top/)){Hc=f==null?"0":f;}else if(g.match(/-right/)){C=f==null?"0":f;}else if(g.match(/-bottom/)){S=f==null?"0":f;}else if(g.match(/-left/)){J=f==null?"0":f;}else{Hc=jsx3.util.strEmpty(f)?"0":f;C=jsx3.util.strEmpty(c)?Hc:c;S=jsx3.util.strEmpty(p)?Hc:p;J=jsx3.util.strEmpty(m)?C:m;}return Hc+" "+C+" "+S+" "+J;});rb=Hc+" "+C+" "+S+" "+J;}}return rb;};o.dr=function(f){var
bb="not matched";var
D=["0px","solid",""];var
yb=["0px","solid",""];var
Tb=["0px","solid",""];var
qc=["0px","solid",""];var
ic="";var
Bc="";var
Q="";var
fc=/border\s*.*[^;]\s*border/ig;var
Ab=/^(\d+)(px)?$/i;var
Nb=/^(dashed|dotted|double|groove|hidden|inset|none|outset|ridge|solid)$/i;var
Eb=/^(#[a-zA-Z0-9]{6}|rgb\s*\(\s*\d{1,3}%?\s*,\s*\d{1,3}%?\s*,\s*\d{1,3}%?\s*\)|(AliceBlue|AntiqueWhite|Aqua|Aquamarine|Azure|Beige|Bisque|Black|BlanchedAlmond|Blue|BlueViolet|Brown|BurlyWood|CadetBlue|Chartreuse|Chocolate|Coral|CornflowerBlue|Cornsilk|Crimson|Cyan|DarkBlue|DarkCyan|DarkGoldenrod|DarkGray|DarkGreen|DarkKhaki|DarkMagenta|DarkOliveGreen|DarkOrange|DarkOrchid|DarkRed|DarkSalmon|DarkSeaGreen|DarkSlateBlue|DarkSlateGray|DarkTurquoise|DarkViolet|DeepPink|DeepSkyBlue|DimGray|DodgerBlue|FireBrick|FloralWhite|ForestGreen|Fuchsia|Gainsboro|GhostWhite|Gold|Goldenrod|Gray|Green|GreenYellow|Honeydew|HotPink|IndianRed|Indigo|Ivory|Khaki|Lavender|LavenderBlush|LawnGreen|LemonChiffon|LightBlue|LightCora|LightCyan|LightGoldenrodYellow|LightGreen|LightGrey|LightPink|LightSalmon|LightSeaGreen|LightSkyBlue|LightSlateGray|LightSteelBlu|LightYellow|Lime|LimeGreen|Linen|Magenta|Maroon|MediumAquamarine|MediumBlue|MediumOrchid|MediumPurple|MediumSeaGreen|MediumSlateBlue|MediumSpringGreen|MediumTurquoise|MediumVioletRed|MidnightBlue|MintCream|MistyRose|Moccasin|NavajoWhite|Navy|OldLace|Olive|OliveDrab|Orange|OrangeRed|Orchid|PaleGoldenrod|PaleGreen|PaleTurquoise|PaleVioletRed|PapayaWhip|PeachPuff|Peru|Pink|Plum|PowderBlue|Purple|Red|RosyBrown|RoyalBlue|SaddleBrown|Salmon|SandyBrown|SeaGreen|Seashell|Sienna|Silver|SkyBlue|SlateBlue|SlateGray|Snow|SpringGreen|SteelBlue|Tan|Teal|Thistle|Tomato|Turquoise|Violet|Wheat|White|WhiteSmoke|Yellow|YellowGreen))$/i;var
Nc=f.split(";");if(Nc){for(var
lc=0;lc<Nc.length;lc++){if(Nc[lc].match(fc))return {desc:"Missing Semicolon",cause:Nc[lc]};var
M=Nc[lc].split(":");if(M.length==2){var
Vb=M[1].split(" ");for(var
Ic=0;Ic<Vb.length;Ic++)if(Vb[Ic]!=""){if(Vb[Ic].match(Ab)){ic=Vb[Ic].replace(Ab,function(g,i,e,j){return i;});ic=ic+"px";}else if(Vb[Ic].match(Nb)){Bc=Vb[Ic];}else if(Vb[Ic].match(Eb)){Q=Vb[Ic];}else return {desc:"Mismatch Width Color Style",cause:Vb[lc]};if(M[0].match(/^\s*border\s*$/)){D=[ic,Bc,Q];yb=[ic,Bc,Q];Tb=[ic,Bc,Q];qc=[ic,Bc,Q];}else if(M[0].match(/^\s*border-top\s*$/)){D[0]=ic;D[1]=Bc;D[2]=Q;}else if(M[0].match(/^\s*border-bottom\s*$/)){Tb[0]=ic;Tb[1]=Bc;Tb[2]=Q;}else if(M[0].match(/^\s*border-right\s*$/)){yb[0]=ic;yb[1]=Bc;yb[2]=Q;}else if(M[0].match(/^\s*border-left\s*$/)){qc[0]=ic;qc[1]=Bc;qc[2]=Q;}else if(M[0].match(/^\s*border-width\s*$/)){D[0]=ic;yb[0]=ic;Tb[0]=ic;qc[0]=ic;}else if(M[0].match(/^\s*border-top-width\s*$/)){D[0]=ic;}else if(M[0].match(/^\s*border-bottom-width\s*$/)){Tb[0]=ic;}else if(M[0].match(/^\s*border-right-width\s*$/)){yb[0]=ic;}else if(M[0].match(/^\s*border-left-width\s*$/)){qc[0]=ic;}else if(M[0].match(/^\s*border-style\s*$/)){D[1]=Bc;yb[1]=Bc;Tb[1]=Bc;qc[1]=Bc;}else if(M[0].match(/^\s*border-top-style\s*$/)){D[1]=Bc;}else if(M[0].match(/^\s*border-bottom-style\s*$/)){Tb[1]=Bc;}else if(M[0].match(/^\s*border-right-style\s*$/)){yb[1]=Bc;}else if(M[0].match(/^\s*border-left-style\s*$/)){qc[1]=Bc;}else if(M[0].match(/^\s*border-color\s*$/)){D[2]=Q;yb[2]=Q;Tb[2]=Q;qc[2]=Q;}else if(M[0].match(/^\s*border-top-color\s*$/)){D[2]=Q;}else if(M[0].match(/^\s*border-bottom-color\s*$/)){Tb[2]=Q;}else if(M[0].match(/^\s*border-right-color\s*$/)){yb[2]=Q;}else if(M[0].match(/^\s*border-left-color\s*$/)){qc[2]=Q;}else return {desc:"Mismatch Name",cause:M[lc]};}}else if(Nc[lc].search(/[^\s*]/i)>=0)return {desc:"Missing Colon",cause:Nc[lc]};}bb=D[0]+" "+D[1]+" "+D[2]+";"+yb[0]+" "+yb[1]+" "+yb[2]+";"+Tb[0]+" "+Tb[1]+" "+Tb[2]+";"+qc[0]+" "+qc[1]+" "+qc[2];}return bb;};d.toString=function(){var
mb="IMPLICIT:\n";for(var J in this.implicit)mb=mb+(J+": "+this.implicit[J]+"\n");mb=mb+"\nEXPLICIT:\n";for(var J in this.Tt)mb=mb+(J+": "+this.Tt[J]+"\n");return mb;};});jsx3.Class.defineClass("jsx3.gui.Heavyweight",null,null,function(a,s){var
Lc=jsx3.util.Logger.getLogger(a.jsxclass.getName());a.b5={};a.Y9=1;a.DEFAULTZINDEX=32000;a.PADDING=10;s.init=function(j,r){this.SU=j!=null?j:a.zK();this.sH=r;if(a.b5[this.SU]!=null)a.b5[this.SU].destroy();a.b5[this.SU]=this;};a.zK=function(){return "jsx_heavyweight_"+a.Y9++;};a.cT=function(){var
wc=a.b5;var
Zb=false;for(var qc in wc){wc[qc].hide();if(!Zb&&wc[qc].sH){wc[qc].sH.focus();Zb=true;}}};jsx3.gui.Event.subscribe("resize",a.cT);s.du=function(){if(this.sH){var
fc=this.sH.getDocument();if(fc)return fc.getElementsByTagName("body")[0];else Lc.warn(jsx3._msg("gui.hw.doc",this));}else Lc.warn(jsx3._msg("gui.hw.own",this));return null;};a.GO=function(i){return a.b5[i];};s.show=function(g){var
ic=this.getId();var
ec=this.getHTML();if(jsx3.util.strEmpty(ec))return;var
xb=this.getWidth();var
fc=xb==null?"":"width:"+xb+"px;";var
P=this.getHeight();var
cc=P==null?"":"height:"+P+"px;";var
lb='<span id="'+ic+'" class="jsx30block" style="position:absolute;overflow:;'+fc+cc+"left:0px;top:0px;z-index:"+this.getZIndex()+';visibility:hidden;">'+ec+"</span>";var
Kc=this.getDomParent();jsx3.html.insertAdjacentHTML(Kc,"beforeEnd",lb);this.applyRatio();this.applyRules("Y");this.applyRules("X");if(g!=false)this.setVisibility("");if(this.sH)this.sH.subscribe("jsxdestroy",this,"rD");};s.applyRatio=function(h){var
v=this.getRendered();if(v&&v.style){var
S=null,Mb=null;if(h||!v.childNodes[0]){S=v.offsetHeight;Mb=v.offsetWidth;}else{S=v.childNodes[0].offsetHeight;Mb=v.childNodes[0].offsetWidth;}var
Sb=this.getRatio();if(Sb){Mb=parseInt(Sb*(Mb+S));v.style.width=Mb+"px";v.childNodes[0].style.width=Mb;if(h!=true){S=v.childNodes[0].offsetHeight;v.style.height=S+"px";}else v.childNodes[0].style.height=S+"px";}else if(h!=true){v.style.width=Mb+"px";v.style.height=S+"px";}}};s.setContentNodePath=function(j){this._jsxhI=j;};s.wF=function(i){return jsx3.html.selectSingleElm(i,this._jsxhI!=null?this._jsxhI:0);};s.applyRules=function(l){var
tc=this.getRendered();var
qc=this.getDomParent();if(tc==null||qc==null)return;var
nc,y,uc,sb,_;if(l=="X"){nc="clientWidth";y="left";uc="width";sb=this.wF(tc).offsetWidth;_=this.getWidth();}else{nc="clientHeight";y="top";uc="height";sb=this.wF(tc).offsetHeight;_=this.getHeight();}var
X=this.getPositionRules()[l].length;var
xc=qc[nc];var
Mb=0;if(Lc.isLoggable(6))Lc.trace("applyRules - axis:"+l+" size:"+sb+" explicit:"+_+" space:"+xc);for(var
Lb=0;Lb<X;Lb++){var
Ab=this.getPositionRule(Lb,l);var
Hb=this.getPoint(tc,Ab.x0);if(Ab.qG==null){Mb=Math.max(a.PADDING,xc-sb-a.PADDING);}else Mb=Ab.RI?Ab.qG+Ab.sD-Hb[l]-sb:Ab.qG+Ab.sD-Hb[l];if(Mb<0||Mb+sb>xc){Ab.UL=Ab.RI?Mb:Mb<0?sb+Mb:xc-Mb;Ab.bW=Mb;if(Lc.isLoggable(6))Lc.trace("rule is not perfect - index:"+Lb+" point:"+Ab.x0+" inverse:"+Ab.RI+" size:"+sb+" origin:"+Mb+" space:"+xc+" maxsize:"+Ab.UL);}else{if(Lc.isLoggable(6))Lc.trace("applying rule - index:"+Lb+" point:"+Ab.x0+" pixel:"+Ab.qG+" offset:"+Ab.sD);tc.style[y]=Mb+"px";tc.style[uc]=sb+"px";return;}}var
bc=-1;var
wc=-1;for(var
Lb=0;Lb<X;Lb++){var
Ab=this.getPositionRule(Lb,l);if(bc<Ab.UL){bc=Ab.UL;wc=Lb;}}var
Ab=this.getPositionRule(Math.max(0,wc),l);if(Ab!=null){if(Lc.isLoggable(6))Lc.trace("apply best rule - index:"+wc+" origin:"+Ab.bW+" size:"+Ab.UL+" point:"+Ab.x0);tc.style[y]=Ab.bW+"px";if(_==null){tc.childNodes[0].style[uc]=Math.max(0,Ab.UL-a.PADDING)+"px";if(this.getOverflow()==1)tc.childNodes[0].style.overflow="auto";tc.style[uc]=Math.max(0,Ab.UL-a.PADDING)+"px";if(Ab.bW<0)tc.style[y]=a.PADDING+"px";}}};s.hide=function(){var
lb=this.getRendered();if(lb!=null)lb.parentNode.removeChild(lb);if(this.sH)this.sH.unsubscribe("jsxdestroy",this);};s.rD=function(l){if(Lc.isLoggable(6))Lc.trace("_onOwnerDestroyed "+l.target.getName());var
ob=l.context.objPARENT;var
Zb=ob.getDocument().getElementById(this.getId());if(Zb!=null)Zb.parentNode.removeChild(Zb);this.sH.unsubscribe("jsxdestroy",this);this.sH=null;delete a.b5[this.getId()];this.SU=null;};s.destroy=function(){if(!a.b5[this.SU])return;this.hide();this.sH=null;delete a.b5[this.SU];this.SU=null;};s.getRendered=function(i){var
kc=this.getId();if(kc==null)return null;var
V=null;if(i instanceof jsx3.gui.Event){if(i.srcElement())V=i.srcElement().ownerDocument;}else if(i!=null)V=i.getElementById?i:i.ownerDocument;if(!V&&this.sH)V=this.sH.getDocument();if(V)return V.getElementById(kc);else if(this.sH!=null&&this.sH.getServer()!=null)Lc.warn(jsx3._msg("gui.hw.doc",this));return null;};s.containsHtmlElement=function(j){var
rb=this.getRendered(j);if(rb)while(j!=null){if(rb==j)return true;j=j.parentNode;}return false;};s.getId=function(){return this.SU;};s._setId=function(q){this.SU=q;};s.getHTML=function(){return this.html;};s.setHTML=function(m,j){this.html=m;if(j){var
zb=this.getRendered();if(zb!=null)zb.innerHTML=m;}return this;};s.getDomParent=function(){return this.Kv==null?this.du():this.Kv;};s.setDomParent=function(i){this.Kv=i;return this;};s.getRatio=function(){return this.l3;};s.setRatio=function(n){this.l3=n;return this;};s.getOverflow=function(){return this.uq==null?1:this.uq;};s.setOverflow=function(o){this.uq=o;return this;};s.setVisibility=function(l){var
ab=this.getRendered();if(ab)ab.style.visibility=l;return this;};s.getZIndex=function(){return this.qs!=null?this.qs:a.DEFAULTZINDEX;};s.setZIndex=function(q){this.qs=q;return this;};s.getWidth=function(){return this.qA==null?null:this.qA;};s.setWidth=function(k){this.qA=k;return this;};s.getHeight=function(){return this.rA==null?null:this.rA;};s.setHeight=function(h){this.rA=h;return this;};s.addXRule=function(e,p,m,r,l){var
Fb=e instanceof jsx3.gui.Event?e.clientX():this.getPoint(e,p).X;this.addRule(Fb,m,r,"X",l);return this;};s.addYRule=function(r,c,i,e,p){var
dc=r instanceof jsx3.gui.Event?r.clientY():this.getPoint(r,c).Y;this.addRule(dc,i,e,"Y",p);return this;};s.addRule=function(o,e,p,j,k){var
Tb=this.getPositionRules();var
Jb=Tb[j];Jb[Jb.length]={qG:o,sD:p,x0:e,RI:k};return this;};s.getPositionRule=function(e,o){return this.getPositionRules()[o][e];};s.getPositionRules=function(){if(typeof this.zA!="object"){this.zA={};this.zA.X=[];this.zA.Y=[];}return this.zA;};s.getPoint=function(m,e){if(typeof m=="number")return {X:m,Y:m};var
N=null;if(m instanceof jsx3.gui.Block)N=m.getAbsolutePosition(this.getDomParent());else N=jsx3.html.getRelativePosition(this.getDomParent(),m);switch(e){case "N":return {X:N.L+Math.floor(N.W/2),Y:N.T};case "S":return {X:N.L+Math.floor(N.W/2),Y:N.T+N.H};case "E":return {X:N.L+N.W,Y:N.T+Math.floor(N.H/2)};case "W":return {X:N.L,Y:N.T+Math.floor(N.H/2)};case "NE":return {X:N.L+N.W,Y:N.T};case "SE":return {X:N.L+N.W,Y:N.T+N.H};case "SW":return {X:N.L,Y:N.T+N.H};case "NW":return {X:N.L,Y:N.T};case "O":return {X:N.L+Math.floor(N.W/2),Y:N.T+Math.floor(N.H/2)};}};s.toString=function(){return this.jsxsuper()+" "+this.getId()+"/"+this.sH;};a.getVersion=function(){return "3.00.00";};});jsx3.Heavyweight=jsx3.gui.Heavyweight;jsx3.require("jsx3.gui.HotKey","jsx3.gui.Heavyweight");jsx3.Class.defineInterface("jsx3.gui.Interactive",null,function(j,i){var
tb=jsx3.gui.Event;j.JSXBLUR="jsxblur";j.JSXCHANGE="jsxchange";j.JSXCLICK="jsxclick";j.JSXDOUBLECLICK="jsxdblclick";j.JSXFOCUS="jsxfocus";j.JSXKEYDOWN="jsxkeydown";j.JSXKEYPRESS="jsxkeypress";j.JSXKEYUP="jsxkeyup";j.JSXLOAD="jsxload";j.JSXMOUSEDOWN="jsxmousedown";j.JSXMOUSEOUT="jsxmouseout";j.JSXMOUSEOVER="jsxmouseover";j.JSXMOUSEUP="jsxmouseup";j.JSXMOUSEWHEEL="jsxmousewheel";j.FOCUS_STYLE="text-decoration:underline";j.ADOPT="jsxadopt";j.AFTER_APPEND="jsxafterappend";j.AFTER_COMMIT="jsxaftercommit";j.AFTER_EDIT="jsxafteredit";j.AFTER_MOVE="jsxaftermove";j.AFTER_REORDER="jsxafterreorder";j.AFTER_RESIZE="jsxafterresize";j.AFTER_RESIZE_VIEW="jsxafterresizeview";j.AFTER_SORT="jsxaftersort";j.BEFORE_APPEND="jsxbeforeappend";j.BEFORE_DROP="jsxbeforedrop";j.BEFORE_EDIT="jsxbeforeedit";j.BEFORE_MOVE="jsxbeforemove";j.BEFORE_RESIZE="jsxbeforeresize";j.BEFORE_SELECT="jsxbeforeselect";j.BEFORE_SORT="jsxbeforesort";j.CANCEL_DROP="jsxcanceldrop";j.CHANGE="jsxchange";j.CTRL_DROP="jsxctrldrop";j.DESTROY="jsxdestroy";j.DATA="jsxdata";j.DRAG="jsxdrag";j.DROP="jsxdrop";j.EXECUTE="jsxexecute";j.HIDE="jsxhide";j.INCR_CHANGE="jsxincchange";j.INPUT="jsxinput";j.MENU="jsxmenu";j.SCROLL="jsxscroll";j.SELECT="jsxselect";j.SHOW="jsxshow";j.SPYGLASS="jsxspy";j.TOGGLE="jsxtoggle";i.wd=function(m,s){this.doEvent("jsxblur",{objEVENT:m});};i.zd=function(q,o){this.doEvent("jsxchange",{objEVENT:q});};i.Th=function(a,l){this.doEvent("jsxclick",{objEVENT:a});};i.gg=function(n,r){this.doEvent("jsxdblclick",{objEVENT:n});};i.Uo=function(s,m){this.doEvent("jsxfocus",{objEVENT:s});};i.Rn=function(f,c){var
pb=false;if(this.hasHotKey())pb=this.checkHotKeys(f);if(!pb)this.doEvent("jsxkeydown",{objEVENT:f});return pb;};i.ri=function(s,m){this.doEvent("jsxkeypress",{objEVENT:s});};i.Bi=function(l,a){this.doEvent("jsxkeyup",{objEVENT:l});};i.Sf=function(r,n){this.doEvent("jsxmousedown",{objEVENT:r});};i.gn=function(n,r){this.doEvent("jsxmouseout",{objEVENT:n});};i.Wh=function(m,s){this.doEvent("jsxmouseover",{objEVENT:m});};i.ZY=function(q,o){var
Gb=null;this.doEvent("jsxmouseup",{objEVENT:q});if(q.rightButton()&&(Gb=this.getMenu())!=null){var
Tb=this.getServer().getJSX(Gb);if(Tb!=null){var
Q=this.doEvent("jsxmenu",{objEVENT:q,objMENU:Tb});if(Q!==false){if(Q instanceof Object&&Q.objMENU instanceof jsx3.gui.Menu)Tb=Q.objMENU;Tb.showContextMenu(q,this);}}}};i.ti=function(l,a){this.doEvent("jsxmousewheel",{objEVENT:l});};i.setEvent=function(d,a){this.getEvents()[a]=d;return this;};i.getEvents=function(){if(this._jsxHk==null)this._jsxHk={};return this._jsxHk;};i.getEvent=function(p){if(this._jsxHk)return this._jsxHk[p];};i.hasEvent=function(b){return this._jsxHk!=null&&this._jsxHk[b]!=null&&this._jsxHk[b].match(/\S/);};i.doEvent=function(r,e){var
Wb=this.getEvent(r);if(typeof this.publish=="function")this.publish({subject:r,context:e});return this.eval(Wb,e);};i.removeEvent=function(d){if(this._jsxHk!=null)delete this._jsxHk[d];return this;};i.removeEvents=function(){this._jsxHk={};return this;};i.setCanMove=function(b){this.jsxmove=b;return this;};i.getCanMove=function(){return this.jsxmove||0;};i.setCanDrag=function(l){this.jsxdrag=l;return this;};i.getCanDrag=function(){return this.jsxdrag||0;};i.setCanDrop=function(p){this.jsxdrop=p;return this;};i.getCanDrop=function(){return this.jsxdrop||0;};i.setCanSpy=function(r){this.jsxspy=r;return this;};i.getCanSpy=function(){return this.jsxspy||0;};i.getMenu=function(){return this.jsxmenu;};i.setMenu=function(c){this.jsxmenu=c;return this;};j.Tk=["blur","change","click","dblclick","focus","keydown","keypress","keyup","mousedown","mousemove","mouseout","mouseover","mouseup","mousewheel"];j.Sn={};j.Sn["blur"]="wd";j.Sn["change"]="zd";j.Sn["click"]="Th";j.Sn["dblclick"]="gg";j.Sn["focus"]="Uo";j.Sn["keydown"]="Rn";j.Sn["keypress"]="ri";j.Sn["keyup"]="Bi";j.Sn["mousedown"]="Sf";j.Sn["mousemove"]="_ebMouseMove";j.Sn["mouseout"]="gn";j.Sn["mouseover"]="Wh";j.Sn["mouseup"]="ZY";j.Sn["mousewheel"]="ti";j.isBridgeEventHandler=function(p){if(j.wD==null){j.wD={};for(var
bc=0;bc<j.Tk.length;bc++)j.wD["on"+j.Tk[bc]]=true;}return j.wD[p];};j.mx="Vi";j.oS="Mm";i.qk=function(b,g){var
dc={};if((b==null||!b["keydown"])&&(this.hasHotKey()||this.getAlwaysCheckHotKeys()))dc["keydown"]=true;if((b==null||!b["mouseup"])&&this.getMenu())dc["mouseup"]=true;var
Db=[];var
Lb=this.instanceOf(jsx3.gui.Painted);var
fb=this.getId();for(var
mb=0;mb<j.Tk.length;mb++){var
Ac=j.Tk[mb];var
nc="on"+Ac;var
Qb=[];var
sc=Lb?this.getAttribute(nc):null;if(sc)Qb[Qb.length]=sc.replace(/\"/g,"&quot;")+";";var
Xb=b&&b[Ac]||dc[Ac];if(Xb){if(typeof Xb!="string")Xb=j.Sn[Ac];if(g!=null)Qb[Qb.length]="jsx3."+j.oS+"(event,this,'"+Xb+"',"+g+");";else Qb[Qb.length]="jsx3.GO('"+fb+"')."+j.mx+"(event,this,'"+Xb+"');";}if(Qb.length>0)Db[Db.length]=" "+nc+'="'+Qb.join("")+'"';}return Db.join("");};i.cn=function(d,q,r){var
gc="on"+d;var
_b="";var
Hc=false;if(Hc){var
zb=this.getAttribute(gc);if(zb){_b=_b+zb;if(!zb.match(/;\s*$/))_b=_b+";";}}var
pc=r!=null?"jsx3."+j.oS+"(event,this,'"+q+"',"+r+");":"jsx3.GO('"+this.getId()+"')."+j.mx+"(event,this,'"+q+"');";return " "+gc+'="'+_b+pc+'"';};i.Vi=function(b,l,h){var
ab=this[h];var
gc=jsx3.gui.Event.wrap(b);if(ab){ab.call(this,gc,l);}else throw new
jsx3.Exception(jsx3._msg("gui.int.br",h,gc.getType(),this));};jsx3.Mm=function(a,l,c,m){var
Db=l;m=m||Number(0);for(var
cb=0;cb<m;cb++)Db=Db.parentNode;var
A=Db.getAttribute("id");var
qc=jsx3.GO(A);if(qc!=null)qc.Vi(a,l,c);else if(jsx3.html.getElmUpByTagName(l,"body")!=null)throw new
jsx3.Exception(jsx3._msg("gui.int.eb",A,m,l));};j.Uk=function(b,k,l,q){var
y=k.ownerDocument;jsx3.gui.Event.preventSelection(y);var
z=b.getTrueX();var
V=k.offsetLeft;jsx3.EventHelp.constrainY=q;jsx3.EventHelp.xOff=V-z;var
Z=b.getTrueY();var
mc=k.offsetTop;jsx3.EventHelp.constrainX=l;jsx3.EventHelp.yOff=mc-Z;jsx3.EventHelp.curDragObject=k;jsx3.EventHelp.FLAG=1;jsx3.EventHelp.beginTrackMouse(b);b.setCapture(k);b.cancelReturn();b.cancelBubble();};j.ll=function(b,k,f){var
xb=k.ownerDocument;jsx3.gui.Event.preventSelection(xb);jsx3.EventHelp.startX=b.getTrueX();jsx3.EventHelp.startY=b.getTrueY();jsx3.EventHelp.xOff=k.offsetLeft;jsx3.EventHelp.yOff=k.offsetTop;jsx3.EventHelp.dragRounder=f;jsx3.EventHelp.curDragObject=k;jsx3.EventHelp.FLAG=3;jsx3.EventHelp.beginTrackMouse(b);b.setCapture(k);b.cancelReturn();b.cancelBubble();};i.doBeginMove=function(s,d){if(!s.leftButton())return;if(d==null)d=this.getRendered();var
Jc=d.ownerDocument;var
Bb=this.doEvent("jsxbeforemove",{objEVENT:s});var
kc=Bb===false;if(d!=null&&!kc){d.style.zIndex=this.getServer().getNextZIndex(jsx3.app.Server.Z_DRAG);jsx3.gui.Event.preventSelection(Jc);var
D=s.getTrueX();var
W=d.style.position=="absolute"?parseInt(d.style.left)||0:d.scrollLeft;if(Bb&&Bb.bCONSTRAINY)jsx3.EventHelp.constrainY=true;jsx3.EventHelp.xOff=W-D;var
Dc=s.getTrueY();var
V=d.style.position=="absolute"?parseInt(d.style.top)||0:d.scrollTop;if(Bb&&Bb.bCONSTRAINX)jsx3.EventHelp.constrainX=true;jsx3.EventHelp.yOff=V-Dc;jsx3.EventHelp.curDragObject=d;jsx3.EventHelp.FLAG=1;jsx3.EventHelp.beginTrackMouse(s);s.setCapture(d);}};i.doEndMove=function(k,b){if(b==null)b=this.getRendered();if(b!=null){b.style.zIndex=this.getZIndex();k.releaseCapture(b);var
lb=parseInt(b.style.left);var
rb=parseInt(b.style.top);this.setLeft(lb);this.setTop(rb);this.doEvent("jsxaftermove",{objEVENT:k});}};i.doDrag=function(b,k,q,o){b.cancelAll();if(k==null){k=b.srcElement();while(k!=null&&k.getAttribute("JSXDragId")==null){k=k.parentNode;if(k=k.ownerDocument.getElementsByTagName("body")[0])k=null;}if(k==null)return;}var
sc=k.getAttribute("JSXDragId");var
Nb=k.getAttribute("JSXDragType");if(o==null)o={};o.strDRAGID=k.getAttribute("JSXDragId");o.strDRAGTYPE=k.getAttribute("JSXDragType");o.objGUI=k;o.objEVENT=b;if(this.doEvent("jsxdrag",o)===false)return;jsx3.EventHelp.DRAGTYPE=o.strDRAGTYPE;jsx3.EventHelp.DRAGID=o.strDRAGID;if(o.strDRAGIDS instanceof Array)jsx3.EventHelp.DRAGIDS=o.strDRAGIDS;jsx3.EventHelp.JSXID=this;if(q==null)q=jsx3.EventHelp.drag;var
I=q(k,this,jsx3.EventHelp.DRAGTYPE,jsx3.EventHelp.DRAGID);if(I==null){return false;}else{jsx3.EventHelp.dragItemHTML=I;jsx3.EventHelp.FLAG=2;jsx3.EventHelp.beginTrackMouse(b);}jsx3.EventHelp.constrainX=false;jsx3.EventHelp.constrainY=false;};i.doDrop=function(m,s,k){if(jsx3.EventHelp.DRAGID!=null){var
X=jsx3.EventHelp.JSXID;var
gb=jsx3.EventHelp.DRAGID;var
uc=jsx3.EventHelp.DRAGTYPE;var
xb={objEVENT:m,objSOURCE:X,strDRAGID:gb,strDRAGTYPE:uc};if(k==jsx3.EventHelp.ONDROP&&jsx3.gui.isMouseEventModKey(m)){xb.objGUI=m.srcElement();this.doEvent("jsxctrldrop",xb);jsx3.EventHelp.reset();}else if(k==jsx3.EventHelp.ONDROP){xb.objGUI=m.srcElement();this.doEvent("jsxdrop",xb);jsx3.EventHelp.reset();}else if(k==jsx3.EventHelp.ONBEFOREDROP){xb.objGUI=m.toElement();this.doEvent("jsxbeforedrop",xb);}else if(k==jsx3.EventHelp.ONCANCELDROP){xb.objGUI=m.fromElement();this.doEvent("jsxcanceldrop",xb);}}};i.doSpyOver=function(f,g,k){var
zb=f.getTrueX();var
Fb=f.getTrueY();if(this._jsxspytimeout)return;if(k==null)k={};f.bg();k.objEVENT=f;var
Zb=this;this._jsxspytimeout=window.setTimeout(function(){if(Zb.getParent()==null)return;Zb._jsxspytimeout=null;var
L=Zb.doEvent("jsxspy",k);if(L)Zb.showSpy(L,zb,Fb);},jsx3.EventHelp.SPYDELAY);};i.doSpyOut=function(q,o){if(q.toElement()!=null&&q.toElement().className=="jsx30spyglassbuffer")return;window.clearTimeout(this._jsxspytimeout);this._jsxspytimeout=null;j.hideSpy();};i.showSpy=function(a,l,h){if(a!=null){j.hideSpy();a='<span onmouseout="if (event.toElement != this.childNodes[0]) jsx3.gui.Interactive.hideSpy();" class="jsx30spyglassbuffer"><div id="_jsxspychild" class="jsx30spyglass">'+a+"</div></span>";var
tc=new
jsx3.gui.Heavyweight("_jsxspy",this);tc.setHTML(a);tc.addRule(l,"W",-2,"X");tc.addRule(l,"E",12,"X");tc.addRule(null,"W",-24,"X");tc.addRule(h,"N",-2,"Y");tc.addRule(h,"S",-6,"Y");tc.addRule(null,"N",-224,"Y");tc.setOverflow(3);tc.show();var
Gb=tc.getRendered();if(Gb){var
N=Gb.ownerDocument.getElementsByTagName("body")[0];var
_b=N.offsetHeight-(Gb.childNodes[0].offsetHeight+parseInt(Gb.style.top));if(_b<0)Gb.style.top=parseInt(Gb.style.top)+_b+"px";if(parseInt(Gb.style.width)+parseInt(Gb.style.left)>N.offsetWidth)tc.applyRules("X");}tb.subscribe("mousedown",jsx3.gui.Interactive.hideSpy);}};j.hideSpy=function(){if(jsx3.gui.Heavyweight){var
W=jsx3.gui.Heavyweight.GO("_jsxspy");if(W){W.destroy();tb.unsubscribe("mousedown",jsx3.gui.Interactive.hideSpy);}}};i.getSpyStyles=function(d){return this.jsxspystyle?this.jsxspystyle:d?d:null;};i.setSpyStyles=function(o){delete this._jsxtK;delete this._jsxy2;delete this.jsxspystylekeys;delete this.jsxspystylevalues;this.jsxspystyle=o;};i.lU=function(){var
Vb={};if(jsx3.util.strEmpty(this.getSpyStyles())&&this.jsxspystylekeys!=null){var
qb=(this.jsxspystylekeys||"").split(/ *; */);var
I=(this.jsxspystylevalues||"").split(/ *; */);for(var
Fb=0;Fb<qb.length;Fb++)Vb[qb[Fb]]=I[Fb];}else{var
Kb=this.getSpyStyles("text-decoration:underline");var
Rb=/(-\S)/gi;var
Vb={};var
Bc=Kb.split(";");for(var
Fb=0;Fb<Bc.length;Fb++){var
y=Bc[Fb]+"";var
cc=y.split(":");if(cc&&cc.length==2){var
z=cc[0].replace(Rb,function(n,m){return m.substring(1).toUpperCase();});Vb[z]=cc[1];}}}return Vb;};i.applySpyStyle=function(k){if(this._jsxtK==null)this._jsxtK=this.lU();if(this._jsxy2==null){this._jsxy2={};for(var kb in this._jsxtK)this._jsxy2[kb]=k.style[kb];}for(var kb in this._jsxtK)k.style[kb]=this._jsxtK[kb];};i.removeSpyStyle=function(m){for(var x in this._jsxy2)m.style[x]=this._jsxy2[x];};i.checkHotKeys=function(c){if(this._jsxVZ==null)return false;if(c.isModifierKey())return false;var
vb=false;var
M=c.getAttribute("jsxmodal");for(var _ in this._jsxVZ){var
Ib=this._jsxVZ[_];if(Ib instanceof jsx3.gui.HotKey){if(Ib.isDestroyed()){delete this._jsxVZ[_];continue;}else if(!Ib.isEnabled())continue;if(Ib.isMatch(c)){if(!M)Ib.invoke(this,[c]);vb=true;}}}if(vb)c.cancelAll();return vb;};i.registerHotKey=function(h,g,c,l,n){var
v;if(h instanceof jsx3.gui.HotKey){v=h;}else{var
U=typeof h=="function"?h:this[h];if(!(typeof U=="function"))throw new
jsx3.IllegalArgumentException("vntCallback",h);v=new
jsx3.gui.HotKey(U,g,c,l,n);}if(this._jsxVZ==null)this._jsxVZ={length:0};var
qc=v.getKey();this._jsxVZ.length+=(this._jsxVZ[qc]?0:1);this._jsxVZ[qc]=v;return v;};i.hasHotKey=function(){return this._jsxVZ!=null&&this._jsxVZ.length>0;};i.setAlwaysCheckHotKeys=function(d){this.jsxalwayscheckhk=d;return this;};i.getAlwaysCheckHotKeys=function(){return this.jsxalwayscheckhk;};i.clearHotKeys=function(){this._jsxVZ=null;};j.getVersion=function(){return "3.00.00";};i.isOldEventProtocol=function(){var
t=this.getServer();return t&&t.getEnv("EVENTSVERS")<3.1;};});jsx3.Event=jsx3.gui.Interactive;jsx3.Class.defineClass("jsx3.EventHelp",null,null,function(d,h){d.ONBEFOREDROP=0;d.ONDROP=1;d.ONCANCELDROP=2;d.DRAGICONINDEX=32000;d.DEFAULTSPYLEFTOFFSET=5;d.DEFAULTSPYTOPOFFSET=5;d.SPYDELAY=300;d.FLAG=0;d.yOff=0;d.xOff=0;d.curDragObject=null;d.beginTrackMouse=function(e){jsx3.gui.Event.subscribe("mousemove",d.mouseTracker);jsx3.gui.Event.subscribe("mouseup",d.mouseUpTracker);};d.endTrackMouse=function(){jsx3.gui.Event.unsubscribe("mousemove",d.mouseTracker);jsx3.gui.Event.unsubscribe("mouseup",d.mouseUpTracker);};d.mouseTracker=function(m){d.doMouseMove(m.event);};d.mouseUpTracker=function(p){d.reset();};d.drag=function(m,p,s,b){return "<span style='background-color:#f6f6ff;border:solid 1px #a8a8af;font-family:Verdana;font-size:10px;padding:2px;height:11px;filter:progid:DXImageTransform.Microsoft.Alpha(Opacity=70, FinishOpacity=0, Style=0, StartX=0,  FinishX=100, StartY=0, FinishY=100);'><nobr>"+m.innerText+"</nobr></span>";};d.doMouseMove=function(b){if(d.FLAG==1||d.FLAG==3){var
O=d.curDragObject.ownerDocument;if(d.FLAG==1){if(!d.constrainX)d.curDragObject.style.left=b.getTrueX()+d.xOff+"px";if(!d.constrainY)d.curDragObject.style.top=b.getTrueY()+d.yOff+"px";}else{var
Z=b.getTrueX()-d.startX;var
Ac=b.getTrueY()-d.startY;var
R=d["dragRounder"](d.xOff+Z,d.yOff+Ac,b);if(R[0]!=d.offsetLeft||R[1]!=d.offsetTop){if(!isNaN(R[0]))d.curDragObject.style.left=R[0]+"px";if(!isNaN(R[1]))d.curDragObject.style.top=R[1]+"px";}}}else if(d.FLAG==2){var
O=d.JSXID.getDocument();var
cb=O.getElementsByTagName("body")[0];d.xOff=10;d.yOff=10;jsx3.gui.Event.preventSelection(O);var
wc='<div id="_jsxdrag" unselectable="on" style="position:absolute;left:'+(d.constrainX?parseInt(d.curDragObject.style.left):b.getTrueX()+d.xOff)+"px;top:"+(d.constrainY?parseInt(d.curDragObject.style.top):b.getTrueY()+d.yOff)+"px;min-width:10px;z-index:"+d.DRAGICONINDEX+';">'+d.dragItemHTML+"</div>";jsx3.html.insertAdjacentHTML(cb,"beforeEnd",wc);d.curDragObject=O.getElementById("_jsxdrag");d.FLAG=1;}else d.endTrackMouse();};d.reset=function(){d.DRAGTYPE=null;d.DRAGID=null;d.DRAGIDS=null;d.FLAG=0;d.endTrackMouse();if(d.curDragObject!=null){if(d.curDragObject.id=="_jsxdrag")jsx3.html.setOuterHTML(d.curDragObject,"");if(jsx3.CLASS_LOADER.IE)d.curDragObject.releaseCapture();d.curDragObject=null;d.constrainX=false;d.constrainY=false;}};d.isDragging=function(){return d.curDragObject!=null;};d.getDragIcon=function(){return d.curDragObject;};d.getDragSource=function(){return d.JSXID;};d.getDragType=function(){return d.DRAGTYPE;};d.getDragId=function(){return d.DRAGID;};d.getDragIds=function(){return d.DRAGIDS instanceof Array?d.DRAGIDS:[d.DRAGID];};});jsx3.require("jsx3.gui.Interactive");jsx3.Class.defineInterface("jsx3.gui.Alerts",null,function(h,i){var
G=jsx3.gui.Interactive;i.getAlertsParent=jsx3.Method.newAbstract();i.alert=function(c,r,g,o,s){var
hb=jsx3.net.URIResolver.JSX;var
Kc=this.getAlertsParent().loadAndCache("xml/components/dialog_alert.xml",false,null,hb);var
vc=Kc.getDescendantOfName("ok");if(c!=null)Kc.getDescendantOfName("title").setText(c);if(r!=null)Kc.getDescendantOfName("message").setText(r);if(o===false)Kc.hideButton();else if(o!=null)vc.setText(o);if(g!=null){var
tb="y1";vc.y1=g;vc.setEvent("this."+tb+"(this.getAncestorOfType(jsx3.gui.Dialog));","jsxexecute");}this.configureAlert(Kc,s);this.getAlertsParent().paintChild(Kc);Kc.focus();return Kc;};i.prompt=function(g,c,k,e,m,q,o){var
lb=jsx3.net.URIResolver.JSX;var
tb=this.getAlertsParent().loadAndCache("xml/components/dialog_prompt.xml",false,null,lb);var
kc=tb.getDescendantOfName("ok");var
vc=tb.getDescendantOfName("cancel");if(g!=null)tb.getDescendantOfName("title").setText(g);if(c!=null)tb.getDescendantOfName("message").setText(c);if(m!=null)kc.setText(m);if(q!=null)vc.setText(q);if(k!=null){var
_="y1";kc.y1=k;kc.setEvent("var d = this.getAncestorOfType(jsx3.gui.Dialog); this."+_+"(d, d.getDescendantOfName('value').getValue());","jsxexecute");}if(e!=null){var
_="y1";vc.y1=e;vc.setEvent("this."+_+"(this.getAncestorOfType(jsx3.gui.Dialog));","jsxexecute");}this.configureAlert(tb,o);this.getAlertsParent().paintChild(tb);jsx3.sleep(function(){tb.getDescendantOfName("value").focus();});return tb;};i.confirm=function(n,j,r,q,d,o,m,g,a,s){var
ub=jsx3.net.URIResolver.JSX;var
Bc=this.getAlertsParent().loadAndCache("xml/components/dialog_confirm.xml",false,null,ub);var
rc=Bc.getDescendantOfName("ok");var
lb=Bc.getDescendantOfName("cancel");var
xb=Bc.getDescendantOfName("no");var
jc=[rc,lb,xb];m=m!=null?m-1:0;if(n!=null)Bc.getDescendantOfName("title").setText(n);if(j!=null)Bc.getDescendantOfName("message").setText(j);if(d!=null)rc.setText(d);if(o!=null)lb.setText(o);if(q!=null){var
xc="y1";lb.y1=q;lb.setEvent("this."+xc+"(this.getAncestorOfType(jsx3.gui.Dialog));","jsxexecute");}if(r!=null){var
xc="y1";rc.y1=r;rc.setEvent("this."+xc+"(this.getAncestorOfType(jsx3.gui.Dialog));","jsxexecute");}if(g!=null||a!=null||m==3){if(a)xb.setText(a);if(g){var
xc="y1";xb.y1=g;xb.setEvent("this."+xc+"(this.getAncestorOfType(jsx3.gui.Dialog));","jsxexecute");}xb.setDisplay("");}var
uc=jc[m];if(uc){uc.setFontWeight("bold");Bc.registerHotKey(function(b){if(b.enterKey()){this.getDescendantOfName(uc.getName()).doExecute(b);b.cancelBubble();}},13,false,false,false);}this.configureAlert(Bc,s);this.getAlertsParent().paintChild(Bc);Bc.focus();return Bc;};i.configureAlert=function(m,k){if(k==null)return;if(k.width)m.setWidth(k.width,false);if(k.height)m.setHeight(k.height,false);if(k.noTitle)m.removeChild(m.getChild("title"));if(k.nonModal)m.setModal(0);};});jsx3.Alerts=jsx3.gui.Alerts;jsx3.require("jsx3.gui.Painted","jsx3.gui.Interactive");jsx3.Class.defineClass("jsx3.gui.Block",jsx3.gui.Painted,[jsx3.gui.Interactive],function(l,k){var
gb=jsx3.gui.Event;var
F=jsx3.gui.Interactive;l.SCROLLSIZE=16;l.OVERFLOWSCROLL=1;l.OVERFLOWHIDDEN=2;l.OVERFLOWEXPAND=3;l.DEFAULTFONTNAME="Verdana";l.DEFAULTFONTSIZE=10;l.DEFAULTCOLOR="#000000";l.DEFAULTTEXT="&#160;";l.DEFAULTCLASSNAME="jsx30block";l.DEFAULTTAGNAME="span";l.FONTBOLD="bold";l.FONTNORMAL="normal";l.DISPLAYBLOCK="";l.DISPLAYNONE="none";l.VISIBILITYVISIBLE="";l.VISIBILITYHIDDEN="hidden";l.NULLSTYLE=-1;l.ALIGNLEFT="left";l.ALIGNCENTER="center";l.ALIGNRIGHT="right";l.ABSOLUTE=0;l.RELATIVE=1;l.MASK_NO_EDIT=jsx3.gui.Painted.MASK_NO_EDIT;l.MASK_ALL_EDIT=jsx3.gui.Painted.MASK_ALL_EDIT;l.MASK_MOVE_ONLY={MM:true};l.MASK_EAST_ONLY={NN:false,EE:true,SS:false,WW:false,MM:false};l.SPACE=jsx3.resolveURI("jsx:///images/spc.gif");jsx3.html.loadImages(l.SPACE);k.init=function(s,f,a,q,n,e){this.jsxsuper(s);if(f!=null)this.setLeft(f);if(a!=null)this.setTop(a);if(q!=null)this.setWidth(q);if(n!=null)this.setHeight(n);if(e!=null)this.setText(e);};k.getBackgroundColor=function(){return this.jsxbgcolor;};k.setBackgroundColor=function(f,b){this.jsxbgcolor=f;if(b)this.updateGUI("backgroundColor",f==l.NULLSTYLE?"":f);return this;};k.getBackground=function(){return this.jsxbg;};k.setBackground=function(e){this.jsxbg=e;return this;};k.getBorder=function(){return this.jsxborder;};k.setBorder=function(q,g){this.jsxborder=q;if(g)this.recalcBox(["border"]);else this.fi();return this;};k.getColor=function(){return this.jsxcolor;};k.setColor=function(g,q){this.jsxcolor=g;if(q)this.updateGUI("color",g==l.NULLSTYLE?"":g);return this;};k.getCursor=function(){return this.jsxcursor;};k.setCursor=function(q,a){this.jsxcursor=q;if(a)this.updateGUI("cursor",q);return this;};k.getCSSOverride=function(){return this.jsxstyleoverride;};k.setCSSOverride=function(f){this.jsxstyleoverride=f;return this;};k.getClassName=function(){return this.jsxclassname;};k.setClassName=function(c){this.jsxclassname=c;return this;};k.getDisplay=function(){return this.jsxdisplay;};k.setDisplay=function(f,b){this.jsxdisplay=f;if(b){if(f!="none"){var
L=this.vi();if(!(this.getRelativePosition()==0||L&&L.getBoxType()!="relativebox")){var
zb=jsx3.gui.Painted.Box.getCssFix().split(":");if(zb.length==2)f=zb[1];}}this.updateGUI("display",f);}return this;};k.getFontName=function(){return this.jsxfontname;};k.setFontName=function(p){this.jsxfontname=p;return this;};k.getFontSize=function(){return this.jsxfontsize;};k.setFontSize=function(o){this.jsxfontsize=o;return this;};k.getFontWeight=function(){return this.jsxfontweight;};k.setFontWeight=function(a){this.jsxfontweight=a;return this;};k.getHeight=function(){return this.jsxheight;};k.setHeight=function(c,j){this.jsxheight=c;if(j){var
L=this.vi(true);this.Ch({height:c},true);}else this.fi();return this;};k.getIndex=function(){return this.jsxindex;};k.setIndex=function(e,g){this.jsxindex=e;if(g){var
dc=this.getRendered();if(dc!=null)dc.tabIndex=e;}return this;};l.getJSXParent=function(r){return jsx3.html.getJSXParent(r);};k.getLeft=function(){return this.jsxleft;};k.setLeft=function(r,d){this.jsxleft=r;if(d){if(r==null)r=0;var
Gc=this.vi(true);this.Ch({left:r},true);}else this.qo(false);return this;};k.setDimensions=function(m,p,g,q,h){if(m instanceof Array){this.setLeft(m[0],h);this.setTop(m[1],h);this.setWidth(m[2],h);this.setHeight(m[3],h);}else{this.setLeft(m,h);this.setTop(p,h);this.setWidth(g,h);this.setHeight(q,h);}};k.getDimensions=function(){return [this.getLeft(),this.getTop(),this.getWidth(),this.getHeight()];};k.getMargin=function(){return this.jsxmargin;};k.setMargin=function(n,d){this.jsxmargin=n;if(d)this.recalcBox(["margin"]);else this.fi();return this;};k.getMaskProperties=function(){var
O={};O.NN=true;O.SS=true;O.EE=true;O.WW=true;O.MM=this.getRelativePosition()==0;return O;};k.doBeginMove=function(h,e){if(h.leftButton()){this.jsxsupermix(h,e);gb.subscribe("mouseup",this,"doEndMove");h.cancelAll();}};k.doEndMove=function(p){p=p.event;var
Ab=this.getRendered(p);if(p.leftButton()){gb.unsubscribe("mouseup",this,"doEndMove");this.jsxsupermix(p,Ab);}else this.ZY(p,Ab);};k.doBeginDrag=function(m,b){if(m.leftButton())this.doDrag(m,b,null);};k.getOverflow=function(){return this.jsxoverflow;};k.setOverflow=function(a){this.jsxoverflow=a;return this;};k.getPadding=function(){return this.jsxpadding;};k.setPadding=function(s,b){this.jsxpadding=s;if(b)this.recalcBox(["padding"]);else this.fi();return this;};k.getPropertiesPath=function(){return null;};k.getModelEventsPath=function(){return null;};k.getRelativePosition=function(){return this.jsxrelativeposition;};k.setRelativePosition=function(e,o){this.fi();this.jsxrelativeposition=e;if(o){if(e==0){this.setLeft(this.getLeft()?this.getLeft():0,true);this.setTop(this.getTop()?this.getTop():0,true);this.updateGUI("margin","0px");}else{this.updateGUI("left","0px");this.updateGUI("top","0px");if(this.getMargin())this.setMargin(this.getMargin(),true);}this.updateGUI("position",e==1?"relative":"absolute");if(this.getDisplay()!="none")this.setDisplay("",true);}return this;};k.getTagName=function(){return this.jsxtagname;};k.setTagName=function(r){this.jsxtagname=r;this.fi();return this;};k.getText=function(){return this.jsxtext;};k.setText=function(b,o){this.jsxtext=b;if(o)if(this.getChild(0)!=null||this.vi(true).tp(0)!=null){this.repaint();}else{var
fb=this.getRendered();if(fb!=null)fb.innerHTML=b;}return this;};k.getTextAlign=function(){return this.jsxtextalign;};k.setTextAlign=function(m){this.jsxtextalign=m;return this;};k.getTip=function(){return this.jsxtip;};k.setTip=function(e){this.jsxtip=e;var
Ib;if(Ib=this.getRendered())Ib.title=e;return this;};k.getTop=function(){return this.jsxtop;};k.setTop=function(r,p){this.jsxtop=r;if(p){if(r==null)r=0;var
fb=this.vi(true);this.Ch({top:r},true);}else this.qo(false);return this;};k.updateGUI=function(c,f){var
eb=this.getRendered();if(eb!=null)try{eb.style[c]=f;}catch(Kc){}};k.getVisibility=function(){return this.jsxvisibility;};k.setVisibility=function(e,m){this.jsxvisibility=e;if(m)this.updateGUI("visibility",e);return this;};k.getWidth=function(){return this.jsxwidth;};k.setWidth=function(q,r){this.jsxwidth=q;if(r){var
Ob=this.vi(true);this.Ch({width:q},true);}else this.fi();return this;};k.getZIndex=function(){return this.jsxzindex;};k.setZIndex=function(q,j){this.jsxzindex=q;if(j)this.updateGUI("zIndex",q);return this;};k.Vd=function(o,d,c){this.Qh(o,d,c,4);};k.zj=function(d){this.applyDynamicProperties();if(this.getParent()&&(d==null||isNaN(d.parentwidth)||isNaN(d.parentheight))){d=this.getParent().Ln(this);}else if(d==null)d={};var
xc=d.boxtype&&d.boxtype!="box"||this.getRelativePosition()!=0;var
Zb=xc?null:d.left?d.left:this.getLeft();var
tb=xc?null:d.top?d.top:this.getTop();if(!xc&&!Zb)Zb=0;if(!xc&&!tb)tb=0;var
fc,x,D,Eb;if(d.boxtype==null)d.boxtype=xc?"relativebox":"box";if(d.tagname==null)d.tagname=(fc=this.getTagName())?fc.toLowerCase():jsx3.gui.Block.DEFAULTTAGNAME;if(d.left==null&&d.boxtype=="box")d.left=Zb;if(d.top==null&&d.boxtype=="box")d.top=tb;if(d.width==null)d.width=d.width?d.width:this.getWidth();if(d.height==null)d.height=d.height?d.height:this.getHeight();if(d.width=="100%"||d.tagName=="div"&&this.im()==""){d.tagname="div";d.container=true;}if((x=this.getPadding())!=null&&x!="")d.padding=x;if(xc&&(D=this.getMargin())!=null&&D!="")d.margin=D;if((Eb=this.getBorder())!=null&&Eb!="")d.border=Eb;return new
jsx3.gui.Painted.Box(d);};k.paint=function(s){this.applyDynamicProperties();s=s==null?this.im():s;var
ab=this.getId();var
ub={};if(this.hasEvent("jsxdblclick"))ub["dblclick"]=true;if(this.hasEvent("jsxclick"))ub["click"]=true;if(this.hasEvent("jsxkeydown"))ub["keydown"]=true;var
t="";if(this.getCanSpy()==1){ub["mouseover"]=true;ub["mouseout"]=true;}if(this.getCanMove()==1){if(this.getCanMove()==1)ub["mousedown"]="doBeginMove";}else if(this.getMenu()!=null){ub["mouseup"]=true;}else if(this.getCanDrop()==1)ub["mouseup"]=true;if(ub["mousedown"]==null&&this.getCanDrag()==1){ub["mousedown"]="doBeginDrag";t=t+(' JSXDragId="'+ab+'" JSXDragType="JSX_GENERIC"');}var
H=this.qk(ub,0)+t;var
Cb=this.renderAttributes(null,true);var
I=this.vi(true);I.setAttributes(this.vo()+this.fo()+H+' id="'+ab+'"'+this.so()+' class="'+this.Wg()+'" '+Cb);I.setStyles(this.xp()+this.Dg()+this.mg()+this.Eo()+this.Oo()+this.Ak()+this.vl()+this.Wm()+this.Ho()+this.Nh()+this.Af()+this.paintBlockDisplay()+this.ji());return I.paint().join(s+this.paintChildren());};k.Wh=function(q,o){if(this.getCanSpy()==1)this.doSpyOver(q,o);if(this.getCanDrop()==1)this.doDrop(q,o,jsx3.EventHelp.ONBEFOREDROP);};k.gn=function(e,h){if(this.getCanSpy()==1)this.doSpyOut(e,h);if(this.getCanDrop()==1)this.doDrop(e,h,jsx3.EventHelp.ONCANCELDROP);};k.ZY=function(r,a){if(this.getCanDrop()==1)this.doDrop(r,a,jsx3.EventHelp.ONDROP);else this.jsxsupermix(r,a);};k.so=function(){var
Eb=this.getName();return Eb!=null?' label="'+Eb+'"':"";};k.Dg=function(){var
H=this.getBackgroundColor();return H?"background-color:"+H+";":"";};k.mg=function(){return this.getBackground()?this.getBackground()+";":"";};k.Eo=function(){var
bc=this.getColor();return bc?"color:"+bc+";":"";};k.Nh=function(){var
ab=this.getCursor();return ab?"cursor:"+ab+";":"";};k.ji=function(){return this.getCSSOverride()?this.getCSSOverride():"";};k.Wg=function(){var
v=this.getClassName();return l.DEFAULTCLASSNAME+(v?" "+v:"");};k.paintBlockDisplay=function(){if(jsx3.util.strEmpty(this.getDisplay())||this.getDisplay()=="block"){var
D=this.vi();if(this.getWidth()=="100%"){return "display:block;";}else return "";}else if(this.getDisplay()=="none")return "display:none;";return "";};k.Dh=function(){var
G=this.getDisplay();return jsx3.util.strEmpty(G)||G==""?"":"display:none;";};k.Ak=function(){var
Sb=this.getFontName();return Sb?"font-family:"+Sb+";":"";};k.xp=function(){var
cb=parseInt(this.getFontSize());return isNaN(cb)?"":"font-size:"+cb+"px;";};k.Wm=function(){var
eb=this.getFontWeight();return eb?"font-weight:"+eb+";":"";};k.vo=function(o){if(o==null)o=this.getIndex();return o!=null?' tabindex="'+o+'" jsxtabindex="'+o+'"':"";};k.Oo=function(){if(this.getOverflow()==1){return "overflow:auto;";}else if(this.getOverflow()==2){return "overflow:hidden;";}else return "";};k.im=function(){return this.getText()?this.getText():"";};k.Ho=function(){var
Lc=this.getTextAlign();return Lc?"text-align:"+Lc+";":"";};k.fo=function(){var
D=this.getTip();if(D!=null){D=D.replace(/\"/g,"&quot;");return D?' title="'+D+'" ':"";}else if(jsx3.gui.Form&&this.instanceOf(jsx3.gui.Form)){var
gc=this.getKeyBinding();return gc?' title="'+gc.replace(/\"/g,"&quot;")+'" ':"";}else return "";};k.Af=function(){return jsx3.util.strEmpty(this.getVisibility())||this.getVisibility()==""?"":"visibility:hidden;";};k.vl=function(){var
Ec=this.getZIndex();return isNaN(Ec)?"":"z-index:"+Ec+";";};k.showMask=function(g){if(this._jsxcR)this.hideMask();var
Kc;if(Kc=this.getRendered()){var
P=this.getAbsolutePosition().H;if(Kc.onfocus)Kc._jsxiU=Kc.onfocus;jsx3.html.addEventListener(Kc,"onfocus",l._q);if(Kc.tabIndex)Kc._jsxtabindex=Kc.tabIndex;Kc.tabIndex=0;this._jsxcR=this.getId()+"_mask";var
Lc=(new
l(this._jsxcR,0,0,"100%","100%",g)).setOverflow(2).setFontWeight("bold").setTextAlign("center").setIndex(0).setRelativePosition(0).setZIndex(32000).setDynamicProperty("jsxbgcolor","@Solid Shadow").setDynamicProperty("jsxbg","@Mask 70%").setDynamicProperty("jsxcursor","@Wait");Lc.setWidth("100%");Lc.setHeight("100%");Lc.setPadding(parseInt(P/2));Lc.setEvent("if (objEVENT.tabKey() && objEVENT.shiftKey()) { this.getParent().focus(); }","jsxkeydown");Lc.setAttribute("onfocus","var objEVENT = jsx3.gui.Event.wrap(event); if (objEVENT.shiftKey()) { jsx3.GO(this.id).getParent().focus(); }");this.setChild(Lc);this.paintChild(Lc);}};l._q=function(n){var
cb=jsx3.GO(this.id);if(cb){var
Y=gb.wrap(n||window.event);if(!Y.shiftKey())if(cb.getChildren().length)cb.getLastChild().focus();}};k.hideMask=function(){var
fb;if(fb=this.getChild(this._jsxcR)){this.removeChild(fb);delete this._jsxcR;var
H;if(H=this.getRendered()){if(H._jsxtabindex){H.tabIndex=H._jsxtabindex;}else H.removeAttribute("tabIndex");jsx3.html.removeEventListener(H,"onfocus",l._q);if(H._jsxiU){H.onfocus=H._jsxiU;delete H._jsxiU;}else{}}}};l.getVersion=function(){return "3.00.00";};k.onDestroy=function(m){this.jsxsuper(m);this.doEvent("jsxdestroy",{objPARENT:m});};});jsx3.Block=jsx3.gui.Block;