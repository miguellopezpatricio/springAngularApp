package com.mlpatri.springboot.backend.apirest.auth;

public class JwtConfig {
	
	public static final String LLAVE_SECRETA = "alguna.clave.secreta.12345678";

	public static final String RSA_PRIVADA = "-----BEGIN PRIVATE KEY-----\n"
			+ "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQChuR1CPIgCxePW\n"
			+ "muEiyXR1nBY4dN2YyuvOXL2hrWsmt75ziHVF7kyUSAPUy80qvHYpTCRAVeUTzQIt\n"
			+ "AjjCl6wq90rmoRMGLlpvVjNfi9N5SDh4JZPToOHhiBh+PqU1R2eMU41U8svxUcc9\n"
			+ "FK1bspUVJIqSkGqXhect8e4bpm6nciRg6YuIJJWXBG7xKXVntUSv+2LRAmrv6Byy\n"
			+ "klh2sz0rYwUGKFHahoshar7sJoPsLqMinLcpMaCJvQ4vnKnT+pAUAlurARsA6yZ4\n"
			+ "kgR8q0uu5sRMprDZspl2hzJYZ7EbYfASf5R5swLh0MOLEpNIii3hFDRVfXbugR1J\n"
			+ "RFTRTmudAgMBAAECggEABUBodv2rNwKBFGIhfHUz7xvF9vMIknfIcizodYcW9ddn\n"
			+ "+6114shLEVJIruYn/+1wctqHn3/f4/riHrRgmSUUEK3IxLYnUtSPgue23Fvt3pWI\n"
			+ "oTzV0OdRCSICavBoLKjob7yeLXYtnDpZG3PVRfyFwygqyHlLFNI4KxxHl1CaGEgw\n"
			+ "iSddzbxe4QnQO7WZqu83iTawinkZG7uyPJy6f9TypTXgEUBvU4HnGvCU97FLEyth\n"
			+ "X1yPQC2GQP3d6files5tz9xBCKaYRUw2N4pJKlyI2UUYqr1R8bZNF7jBLhu54UMP\n"
			+ "GDUKFhpQaDmshaoLiopzDoYltm43tXzswU8ZpiV/oQKBgQDVRrmP5l73fHXy1ZyT\n"
			+ "G3VdAPhNUrYfZu8rqcmy2e3UIYcLvLc/QxdtFe9JJLnUO4cvXYkhN7iV1rNuzF89\n"
			+ "XN8v8ZjHMX+ItoOU3OoypW3X1O9sTenCISsDmpe4CE3XxGfJWbUD5kObovAA4lOu\n"
			+ "F0CT23dVee8yi5btulcHIiesDQKBgQDCHqFDLEQ13LlGnYZsTtRogQN5b5Xxk9J4\n"
			+ "03+3h040T9OFHDtfi3pFVsMazkUUCZ1sQzrtcloYVJgovV74h7fXG5unaXOqzYtV\n"
			+ "aXlDIzMz1wFvjUPG66n9/RL0mwN/CuFUD0jgHIoGzq0vj/UkWu3yrglDwK3TqzGc\n"
			+ "DZIwFTiJ0QKBgHiO8BntyUTwr+PC6C0n2mHmSHW9CYIat5vg8EkPc6b0BNiXpqY2\n"
			+ "EKnzOj4IapsTw0j9AKUsUEUzBl7dXADd3LPHR+thiYwIT7z4W9KhPMRCc8yvBjJc\n"
			+ "eWoiGx1GZGpRdbGV6gL4SMNTiYOWbGL+ddyetIg20wWpbnmXWdaIchCJAoGBAKn3\n"
			+ "tc2iKctbi2J4NSYKU9N4+zjN6mVOwGAJF+/zahdFuff4A0iiUJn74PNMnpFv5cXQ\n"
			+ "i/0yPg7Fq0EopspH00FmrACGxb9NH+3WX1XYsVF3tYseDrVSzVJVz84bGJGZTjiS\n"
			+ "9YU9l+Fj/6IAk22UrHnrxrLrN4h5ggOYomK1gf6xAoGAOqBXn75mn7F753H2g+L0\n"
			+ "jJkf1R67oS5Fbyb+PR+VOCFD1lF8ydlLTpCbrBLwsQXE5rk3+qFOJ7JtB7nFDYYb\n"
			+ "B47nfCtfB5O2XKb4gYeayOPSm/wSCiVrModOh8rPYOsPm4Z2OoNOwoxLGjtJQLJJ\n"
			+ "TsFtcZxDNzdkvppdTlXrTwg=\n"
			+ "-----END PRIVATE KEY-----";
	
	public static final String RSA_PUBLICA = "-----BEGIN PUBLIC KEY-----\n"
			+ "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAobkdQjyIAsXj1prhIsl0\n"
			+ "dZwWOHTdmMrrzly9oa1rJre+c4h1Re5MlEgD1MvNKrx2KUwkQFXlE80CLQI4wpes\n"
			+ "KvdK5qETBi5ab1YzX4vTeUg4eCWT06Dh4YgYfj6lNUdnjFONVPLL8VHHPRStW7KV\n"
			+ "FSSKkpBql4XnLfHuG6Zup3IkYOmLiCSVlwRu8Sl1Z7VEr/ti0QJq7+gcspJYdrM9\n"
			+ "K2MFBihR2oaLIWq+7CaD7C6jIpy3KTGgib0OL5yp0/qQFAJbqwEbAOsmeJIEfKtL\n"
			+ "rubETKaw2bKZdocyWGexG2HwEn+UebMC4dDDixKTSIot4RQ0VX127oEdSURU0U5r\n"
			+ "nQIDAQAB\n"
			+ "-----END PUBLIC KEY-----";
	
}

