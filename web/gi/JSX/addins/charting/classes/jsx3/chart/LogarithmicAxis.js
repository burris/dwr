/*
 * Copyright (c) 2001-2007, TIBCO Software Inc.
 * Use, modification, and distribution subject to terms of license.
 */
jsx3.require("jsx3.chart.Axis");jsx3.Class.defineClass("jsx3.chart.LogarithmicAxis",jsx3.chart.Axis,null,function(b,m){b.MAX_TICKS=200;b.l0=1;b.x8=0;b.DW=2;m.init=function(p,k,j){this.jsxsuper(p,k,j);this.autoAdjust=jsx3.Boolean.TRUE;this.baseAtZero=jsx3.Boolean.TRUE;this.showNegativeValues=jsx3.Boolean.FALSE;this.minExponent=null;this.maxExponent=null;this.base=10;this.majorDivisions=1;this.tm("Fi",b.x8);this.tm("ap",b.DW);};m.getAutoAdjust=function(){return this.autoAdjust;};m.setAutoAdjust=function(c){this.autoAdjust=c;};m.getBaseAtZero=function(){return this.baseAtZero;};m.setBaseAtZero=function(n){this.baseAtZero=n;};m.getShowNegativeValues=function(){return this.showNegativeValues;};m.setShowNegativeValues=function(f){this.showNegativeValues=f;};m.getMinExponent=function(){return this.minExponent;};m.setMinExponent=function(o){this.minExponent=o;};m.getMaxExponent=function(){return this.maxExponent;};m.setMaxExponent=function(e){this.maxExponent=e;};m.getBase=function(){return this.base;};m.setBase=function(n){this.base=n;};m.getMajorDivisions=function(){return this.majorDivisions;};m.setMajorDivisions=function(f){this.majorDivisions=f;};m.ve=function(){var
Ab=false;if(this.autoAdjust)Ab=this.tX();if(!Ab){this.tm("Fi",this.minExponent!=null?this.minExponent:b.x8);this.tm("ap",this.maxExponent!=null?this.maxExponent:b.DW);}};m.tX=function(){var
Ec=this.getChart();if(Ec==null)return false;var
sb=Ec.getRangeForAxis(this);if(sb==null){jsx3.chart.LOG.debug("no range for axis "+this+" in chart "+Ec);return false;}var
O=Math.max(0,sb[0]);var
db=Math.max(0,sb[1]);if(db==0){jsx3.chart.LOG.debug("range of axis "+this+" is all negative "+Ec);return false;}var
Bb=null,Rb=null;if(this.minExponent!=null){Bb=this.minExponent;}else if(this.baseAtZero)Bb=0;if(this.maxExponent!=null)Rb=this.maxExponent;O=O*b.l0;db=db*b.l0;if(Bb==null)if(O==0)Bb=0;else Bb=Math.floor(Math.log(O)/Math.log(this.base));if(Rb==null)Rb=Math.ceil(Math.log(db)/Math.log(this.base));this.tm("Fi",Bb);this.tm("ap",Rb);return true;};m.af=function(f){var
x=this.pk("Fi");var
Fc=Math.floor(x+f/this.majorDivisions);var
M=f%this.majorDivisions;if(M==0){return Math.pow(this.base,Fc);}else{var
Tb=Math.pow(this.base,Fc);var
sc=Math.pow(this.base,Fc+1);return Tb+M*(sc-Tb)/this.majorDivisions;}};m.yf=function(){var
Jb=this.pk("Fi");var
Zb=this.pk("ap");var
sb=[];var
Gb=0;for(var
rb=Jb;rb<=Zb&&Gb<b.MAX_TICKS;rb++){var
dc=Math.pow(this.base,rb);if(rb>Jb){var
Vb=Math.pow(this.base,rb-1);for(var
Rb=1;Rb<this.majorDivisions;Rb++){var
Pb=Vb+Rb*(dc-Vb)/this.majorDivisions;sb.push(this.getCoordinateFor(Pb));Gb++;}}sb.push(this.getCoordinateFor(dc));Gb++;}return sb;};m.ff=function(j,f){var
cc=[];if(f==0){return [];}else if(f==j.length){return [];}else{var
L=this.af(f-1);var
Cc=this.af(f);for(var
rb=1;rb<this.minorTickDivisions;rb++){var
kc=L+rb*(Cc-L)/this.minorTickDivisions;cc.push(this.getCoordinateFor(kc));}}return cc;};m.Kk=function(){return false;};m.getCoordinateFor=function(p){var
Ub=this.pk("Fi");var
sb=this.pk("ap");var
cc=null;if(p<=0){cc=0;}else{var
eb=Math.log(p)/Math.log(this.base);if(eb<Ub){cc=0;}else if(eb>sb){cc=this.length;}else cc=Math.round(this.length*(eb-Ub)/(sb-Ub));}return this.horizontal?cc:this.length-cc;};m.getCoordinateForNoClip=function(j){var
Pb=this.pk("Fi");var
yc=this.pk("ap");var
db=null;if(j<=0){db=-1;}else{var
Nb=Math.log(j)/Math.log(this.base);db=Math.round(this.length*(Nb-Pb)/(yc-Pb));}return this.horizontal?db:this.length-db;};m.toString=function(){return "[LogarithmicAxis '"+this.getName()+"']";};b.getVersion=function(){return jsx3.chart.sj;};});
