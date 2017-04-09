'use strict';

import * as path from 'path';
import * as os from 'os';

import {Trace} from 'vscode-jsonrpc';
import { workspace, ExtensionContext } from 'vscode';
import { LanguageClient, LanguageClientOptions, ServerOptions } from 'vscode-languageclient';

export function activate(context: ExtensionContext) {
    // The server is a locally installed in src/entitas_lang
    let launcher = os.platform() === 'win32' ? 'entitas-lang-standalone.bat' : 'entitas-lang-standalone';
    let script = context.asAbsolutePath(path.join('src', 'entitas_lang', 'bin', launcher));
    
    let serverOptions: ServerOptions = {
        run : { command: script },
        debug: { command: script, args: ['-Xdebug','-Xrunjdwp:server=y,transport=dt_socket,address=8000,suspend=n,quiet=y','-Xmx256m'] }
    };
    
    let clientOptions: LanguageClientOptions = {
        documentSelector: ['entitas'],
        synchronize: {
            fileEvents: workspace.createFileSystemWatcher('**/*.*')
        }
    };
    
    // Create the language client and start the client.
    let lc = new LanguageClient('Entitas Lang Server', serverOptions, clientOptions);
    // enable tracing (.Off, .Messages, Verbose)
    lc.trace = Trace.Off;
    let disposable = lc.start();
    
    // Push the disposable to the context's subscriptions so that the 
    // client can be deactivated on extension deactivation
    context.subscriptions.push(disposable);
}