export interface JwtAuthResponse {
  accessToken: string;
  tokenType: string;
  userName: string;
  role: string;
  personId: number;
}
