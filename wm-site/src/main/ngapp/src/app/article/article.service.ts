import {Injectable} from "@angular/core";
import {Headers, Http} from "@angular/http";

import {Article} from "./article";

import "rxjs/add/operator/toPromise";
import {Page} from "../Page";

@Injectable()
export class ArticleService {
  private headers = new Headers({'Content-Type': 'application/json'});
  private articlesUrl = '/articles';

  constructor(private http: Http) {
  }

  getArticlePage(): Promise<Page<Article>> {
    return this.http.get(this.articlesUrl)
      .toPromise()
      .then(response => response.json().data as Page<Article>)
      .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }
}
