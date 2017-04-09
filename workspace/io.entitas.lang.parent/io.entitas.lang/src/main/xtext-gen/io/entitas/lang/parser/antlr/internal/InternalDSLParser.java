package io.entitas.lang.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import io.entitas.lang.services.DSLGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalDSLParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'target'", "','", "'('", "')'", "'gen_path'", "':'", "'.'", "'namespace'", "'context'", "'default'", "'alias'", "'comp'", "'prefix'", "'unique'", "'in'", "'sys'", "'trigger'", "'noFilter'", "'filter'", "'access'", "'init'", "'cleanup'", "'teardown'", "'no_exec'", "'explicit_context_list'", "'removed'", "'added'", "'removedOrAdded'", "'allOf'", "'anyOf'", "'noneOf'"
    };
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__37=37;
    public static final int T__16=16;
    public static final int T__38=38;
    public static final int T__17=17;
    public static final int T__39=39;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__33=33;
    public static final int T__12=12;
    public static final int T__34=34;
    public static final int T__13=13;
    public static final int T__35=35;
    public static final int T__14=14;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalDSLParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalDSLParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalDSLParser.tokenNames; }
    public String getGrammarFileName() { return "InternalDSL.g"; }



     	private DSLGrammarAccess grammarAccess;

        public InternalDSLParser(TokenStream input, DSLGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Root";
       	}

       	@Override
       	protected DSLGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleRoot"
    // InternalDSL.g:64:1: entryRuleRoot returns [EObject current=null] : iv_ruleRoot= ruleRoot EOF ;
    public final EObject entryRuleRoot() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRoot = null;


        try {
            // InternalDSL.g:64:45: (iv_ruleRoot= ruleRoot EOF )
            // InternalDSL.g:65:2: iv_ruleRoot= ruleRoot EOF
            {
             newCompositeNode(grammarAccess.getRootRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRoot=ruleRoot();

            state._fsp--;

             current =iv_ruleRoot; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRoot"


    // $ANTLR start "ruleRoot"
    // InternalDSL.g:71:1: ruleRoot returns [EObject current=null] : ( ( (lv_target_0_0= ruleTarget ) )? ( (lv_namespace_1_0= ruleNamespace ) )? ( (lv_context_2_0= ruleContext ) )? ( (lv_typeAliases_3_0= ruleAlias ) )* ( (lv_components_4_0= ruleComponent ) )* ( (lv_systems_5_0= ruleSystem ) )* ) ;
    public final EObject ruleRoot() throws RecognitionException {
        EObject current = null;

        EObject lv_target_0_0 = null;

        EObject lv_namespace_1_0 = null;

        EObject lv_context_2_0 = null;

        EObject lv_typeAliases_3_0 = null;

        EObject lv_components_4_0 = null;

        EObject lv_systems_5_0 = null;



        	enterRule();

        try {
            // InternalDSL.g:77:2: ( ( ( (lv_target_0_0= ruleTarget ) )? ( (lv_namespace_1_0= ruleNamespace ) )? ( (lv_context_2_0= ruleContext ) )? ( (lv_typeAliases_3_0= ruleAlias ) )* ( (lv_components_4_0= ruleComponent ) )* ( (lv_systems_5_0= ruleSystem ) )* ) )
            // InternalDSL.g:78:2: ( ( (lv_target_0_0= ruleTarget ) )? ( (lv_namespace_1_0= ruleNamespace ) )? ( (lv_context_2_0= ruleContext ) )? ( (lv_typeAliases_3_0= ruleAlias ) )* ( (lv_components_4_0= ruleComponent ) )* ( (lv_systems_5_0= ruleSystem ) )* )
            {
            // InternalDSL.g:78:2: ( ( (lv_target_0_0= ruleTarget ) )? ( (lv_namespace_1_0= ruleNamespace ) )? ( (lv_context_2_0= ruleContext ) )? ( (lv_typeAliases_3_0= ruleAlias ) )* ( (lv_components_4_0= ruleComponent ) )* ( (lv_systems_5_0= ruleSystem ) )* )
            // InternalDSL.g:79:3: ( (lv_target_0_0= ruleTarget ) )? ( (lv_namespace_1_0= ruleNamespace ) )? ( (lv_context_2_0= ruleContext ) )? ( (lv_typeAliases_3_0= ruleAlias ) )* ( (lv_components_4_0= ruleComponent ) )* ( (lv_systems_5_0= ruleSystem ) )*
            {
            // InternalDSL.g:79:3: ( (lv_target_0_0= ruleTarget ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==11) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalDSL.g:80:4: (lv_target_0_0= ruleTarget )
                    {
                    // InternalDSL.g:80:4: (lv_target_0_0= ruleTarget )
                    // InternalDSL.g:81:5: lv_target_0_0= ruleTarget
                    {

                    					newCompositeNode(grammarAccess.getRootAccess().getTargetTargetParserRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_3);
                    lv_target_0_0=ruleTarget();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getRootRule());
                    					}
                    					set(
                    						current,
                    						"target",
                    						lv_target_0_0,
                    						"io.entitas.lang.DSL.Target");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalDSL.g:98:3: ( (lv_namespace_1_0= ruleNamespace ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==18) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalDSL.g:99:4: (lv_namespace_1_0= ruleNamespace )
                    {
                    // InternalDSL.g:99:4: (lv_namespace_1_0= ruleNamespace )
                    // InternalDSL.g:100:5: lv_namespace_1_0= ruleNamespace
                    {

                    					newCompositeNode(grammarAccess.getRootAccess().getNamespaceNamespaceParserRuleCall_1_0());
                    				
                    pushFollow(FOLLOW_4);
                    lv_namespace_1_0=ruleNamespace();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getRootRule());
                    					}
                    					set(
                    						current,
                    						"namespace",
                    						lv_namespace_1_0,
                    						"io.entitas.lang.DSL.Namespace");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalDSL.g:117:3: ( (lv_context_2_0= ruleContext ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==19) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalDSL.g:118:4: (lv_context_2_0= ruleContext )
                    {
                    // InternalDSL.g:118:4: (lv_context_2_0= ruleContext )
                    // InternalDSL.g:119:5: lv_context_2_0= ruleContext
                    {

                    					newCompositeNode(grammarAccess.getRootAccess().getContextContextParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_5);
                    lv_context_2_0=ruleContext();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getRootRule());
                    					}
                    					set(
                    						current,
                    						"context",
                    						lv_context_2_0,
                    						"io.entitas.lang.DSL.Context");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalDSL.g:136:3: ( (lv_typeAliases_3_0= ruleAlias ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==21) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalDSL.g:137:4: (lv_typeAliases_3_0= ruleAlias )
            	    {
            	    // InternalDSL.g:137:4: (lv_typeAliases_3_0= ruleAlias )
            	    // InternalDSL.g:138:5: lv_typeAliases_3_0= ruleAlias
            	    {

            	    					newCompositeNode(grammarAccess.getRootAccess().getTypeAliasesAliasParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_5);
            	    lv_typeAliases_3_0=ruleAlias();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getRootRule());
            	    					}
            	    					add(
            	    						current,
            	    						"typeAliases",
            	    						lv_typeAliases_3_0,
            	    						"io.entitas.lang.DSL.Alias");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            // InternalDSL.g:155:3: ( (lv_components_4_0= ruleComponent ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==22) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalDSL.g:156:4: (lv_components_4_0= ruleComponent )
            	    {
            	    // InternalDSL.g:156:4: (lv_components_4_0= ruleComponent )
            	    // InternalDSL.g:157:5: lv_components_4_0= ruleComponent
            	    {

            	    					newCompositeNode(grammarAccess.getRootAccess().getComponentsComponentParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_6);
            	    lv_components_4_0=ruleComponent();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getRootRule());
            	    					}
            	    					add(
            	    						current,
            	    						"components",
            	    						lv_components_4_0,
            	    						"io.entitas.lang.DSL.Component");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            // InternalDSL.g:174:3: ( (lv_systems_5_0= ruleSystem ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==26) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalDSL.g:175:4: (lv_systems_5_0= ruleSystem )
            	    {
            	    // InternalDSL.g:175:4: (lv_systems_5_0= ruleSystem )
            	    // InternalDSL.g:176:5: lv_systems_5_0= ruleSystem
            	    {

            	    					newCompositeNode(grammarAccess.getRootAccess().getSystemsSystemParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_7);
            	    lv_systems_5_0=ruleSystem();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getRootRule());
            	    					}
            	    					add(
            	    						current,
            	    						"systems",
            	    						lv_systems_5_0,
            	    						"io.entitas.lang.DSL.System");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRoot"


    // $ANTLR start "entryRuleTarget"
    // InternalDSL.g:197:1: entryRuleTarget returns [EObject current=null] : iv_ruleTarget= ruleTarget EOF ;
    public final EObject entryRuleTarget() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTarget = null;


        try {
            // InternalDSL.g:197:47: (iv_ruleTarget= ruleTarget EOF )
            // InternalDSL.g:198:2: iv_ruleTarget= ruleTarget EOF
            {
             newCompositeNode(grammarAccess.getTargetRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTarget=ruleTarget();

            state._fsp--;

             current =iv_ruleTarget; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTarget"


    // $ANTLR start "ruleTarget"
    // InternalDSL.g:204:1: ruleTarget returns [EObject current=null] : (otherlv_0= 'target' ( ( (lv_ids_1_0= ruleTargetId ) ) (otherlv_2= ',' )? )+ ) ;
    public final EObject ruleTarget() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_ids_1_0 = null;



        	enterRule();

        try {
            // InternalDSL.g:210:2: ( (otherlv_0= 'target' ( ( (lv_ids_1_0= ruleTargetId ) ) (otherlv_2= ',' )? )+ ) )
            // InternalDSL.g:211:2: (otherlv_0= 'target' ( ( (lv_ids_1_0= ruleTargetId ) ) (otherlv_2= ',' )? )+ )
            {
            // InternalDSL.g:211:2: (otherlv_0= 'target' ( ( (lv_ids_1_0= ruleTargetId ) ) (otherlv_2= ',' )? )+ )
            // InternalDSL.g:212:3: otherlv_0= 'target' ( ( (lv_ids_1_0= ruleTargetId ) ) (otherlv_2= ',' )? )+
            {
            otherlv_0=(Token)match(input,11,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getTargetAccess().getTargetKeyword_0());
            		
            // InternalDSL.g:216:3: ( ( (lv_ids_1_0= ruleTargetId ) ) (otherlv_2= ',' )? )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_ID) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalDSL.g:217:4: ( (lv_ids_1_0= ruleTargetId ) ) (otherlv_2= ',' )?
            	    {
            	    // InternalDSL.g:217:4: ( (lv_ids_1_0= ruleTargetId ) )
            	    // InternalDSL.g:218:5: (lv_ids_1_0= ruleTargetId )
            	    {
            	    // InternalDSL.g:218:5: (lv_ids_1_0= ruleTargetId )
            	    // InternalDSL.g:219:6: lv_ids_1_0= ruleTargetId
            	    {

            	    						newCompositeNode(grammarAccess.getTargetAccess().getIdsTargetIdParserRuleCall_1_0_0());
            	    					
            	    pushFollow(FOLLOW_9);
            	    lv_ids_1_0=ruleTargetId();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getTargetRule());
            	    						}
            	    						add(
            	    							current,
            	    							"ids",
            	    							lv_ids_1_0,
            	    							"io.entitas.lang.DSL.TargetId");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }

            	    // InternalDSL.g:236:4: (otherlv_2= ',' )?
            	    int alt7=2;
            	    int LA7_0 = input.LA(1);

            	    if ( (LA7_0==12) ) {
            	        alt7=1;
            	    }
            	    switch (alt7) {
            	        case 1 :
            	            // InternalDSL.g:237:5: otherlv_2= ','
            	            {
            	            otherlv_2=(Token)match(input,12,FOLLOW_10); 

            	            					newLeafNode(otherlv_2, grammarAccess.getTargetAccess().getCommaKeyword_1_1());
            	            				

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt8 >= 1 ) break loop8;
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTarget"


    // $ANTLR start "entryRuleTargetId"
    // InternalDSL.g:247:1: entryRuleTargetId returns [EObject current=null] : iv_ruleTargetId= ruleTargetId EOF ;
    public final EObject entryRuleTargetId() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTargetId = null;


        try {
            // InternalDSL.g:247:49: (iv_ruleTargetId= ruleTargetId EOF )
            // InternalDSL.g:248:2: iv_ruleTargetId= ruleTargetId EOF
            {
             newCompositeNode(grammarAccess.getTargetIdRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTargetId=ruleTargetId();

            state._fsp--;

             current =iv_ruleTargetId; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTargetId"


    // $ANTLR start "ruleTargetId"
    // InternalDSL.g:254:1: ruleTargetId returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_parameters_2_0= ruleTargetParameter ) ) (otherlv_3= ',' )? otherlv_4= ')' )? ( (lv_version_5_0= ruleVersion ) )? ) ;
    public final EObject ruleTargetId() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject lv_parameters_2_0 = null;

        EObject lv_version_5_0 = null;



        	enterRule();

        try {
            // InternalDSL.g:260:2: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_parameters_2_0= ruleTargetParameter ) ) (otherlv_3= ',' )? otherlv_4= ')' )? ( (lv_version_5_0= ruleVersion ) )? ) )
            // InternalDSL.g:261:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_parameters_2_0= ruleTargetParameter ) ) (otherlv_3= ',' )? otherlv_4= ')' )? ( (lv_version_5_0= ruleVersion ) )? )
            {
            // InternalDSL.g:261:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_parameters_2_0= ruleTargetParameter ) ) (otherlv_3= ',' )? otherlv_4= ')' )? ( (lv_version_5_0= ruleVersion ) )? )
            // InternalDSL.g:262:3: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_parameters_2_0= ruleTargetParameter ) ) (otherlv_3= ',' )? otherlv_4= ')' )? ( (lv_version_5_0= ruleVersion ) )?
            {
            // InternalDSL.g:262:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalDSL.g:263:4: (lv_name_0_0= RULE_ID )
            {
            // InternalDSL.g:263:4: (lv_name_0_0= RULE_ID )
            // InternalDSL.g:264:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_11); 

            					newLeafNode(lv_name_0_0, grammarAccess.getTargetIdAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTargetIdRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalDSL.g:280:3: (otherlv_1= '(' ( (lv_parameters_2_0= ruleTargetParameter ) ) (otherlv_3= ',' )? otherlv_4= ')' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==13) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalDSL.g:281:4: otherlv_1= '(' ( (lv_parameters_2_0= ruleTargetParameter ) ) (otherlv_3= ',' )? otherlv_4= ')'
                    {
                    otherlv_1=(Token)match(input,13,FOLLOW_12); 

                    				newLeafNode(otherlv_1, grammarAccess.getTargetIdAccess().getLeftParenthesisKeyword_1_0());
                    			
                    // InternalDSL.g:285:4: ( (lv_parameters_2_0= ruleTargetParameter ) )
                    // InternalDSL.g:286:5: (lv_parameters_2_0= ruleTargetParameter )
                    {
                    // InternalDSL.g:286:5: (lv_parameters_2_0= ruleTargetParameter )
                    // InternalDSL.g:287:6: lv_parameters_2_0= ruleTargetParameter
                    {

                    						newCompositeNode(grammarAccess.getTargetIdAccess().getParametersTargetParameterParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_13);
                    lv_parameters_2_0=ruleTargetParameter();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTargetIdRule());
                    						}
                    						add(
                    							current,
                    							"parameters",
                    							lv_parameters_2_0,
                    							"io.entitas.lang.DSL.TargetParameter");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalDSL.g:304:4: (otherlv_3= ',' )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==12) ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // InternalDSL.g:305:5: otherlv_3= ','
                            {
                            otherlv_3=(Token)match(input,12,FOLLOW_14); 

                            					newLeafNode(otherlv_3, grammarAccess.getTargetIdAccess().getCommaKeyword_1_2());
                            				

                            }
                            break;

                    }

                    otherlv_4=(Token)match(input,14,FOLLOW_15); 

                    				newLeafNode(otherlv_4, grammarAccess.getTargetIdAccess().getRightParenthesisKeyword_1_3());
                    			

                    }
                    break;

            }

            // InternalDSL.g:315:3: ( (lv_version_5_0= ruleVersion ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_INT) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalDSL.g:316:4: (lv_version_5_0= ruleVersion )
                    {
                    // InternalDSL.g:316:4: (lv_version_5_0= ruleVersion )
                    // InternalDSL.g:317:5: lv_version_5_0= ruleVersion
                    {

                    					newCompositeNode(grammarAccess.getTargetIdAccess().getVersionVersionParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_version_5_0=ruleVersion();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getTargetIdRule());
                    					}
                    					set(
                    						current,
                    						"version",
                    						lv_version_5_0,
                    						"io.entitas.lang.DSL.Version");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTargetId"


    // $ANTLR start "entryRuleTargetParameter"
    // InternalDSL.g:338:1: entryRuleTargetParameter returns [EObject current=null] : iv_ruleTargetParameter= ruleTargetParameter EOF ;
    public final EObject entryRuleTargetParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTargetParameter = null;


        try {
            // InternalDSL.g:338:56: (iv_ruleTargetParameter= ruleTargetParameter EOF )
            // InternalDSL.g:339:2: iv_ruleTargetParameter= ruleTargetParameter EOF
            {
             newCompositeNode(grammarAccess.getTargetParameterRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTargetParameter=ruleTargetParameter();

            state._fsp--;

             current =iv_ruleTargetParameter; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTargetParameter"


    // $ANTLR start "ruleTargetParameter"
    // InternalDSL.g:345:1: ruleTargetParameter returns [EObject current=null] : (otherlv_0= 'gen_path' otherlv_1= ':' ( (lv_path_2_0= RULE_STRING ) ) ) ;
    public final EObject ruleTargetParameter() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_path_2_0=null;


        	enterRule();

        try {
            // InternalDSL.g:351:2: ( (otherlv_0= 'gen_path' otherlv_1= ':' ( (lv_path_2_0= RULE_STRING ) ) ) )
            // InternalDSL.g:352:2: (otherlv_0= 'gen_path' otherlv_1= ':' ( (lv_path_2_0= RULE_STRING ) ) )
            {
            // InternalDSL.g:352:2: (otherlv_0= 'gen_path' otherlv_1= ':' ( (lv_path_2_0= RULE_STRING ) ) )
            // InternalDSL.g:353:3: otherlv_0= 'gen_path' otherlv_1= ':' ( (lv_path_2_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,15,FOLLOW_16); 

            			newLeafNode(otherlv_0, grammarAccess.getTargetParameterAccess().getGen_pathKeyword_0());
            		
            otherlv_1=(Token)match(input,16,FOLLOW_17); 

            			newLeafNode(otherlv_1, grammarAccess.getTargetParameterAccess().getColonKeyword_1());
            		
            // InternalDSL.g:361:3: ( (lv_path_2_0= RULE_STRING ) )
            // InternalDSL.g:362:4: (lv_path_2_0= RULE_STRING )
            {
            // InternalDSL.g:362:4: (lv_path_2_0= RULE_STRING )
            // InternalDSL.g:363:5: lv_path_2_0= RULE_STRING
            {
            lv_path_2_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(lv_path_2_0, grammarAccess.getTargetParameterAccess().getPathSTRINGTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTargetParameterRule());
            					}
            					setWithLastConsumed(
            						current,
            						"path",
            						lv_path_2_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTargetParameter"


    // $ANTLR start "entryRuleVersion"
    // InternalDSL.g:383:1: entryRuleVersion returns [EObject current=null] : iv_ruleVersion= ruleVersion EOF ;
    public final EObject entryRuleVersion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVersion = null;


        try {
            // InternalDSL.g:383:48: (iv_ruleVersion= ruleVersion EOF )
            // InternalDSL.g:384:2: iv_ruleVersion= ruleVersion EOF
            {
             newCompositeNode(grammarAccess.getVersionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVersion=ruleVersion();

            state._fsp--;

             current =iv_ruleVersion; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVersion"


    // $ANTLR start "ruleVersion"
    // InternalDSL.g:390:1: ruleVersion returns [EObject current=null] : ( () ( (lv_major_1_0= RULE_INT ) ) (otherlv_2= '.' ( (lv_minor_3_0= RULE_INT ) ) (otherlv_4= '.' ( (lv_patch_5_0= RULE_INT ) ) )? )? ) ;
    public final EObject ruleVersion() throws RecognitionException {
        EObject current = null;

        Token lv_major_1_0=null;
        Token otherlv_2=null;
        Token lv_minor_3_0=null;
        Token otherlv_4=null;
        Token lv_patch_5_0=null;


        	enterRule();

        try {
            // InternalDSL.g:396:2: ( ( () ( (lv_major_1_0= RULE_INT ) ) (otherlv_2= '.' ( (lv_minor_3_0= RULE_INT ) ) (otherlv_4= '.' ( (lv_patch_5_0= RULE_INT ) ) )? )? ) )
            // InternalDSL.g:397:2: ( () ( (lv_major_1_0= RULE_INT ) ) (otherlv_2= '.' ( (lv_minor_3_0= RULE_INT ) ) (otherlv_4= '.' ( (lv_patch_5_0= RULE_INT ) ) )? )? )
            {
            // InternalDSL.g:397:2: ( () ( (lv_major_1_0= RULE_INT ) ) (otherlv_2= '.' ( (lv_minor_3_0= RULE_INT ) ) (otherlv_4= '.' ( (lv_patch_5_0= RULE_INT ) ) )? )? )
            // InternalDSL.g:398:3: () ( (lv_major_1_0= RULE_INT ) ) (otherlv_2= '.' ( (lv_minor_3_0= RULE_INT ) ) (otherlv_4= '.' ( (lv_patch_5_0= RULE_INT ) ) )? )?
            {
            // InternalDSL.g:398:3: ()
            // InternalDSL.g:399:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getVersionAccess().getVersionAction_0(),
            					current);
            			

            }

            // InternalDSL.g:405:3: ( (lv_major_1_0= RULE_INT ) )
            // InternalDSL.g:406:4: (lv_major_1_0= RULE_INT )
            {
            // InternalDSL.g:406:4: (lv_major_1_0= RULE_INT )
            // InternalDSL.g:407:5: lv_major_1_0= RULE_INT
            {
            lv_major_1_0=(Token)match(input,RULE_INT,FOLLOW_18); 

            					newLeafNode(lv_major_1_0, grammarAccess.getVersionAccess().getMajorINTTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getVersionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"major",
            						lv_major_1_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            // InternalDSL.g:423:3: (otherlv_2= '.' ( (lv_minor_3_0= RULE_INT ) ) (otherlv_4= '.' ( (lv_patch_5_0= RULE_INT ) ) )? )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==17) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalDSL.g:424:4: otherlv_2= '.' ( (lv_minor_3_0= RULE_INT ) ) (otherlv_4= '.' ( (lv_patch_5_0= RULE_INT ) ) )?
                    {
                    otherlv_2=(Token)match(input,17,FOLLOW_19); 

                    				newLeafNode(otherlv_2, grammarAccess.getVersionAccess().getFullStopKeyword_2_0());
                    			
                    // InternalDSL.g:428:4: ( (lv_minor_3_0= RULE_INT ) )
                    // InternalDSL.g:429:5: (lv_minor_3_0= RULE_INT )
                    {
                    // InternalDSL.g:429:5: (lv_minor_3_0= RULE_INT )
                    // InternalDSL.g:430:6: lv_minor_3_0= RULE_INT
                    {
                    lv_minor_3_0=(Token)match(input,RULE_INT,FOLLOW_18); 

                    						newLeafNode(lv_minor_3_0, grammarAccess.getVersionAccess().getMinorINTTerminalRuleCall_2_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getVersionRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"minor",
                    							lv_minor_3_0,
                    							"org.eclipse.xtext.common.Terminals.INT");
                    					

                    }


                    }

                    // InternalDSL.g:446:4: (otherlv_4= '.' ( (lv_patch_5_0= RULE_INT ) ) )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==17) ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // InternalDSL.g:447:5: otherlv_4= '.' ( (lv_patch_5_0= RULE_INT ) )
                            {
                            otherlv_4=(Token)match(input,17,FOLLOW_19); 

                            					newLeafNode(otherlv_4, grammarAccess.getVersionAccess().getFullStopKeyword_2_2_0());
                            				
                            // InternalDSL.g:451:5: ( (lv_patch_5_0= RULE_INT ) )
                            // InternalDSL.g:452:6: (lv_patch_5_0= RULE_INT )
                            {
                            // InternalDSL.g:452:6: (lv_patch_5_0= RULE_INT )
                            // InternalDSL.g:453:7: lv_patch_5_0= RULE_INT
                            {
                            lv_patch_5_0=(Token)match(input,RULE_INT,FOLLOW_2); 

                            							newLeafNode(lv_patch_5_0, grammarAccess.getVersionAccess().getPatchINTTerminalRuleCall_2_2_1_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getVersionRule());
                            							}
                            							setWithLastConsumed(
                            								current,
                            								"patch",
                            								lv_patch_5_0,
                            								"org.eclipse.xtext.common.Terminals.INT");
                            						

                            }


                            }


                            }
                            break;

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVersion"


    // $ANTLR start "entryRuleNamespace"
    // InternalDSL.g:475:1: entryRuleNamespace returns [EObject current=null] : iv_ruleNamespace= ruleNamespace EOF ;
    public final EObject entryRuleNamespace() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamespace = null;


        try {
            // InternalDSL.g:475:50: (iv_ruleNamespace= ruleNamespace EOF )
            // InternalDSL.g:476:2: iv_ruleNamespace= ruleNamespace EOF
            {
             newCompositeNode(grammarAccess.getNamespaceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNamespace=ruleNamespace();

            state._fsp--;

             current =iv_ruleNamespace; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNamespace"


    // $ANTLR start "ruleNamespace"
    // InternalDSL.g:482:1: ruleNamespace returns [EObject current=null] : (otherlv_0= 'namespace' ( (lv_name_1_0= ruleQualifiedName ) ) ) ;
    public final EObject ruleNamespace() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;



        	enterRule();

        try {
            // InternalDSL.g:488:2: ( (otherlv_0= 'namespace' ( (lv_name_1_0= ruleQualifiedName ) ) ) )
            // InternalDSL.g:489:2: (otherlv_0= 'namespace' ( (lv_name_1_0= ruleQualifiedName ) ) )
            {
            // InternalDSL.g:489:2: (otherlv_0= 'namespace' ( (lv_name_1_0= ruleQualifiedName ) ) )
            // InternalDSL.g:490:3: otherlv_0= 'namespace' ( (lv_name_1_0= ruleQualifiedName ) )
            {
            otherlv_0=(Token)match(input,18,FOLLOW_20); 

            			newLeafNode(otherlv_0, grammarAccess.getNamespaceAccess().getNamespaceKeyword_0());
            		
            // InternalDSL.g:494:3: ( (lv_name_1_0= ruleQualifiedName ) )
            // InternalDSL.g:495:4: (lv_name_1_0= ruleQualifiedName )
            {
            // InternalDSL.g:495:4: (lv_name_1_0= ruleQualifiedName )
            // InternalDSL.g:496:5: lv_name_1_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getNamespaceAccess().getNameQualifiedNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_name_1_0=ruleQualifiedName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getNamespaceRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"io.entitas.lang.DSL.QualifiedName");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNamespace"


    // $ANTLR start "entryRuleContext"
    // InternalDSL.g:517:1: entryRuleContext returns [EObject current=null] : iv_ruleContext= ruleContext EOF ;
    public final EObject entryRuleContext() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContext = null;


        try {
            // InternalDSL.g:517:48: (iv_ruleContext= ruleContext EOF )
            // InternalDSL.g:518:2: iv_ruleContext= ruleContext EOF
            {
             newCompositeNode(grammarAccess.getContextRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleContext=ruleContext();

            state._fsp--;

             current =iv_ruleContext; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleContext"


    // $ANTLR start "ruleContext"
    // InternalDSL.g:524:1: ruleContext returns [EObject current=null] : (otherlv_0= 'context' ( ( (lv_ids_1_0= ruleContextId ) ) (otherlv_2= ',' )? )+ ) ;
    public final EObject ruleContext() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_ids_1_0 = null;



        	enterRule();

        try {
            // InternalDSL.g:530:2: ( (otherlv_0= 'context' ( ( (lv_ids_1_0= ruleContextId ) ) (otherlv_2= ',' )? )+ ) )
            // InternalDSL.g:531:2: (otherlv_0= 'context' ( ( (lv_ids_1_0= ruleContextId ) ) (otherlv_2= ',' )? )+ )
            {
            // InternalDSL.g:531:2: (otherlv_0= 'context' ( ( (lv_ids_1_0= ruleContextId ) ) (otherlv_2= ',' )? )+ )
            // InternalDSL.g:532:3: otherlv_0= 'context' ( ( (lv_ids_1_0= ruleContextId ) ) (otherlv_2= ',' )? )+
            {
            otherlv_0=(Token)match(input,19,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getContextAccess().getContextKeyword_0());
            		
            // InternalDSL.g:536:3: ( ( (lv_ids_1_0= ruleContextId ) ) (otherlv_2= ',' )? )+
            int cnt15=0;
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==RULE_ID) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalDSL.g:537:4: ( (lv_ids_1_0= ruleContextId ) ) (otherlv_2= ',' )?
            	    {
            	    // InternalDSL.g:537:4: ( (lv_ids_1_0= ruleContextId ) )
            	    // InternalDSL.g:538:5: (lv_ids_1_0= ruleContextId )
            	    {
            	    // InternalDSL.g:538:5: (lv_ids_1_0= ruleContextId )
            	    // InternalDSL.g:539:6: lv_ids_1_0= ruleContextId
            	    {

            	    						newCompositeNode(grammarAccess.getContextAccess().getIdsContextIdParserRuleCall_1_0_0());
            	    					
            	    pushFollow(FOLLOW_9);
            	    lv_ids_1_0=ruleContextId();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getContextRule());
            	    						}
            	    						add(
            	    							current,
            	    							"ids",
            	    							lv_ids_1_0,
            	    							"io.entitas.lang.DSL.ContextId");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }

            	    // InternalDSL.g:556:4: (otherlv_2= ',' )?
            	    int alt14=2;
            	    int LA14_0 = input.LA(1);

            	    if ( (LA14_0==12) ) {
            	        alt14=1;
            	    }
            	    switch (alt14) {
            	        case 1 :
            	            // InternalDSL.g:557:5: otherlv_2= ','
            	            {
            	            otherlv_2=(Token)match(input,12,FOLLOW_10); 

            	            					newLeafNode(otherlv_2, grammarAccess.getContextAccess().getCommaKeyword_1_1());
            	            				

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt15 >= 1 ) break loop15;
                        EarlyExitException eee =
                            new EarlyExitException(15, input);
                        throw eee;
                }
                cnt15++;
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContext"


    // $ANTLR start "entryRuleContextId"
    // InternalDSL.g:567:1: entryRuleContextId returns [EObject current=null] : iv_ruleContextId= ruleContextId EOF ;
    public final EObject entryRuleContextId() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContextId = null;


        try {
            // InternalDSL.g:567:50: (iv_ruleContextId= ruleContextId EOF )
            // InternalDSL.g:568:2: iv_ruleContextId= ruleContextId EOF
            {
             newCompositeNode(grammarAccess.getContextIdRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleContextId=ruleContextId();

            state._fsp--;

             current =iv_ruleContextId; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleContextId"


    // $ANTLR start "ruleContextId"
    // InternalDSL.g:574:1: ruleContextId returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_parameters_2_0= ruleContextParameter ) ) (otherlv_3= ',' )? otherlv_4= ')' )? ) ;
    public final EObject ruleContextId() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_parameters_2_0 = null;



        	enterRule();

        try {
            // InternalDSL.g:580:2: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_parameters_2_0= ruleContextParameter ) ) (otherlv_3= ',' )? otherlv_4= ')' )? ) )
            // InternalDSL.g:581:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_parameters_2_0= ruleContextParameter ) ) (otherlv_3= ',' )? otherlv_4= ')' )? )
            {
            // InternalDSL.g:581:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_parameters_2_0= ruleContextParameter ) ) (otherlv_3= ',' )? otherlv_4= ')' )? )
            // InternalDSL.g:582:3: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_parameters_2_0= ruleContextParameter ) ) (otherlv_3= ',' )? otherlv_4= ')' )?
            {
            // InternalDSL.g:582:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalDSL.g:583:4: (lv_name_0_0= RULE_ID )
            {
            // InternalDSL.g:583:4: (lv_name_0_0= RULE_ID )
            // InternalDSL.g:584:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_21); 

            					newLeafNode(lv_name_0_0, grammarAccess.getContextIdAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getContextIdRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalDSL.g:600:3: (otherlv_1= '(' ( (lv_parameters_2_0= ruleContextParameter ) ) (otherlv_3= ',' )? otherlv_4= ')' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==13) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalDSL.g:601:4: otherlv_1= '(' ( (lv_parameters_2_0= ruleContextParameter ) ) (otherlv_3= ',' )? otherlv_4= ')'
                    {
                    otherlv_1=(Token)match(input,13,FOLLOW_22); 

                    				newLeafNode(otherlv_1, grammarAccess.getContextIdAccess().getLeftParenthesisKeyword_1_0());
                    			
                    // InternalDSL.g:605:4: ( (lv_parameters_2_0= ruleContextParameter ) )
                    // InternalDSL.g:606:5: (lv_parameters_2_0= ruleContextParameter )
                    {
                    // InternalDSL.g:606:5: (lv_parameters_2_0= ruleContextParameter )
                    // InternalDSL.g:607:6: lv_parameters_2_0= ruleContextParameter
                    {

                    						newCompositeNode(grammarAccess.getContextIdAccess().getParametersContextParameterParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_13);
                    lv_parameters_2_0=ruleContextParameter();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getContextIdRule());
                    						}
                    						add(
                    							current,
                    							"parameters",
                    							lv_parameters_2_0,
                    							"io.entitas.lang.DSL.ContextParameter");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalDSL.g:624:4: (otherlv_3= ',' )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==12) ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // InternalDSL.g:625:5: otherlv_3= ','
                            {
                            otherlv_3=(Token)match(input,12,FOLLOW_14); 

                            					newLeafNode(otherlv_3, grammarAccess.getContextIdAccess().getCommaKeyword_1_2());
                            				

                            }
                            break;

                    }

                    otherlv_4=(Token)match(input,14,FOLLOW_2); 

                    				newLeafNode(otherlv_4, grammarAccess.getContextIdAccess().getRightParenthesisKeyword_1_3());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContextId"


    // $ANTLR start "entryRuleContextParameter"
    // InternalDSL.g:639:1: entryRuleContextParameter returns [String current=null] : iv_ruleContextParameter= ruleContextParameter EOF ;
    public final String entryRuleContextParameter() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleContextParameter = null;


        try {
            // InternalDSL.g:639:56: (iv_ruleContextParameter= ruleContextParameter EOF )
            // InternalDSL.g:640:2: iv_ruleContextParameter= ruleContextParameter EOF
            {
             newCompositeNode(grammarAccess.getContextParameterRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleContextParameter=ruleContextParameter();

            state._fsp--;

             current =iv_ruleContextParameter.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleContextParameter"


    // $ANTLR start "ruleContextParameter"
    // InternalDSL.g:646:1: ruleContextParameter returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'default' ;
    public final AntlrDatatypeRuleToken ruleContextParameter() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalDSL.g:652:2: (kw= 'default' )
            // InternalDSL.g:653:2: kw= 'default'
            {
            kw=(Token)match(input,20,FOLLOW_2); 

            		current.merge(kw);
            		newLeafNode(kw, grammarAccess.getContextParameterAccess().getDefaultKeyword());
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContextParameter"


    // $ANTLR start "entryRuleAlias"
    // InternalDSL.g:661:1: entryRuleAlias returns [EObject current=null] : iv_ruleAlias= ruleAlias EOF ;
    public final EObject entryRuleAlias() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAlias = null;


        try {
            // InternalDSL.g:661:46: (iv_ruleAlias= ruleAlias EOF )
            // InternalDSL.g:662:2: iv_ruleAlias= ruleAlias EOF
            {
             newCompositeNode(grammarAccess.getAliasRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAlias=ruleAlias();

            state._fsp--;

             current =iv_ruleAlias; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAlias"


    // $ANTLR start "ruleAlias"
    // InternalDSL.g:668:1: ruleAlias returns [EObject current=null] : (otherlv_0= 'alias' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_listOfAliases_2_0= ruleAliasList ) ) | ( (lv_singleAlias_3_0= ruleSingleAlias ) ) ) ) ;
    public final EObject ruleAlias() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        EObject lv_listOfAliases_2_0 = null;

        EObject lv_singleAlias_3_0 = null;



        	enterRule();

        try {
            // InternalDSL.g:674:2: ( (otherlv_0= 'alias' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_listOfAliases_2_0= ruleAliasList ) ) | ( (lv_singleAlias_3_0= ruleSingleAlias ) ) ) ) )
            // InternalDSL.g:675:2: (otherlv_0= 'alias' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_listOfAliases_2_0= ruleAliasList ) ) | ( (lv_singleAlias_3_0= ruleSingleAlias ) ) ) )
            {
            // InternalDSL.g:675:2: (otherlv_0= 'alias' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_listOfAliases_2_0= ruleAliasList ) ) | ( (lv_singleAlias_3_0= ruleSingleAlias ) ) ) )
            // InternalDSL.g:676:3: otherlv_0= 'alias' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_listOfAliases_2_0= ruleAliasList ) ) | ( (lv_singleAlias_3_0= ruleSingleAlias ) ) )
            {
            otherlv_0=(Token)match(input,21,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getAliasAccess().getAliasKeyword_0());
            		
            // InternalDSL.g:680:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalDSL.g:681:4: (lv_name_1_0= RULE_ID )
            {
            // InternalDSL.g:681:4: (lv_name_1_0= RULE_ID )
            // InternalDSL.g:682:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_23); 

            					newLeafNode(lv_name_1_0, grammarAccess.getAliasAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAliasRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalDSL.g:698:3: ( ( (lv_listOfAliases_2_0= ruleAliasList ) ) | ( (lv_singleAlias_3_0= ruleSingleAlias ) ) )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_ID) ) {
                alt18=1;
            }
            else if ( (LA18_0==16) ) {
                alt18=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // InternalDSL.g:699:4: ( (lv_listOfAliases_2_0= ruleAliasList ) )
                    {
                    // InternalDSL.g:699:4: ( (lv_listOfAliases_2_0= ruleAliasList ) )
                    // InternalDSL.g:700:5: (lv_listOfAliases_2_0= ruleAliasList )
                    {
                    // InternalDSL.g:700:5: (lv_listOfAliases_2_0= ruleAliasList )
                    // InternalDSL.g:701:6: lv_listOfAliases_2_0= ruleAliasList
                    {

                    						newCompositeNode(grammarAccess.getAliasAccess().getListOfAliasesAliasListParserRuleCall_2_0_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_listOfAliases_2_0=ruleAliasList();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getAliasRule());
                    						}
                    						set(
                    							current,
                    							"listOfAliases",
                    							lv_listOfAliases_2_0,
                    							"io.entitas.lang.DSL.AliasList");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalDSL.g:719:4: ( (lv_singleAlias_3_0= ruleSingleAlias ) )
                    {
                    // InternalDSL.g:719:4: ( (lv_singleAlias_3_0= ruleSingleAlias ) )
                    // InternalDSL.g:720:5: (lv_singleAlias_3_0= ruleSingleAlias )
                    {
                    // InternalDSL.g:720:5: (lv_singleAlias_3_0= ruleSingleAlias )
                    // InternalDSL.g:721:6: lv_singleAlias_3_0= ruleSingleAlias
                    {

                    						newCompositeNode(grammarAccess.getAliasAccess().getSingleAliasSingleAliasParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_singleAlias_3_0=ruleSingleAlias();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getAliasRule());
                    						}
                    						set(
                    							current,
                    							"singleAlias",
                    							lv_singleAlias_3_0,
                    							"io.entitas.lang.DSL.SingleAlias");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAlias"


    // $ANTLR start "entryRuleAliasList"
    // InternalDSL.g:743:1: entryRuleAliasList returns [EObject current=null] : iv_ruleAliasList= ruleAliasList EOF ;
    public final EObject entryRuleAliasList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAliasList = null;


        try {
            // InternalDSL.g:743:50: (iv_ruleAliasList= ruleAliasList EOF )
            // InternalDSL.g:744:2: iv_ruleAliasList= ruleAliasList EOF
            {
             newCompositeNode(grammarAccess.getAliasListRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAliasList=ruleAliasList();

            state._fsp--;

             current =iv_ruleAliasList; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAliasList"


    // $ANTLR start "ruleAliasList"
    // InternalDSL.g:750:1: ruleAliasList returns [EObject current=null] : ( (lv_rules_0_0= ruleAliasRule ) )+ ;
    public final EObject ruleAliasList() throws RecognitionException {
        EObject current = null;

        EObject lv_rules_0_0 = null;



        	enterRule();

        try {
            // InternalDSL.g:756:2: ( ( (lv_rules_0_0= ruleAliasRule ) )+ )
            // InternalDSL.g:757:2: ( (lv_rules_0_0= ruleAliasRule ) )+
            {
            // InternalDSL.g:757:2: ( (lv_rules_0_0= ruleAliasRule ) )+
            int cnt19=0;
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==RULE_ID) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalDSL.g:758:3: (lv_rules_0_0= ruleAliasRule )
            	    {
            	    // InternalDSL.g:758:3: (lv_rules_0_0= ruleAliasRule )
            	    // InternalDSL.g:759:4: lv_rules_0_0= ruleAliasRule
            	    {

            	    				newCompositeNode(grammarAccess.getAliasListAccess().getRulesAliasRuleParserRuleCall_0());
            	    			
            	    pushFollow(FOLLOW_10);
            	    lv_rules_0_0=ruleAliasRule();

            	    state._fsp--;


            	    				if (current==null) {
            	    					current = createModelElementForParent(grammarAccess.getAliasListRule());
            	    				}
            	    				add(
            	    					current,
            	    					"rules",
            	    					lv_rules_0_0,
            	    					"io.entitas.lang.DSL.AliasRule");
            	    				afterParserOrEnumRuleCall();
            	    			

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt19 >= 1 ) break loop19;
                        EarlyExitException eee =
                            new EarlyExitException(19, input);
                        throw eee;
                }
                cnt19++;
            } while (true);


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAliasList"


    // $ANTLR start "entryRuleAliasRule"
    // InternalDSL.g:779:1: entryRuleAliasRule returns [EObject current=null] : iv_ruleAliasRule= ruleAliasRule EOF ;
    public final EObject entryRuleAliasRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAliasRule = null;


        try {
            // InternalDSL.g:779:50: (iv_ruleAliasRule= ruleAliasRule EOF )
            // InternalDSL.g:780:2: iv_ruleAliasRule= ruleAliasRule EOF
            {
             newCompositeNode(grammarAccess.getAliasRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAliasRule=ruleAliasRule();

            state._fsp--;

             current =iv_ruleAliasRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAliasRule"


    // $ANTLR start "ruleAliasRule"
    // InternalDSL.g:786:1: ruleAliasRule returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (lv_typeAlias_2_0= RULE_STRING ) ) ) ;
    public final EObject ruleAliasRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_typeAlias_2_0=null;


        	enterRule();

        try {
            // InternalDSL.g:792:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (lv_typeAlias_2_0= RULE_STRING ) ) ) )
            // InternalDSL.g:793:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (lv_typeAlias_2_0= RULE_STRING ) ) )
            {
            // InternalDSL.g:793:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (lv_typeAlias_2_0= RULE_STRING ) ) )
            // InternalDSL.g:794:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= ':' ( (lv_typeAlias_2_0= RULE_STRING ) )
            {
            // InternalDSL.g:794:3: ( (otherlv_0= RULE_ID ) )
            // InternalDSL.g:795:4: (otherlv_0= RULE_ID )
            {
            // InternalDSL.g:795:4: (otherlv_0= RULE_ID )
            // InternalDSL.g:796:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAliasRuleRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_16); 

            					newLeafNode(otherlv_0, grammarAccess.getAliasRuleAccess().getTargetTargetIdCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,16,FOLLOW_17); 

            			newLeafNode(otherlv_1, grammarAccess.getAliasRuleAccess().getColonKeyword_1());
            		
            // InternalDSL.g:811:3: ( (lv_typeAlias_2_0= RULE_STRING ) )
            // InternalDSL.g:812:4: (lv_typeAlias_2_0= RULE_STRING )
            {
            // InternalDSL.g:812:4: (lv_typeAlias_2_0= RULE_STRING )
            // InternalDSL.g:813:5: lv_typeAlias_2_0= RULE_STRING
            {
            lv_typeAlias_2_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(lv_typeAlias_2_0, grammarAccess.getAliasRuleAccess().getTypeAliasSTRINGTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAliasRuleRule());
            					}
            					setWithLastConsumed(
            						current,
            						"typeAlias",
            						lv_typeAlias_2_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAliasRule"


    // $ANTLR start "entryRuleSingleAlias"
    // InternalDSL.g:833:1: entryRuleSingleAlias returns [EObject current=null] : iv_ruleSingleAlias= ruleSingleAlias EOF ;
    public final EObject entryRuleSingleAlias() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSingleAlias = null;


        try {
            // InternalDSL.g:833:52: (iv_ruleSingleAlias= ruleSingleAlias EOF )
            // InternalDSL.g:834:2: iv_ruleSingleAlias= ruleSingleAlias EOF
            {
             newCompositeNode(grammarAccess.getSingleAliasRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSingleAlias=ruleSingleAlias();

            state._fsp--;

             current =iv_ruleSingleAlias; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSingleAlias"


    // $ANTLR start "ruleSingleAlias"
    // InternalDSL.g:840:1: ruleSingleAlias returns [EObject current=null] : (otherlv_0= ':' ( (lv_typeAlias_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleSingleAlias() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_typeAlias_1_0=null;


        	enterRule();

        try {
            // InternalDSL.g:846:2: ( (otherlv_0= ':' ( (lv_typeAlias_1_0= RULE_STRING ) ) ) )
            // InternalDSL.g:847:2: (otherlv_0= ':' ( (lv_typeAlias_1_0= RULE_STRING ) ) )
            {
            // InternalDSL.g:847:2: (otherlv_0= ':' ( (lv_typeAlias_1_0= RULE_STRING ) ) )
            // InternalDSL.g:848:3: otherlv_0= ':' ( (lv_typeAlias_1_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,16,FOLLOW_17); 

            			newLeafNode(otherlv_0, grammarAccess.getSingleAliasAccess().getColonKeyword_0());
            		
            // InternalDSL.g:852:3: ( (lv_typeAlias_1_0= RULE_STRING ) )
            // InternalDSL.g:853:4: (lv_typeAlias_1_0= RULE_STRING )
            {
            // InternalDSL.g:853:4: (lv_typeAlias_1_0= RULE_STRING )
            // InternalDSL.g:854:5: lv_typeAlias_1_0= RULE_STRING
            {
            lv_typeAlias_1_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(lv_typeAlias_1_0, grammarAccess.getSingleAliasAccess().getTypeAliasSTRINGTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSingleAliasRule());
            					}
            					setWithLastConsumed(
            						current,
            						"typeAlias",
            						lv_typeAlias_1_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSingleAlias"


    // $ANTLR start "entryRuleComponent"
    // InternalDSL.g:874:1: entryRuleComponent returns [EObject current=null] : iv_ruleComponent= ruleComponent EOF ;
    public final EObject entryRuleComponent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComponent = null;


        try {
            // InternalDSL.g:874:50: (iv_ruleComponent= ruleComponent EOF )
            // InternalDSL.g:875:2: iv_ruleComponent= ruleComponent EOF
            {
             newCompositeNode(grammarAccess.getComponentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleComponent=ruleComponent();

            state._fsp--;

             current =iv_ruleComponent; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleComponent"


    // $ANTLR start "ruleComponent"
    // InternalDSL.g:881:1: ruleComponent returns [EObject current=null] : (otherlv_0= 'comp' ( (lv_name_1_0= ruleValidID ) ) (otherlv_2= '(' ( ( (lv_parameters_3_0= ruleComponentParameter ) ) (otherlv_4= ',' )? )+ otherlv_5= ')' )? ( (lv_scope_6_0= ruleContextScopes ) )? ( ( (lv_listOfProperties_7_0= rulePropertyList ) ) | ( (lv_propertyPrefix_8_0= rulePropertyPrefix ) ) )? ) ;
    public final EObject ruleComponent() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_parameters_3_0 = null;

        EObject lv_scope_6_0 = null;

        EObject lv_listOfProperties_7_0 = null;

        EObject lv_propertyPrefix_8_0 = null;



        	enterRule();

        try {
            // InternalDSL.g:887:2: ( (otherlv_0= 'comp' ( (lv_name_1_0= ruleValidID ) ) (otherlv_2= '(' ( ( (lv_parameters_3_0= ruleComponentParameter ) ) (otherlv_4= ',' )? )+ otherlv_5= ')' )? ( (lv_scope_6_0= ruleContextScopes ) )? ( ( (lv_listOfProperties_7_0= rulePropertyList ) ) | ( (lv_propertyPrefix_8_0= rulePropertyPrefix ) ) )? ) )
            // InternalDSL.g:888:2: (otherlv_0= 'comp' ( (lv_name_1_0= ruleValidID ) ) (otherlv_2= '(' ( ( (lv_parameters_3_0= ruleComponentParameter ) ) (otherlv_4= ',' )? )+ otherlv_5= ')' )? ( (lv_scope_6_0= ruleContextScopes ) )? ( ( (lv_listOfProperties_7_0= rulePropertyList ) ) | ( (lv_propertyPrefix_8_0= rulePropertyPrefix ) ) )? )
            {
            // InternalDSL.g:888:2: (otherlv_0= 'comp' ( (lv_name_1_0= ruleValidID ) ) (otherlv_2= '(' ( ( (lv_parameters_3_0= ruleComponentParameter ) ) (otherlv_4= ',' )? )+ otherlv_5= ')' )? ( (lv_scope_6_0= ruleContextScopes ) )? ( ( (lv_listOfProperties_7_0= rulePropertyList ) ) | ( (lv_propertyPrefix_8_0= rulePropertyPrefix ) ) )? )
            // InternalDSL.g:889:3: otherlv_0= 'comp' ( (lv_name_1_0= ruleValidID ) ) (otherlv_2= '(' ( ( (lv_parameters_3_0= ruleComponentParameter ) ) (otherlv_4= ',' )? )+ otherlv_5= ')' )? ( (lv_scope_6_0= ruleContextScopes ) )? ( ( (lv_listOfProperties_7_0= rulePropertyList ) ) | ( (lv_propertyPrefix_8_0= rulePropertyPrefix ) ) )?
            {
            otherlv_0=(Token)match(input,22,FOLLOW_20); 

            			newLeafNode(otherlv_0, grammarAccess.getComponentAccess().getCompKeyword_0());
            		
            // InternalDSL.g:893:3: ( (lv_name_1_0= ruleValidID ) )
            // InternalDSL.g:894:4: (lv_name_1_0= ruleValidID )
            {
            // InternalDSL.g:894:4: (lv_name_1_0= ruleValidID )
            // InternalDSL.g:895:5: lv_name_1_0= ruleValidID
            {

            					newCompositeNode(grammarAccess.getComponentAccess().getNameValidIDParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_24);
            lv_name_1_0=ruleValidID();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getComponentRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"io.entitas.lang.DSL.ValidID");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalDSL.g:912:3: (otherlv_2= '(' ( ( (lv_parameters_3_0= ruleComponentParameter ) ) (otherlv_4= ',' )? )+ otherlv_5= ')' )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==13) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalDSL.g:913:4: otherlv_2= '(' ( ( (lv_parameters_3_0= ruleComponentParameter ) ) (otherlv_4= ',' )? )+ otherlv_5= ')'
                    {
                    otherlv_2=(Token)match(input,13,FOLLOW_25); 

                    				newLeafNode(otherlv_2, grammarAccess.getComponentAccess().getLeftParenthesisKeyword_2_0());
                    			
                    // InternalDSL.g:917:4: ( ( (lv_parameters_3_0= ruleComponentParameter ) ) (otherlv_4= ',' )? )+
                    int cnt21=0;
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( (LA21_0==24) ) {
                            alt21=1;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // InternalDSL.g:918:5: ( (lv_parameters_3_0= ruleComponentParameter ) ) (otherlv_4= ',' )?
                    	    {
                    	    // InternalDSL.g:918:5: ( (lv_parameters_3_0= ruleComponentParameter ) )
                    	    // InternalDSL.g:919:6: (lv_parameters_3_0= ruleComponentParameter )
                    	    {
                    	    // InternalDSL.g:919:6: (lv_parameters_3_0= ruleComponentParameter )
                    	    // InternalDSL.g:920:7: lv_parameters_3_0= ruleComponentParameter
                    	    {

                    	    							newCompositeNode(grammarAccess.getComponentAccess().getParametersComponentParameterParserRuleCall_2_1_0_0());
                    	    						
                    	    pushFollow(FOLLOW_26);
                    	    lv_parameters_3_0=ruleComponentParameter();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getComponentRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"parameters",
                    	    								lv_parameters_3_0,
                    	    								"io.entitas.lang.DSL.ComponentParameter");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }

                    	    // InternalDSL.g:937:5: (otherlv_4= ',' )?
                    	    int alt20=2;
                    	    int LA20_0 = input.LA(1);

                    	    if ( (LA20_0==12) ) {
                    	        alt20=1;
                    	    }
                    	    switch (alt20) {
                    	        case 1 :
                    	            // InternalDSL.g:938:6: otherlv_4= ','
                    	            {
                    	            otherlv_4=(Token)match(input,12,FOLLOW_27); 

                    	            						newLeafNode(otherlv_4, grammarAccess.getComponentAccess().getCommaKeyword_2_1_1());
                    	            					

                    	            }
                    	            break;

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt21 >= 1 ) break loop21;
                                EarlyExitException eee =
                                    new EarlyExitException(21, input);
                                throw eee;
                        }
                        cnt21++;
                    } while (true);

                    otherlv_5=(Token)match(input,14,FOLLOW_28); 

                    				newLeafNode(otherlv_5, grammarAccess.getComponentAccess().getRightParenthesisKeyword_2_2());
                    			

                    }
                    break;

            }

            // InternalDSL.g:949:3: ( (lv_scope_6_0= ruleContextScopes ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==25) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalDSL.g:950:4: (lv_scope_6_0= ruleContextScopes )
                    {
                    // InternalDSL.g:950:4: (lv_scope_6_0= ruleContextScopes )
                    // InternalDSL.g:951:5: lv_scope_6_0= ruleContextScopes
                    {

                    					newCompositeNode(grammarAccess.getComponentAccess().getScopeContextScopesParserRuleCall_3_0());
                    				
                    pushFollow(FOLLOW_29);
                    lv_scope_6_0=ruleContextScopes();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getComponentRule());
                    					}
                    					set(
                    						current,
                    						"scope",
                    						lv_scope_6_0,
                    						"io.entitas.lang.DSL.ContextScopes");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalDSL.g:968:3: ( ( (lv_listOfProperties_7_0= rulePropertyList ) ) | ( (lv_propertyPrefix_8_0= rulePropertyPrefix ) ) )?
            int alt24=3;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==RULE_ID) ) {
                alt24=1;
            }
            else if ( (LA24_0==23) ) {
                alt24=2;
            }
            switch (alt24) {
                case 1 :
                    // InternalDSL.g:969:4: ( (lv_listOfProperties_7_0= rulePropertyList ) )
                    {
                    // InternalDSL.g:969:4: ( (lv_listOfProperties_7_0= rulePropertyList ) )
                    // InternalDSL.g:970:5: (lv_listOfProperties_7_0= rulePropertyList )
                    {
                    // InternalDSL.g:970:5: (lv_listOfProperties_7_0= rulePropertyList )
                    // InternalDSL.g:971:6: lv_listOfProperties_7_0= rulePropertyList
                    {

                    						newCompositeNode(grammarAccess.getComponentAccess().getListOfPropertiesPropertyListParserRuleCall_4_0_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_listOfProperties_7_0=rulePropertyList();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getComponentRule());
                    						}
                    						set(
                    							current,
                    							"listOfProperties",
                    							lv_listOfProperties_7_0,
                    							"io.entitas.lang.DSL.PropertyList");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalDSL.g:989:4: ( (lv_propertyPrefix_8_0= rulePropertyPrefix ) )
                    {
                    // InternalDSL.g:989:4: ( (lv_propertyPrefix_8_0= rulePropertyPrefix ) )
                    // InternalDSL.g:990:5: (lv_propertyPrefix_8_0= rulePropertyPrefix )
                    {
                    // InternalDSL.g:990:5: (lv_propertyPrefix_8_0= rulePropertyPrefix )
                    // InternalDSL.g:991:6: lv_propertyPrefix_8_0= rulePropertyPrefix
                    {

                    						newCompositeNode(grammarAccess.getComponentAccess().getPropertyPrefixPropertyPrefixParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_propertyPrefix_8_0=rulePropertyPrefix();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getComponentRule());
                    						}
                    						set(
                    							current,
                    							"propertyPrefix",
                    							lv_propertyPrefix_8_0,
                    							"io.entitas.lang.DSL.PropertyPrefix");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleComponent"


    // $ANTLR start "entryRulePropertyList"
    // InternalDSL.g:1013:1: entryRulePropertyList returns [EObject current=null] : iv_rulePropertyList= rulePropertyList EOF ;
    public final EObject entryRulePropertyList() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyList = null;


        try {
            // InternalDSL.g:1013:53: (iv_rulePropertyList= rulePropertyList EOF )
            // InternalDSL.g:1014:2: iv_rulePropertyList= rulePropertyList EOF
            {
             newCompositeNode(grammarAccess.getPropertyListRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePropertyList=rulePropertyList();

            state._fsp--;

             current =iv_rulePropertyList; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePropertyList"


    // $ANTLR start "rulePropertyList"
    // InternalDSL.g:1020:1: rulePropertyList returns [EObject current=null] : ( (lv_rules_0_0= rulePropertyRules ) )+ ;
    public final EObject rulePropertyList() throws RecognitionException {
        EObject current = null;

        EObject lv_rules_0_0 = null;



        	enterRule();

        try {
            // InternalDSL.g:1026:2: ( ( (lv_rules_0_0= rulePropertyRules ) )+ )
            // InternalDSL.g:1027:2: ( (lv_rules_0_0= rulePropertyRules ) )+
            {
            // InternalDSL.g:1027:2: ( (lv_rules_0_0= rulePropertyRules ) )+
            int cnt25=0;
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==RULE_ID) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalDSL.g:1028:3: (lv_rules_0_0= rulePropertyRules )
            	    {
            	    // InternalDSL.g:1028:3: (lv_rules_0_0= rulePropertyRules )
            	    // InternalDSL.g:1029:4: lv_rules_0_0= rulePropertyRules
            	    {

            	    				newCompositeNode(grammarAccess.getPropertyListAccess().getRulesPropertyRulesParserRuleCall_0());
            	    			
            	    pushFollow(FOLLOW_10);
            	    lv_rules_0_0=rulePropertyRules();

            	    state._fsp--;


            	    				if (current==null) {
            	    					current = createModelElementForParent(grammarAccess.getPropertyListRule());
            	    				}
            	    				add(
            	    					current,
            	    					"rules",
            	    					lv_rules_0_0,
            	    					"io.entitas.lang.DSL.PropertyRules");
            	    				afterParserOrEnumRuleCall();
            	    			

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt25 >= 1 ) break loop25;
                        EarlyExitException eee =
                            new EarlyExitException(25, input);
                        throw eee;
                }
                cnt25++;
            } while (true);


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePropertyList"


    // $ANTLR start "entryRulePropertyRules"
    // InternalDSL.g:1049:1: entryRulePropertyRules returns [EObject current=null] : iv_rulePropertyRules= rulePropertyRules EOF ;
    public final EObject entryRulePropertyRules() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyRules = null;


        try {
            // InternalDSL.g:1049:54: (iv_rulePropertyRules= rulePropertyRules EOF )
            // InternalDSL.g:1050:2: iv_rulePropertyRules= rulePropertyRules EOF
            {
             newCompositeNode(grammarAccess.getPropertyRulesRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePropertyRules=rulePropertyRules();

            state._fsp--;

             current =iv_rulePropertyRules; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePropertyRules"


    // $ANTLR start "rulePropertyRules"
    // InternalDSL.g:1056:1: rulePropertyRules returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= ',' )? ) ;
    public final EObject rulePropertyRules() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalDSL.g:1062:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= ',' )? ) )
            // InternalDSL.g:1063:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= ',' )? )
            {
            // InternalDSL.g:1063:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= ',' )? )
            // InternalDSL.g:1064:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= ',' )?
            {
            // InternalDSL.g:1064:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalDSL.g:1065:4: (lv_name_0_0= RULE_ID )
            {
            // InternalDSL.g:1065:4: (lv_name_0_0= RULE_ID )
            // InternalDSL.g:1066:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_16); 

            					newLeafNode(lv_name_0_0, grammarAccess.getPropertyRulesAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPropertyRulesRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_1=(Token)match(input,16,FOLLOW_8); 

            			newLeafNode(otherlv_1, grammarAccess.getPropertyRulesAccess().getColonKeyword_1());
            		
            // InternalDSL.g:1086:3: ( (otherlv_2= RULE_ID ) )
            // InternalDSL.g:1087:4: (otherlv_2= RULE_ID )
            {
            // InternalDSL.g:1087:4: (otherlv_2= RULE_ID )
            // InternalDSL.g:1088:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPropertyRulesRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_30); 

            					newLeafNode(otherlv_2, grammarAccess.getPropertyRulesAccess().getAliasAliasCrossReference_2_0());
            				

            }


            }

            // InternalDSL.g:1099:3: (otherlv_3= ',' )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==12) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalDSL.g:1100:4: otherlv_3= ','
                    {
                    otherlv_3=(Token)match(input,12,FOLLOW_2); 

                    				newLeafNode(otherlv_3, grammarAccess.getPropertyRulesAccess().getCommaKeyword_3());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePropertyRules"


    // $ANTLR start "entryRulePropertyPrefix"
    // InternalDSL.g:1109:1: entryRulePropertyPrefix returns [EObject current=null] : iv_rulePropertyPrefix= rulePropertyPrefix EOF ;
    public final EObject entryRulePropertyPrefix() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyPrefix = null;


        try {
            // InternalDSL.g:1109:55: (iv_rulePropertyPrefix= rulePropertyPrefix EOF )
            // InternalDSL.g:1110:2: iv_rulePropertyPrefix= rulePropertyPrefix EOF
            {
             newCompositeNode(grammarAccess.getPropertyPrefixRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePropertyPrefix=rulePropertyPrefix();

            state._fsp--;

             current =iv_rulePropertyPrefix; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePropertyPrefix"


    // $ANTLR start "rulePropertyPrefix"
    // InternalDSL.g:1116:1: rulePropertyPrefix returns [EObject current=null] : (otherlv_0= 'prefix' otherlv_1= '(' ( (lv_string_2_0= RULE_STRING ) ) otherlv_3= ')' ) ;
    public final EObject rulePropertyPrefix() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_string_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalDSL.g:1122:2: ( (otherlv_0= 'prefix' otherlv_1= '(' ( (lv_string_2_0= RULE_STRING ) ) otherlv_3= ')' ) )
            // InternalDSL.g:1123:2: (otherlv_0= 'prefix' otherlv_1= '(' ( (lv_string_2_0= RULE_STRING ) ) otherlv_3= ')' )
            {
            // InternalDSL.g:1123:2: (otherlv_0= 'prefix' otherlv_1= '(' ( (lv_string_2_0= RULE_STRING ) ) otherlv_3= ')' )
            // InternalDSL.g:1124:3: otherlv_0= 'prefix' otherlv_1= '(' ( (lv_string_2_0= RULE_STRING ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,23,FOLLOW_31); 

            			newLeafNode(otherlv_0, grammarAccess.getPropertyPrefixAccess().getPrefixKeyword_0());
            		
            otherlv_1=(Token)match(input,13,FOLLOW_17); 

            			newLeafNode(otherlv_1, grammarAccess.getPropertyPrefixAccess().getLeftParenthesisKeyword_1());
            		
            // InternalDSL.g:1132:3: ( (lv_string_2_0= RULE_STRING ) )
            // InternalDSL.g:1133:4: (lv_string_2_0= RULE_STRING )
            {
            // InternalDSL.g:1133:4: (lv_string_2_0= RULE_STRING )
            // InternalDSL.g:1134:5: lv_string_2_0= RULE_STRING
            {
            lv_string_2_0=(Token)match(input,RULE_STRING,FOLLOW_14); 

            					newLeafNode(lv_string_2_0, grammarAccess.getPropertyPrefixAccess().getStringSTRINGTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPropertyPrefixRule());
            					}
            					setWithLastConsumed(
            						current,
            						"string",
            						lv_string_2_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_3=(Token)match(input,14,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getPropertyPrefixAccess().getRightParenthesisKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePropertyPrefix"


    // $ANTLR start "entryRuleComponentParameter"
    // InternalDSL.g:1158:1: entryRuleComponentParameter returns [String current=null] : iv_ruleComponentParameter= ruleComponentParameter EOF ;
    public final String entryRuleComponentParameter() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleComponentParameter = null;


        try {
            // InternalDSL.g:1158:58: (iv_ruleComponentParameter= ruleComponentParameter EOF )
            // InternalDSL.g:1159:2: iv_ruleComponentParameter= ruleComponentParameter EOF
            {
             newCompositeNode(grammarAccess.getComponentParameterRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleComponentParameter=ruleComponentParameter();

            state._fsp--;

             current =iv_ruleComponentParameter.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleComponentParameter"


    // $ANTLR start "ruleComponentParameter"
    // InternalDSL.g:1165:1: ruleComponentParameter returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'unique' ;
    public final AntlrDatatypeRuleToken ruleComponentParameter() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalDSL.g:1171:2: (kw= 'unique' )
            // InternalDSL.g:1172:2: kw= 'unique'
            {
            kw=(Token)match(input,24,FOLLOW_2); 

            		current.merge(kw);
            		newLeafNode(kw, grammarAccess.getComponentParameterAccess().getUniqueKeyword());
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleComponentParameter"


    // $ANTLR start "entryRuleContextScopes"
    // InternalDSL.g:1180:1: entryRuleContextScopes returns [EObject current=null] : iv_ruleContextScopes= ruleContextScopes EOF ;
    public final EObject entryRuleContextScopes() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContextScopes = null;


        try {
            // InternalDSL.g:1180:54: (iv_ruleContextScopes= ruleContextScopes EOF )
            // InternalDSL.g:1181:2: iv_ruleContextScopes= ruleContextScopes EOF
            {
             newCompositeNode(grammarAccess.getContextScopesRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleContextScopes=ruleContextScopes();

            state._fsp--;

             current =iv_ruleContextScopes; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleContextScopes"


    // $ANTLR start "ruleContextScopes"
    // InternalDSL.g:1187:1: ruleContextScopes returns [EObject current=null] : (otherlv_0= 'in' ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' )? )+ ) ;
    public final EObject ruleContextScopes() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalDSL.g:1193:2: ( (otherlv_0= 'in' ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' )? )+ ) )
            // InternalDSL.g:1194:2: (otherlv_0= 'in' ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' )? )+ )
            {
            // InternalDSL.g:1194:2: (otherlv_0= 'in' ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' )? )+ )
            // InternalDSL.g:1195:3: otherlv_0= 'in' ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' )? )+
            {
            otherlv_0=(Token)match(input,25,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getContextScopesAccess().getInKeyword_0());
            		
            // InternalDSL.g:1199:3: ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' )? )+
            int cnt28=0;
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==RULE_ID) ) {
                    int LA28_1 = input.LA(2);

                    if ( (LA28_1==EOF||LA28_1==RULE_ID||LA28_1==12||(LA28_1>=22 && LA28_1<=23)||LA28_1==26) ) {
                        alt28=1;
                    }


                }


                switch (alt28) {
            	case 1 :
            	    // InternalDSL.g:1200:4: ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' )?
            	    {
            	    // InternalDSL.g:1200:4: ( (otherlv_1= RULE_ID ) )
            	    // InternalDSL.g:1201:5: (otherlv_1= RULE_ID )
            	    {
            	    // InternalDSL.g:1201:5: (otherlv_1= RULE_ID )
            	    // InternalDSL.g:1202:6: otherlv_1= RULE_ID
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getContextScopesRule());
            	    						}
            	    					
            	    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_9); 

            	    						newLeafNode(otherlv_1, grammarAccess.getContextScopesAccess().getReferencesContextIdCrossReference_1_0_0());
            	    					

            	    }


            	    }

            	    // InternalDSL.g:1213:4: (otherlv_2= ',' )?
            	    int alt27=2;
            	    int LA27_0 = input.LA(1);

            	    if ( (LA27_0==12) ) {
            	        alt27=1;
            	    }
            	    switch (alt27) {
            	        case 1 :
            	            // InternalDSL.g:1214:5: otherlv_2= ','
            	            {
            	            otherlv_2=(Token)match(input,12,FOLLOW_10); 

            	            					newLeafNode(otherlv_2, grammarAccess.getContextScopesAccess().getCommaKeyword_1_1());
            	            				

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt28 >= 1 ) break loop28;
                        EarlyExitException eee =
                            new EarlyExitException(28, input);
                        throw eee;
                }
                cnt28++;
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContextScopes"


    // $ANTLR start "entryRuleSystem"
    // InternalDSL.g:1224:1: entryRuleSystem returns [EObject current=null] : iv_ruleSystem= ruleSystem EOF ;
    public final EObject entryRuleSystem() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSystem = null;


        try {
            // InternalDSL.g:1224:47: (iv_ruleSystem= ruleSystem EOF )
            // InternalDSL.g:1225:2: iv_ruleSystem= ruleSystem EOF
            {
             newCompositeNode(grammarAccess.getSystemRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSystem=ruleSystem();

            state._fsp--;

             current =iv_ruleSystem; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSystem"


    // $ANTLR start "ruleSystem"
    // InternalDSL.g:1231:1: ruleSystem returns [EObject current=null] : (otherlv_0= 'sys' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( ( (lv_parameters_3_0= ruleSystemParameter ) ) (otherlv_4= ',' )? )+ otherlv_5= ')' )? ( ( (lv_reactive_6_0= 'trigger' ) ) ( (lv_scope_7_0= ruleContextScope ) )? otherlv_8= ':' ( ( (lv_triggerRules_9_0= ruleTriggerRule ) ) (otherlv_10= ',' )? )+ ( ( (lv_noFilter_11_0= 'noFilter' ) ) | (otherlv_12= 'filter' ( (lv_matcherRules_13_0= ruleMatcherRule ) ) ) )? )? (otherlv_14= 'access' otherlv_15= ':' ( (lv_accessRules_16_0= ruleAccessRule ) )+ )? ) ;
    public final EObject ruleSystem() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token lv_reactive_6_0=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token lv_noFilter_11_0=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        AntlrDatatypeRuleToken lv_parameters_3_0 = null;

        EObject lv_scope_7_0 = null;

        EObject lv_triggerRules_9_0 = null;

        EObject lv_matcherRules_13_0 = null;

        EObject lv_accessRules_16_0 = null;



        	enterRule();

        try {
            // InternalDSL.g:1237:2: ( (otherlv_0= 'sys' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( ( (lv_parameters_3_0= ruleSystemParameter ) ) (otherlv_4= ',' )? )+ otherlv_5= ')' )? ( ( (lv_reactive_6_0= 'trigger' ) ) ( (lv_scope_7_0= ruleContextScope ) )? otherlv_8= ':' ( ( (lv_triggerRules_9_0= ruleTriggerRule ) ) (otherlv_10= ',' )? )+ ( ( (lv_noFilter_11_0= 'noFilter' ) ) | (otherlv_12= 'filter' ( (lv_matcherRules_13_0= ruleMatcherRule ) ) ) )? )? (otherlv_14= 'access' otherlv_15= ':' ( (lv_accessRules_16_0= ruleAccessRule ) )+ )? ) )
            // InternalDSL.g:1238:2: (otherlv_0= 'sys' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( ( (lv_parameters_3_0= ruleSystemParameter ) ) (otherlv_4= ',' )? )+ otherlv_5= ')' )? ( ( (lv_reactive_6_0= 'trigger' ) ) ( (lv_scope_7_0= ruleContextScope ) )? otherlv_8= ':' ( ( (lv_triggerRules_9_0= ruleTriggerRule ) ) (otherlv_10= ',' )? )+ ( ( (lv_noFilter_11_0= 'noFilter' ) ) | (otherlv_12= 'filter' ( (lv_matcherRules_13_0= ruleMatcherRule ) ) ) )? )? (otherlv_14= 'access' otherlv_15= ':' ( (lv_accessRules_16_0= ruleAccessRule ) )+ )? )
            {
            // InternalDSL.g:1238:2: (otherlv_0= 'sys' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( ( (lv_parameters_3_0= ruleSystemParameter ) ) (otherlv_4= ',' )? )+ otherlv_5= ')' )? ( ( (lv_reactive_6_0= 'trigger' ) ) ( (lv_scope_7_0= ruleContextScope ) )? otherlv_8= ':' ( ( (lv_triggerRules_9_0= ruleTriggerRule ) ) (otherlv_10= ',' )? )+ ( ( (lv_noFilter_11_0= 'noFilter' ) ) | (otherlv_12= 'filter' ( (lv_matcherRules_13_0= ruleMatcherRule ) ) ) )? )? (otherlv_14= 'access' otherlv_15= ':' ( (lv_accessRules_16_0= ruleAccessRule ) )+ )? )
            // InternalDSL.g:1239:3: otherlv_0= 'sys' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( ( (lv_parameters_3_0= ruleSystemParameter ) ) (otherlv_4= ',' )? )+ otherlv_5= ')' )? ( ( (lv_reactive_6_0= 'trigger' ) ) ( (lv_scope_7_0= ruleContextScope ) )? otherlv_8= ':' ( ( (lv_triggerRules_9_0= ruleTriggerRule ) ) (otherlv_10= ',' )? )+ ( ( (lv_noFilter_11_0= 'noFilter' ) ) | (otherlv_12= 'filter' ( (lv_matcherRules_13_0= ruleMatcherRule ) ) ) )? )? (otherlv_14= 'access' otherlv_15= ':' ( (lv_accessRules_16_0= ruleAccessRule ) )+ )?
            {
            otherlv_0=(Token)match(input,26,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getSystemAccess().getSysKeyword_0());
            		
            // InternalDSL.g:1243:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalDSL.g:1244:4: (lv_name_1_0= RULE_ID )
            {
            // InternalDSL.g:1244:4: (lv_name_1_0= RULE_ID )
            // InternalDSL.g:1245:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_32); 

            					newLeafNode(lv_name_1_0, grammarAccess.getSystemAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSystemRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalDSL.g:1261:3: (otherlv_2= '(' ( ( (lv_parameters_3_0= ruleSystemParameter ) ) (otherlv_4= ',' )? )+ otherlv_5= ')' )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==13) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalDSL.g:1262:4: otherlv_2= '(' ( ( (lv_parameters_3_0= ruleSystemParameter ) ) (otherlv_4= ',' )? )+ otherlv_5= ')'
                    {
                    otherlv_2=(Token)match(input,13,FOLLOW_33); 

                    				newLeafNode(otherlv_2, grammarAccess.getSystemAccess().getLeftParenthesisKeyword_2_0());
                    			
                    // InternalDSL.g:1266:4: ( ( (lv_parameters_3_0= ruleSystemParameter ) ) (otherlv_4= ',' )? )+
                    int cnt30=0;
                    loop30:
                    do {
                        int alt30=2;
                        int LA30_0 = input.LA(1);

                        if ( ((LA30_0>=31 && LA30_0<=35)) ) {
                            alt30=1;
                        }


                        switch (alt30) {
                    	case 1 :
                    	    // InternalDSL.g:1267:5: ( (lv_parameters_3_0= ruleSystemParameter ) ) (otherlv_4= ',' )?
                    	    {
                    	    // InternalDSL.g:1267:5: ( (lv_parameters_3_0= ruleSystemParameter ) )
                    	    // InternalDSL.g:1268:6: (lv_parameters_3_0= ruleSystemParameter )
                    	    {
                    	    // InternalDSL.g:1268:6: (lv_parameters_3_0= ruleSystemParameter )
                    	    // InternalDSL.g:1269:7: lv_parameters_3_0= ruleSystemParameter
                    	    {

                    	    							newCompositeNode(grammarAccess.getSystemAccess().getParametersSystemParameterParserRuleCall_2_1_0_0());
                    	    						
                    	    pushFollow(FOLLOW_34);
                    	    lv_parameters_3_0=ruleSystemParameter();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getSystemRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"parameters",
                    	    								lv_parameters_3_0,
                    	    								"io.entitas.lang.DSL.SystemParameter");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }

                    	    // InternalDSL.g:1286:5: (otherlv_4= ',' )?
                    	    int alt29=2;
                    	    int LA29_0 = input.LA(1);

                    	    if ( (LA29_0==12) ) {
                    	        alt29=1;
                    	    }
                    	    switch (alt29) {
                    	        case 1 :
                    	            // InternalDSL.g:1287:6: otherlv_4= ','
                    	            {
                    	            otherlv_4=(Token)match(input,12,FOLLOW_35); 

                    	            						newLeafNode(otherlv_4, grammarAccess.getSystemAccess().getCommaKeyword_2_1_1());
                    	            					

                    	            }
                    	            break;

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt30 >= 1 ) break loop30;
                                EarlyExitException eee =
                                    new EarlyExitException(30, input);
                                throw eee;
                        }
                        cnt30++;
                    } while (true);

                    otherlv_5=(Token)match(input,14,FOLLOW_36); 

                    				newLeafNode(otherlv_5, grammarAccess.getSystemAccess().getRightParenthesisKeyword_2_2());
                    			

                    }
                    break;

            }

            // InternalDSL.g:1298:3: ( ( (lv_reactive_6_0= 'trigger' ) ) ( (lv_scope_7_0= ruleContextScope ) )? otherlv_8= ':' ( ( (lv_triggerRules_9_0= ruleTriggerRule ) ) (otherlv_10= ',' )? )+ ( ( (lv_noFilter_11_0= 'noFilter' ) ) | (otherlv_12= 'filter' ( (lv_matcherRules_13_0= ruleMatcherRule ) ) ) )? )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==27) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalDSL.g:1299:4: ( (lv_reactive_6_0= 'trigger' ) ) ( (lv_scope_7_0= ruleContextScope ) )? otherlv_8= ':' ( ( (lv_triggerRules_9_0= ruleTriggerRule ) ) (otherlv_10= ',' )? )+ ( ( (lv_noFilter_11_0= 'noFilter' ) ) | (otherlv_12= 'filter' ( (lv_matcherRules_13_0= ruleMatcherRule ) ) ) )?
                    {
                    // InternalDSL.g:1299:4: ( (lv_reactive_6_0= 'trigger' ) )
                    // InternalDSL.g:1300:5: (lv_reactive_6_0= 'trigger' )
                    {
                    // InternalDSL.g:1300:5: (lv_reactive_6_0= 'trigger' )
                    // InternalDSL.g:1301:6: lv_reactive_6_0= 'trigger'
                    {
                    lv_reactive_6_0=(Token)match(input,27,FOLLOW_37); 

                    						newLeafNode(lv_reactive_6_0, grammarAccess.getSystemAccess().getReactiveTriggerKeyword_3_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getSystemRule());
                    						}
                    						setWithLastConsumed(current, "reactive", true, "trigger");
                    					

                    }


                    }

                    // InternalDSL.g:1313:4: ( (lv_scope_7_0= ruleContextScope ) )?
                    int alt32=2;
                    int LA32_0 = input.LA(1);

                    if ( (LA32_0==25) ) {
                        alt32=1;
                    }
                    switch (alt32) {
                        case 1 :
                            // InternalDSL.g:1314:5: (lv_scope_7_0= ruleContextScope )
                            {
                            // InternalDSL.g:1314:5: (lv_scope_7_0= ruleContextScope )
                            // InternalDSL.g:1315:6: lv_scope_7_0= ruleContextScope
                            {

                            						newCompositeNode(grammarAccess.getSystemAccess().getScopeContextScopeParserRuleCall_3_1_0());
                            					
                            pushFollow(FOLLOW_16);
                            lv_scope_7_0=ruleContextScope();

                            state._fsp--;


                            						if (current==null) {
                            							current = createModelElementForParent(grammarAccess.getSystemRule());
                            						}
                            						set(
                            							current,
                            							"scope",
                            							lv_scope_7_0,
                            							"io.entitas.lang.DSL.ContextScope");
                            						afterParserOrEnumRuleCall();
                            					

                            }


                            }
                            break;

                    }

                    otherlv_8=(Token)match(input,16,FOLLOW_38); 

                    				newLeafNode(otherlv_8, grammarAccess.getSystemAccess().getColonKeyword_3_2());
                    			
                    // InternalDSL.g:1336:4: ( ( (lv_triggerRules_9_0= ruleTriggerRule ) ) (otherlv_10= ',' )? )+
                    int cnt34=0;
                    loop34:
                    do {
                        int alt34=2;
                        int LA34_0 = input.LA(1);

                        if ( ((LA34_0>=36 && LA34_0<=38)) ) {
                            alt34=1;
                        }


                        switch (alt34) {
                    	case 1 :
                    	    // InternalDSL.g:1337:5: ( (lv_triggerRules_9_0= ruleTriggerRule ) ) (otherlv_10= ',' )?
                    	    {
                    	    // InternalDSL.g:1337:5: ( (lv_triggerRules_9_0= ruleTriggerRule ) )
                    	    // InternalDSL.g:1338:6: (lv_triggerRules_9_0= ruleTriggerRule )
                    	    {
                    	    // InternalDSL.g:1338:6: (lv_triggerRules_9_0= ruleTriggerRule )
                    	    // InternalDSL.g:1339:7: lv_triggerRules_9_0= ruleTriggerRule
                    	    {

                    	    							newCompositeNode(grammarAccess.getSystemAccess().getTriggerRulesTriggerRuleParserRuleCall_3_3_0_0());
                    	    						
                    	    pushFollow(FOLLOW_39);
                    	    lv_triggerRules_9_0=ruleTriggerRule();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getSystemRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"triggerRules",
                    	    								lv_triggerRules_9_0,
                    	    								"io.entitas.lang.DSL.TriggerRule");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }

                    	    // InternalDSL.g:1356:5: (otherlv_10= ',' )?
                    	    int alt33=2;
                    	    int LA33_0 = input.LA(1);

                    	    if ( (LA33_0==12) ) {
                    	        alt33=1;
                    	    }
                    	    switch (alt33) {
                    	        case 1 :
                    	            // InternalDSL.g:1357:6: otherlv_10= ','
                    	            {
                    	            otherlv_10=(Token)match(input,12,FOLLOW_40); 

                    	            						newLeafNode(otherlv_10, grammarAccess.getSystemAccess().getCommaKeyword_3_3_1());
                    	            					

                    	            }
                    	            break;

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt34 >= 1 ) break loop34;
                                EarlyExitException eee =
                                    new EarlyExitException(34, input);
                                throw eee;
                        }
                        cnt34++;
                    } while (true);

                    // InternalDSL.g:1363:4: ( ( (lv_noFilter_11_0= 'noFilter' ) ) | (otherlv_12= 'filter' ( (lv_matcherRules_13_0= ruleMatcherRule ) ) ) )?
                    int alt35=3;
                    int LA35_0 = input.LA(1);

                    if ( (LA35_0==28) ) {
                        alt35=1;
                    }
                    else if ( (LA35_0==29) ) {
                        alt35=2;
                    }
                    switch (alt35) {
                        case 1 :
                            // InternalDSL.g:1364:5: ( (lv_noFilter_11_0= 'noFilter' ) )
                            {
                            // InternalDSL.g:1364:5: ( (lv_noFilter_11_0= 'noFilter' ) )
                            // InternalDSL.g:1365:6: (lv_noFilter_11_0= 'noFilter' )
                            {
                            // InternalDSL.g:1365:6: (lv_noFilter_11_0= 'noFilter' )
                            // InternalDSL.g:1366:7: lv_noFilter_11_0= 'noFilter'
                            {
                            lv_noFilter_11_0=(Token)match(input,28,FOLLOW_41); 

                            							newLeafNode(lv_noFilter_11_0, grammarAccess.getSystemAccess().getNoFilterNoFilterKeyword_3_4_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getSystemRule());
                            							}
                            							setWithLastConsumed(current, "noFilter", true, "noFilter");
                            						

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalDSL.g:1379:5: (otherlv_12= 'filter' ( (lv_matcherRules_13_0= ruleMatcherRule ) ) )
                            {
                            // InternalDSL.g:1379:5: (otherlv_12= 'filter' ( (lv_matcherRules_13_0= ruleMatcherRule ) ) )
                            // InternalDSL.g:1380:6: otherlv_12= 'filter' ( (lv_matcherRules_13_0= ruleMatcherRule ) )
                            {
                            otherlv_12=(Token)match(input,29,FOLLOW_42); 

                            						newLeafNode(otherlv_12, grammarAccess.getSystemAccess().getFilterKeyword_3_4_1_0());
                            					
                            // InternalDSL.g:1384:6: ( (lv_matcherRules_13_0= ruleMatcherRule ) )
                            // InternalDSL.g:1385:7: (lv_matcherRules_13_0= ruleMatcherRule )
                            {
                            // InternalDSL.g:1385:7: (lv_matcherRules_13_0= ruleMatcherRule )
                            // InternalDSL.g:1386:8: lv_matcherRules_13_0= ruleMatcherRule
                            {

                            								newCompositeNode(grammarAccess.getSystemAccess().getMatcherRulesMatcherRuleParserRuleCall_3_4_1_1_0());
                            							
                            pushFollow(FOLLOW_41);
                            lv_matcherRules_13_0=ruleMatcherRule();

                            state._fsp--;


                            								if (current==null) {
                            									current = createModelElementForParent(grammarAccess.getSystemRule());
                            								}
                            								set(
                            									current,
                            									"matcherRules",
                            									lv_matcherRules_13_0,
                            									"io.entitas.lang.DSL.MatcherRule");
                            								afterParserOrEnumRuleCall();
                            							

                            }


                            }


                            }


                            }
                            break;

                    }


                    }
                    break;

            }

            // InternalDSL.g:1406:3: (otherlv_14= 'access' otherlv_15= ':' ( (lv_accessRules_16_0= ruleAccessRule ) )+ )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==30) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalDSL.g:1407:4: otherlv_14= 'access' otherlv_15= ':' ( (lv_accessRules_16_0= ruleAccessRule ) )+
                    {
                    otherlv_14=(Token)match(input,30,FOLLOW_16); 

                    				newLeafNode(otherlv_14, grammarAccess.getSystemAccess().getAccessKeyword_4_0());
                    			
                    otherlv_15=(Token)match(input,16,FOLLOW_8); 

                    				newLeafNode(otherlv_15, grammarAccess.getSystemAccess().getColonKeyword_4_1());
                    			
                    // InternalDSL.g:1415:4: ( (lv_accessRules_16_0= ruleAccessRule ) )+
                    int cnt37=0;
                    loop37:
                    do {
                        int alt37=2;
                        int LA37_0 = input.LA(1);

                        if ( (LA37_0==RULE_ID) ) {
                            alt37=1;
                        }


                        switch (alt37) {
                    	case 1 :
                    	    // InternalDSL.g:1416:5: (lv_accessRules_16_0= ruleAccessRule )
                    	    {
                    	    // InternalDSL.g:1416:5: (lv_accessRules_16_0= ruleAccessRule )
                    	    // InternalDSL.g:1417:6: lv_accessRules_16_0= ruleAccessRule
                    	    {

                    	    						newCompositeNode(grammarAccess.getSystemAccess().getAccessRulesAccessRuleParserRuleCall_4_2_0());
                    	    					
                    	    pushFollow(FOLLOW_10);
                    	    lv_accessRules_16_0=ruleAccessRule();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getSystemRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"accessRules",
                    	    							lv_accessRules_16_0,
                    	    							"io.entitas.lang.DSL.AccessRule");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt37 >= 1 ) break loop37;
                                EarlyExitException eee =
                                    new EarlyExitException(37, input);
                                throw eee;
                        }
                        cnt37++;
                    } while (true);


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSystem"


    // $ANTLR start "entryRuleAccessRule"
    // InternalDSL.g:1439:1: entryRuleAccessRule returns [EObject current=null] : iv_ruleAccessRule= ruleAccessRule EOF ;
    public final EObject entryRuleAccessRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAccessRule = null;


        try {
            // InternalDSL.g:1439:51: (iv_ruleAccessRule= ruleAccessRule EOF )
            // InternalDSL.g:1440:2: iv_ruleAccessRule= ruleAccessRule EOF
            {
             newCompositeNode(grammarAccess.getAccessRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAccessRule=ruleAccessRule();

            state._fsp--;

             current =iv_ruleAccessRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAccessRule"


    // $ANTLR start "ruleAccessRule"
    // InternalDSL.g:1446:1: ruleAccessRule returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( ( (lv_matcherRule_2_0= ruleMatcherRule ) ) ( (lv_scope_3_0= ruleContextScope ) )? ) | ( (otherlv_4= RULE_ID ) ) ) ) ;
    public final EObject ruleAccessRule() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_4=null;
        EObject lv_matcherRule_2_0 = null;

        EObject lv_scope_3_0 = null;



        	enterRule();

        try {
            // InternalDSL.g:1452:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( ( (lv_matcherRule_2_0= ruleMatcherRule ) ) ( (lv_scope_3_0= ruleContextScope ) )? ) | ( (otherlv_4= RULE_ID ) ) ) ) )
            // InternalDSL.g:1453:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( ( (lv_matcherRule_2_0= ruleMatcherRule ) ) ( (lv_scope_3_0= ruleContextScope ) )? ) | ( (otherlv_4= RULE_ID ) ) ) )
            {
            // InternalDSL.g:1453:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( ( (lv_matcherRule_2_0= ruleMatcherRule ) ) ( (lv_scope_3_0= ruleContextScope ) )? ) | ( (otherlv_4= RULE_ID ) ) ) )
            // InternalDSL.g:1454:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( ( (lv_matcherRule_2_0= ruleMatcherRule ) ) ( (lv_scope_3_0= ruleContextScope ) )? ) | ( (otherlv_4= RULE_ID ) ) )
            {
            // InternalDSL.g:1454:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalDSL.g:1455:4: (lv_name_0_0= RULE_ID )
            {
            // InternalDSL.g:1455:4: (lv_name_0_0= RULE_ID )
            // InternalDSL.g:1456:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_16); 

            					newLeafNode(lv_name_0_0, grammarAccess.getAccessRuleAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAccessRuleRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_1=(Token)match(input,16,FOLLOW_43); 

            			newLeafNode(otherlv_1, grammarAccess.getAccessRuleAccess().getColonKeyword_1());
            		
            // InternalDSL.g:1476:3: ( ( ( (lv_matcherRule_2_0= ruleMatcherRule ) ) ( (lv_scope_3_0= ruleContextScope ) )? ) | ( (otherlv_4= RULE_ID ) ) )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==EOF||(LA40_0>=25 && LA40_0<=26)||(LA40_0>=39 && LA40_0<=41)) ) {
                alt40=1;
            }
            else if ( (LA40_0==RULE_ID) ) {
                int LA40_2 = input.LA(2);

                if ( (LA40_2==EOF||LA40_2==RULE_ID||LA40_2==26) ) {
                    alt40=2;
                }
                else if ( (LA40_2==16) ) {
                    alt40=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 40, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }
            switch (alt40) {
                case 1 :
                    // InternalDSL.g:1477:4: ( ( (lv_matcherRule_2_0= ruleMatcherRule ) ) ( (lv_scope_3_0= ruleContextScope ) )? )
                    {
                    // InternalDSL.g:1477:4: ( ( (lv_matcherRule_2_0= ruleMatcherRule ) ) ( (lv_scope_3_0= ruleContextScope ) )? )
                    // InternalDSL.g:1478:5: ( (lv_matcherRule_2_0= ruleMatcherRule ) ) ( (lv_scope_3_0= ruleContextScope ) )?
                    {
                    // InternalDSL.g:1478:5: ( (lv_matcherRule_2_0= ruleMatcherRule ) )
                    // InternalDSL.g:1479:6: (lv_matcherRule_2_0= ruleMatcherRule )
                    {
                    // InternalDSL.g:1479:6: (lv_matcherRule_2_0= ruleMatcherRule )
                    // InternalDSL.g:1480:7: lv_matcherRule_2_0= ruleMatcherRule
                    {

                    							newCompositeNode(grammarAccess.getAccessRuleAccess().getMatcherRuleMatcherRuleParserRuleCall_2_0_0_0());
                    						
                    pushFollow(FOLLOW_44);
                    lv_matcherRule_2_0=ruleMatcherRule();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getAccessRuleRule());
                    							}
                    							set(
                    								current,
                    								"matcherRule",
                    								lv_matcherRule_2_0,
                    								"io.entitas.lang.DSL.MatcherRule");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    // InternalDSL.g:1497:5: ( (lv_scope_3_0= ruleContextScope ) )?
                    int alt39=2;
                    int LA39_0 = input.LA(1);

                    if ( (LA39_0==25) ) {
                        alt39=1;
                    }
                    switch (alt39) {
                        case 1 :
                            // InternalDSL.g:1498:6: (lv_scope_3_0= ruleContextScope )
                            {
                            // InternalDSL.g:1498:6: (lv_scope_3_0= ruleContextScope )
                            // InternalDSL.g:1499:7: lv_scope_3_0= ruleContextScope
                            {

                            							newCompositeNode(grammarAccess.getAccessRuleAccess().getScopeContextScopeParserRuleCall_2_0_1_0());
                            						
                            pushFollow(FOLLOW_2);
                            lv_scope_3_0=ruleContextScope();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getAccessRuleRule());
                            							}
                            							set(
                            								current,
                            								"scope",
                            								lv_scope_3_0,
                            								"io.entitas.lang.DSL.ContextScope");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalDSL.g:1518:4: ( (otherlv_4= RULE_ID ) )
                    {
                    // InternalDSL.g:1518:4: ( (otherlv_4= RULE_ID ) )
                    // InternalDSL.g:1519:5: (otherlv_4= RULE_ID )
                    {
                    // InternalDSL.g:1519:5: (otherlv_4= RULE_ID )
                    // InternalDSL.g:1520:6: otherlv_4= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAccessRuleRule());
                    						}
                    					
                    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_2); 

                    						newLeafNode(otherlv_4, grammarAccess.getAccessRuleAccess().getContextRefContextIdCrossReference_2_1_0());
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAccessRule"


    // $ANTLR start "entryRuleSystemParameter"
    // InternalDSL.g:1536:1: entryRuleSystemParameter returns [String current=null] : iv_ruleSystemParameter= ruleSystemParameter EOF ;
    public final String entryRuleSystemParameter() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSystemParameter = null;


        try {
            // InternalDSL.g:1536:55: (iv_ruleSystemParameter= ruleSystemParameter EOF )
            // InternalDSL.g:1537:2: iv_ruleSystemParameter= ruleSystemParameter EOF
            {
             newCompositeNode(grammarAccess.getSystemParameterRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSystemParameter=ruleSystemParameter();

            state._fsp--;

             current =iv_ruleSystemParameter.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSystemParameter"


    // $ANTLR start "ruleSystemParameter"
    // InternalDSL.g:1543:1: ruleSystemParameter returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'init' | kw= 'cleanup' | kw= 'teardown' | kw= 'no_exec' | kw= 'explicit_context_list' ) ;
    public final AntlrDatatypeRuleToken ruleSystemParameter() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalDSL.g:1549:2: ( (kw= 'init' | kw= 'cleanup' | kw= 'teardown' | kw= 'no_exec' | kw= 'explicit_context_list' ) )
            // InternalDSL.g:1550:2: (kw= 'init' | kw= 'cleanup' | kw= 'teardown' | kw= 'no_exec' | kw= 'explicit_context_list' )
            {
            // InternalDSL.g:1550:2: (kw= 'init' | kw= 'cleanup' | kw= 'teardown' | kw= 'no_exec' | kw= 'explicit_context_list' )
            int alt41=5;
            switch ( input.LA(1) ) {
            case 31:
                {
                alt41=1;
                }
                break;
            case 32:
                {
                alt41=2;
                }
                break;
            case 33:
                {
                alt41=3;
                }
                break;
            case 34:
                {
                alt41=4;
                }
                break;
            case 35:
                {
                alt41=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }

            switch (alt41) {
                case 1 :
                    // InternalDSL.g:1551:3: kw= 'init'
                    {
                    kw=(Token)match(input,31,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getSystemParameterAccess().getInitKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalDSL.g:1557:3: kw= 'cleanup'
                    {
                    kw=(Token)match(input,32,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getSystemParameterAccess().getCleanupKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalDSL.g:1563:3: kw= 'teardown'
                    {
                    kw=(Token)match(input,33,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getSystemParameterAccess().getTeardownKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalDSL.g:1569:3: kw= 'no_exec'
                    {
                    kw=(Token)match(input,34,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getSystemParameterAccess().getNo_execKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalDSL.g:1575:3: kw= 'explicit_context_list'
                    {
                    kw=(Token)match(input,35,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getSystemParameterAccess().getExplicit_context_listKeyword_4());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSystemParameter"


    // $ANTLR start "entryRuleTriggerRule"
    // InternalDSL.g:1584:1: entryRuleTriggerRule returns [EObject current=null] : iv_ruleTriggerRule= ruleTriggerRule EOF ;
    public final EObject entryRuleTriggerRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTriggerRule = null;


        try {
            // InternalDSL.g:1584:52: (iv_ruleTriggerRule= ruleTriggerRule EOF )
            // InternalDSL.g:1585:2: iv_ruleTriggerRule= ruleTriggerRule EOF
            {
             newCompositeNode(grammarAccess.getTriggerRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTriggerRule=ruleTriggerRule();

            state._fsp--;

             current =iv_ruleTriggerRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTriggerRule"


    // $ANTLR start "ruleTriggerRule"
    // InternalDSL.g:1591:1: ruleTriggerRule returns [EObject current=null] : ( ( ( (lv_removed_0_0= 'removed' ) ) | ( (lv_added_1_0= 'added' ) ) | ( (lv_removedOrAdded_2_0= 'removedOrAdded' ) ) ) otherlv_3= '(' ( ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' )? )+ otherlv_6= ')' ) ;
    public final EObject ruleTriggerRule() throws RecognitionException {
        EObject current = null;

        Token lv_removed_0_0=null;
        Token lv_added_1_0=null;
        Token lv_removedOrAdded_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;


        	enterRule();

        try {
            // InternalDSL.g:1597:2: ( ( ( ( (lv_removed_0_0= 'removed' ) ) | ( (lv_added_1_0= 'added' ) ) | ( (lv_removedOrAdded_2_0= 'removedOrAdded' ) ) ) otherlv_3= '(' ( ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' )? )+ otherlv_6= ')' ) )
            // InternalDSL.g:1598:2: ( ( ( (lv_removed_0_0= 'removed' ) ) | ( (lv_added_1_0= 'added' ) ) | ( (lv_removedOrAdded_2_0= 'removedOrAdded' ) ) ) otherlv_3= '(' ( ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' )? )+ otherlv_6= ')' )
            {
            // InternalDSL.g:1598:2: ( ( ( (lv_removed_0_0= 'removed' ) ) | ( (lv_added_1_0= 'added' ) ) | ( (lv_removedOrAdded_2_0= 'removedOrAdded' ) ) ) otherlv_3= '(' ( ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' )? )+ otherlv_6= ')' )
            // InternalDSL.g:1599:3: ( ( (lv_removed_0_0= 'removed' ) ) | ( (lv_added_1_0= 'added' ) ) | ( (lv_removedOrAdded_2_0= 'removedOrAdded' ) ) ) otherlv_3= '(' ( ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' )? )+ otherlv_6= ')'
            {
            // InternalDSL.g:1599:3: ( ( (lv_removed_0_0= 'removed' ) ) | ( (lv_added_1_0= 'added' ) ) | ( (lv_removedOrAdded_2_0= 'removedOrAdded' ) ) )
            int alt42=3;
            switch ( input.LA(1) ) {
            case 36:
                {
                alt42=1;
                }
                break;
            case 37:
                {
                alt42=2;
                }
                break;
            case 38:
                {
                alt42=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }

            switch (alt42) {
                case 1 :
                    // InternalDSL.g:1600:4: ( (lv_removed_0_0= 'removed' ) )
                    {
                    // InternalDSL.g:1600:4: ( (lv_removed_0_0= 'removed' ) )
                    // InternalDSL.g:1601:5: (lv_removed_0_0= 'removed' )
                    {
                    // InternalDSL.g:1601:5: (lv_removed_0_0= 'removed' )
                    // InternalDSL.g:1602:6: lv_removed_0_0= 'removed'
                    {
                    lv_removed_0_0=(Token)match(input,36,FOLLOW_31); 

                    						newLeafNode(lv_removed_0_0, grammarAccess.getTriggerRuleAccess().getRemovedRemovedKeyword_0_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTriggerRuleRule());
                    						}
                    						setWithLastConsumed(current, "removed", true, "removed");
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalDSL.g:1615:4: ( (lv_added_1_0= 'added' ) )
                    {
                    // InternalDSL.g:1615:4: ( (lv_added_1_0= 'added' ) )
                    // InternalDSL.g:1616:5: (lv_added_1_0= 'added' )
                    {
                    // InternalDSL.g:1616:5: (lv_added_1_0= 'added' )
                    // InternalDSL.g:1617:6: lv_added_1_0= 'added'
                    {
                    lv_added_1_0=(Token)match(input,37,FOLLOW_31); 

                    						newLeafNode(lv_added_1_0, grammarAccess.getTriggerRuleAccess().getAddedAddedKeyword_0_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTriggerRuleRule());
                    						}
                    						setWithLastConsumed(current, "added", true, "added");
                    					

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalDSL.g:1630:4: ( (lv_removedOrAdded_2_0= 'removedOrAdded' ) )
                    {
                    // InternalDSL.g:1630:4: ( (lv_removedOrAdded_2_0= 'removedOrAdded' ) )
                    // InternalDSL.g:1631:5: (lv_removedOrAdded_2_0= 'removedOrAdded' )
                    {
                    // InternalDSL.g:1631:5: (lv_removedOrAdded_2_0= 'removedOrAdded' )
                    // InternalDSL.g:1632:6: lv_removedOrAdded_2_0= 'removedOrAdded'
                    {
                    lv_removedOrAdded_2_0=(Token)match(input,38,FOLLOW_31); 

                    						newLeafNode(lv_removedOrAdded_2_0, grammarAccess.getTriggerRuleAccess().getRemovedOrAddedRemovedOrAddedKeyword_0_2_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTriggerRuleRule());
                    						}
                    						setWithLastConsumed(current, "removedOrAdded", true, "removedOrAdded");
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,13,FOLLOW_8); 

            			newLeafNode(otherlv_3, grammarAccess.getTriggerRuleAccess().getLeftParenthesisKeyword_1());
            		
            // InternalDSL.g:1649:3: ( ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' )? )+
            int cnt44=0;
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==RULE_ID) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // InternalDSL.g:1650:4: ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' )?
            	    {
            	    // InternalDSL.g:1650:4: ( (otherlv_4= RULE_ID ) )
            	    // InternalDSL.g:1651:5: (otherlv_4= RULE_ID )
            	    {
            	    // InternalDSL.g:1651:5: (otherlv_4= RULE_ID )
            	    // InternalDSL.g:1652:6: otherlv_4= RULE_ID
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getTriggerRuleRule());
            	    						}
            	    					
            	    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_45); 

            	    						newLeafNode(otherlv_4, grammarAccess.getTriggerRuleAccess().getComponentsComponentCrossReference_2_0_0());
            	    					

            	    }


            	    }

            	    // InternalDSL.g:1663:4: (otherlv_5= ',' )?
            	    int alt43=2;
            	    int LA43_0 = input.LA(1);

            	    if ( (LA43_0==12) ) {
            	        alt43=1;
            	    }
            	    switch (alt43) {
            	        case 1 :
            	            // InternalDSL.g:1664:5: otherlv_5= ','
            	            {
            	            otherlv_5=(Token)match(input,12,FOLLOW_46); 

            	            					newLeafNode(otherlv_5, grammarAccess.getTriggerRuleAccess().getCommaKeyword_2_1());
            	            				

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt44 >= 1 ) break loop44;
                        EarlyExitException eee =
                            new EarlyExitException(44, input);
                        throw eee;
                }
                cnt44++;
            } while (true);

            otherlv_6=(Token)match(input,14,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getTriggerRuleAccess().getRightParenthesisKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTriggerRule"


    // $ANTLR start "entryRuleMatcherRule"
    // InternalDSL.g:1678:1: entryRuleMatcherRule returns [EObject current=null] : iv_ruleMatcherRule= ruleMatcherRule EOF ;
    public final EObject entryRuleMatcherRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMatcherRule = null;


        try {
            // InternalDSL.g:1678:52: (iv_ruleMatcherRule= ruleMatcherRule EOF )
            // InternalDSL.g:1679:2: iv_ruleMatcherRule= ruleMatcherRule EOF
            {
             newCompositeNode(grammarAccess.getMatcherRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMatcherRule=ruleMatcherRule();

            state._fsp--;

             current =iv_ruleMatcherRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMatcherRule"


    // $ANTLR start "ruleMatcherRule"
    // InternalDSL.g:1685:1: ruleMatcherRule returns [EObject current=null] : ( () (otherlv_1= 'allOf' otherlv_2= '(' ( ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' )? )+ otherlv_5= ')' )? (otherlv_6= 'anyOf' otherlv_7= '(' ( ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' )? )+ otherlv_10= ')' )? (otherlv_11= 'noneOf' otherlv_12= '(' ( ( (otherlv_13= RULE_ID ) ) (otherlv_14= ',' )? )+ otherlv_15= ')' )? ) ;
    public final EObject ruleMatcherRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_15=null;


        	enterRule();

        try {
            // InternalDSL.g:1691:2: ( ( () (otherlv_1= 'allOf' otherlv_2= '(' ( ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' )? )+ otherlv_5= ')' )? (otherlv_6= 'anyOf' otherlv_7= '(' ( ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' )? )+ otherlv_10= ')' )? (otherlv_11= 'noneOf' otherlv_12= '(' ( ( (otherlv_13= RULE_ID ) ) (otherlv_14= ',' )? )+ otherlv_15= ')' )? ) )
            // InternalDSL.g:1692:2: ( () (otherlv_1= 'allOf' otherlv_2= '(' ( ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' )? )+ otherlv_5= ')' )? (otherlv_6= 'anyOf' otherlv_7= '(' ( ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' )? )+ otherlv_10= ')' )? (otherlv_11= 'noneOf' otherlv_12= '(' ( ( (otherlv_13= RULE_ID ) ) (otherlv_14= ',' )? )+ otherlv_15= ')' )? )
            {
            // InternalDSL.g:1692:2: ( () (otherlv_1= 'allOf' otherlv_2= '(' ( ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' )? )+ otherlv_5= ')' )? (otherlv_6= 'anyOf' otherlv_7= '(' ( ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' )? )+ otherlv_10= ')' )? (otherlv_11= 'noneOf' otherlv_12= '(' ( ( (otherlv_13= RULE_ID ) ) (otherlv_14= ',' )? )+ otherlv_15= ')' )? )
            // InternalDSL.g:1693:3: () (otherlv_1= 'allOf' otherlv_2= '(' ( ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' )? )+ otherlv_5= ')' )? (otherlv_6= 'anyOf' otherlv_7= '(' ( ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' )? )+ otherlv_10= ')' )? (otherlv_11= 'noneOf' otherlv_12= '(' ( ( (otherlv_13= RULE_ID ) ) (otherlv_14= ',' )? )+ otherlv_15= ')' )?
            {
            // InternalDSL.g:1693:3: ()
            // InternalDSL.g:1694:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getMatcherRuleAccess().getMatcherRuleAction_0(),
            					current);
            			

            }

            // InternalDSL.g:1700:3: (otherlv_1= 'allOf' otherlv_2= '(' ( ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' )? )+ otherlv_5= ')' )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==39) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // InternalDSL.g:1701:4: otherlv_1= 'allOf' otherlv_2= '(' ( ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' )? )+ otherlv_5= ')'
                    {
                    otherlv_1=(Token)match(input,39,FOLLOW_31); 

                    				newLeafNode(otherlv_1, grammarAccess.getMatcherRuleAccess().getAllOfKeyword_1_0());
                    			
                    otherlv_2=(Token)match(input,13,FOLLOW_8); 

                    				newLeafNode(otherlv_2, grammarAccess.getMatcherRuleAccess().getLeftParenthesisKeyword_1_1());
                    			
                    // InternalDSL.g:1709:4: ( ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' )? )+
                    int cnt46=0;
                    loop46:
                    do {
                        int alt46=2;
                        int LA46_0 = input.LA(1);

                        if ( (LA46_0==RULE_ID) ) {
                            alt46=1;
                        }


                        switch (alt46) {
                    	case 1 :
                    	    // InternalDSL.g:1710:5: ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' )?
                    	    {
                    	    // InternalDSL.g:1710:5: ( (otherlv_3= RULE_ID ) )
                    	    // InternalDSL.g:1711:6: (otherlv_3= RULE_ID )
                    	    {
                    	    // InternalDSL.g:1711:6: (otherlv_3= RULE_ID )
                    	    // InternalDSL.g:1712:7: otherlv_3= RULE_ID
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getMatcherRuleRule());
                    	    							}
                    	    						
                    	    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_45); 

                    	    							newLeafNode(otherlv_3, grammarAccess.getMatcherRuleAccess().getAllComponentsComponentCrossReference_1_2_0_0());
                    	    						

                    	    }


                    	    }

                    	    // InternalDSL.g:1723:5: (otherlv_4= ',' )?
                    	    int alt45=2;
                    	    int LA45_0 = input.LA(1);

                    	    if ( (LA45_0==12) ) {
                    	        alt45=1;
                    	    }
                    	    switch (alt45) {
                    	        case 1 :
                    	            // InternalDSL.g:1724:6: otherlv_4= ','
                    	            {
                    	            otherlv_4=(Token)match(input,12,FOLLOW_46); 

                    	            						newLeafNode(otherlv_4, grammarAccess.getMatcherRuleAccess().getCommaKeyword_1_2_1());
                    	            					

                    	            }
                    	            break;

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt46 >= 1 ) break loop46;
                                EarlyExitException eee =
                                    new EarlyExitException(46, input);
                                throw eee;
                        }
                        cnt46++;
                    } while (true);

                    otherlv_5=(Token)match(input,14,FOLLOW_47); 

                    				newLeafNode(otherlv_5, grammarAccess.getMatcherRuleAccess().getRightParenthesisKeyword_1_3());
                    			

                    }
                    break;

            }

            // InternalDSL.g:1735:3: (otherlv_6= 'anyOf' otherlv_7= '(' ( ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' )? )+ otherlv_10= ')' )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==40) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // InternalDSL.g:1736:4: otherlv_6= 'anyOf' otherlv_7= '(' ( ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' )? )+ otherlv_10= ')'
                    {
                    otherlv_6=(Token)match(input,40,FOLLOW_31); 

                    				newLeafNode(otherlv_6, grammarAccess.getMatcherRuleAccess().getAnyOfKeyword_2_0());
                    			
                    otherlv_7=(Token)match(input,13,FOLLOW_8); 

                    				newLeafNode(otherlv_7, grammarAccess.getMatcherRuleAccess().getLeftParenthesisKeyword_2_1());
                    			
                    // InternalDSL.g:1744:4: ( ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' )? )+
                    int cnt49=0;
                    loop49:
                    do {
                        int alt49=2;
                        int LA49_0 = input.LA(1);

                        if ( (LA49_0==RULE_ID) ) {
                            alt49=1;
                        }


                        switch (alt49) {
                    	case 1 :
                    	    // InternalDSL.g:1745:5: ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' )?
                    	    {
                    	    // InternalDSL.g:1745:5: ( (otherlv_8= RULE_ID ) )
                    	    // InternalDSL.g:1746:6: (otherlv_8= RULE_ID )
                    	    {
                    	    // InternalDSL.g:1746:6: (otherlv_8= RULE_ID )
                    	    // InternalDSL.g:1747:7: otherlv_8= RULE_ID
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getMatcherRuleRule());
                    	    							}
                    	    						
                    	    otherlv_8=(Token)match(input,RULE_ID,FOLLOW_45); 

                    	    							newLeafNode(otherlv_8, grammarAccess.getMatcherRuleAccess().getAnyComponentsComponentCrossReference_2_2_0_0());
                    	    						

                    	    }


                    	    }

                    	    // InternalDSL.g:1758:5: (otherlv_9= ',' )?
                    	    int alt48=2;
                    	    int LA48_0 = input.LA(1);

                    	    if ( (LA48_0==12) ) {
                    	        alt48=1;
                    	    }
                    	    switch (alt48) {
                    	        case 1 :
                    	            // InternalDSL.g:1759:6: otherlv_9= ','
                    	            {
                    	            otherlv_9=(Token)match(input,12,FOLLOW_46); 

                    	            						newLeafNode(otherlv_9, grammarAccess.getMatcherRuleAccess().getCommaKeyword_2_2_1());
                    	            					

                    	            }
                    	            break;

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt49 >= 1 ) break loop49;
                                EarlyExitException eee =
                                    new EarlyExitException(49, input);
                                throw eee;
                        }
                        cnt49++;
                    } while (true);

                    otherlv_10=(Token)match(input,14,FOLLOW_48); 

                    				newLeafNode(otherlv_10, grammarAccess.getMatcherRuleAccess().getRightParenthesisKeyword_2_3());
                    			

                    }
                    break;

            }

            // InternalDSL.g:1770:3: (otherlv_11= 'noneOf' otherlv_12= '(' ( ( (otherlv_13= RULE_ID ) ) (otherlv_14= ',' )? )+ otherlv_15= ')' )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==41) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // InternalDSL.g:1771:4: otherlv_11= 'noneOf' otherlv_12= '(' ( ( (otherlv_13= RULE_ID ) ) (otherlv_14= ',' )? )+ otherlv_15= ')'
                    {
                    otherlv_11=(Token)match(input,41,FOLLOW_31); 

                    				newLeafNode(otherlv_11, grammarAccess.getMatcherRuleAccess().getNoneOfKeyword_3_0());
                    			
                    otherlv_12=(Token)match(input,13,FOLLOW_8); 

                    				newLeafNode(otherlv_12, grammarAccess.getMatcherRuleAccess().getLeftParenthesisKeyword_3_1());
                    			
                    // InternalDSL.g:1779:4: ( ( (otherlv_13= RULE_ID ) ) (otherlv_14= ',' )? )+
                    int cnt52=0;
                    loop52:
                    do {
                        int alt52=2;
                        int LA52_0 = input.LA(1);

                        if ( (LA52_0==RULE_ID) ) {
                            alt52=1;
                        }


                        switch (alt52) {
                    	case 1 :
                    	    // InternalDSL.g:1780:5: ( (otherlv_13= RULE_ID ) ) (otherlv_14= ',' )?
                    	    {
                    	    // InternalDSL.g:1780:5: ( (otherlv_13= RULE_ID ) )
                    	    // InternalDSL.g:1781:6: (otherlv_13= RULE_ID )
                    	    {
                    	    // InternalDSL.g:1781:6: (otherlv_13= RULE_ID )
                    	    // InternalDSL.g:1782:7: otherlv_13= RULE_ID
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getMatcherRuleRule());
                    	    							}
                    	    						
                    	    otherlv_13=(Token)match(input,RULE_ID,FOLLOW_45); 

                    	    							newLeafNode(otherlv_13, grammarAccess.getMatcherRuleAccess().getNoneComponentsComponentCrossReference_3_2_0_0());
                    	    						

                    	    }


                    	    }

                    	    // InternalDSL.g:1793:5: (otherlv_14= ',' )?
                    	    int alt51=2;
                    	    int LA51_0 = input.LA(1);

                    	    if ( (LA51_0==12) ) {
                    	        alt51=1;
                    	    }
                    	    switch (alt51) {
                    	        case 1 :
                    	            // InternalDSL.g:1794:6: otherlv_14= ','
                    	            {
                    	            otherlv_14=(Token)match(input,12,FOLLOW_46); 

                    	            						newLeafNode(otherlv_14, grammarAccess.getMatcherRuleAccess().getCommaKeyword_3_2_1());
                    	            					

                    	            }
                    	            break;

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt52 >= 1 ) break loop52;
                                EarlyExitException eee =
                                    new EarlyExitException(52, input);
                                throw eee;
                        }
                        cnt52++;
                    } while (true);

                    otherlv_15=(Token)match(input,14,FOLLOW_2); 

                    				newLeafNode(otherlv_15, grammarAccess.getMatcherRuleAccess().getRightParenthesisKeyword_3_3());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMatcherRule"


    // $ANTLR start "entryRuleContextScope"
    // InternalDSL.g:1809:1: entryRuleContextScope returns [EObject current=null] : iv_ruleContextScope= ruleContextScope EOF ;
    public final EObject entryRuleContextScope() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContextScope = null;


        try {
            // InternalDSL.g:1809:53: (iv_ruleContextScope= ruleContextScope EOF )
            // InternalDSL.g:1810:2: iv_ruleContextScope= ruleContextScope EOF
            {
             newCompositeNode(grammarAccess.getContextScopeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleContextScope=ruleContextScope();

            state._fsp--;

             current =iv_ruleContextScope; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleContextScope"


    // $ANTLR start "ruleContextScope"
    // InternalDSL.g:1816:1: ruleContextScope returns [EObject current=null] : (otherlv_0= 'in' ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleContextScope() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalDSL.g:1822:2: ( (otherlv_0= 'in' ( (otherlv_1= RULE_ID ) ) ) )
            // InternalDSL.g:1823:2: (otherlv_0= 'in' ( (otherlv_1= RULE_ID ) ) )
            {
            // InternalDSL.g:1823:2: (otherlv_0= 'in' ( (otherlv_1= RULE_ID ) ) )
            // InternalDSL.g:1824:3: otherlv_0= 'in' ( (otherlv_1= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,25,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getContextScopeAccess().getInKeyword_0());
            		
            // InternalDSL.g:1828:3: ( (otherlv_1= RULE_ID ) )
            // InternalDSL.g:1829:4: (otherlv_1= RULE_ID )
            {
            // InternalDSL.g:1829:4: (otherlv_1= RULE_ID )
            // InternalDSL.g:1830:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getContextScopeRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(otherlv_1, grammarAccess.getContextScopeAccess().getReferenceContextIdCrossReference_1_0());
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContextScope"


    // $ANTLR start "entryRuleQualifiedName"
    // InternalDSL.g:1845:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalDSL.g:1845:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalDSL.g:1846:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;

             current =iv_ruleQualifiedName.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // InternalDSL.g:1852:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ValidID_0= ruleValidID (kw= '.' this_ValidID_2= ruleValidID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_ValidID_0 = null;

        AntlrDatatypeRuleToken this_ValidID_2 = null;



        	enterRule();

        try {
            // InternalDSL.g:1858:2: ( (this_ValidID_0= ruleValidID (kw= '.' this_ValidID_2= ruleValidID )* ) )
            // InternalDSL.g:1859:2: (this_ValidID_0= ruleValidID (kw= '.' this_ValidID_2= ruleValidID )* )
            {
            // InternalDSL.g:1859:2: (this_ValidID_0= ruleValidID (kw= '.' this_ValidID_2= ruleValidID )* )
            // InternalDSL.g:1860:3: this_ValidID_0= ruleValidID (kw= '.' this_ValidID_2= ruleValidID )*
            {

            			newCompositeNode(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_0());
            		
            pushFollow(FOLLOW_18);
            this_ValidID_0=ruleValidID();

            state._fsp--;


            			current.merge(this_ValidID_0);
            		

            			afterParserOrEnumRuleCall();
            		
            // InternalDSL.g:1870:3: (kw= '.' this_ValidID_2= ruleValidID )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==17) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // InternalDSL.g:1871:4: kw= '.' this_ValidID_2= ruleValidID
            	    {
            	    kw=(Token)match(input,17,FOLLOW_20); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
            	    			

            	    				newCompositeNode(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_1_1());
            	    			
            	    pushFollow(FOLLOW_18);
            	    this_ValidID_2=ruleValidID();

            	    state._fsp--;


            	    				current.merge(this_ValidID_2);
            	    			

            	    				afterParserOrEnumRuleCall();
            	    			

            	    }
            	    break;

            	default :
            	    break loop54;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleValidID"
    // InternalDSL.g:1891:1: entryRuleValidID returns [String current=null] : iv_ruleValidID= ruleValidID EOF ;
    public final String entryRuleValidID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleValidID = null;


        try {
            // InternalDSL.g:1891:47: (iv_ruleValidID= ruleValidID EOF )
            // InternalDSL.g:1892:2: iv_ruleValidID= ruleValidID EOF
            {
             newCompositeNode(grammarAccess.getValidIDRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleValidID=ruleValidID();

            state._fsp--;

             current =iv_ruleValidID.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleValidID"


    // $ANTLR start "ruleValidID"
    // InternalDSL.g:1898:1: ruleValidID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | kw= 'target' | kw= 'namespace' | kw= 'default' | kw= 'unique' | kw= 'prefix' | kw= 'in' | kw= 'alias' ) ;
    public final AntlrDatatypeRuleToken ruleValidID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;


        	enterRule();

        try {
            // InternalDSL.g:1904:2: ( (this_ID_0= RULE_ID | kw= 'target' | kw= 'namespace' | kw= 'default' | kw= 'unique' | kw= 'prefix' | kw= 'in' | kw= 'alias' ) )
            // InternalDSL.g:1905:2: (this_ID_0= RULE_ID | kw= 'target' | kw= 'namespace' | kw= 'default' | kw= 'unique' | kw= 'prefix' | kw= 'in' | kw= 'alias' )
            {
            // InternalDSL.g:1905:2: (this_ID_0= RULE_ID | kw= 'target' | kw= 'namespace' | kw= 'default' | kw= 'unique' | kw= 'prefix' | kw= 'in' | kw= 'alias' )
            int alt55=8;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt55=1;
                }
                break;
            case 11:
                {
                alt55=2;
                }
                break;
            case 18:
                {
                alt55=3;
                }
                break;
            case 20:
                {
                alt55=4;
                }
                break;
            case 24:
                {
                alt55=5;
                }
                break;
            case 23:
                {
                alt55=6;
                }
                break;
            case 25:
                {
                alt55=7;
                }
                break;
            case 21:
                {
                alt55=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 55, 0, input);

                throw nvae;
            }

            switch (alt55) {
                case 1 :
                    // InternalDSL.g:1906:3: this_ID_0= RULE_ID
                    {
                    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_2); 

                    			current.merge(this_ID_0);
                    		

                    			newLeafNode(this_ID_0, grammarAccess.getValidIDAccess().getIDTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalDSL.g:1914:3: kw= 'target'
                    {
                    kw=(Token)match(input,11,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getValidIDAccess().getTargetKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalDSL.g:1920:3: kw= 'namespace'
                    {
                    kw=(Token)match(input,18,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getValidIDAccess().getNamespaceKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalDSL.g:1926:3: kw= 'default'
                    {
                    kw=(Token)match(input,20,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getValidIDAccess().getDefaultKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalDSL.g:1932:3: kw= 'unique'
                    {
                    kw=(Token)match(input,24,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getValidIDAccess().getUniqueKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalDSL.g:1938:3: kw= 'prefix'
                    {
                    kw=(Token)match(input,23,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getValidIDAccess().getPrefixKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalDSL.g:1944:3: kw= 'in'
                    {
                    kw=(Token)match(input,25,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getValidIDAccess().getInKeyword_6());
                    		

                    }
                    break;
                case 8 :
                    // InternalDSL.g:1950:3: kw= 'alias'
                    {
                    kw=(Token)match(input,21,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getValidIDAccess().getAliasKeyword_7());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleValidID"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x00000000046C0002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000004680002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000004600002L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000004400002L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000001012L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000002042L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000005000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000003B40810L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000002802012L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000001005000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000001004000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000002800012L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000800012L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000048002002L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000F80000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000F80005000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000F80004000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000048000002L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000002010000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000007000000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000007070001002L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000007070000002L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000038040000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000038002000010L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000000005010L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000030000000002L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000020000000002L});

}