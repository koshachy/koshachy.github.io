// Disable the webpack-dev-server error overlay entirely.
// Compose for Web (Skiko/Wasm) and Ktor (Coil network layer) trigger
// non-fatal runtime exceptions (e.g., WebGL WEBGL_debug_renderer_info
// deprecation, worker message ID mismatches) that the overlay
// incorrectly surfaces as uncaught runtime errors.
;(function(config) {
    config.devServer = Object.assign(config.devServer || {}, {
        client: Object.assign((config.devServer || {}).client || {}, {
            overlay: false
        })
    });
})(config);
