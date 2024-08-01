export class GenericRequestBody<T> {
  items: T[];

  constructor() {
    this.items = [];
  }

  withItem(item: T): GenericRequestBody<T> {
    this.items = [item];
    return this;
  }

  withItems(items: T[]): GenericRequestBody<T> {
    this.items = items;
    return this;
  }
}
